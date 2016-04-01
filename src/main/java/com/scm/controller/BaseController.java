package com.scm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scm.constant.SecurityConstant;
import com.scm.po.ShopInfo;
import com.scm.po.UserInfo;

public class BaseController {
	private static final Logger log = Logger.getLogger(BaseController.class);

	@Autowired
	public HttpServletRequest request;

	/**
	 * 获取当前登录用户信息
	 * 
	 * @param request
	 * @return
	 */
	public  UserInfo getCurrentUserInfo() {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(SecurityConstant.SCM_ERP_USER_COOKIE_KEY);
		return userInfo;
	}

	/**
	 * 获取当前登录店铺信息
	 * @return
	 */
	public  ShopInfo getCurrentShopInfo() {
		ShopInfo shopInfo = (ShopInfo) request.getSession().getAttribute(SecurityConstant.SCM_ERP_SHOP_COOKIE_KEY);
		return shopInfo;
	}
	
	/**
	 * 设置session值
	 * @param key
	 * @param value
	 */
	public void setSessionAttribute(String key,Object value){
		request.getSession().setAttribute(key, value);
	}
	
	/**
	 * 获取session值
	 * @param key
	 * @param value
	 */
	public Object getSessionAttribute(String key){
		return request.getSession().getAttribute(key);
	}
	
	/**
	 * 从session中移除某项
	 * @param key
	 */
	public void removeSessionAttribute(String key){
		request.getSession().removeAttribute(key);
	}
	
	/**
	 * 退出操作，清除当前用户+店铺信息
	 */
	public void removeCurrentInfo(){
		request.getSession().removeAttribute(SecurityConstant.SCM_ERP_USER_COOKIE_KEY);
		request.getSession().removeAttribute(SecurityConstant.SCM_ERP_SHOP_COOKIE_KEY);
	}

	@ExceptionHandler
	public String exp(Exception ex) {
		// 记录日志
		log.error(ex.getMessage(), ex);
		// 也可根据不同错误转向不同页面
		request.setAttribute("ex", ex);
		return "errors/500";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	protected String resultJson(String... kvs) {
		JSONObject json = new JSONObject();
		if (kvs == null || kvs.length == 0) {
			return json.toString();
		}
		for (int i = 0, len = kvs.length; (i + 1) < len; i += 2) {
			json.put(kvs[i], kvs[i + 1]);
		}
		return json.toString();
	}

	protected String successJson() {
		JSONObject json = new JSONObject();
		json.put("success", true);
		return json.toString();
	}

	protected String successJson(String... kvs) {
		JSONObject json = new JSONObject();
		json.put("success", true);
		if (kvs == null || kvs.length == 0) {
			return json.toString();
		}
		for (int i = 0, len = kvs.length; (i + 1) < len; i += 2) {
			json.put(kvs[i], kvs[i + 1]);
		}
		return json.toString();
	}

	protected static String listJson(List list) {
		return JSON.toJSONString(list, true);
	}

	protected static String mapJson(Map<String, Object> map) {
		JSONObject jsonObject = new JSONObject();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			jsonObject.put(entry.getKey(), entry.getValue());
		}
		return jsonObject.toString();
	}

	protected String errorJson(String msg) {
		JSONObject json = new JSONObject();
		json.put("success", false);
		json.put("msg", msg);
		return json.toString();
	}

	protected String errorJson(Object msg) {
		JSONObject json = new JSONObject();
		json.put("success", false);
		json.put("msg", msg);
		return json.toString();
	}
}
