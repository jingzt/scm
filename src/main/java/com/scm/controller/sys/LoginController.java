package com.scm.controller.sys;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopInfo;
import com.scm.po.SysPrivateMenuInfo;
import com.scm.po.UserInfo;
import com.scm.po.UserLoginInfo;
import com.scm.service.SysPrivateMenuService;
import com.scm.service.UserInfoService;
import com.scm.service.UserLoginService;
import com.scm.service.UserShopRelationService;
import com.scm.utils.MD5Utils;
import com.scm.utils.StringUtil;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
	private Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private UserShopRelationService userShopRelationService;
	
	@Autowired
	private SysPrivateMenuService sysPrivateMenuService ;

	@RequestMapping(value = "login.htm")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping(value = "loginOut.htm")
	public String loginOut(){
		removeCurrentInfo();
		return "redirect:login.htm";
	}

	@RequestMapping(value = "index.htm")
	public String index(ModelMap model) {
		ShopInfo shop=getCurrentShopInfo();
		model.addAttribute("shop", shop);
		UserInfo user = getCurrentUserInfo();
		model.addAttribute("user", user);
		List<SysPrivateMenuInfo> menuList = sysPrivateMenuService.selectAllPrivateMenuInfoList(shop.getId());
		model.addAttribute("menuList", menuList);
		return "index";
	}

	@RequestMapping(value = "login.do")
	public String login(String verify, String loginName,
			String password, RedirectAttributesModelMap attrModel) {
		if (!StringUtils.hasText(verify)) {
			attrModel.addFlashAttribute("loginName", loginName);
			attrModel.addFlashAttribute("errMsg", "验证码不能为空！");
			return "redirect:login.htm";
		}
		String codeInCookie = getVerifyCode(SecurityConstant.USER_LOGIN_VERIFY_CODE_KEY);
		if (codeInCookie == null || !codeInCookie.equals(MD5Utils.MD5(verify))) {
			attrModel.addFlashAttribute("loginName", loginName);
			attrModel.addFlashAttribute("errMsg", "验证码有误！");
			return "redirect:login.htm";
		}
		if (!StringUtils.hasText(loginName) || !StringUtils.hasText(password)) {
			attrModel.addFlashAttribute("loginName", loginName);
			attrModel.addFlashAttribute("errMsg", "用户名或密码不能为空！");
			return "redirect:login.htm";
		}

		
		UserInfo userInfo = userInfoService.selectByLoginName(loginName);
		if(userInfo==null){
			attrModel.addFlashAttribute("loginName", loginName);
			attrModel.addFlashAttribute("errMsg", "没有该用户！");
			return "redirect:login.htm";
		}
		if(!userInfo.getLoginPwd().equals(MD5Utils.MD5(password))){
			attrModel.addFlashAttribute("loginName", loginName);
			attrModel.addFlashAttribute("errMsg", "密码错误！");
			return "redirect:login.htm";
		}
		
		ShopInfo shopInfo = userShopRelationService.selectShopInfoByUserId(userInfo.getId());
		if(shopInfo==null){
			attrModel.addFlashAttribute("loginName", loginName);
			attrModel.addFlashAttribute("errMsg", "没找到对应的商铺,请联系管理员！");
			return "redirect:login.htm";
		}
		setSessionAttribute(SecurityConstant.SCM_ERP_USER_COOKIE_KEY, userInfo);
		setSessionAttribute(SecurityConstant.SCM_ERP_SHOP_COOKIE_KEY, shopInfo);
		String ip = StringUtil.getIp(request);
		String address="";
		if(StringUtil.isNotNullOrEmpty(ip)){
			address =StringUtil.getAddressByIP(ip);
		}
		
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setUserId(userInfo.getId());
		userLoginInfo.setShopId(shopInfo.getId());
		userLoginInfo.setLoginIp(ip);
		userLoginInfo.setLoginAddress(address);
		userLoginService.insertLoginInfo(userLoginInfo);
		
		return "redirect:index.htm";
	}

	

	private String getVerifyCode(String common) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (common.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
