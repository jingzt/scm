package com.scm.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.controller.BaseController;
import com.scm.po.UserInfo;
import com.scm.service.UserInfoService;
import com.scm.utils.MD5Utils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 修改密码时校验原密码
	 * 
	 * @param request
	 * @param oldPwd
	 * @return
	 */
	@RequestMapping("checkOldPwd.do")
	@ResponseBody
	public String checkOldPwd(String oldPwd) {
		UserInfo userInfo = getCurrentUserInfo();
		if (MD5Utils.MD5(oldPwd).equals(userInfo.getLoginPwd())) {
			return "true";
		}
		return "false";

	}

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @param newPwd
	 * @return
	 */
	@RequestMapping("modifyPwd.do")
	@ResponseBody
	public String modifyPwd(String newPwd) {
		UserInfo userInfo = getCurrentUserInfo();
		userInfo.setLoginPwd(MD5Utils.MD5(newPwd));
		userInfoService.updateUserInfo(userInfo);
		return successJson();
	}

	@RequestMapping("modifyUserInfo.do")
	@ResponseBody
	public String modifyUserInfo(UserInfo userInfo) {
		UserInfo user = getCurrentUserInfo();
		user.setNickName(userInfo.getNickName());
		userInfoService.updateUserInfo(user);
		return successJson();
	}

}
