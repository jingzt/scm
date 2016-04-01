package com.scm.controller.sys;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopInfo;
import com.scm.po.SysRegion;
import com.scm.po.UserInfo;
import com.scm.service.SysRegionService;
import com.scm.service.UserInfoService;
import com.scm.utils.MD5Utils;
import com.scm.utils.MailUtil;
import com.scm.utils.StringUtil;
import com.scm.vo.RegisterVO;

@Controller
@RequestMapping("/")
public class RegisterController extends BaseController {
	private Logger log = Logger.getLogger(RegisterController.class);

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private SysRegionService sysRegionService;

	@RequestMapping(value = "register.htm")
	public String toRegister(Model model) {
		List<SysRegion> allProvince = sysRegionService.getAllProvince();
		model.addAttribute("allProvince", allProvince);
		return "register";
	}

	/**
	 * 注册帐号邮箱验证码
	 * @param loginName
	 * @return
	 */
	@RequestMapping("sentVerify.do")
	@ResponseBody
	public String sentVerify(String loginName) {
		String randowmNum = StringUtil.createRandowmNum(6);
		String content = "<html><body>欢迎使用SCM-ERP在线销售分析服务：<br />您本次验证码为：<span style=\"color:red\">"
				+ randowmNum + "</span>.请勿直接回复，谢谢！</body></html>";
		 MailUtil email = new MailUtil();
		 email.sendEmail(loginName, "SCM-ERP在线销售分析系统", content);
		 log.info("注册帐号邮箱验证码:"+content);
		setSessionAttribute(SecurityConstant.USER_REGISTER_VERIFY_CODE_KEY,MD5Utils.MD5(randowmNum));
		return successJson();
	}

	/**
	 * 检查用户名是否注册过
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping("checkLoginName.do")
	@ResponseBody
	public String checkLoginName(String loginName) {
		if (StringUtil.isNotNullOrEmpty(loginName)) {
			UserInfo userInfo = userInfoService.selectByLoginName(loginName);
			if (userInfo != null) {
				return "false";
			}
		}
		return "true";
	}

	/**
	 * 校验邮箱验证码
	 * 
	 * @param request
	 * @param verifyCode
	 * @return
	 */
	@RequestMapping("checkVerifyCode.do")
	@ResponseBody
	public String checkVerifyCode(String verifyCode) {
		String s=(String) getSessionAttribute(SecurityConstant.USER_REGISTER_VERIFY_CODE_KEY);
		if (MD5Utils.MD5(verifyCode).equals(s)) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("register.do")
	@ResponseBody
	public String register(RegisterVO registerVO) {
		UserInfo userInfo = registerVO.getUserInfo();
		userInfo.setState(SecurityConstant.State.ok.getIndex());
		userInfo.setLoginPwd(MD5Utils.MD5(userInfo.getLoginPwd()));
		userInfo.setNickName("SCM-ERP_"+System.currentTimeMillis());

		ShopInfo shopInfo = registerVO.getShopInfo();
		shopInfo.setState(SecurityConstant.State.ok.getIndex());
		shopInfo.setEmail(userInfo.getLoginName());

		userInfoService.addUserAndShop(userInfo, shopInfo);
		return successJson();
	}

	/**
	 * 跳转到找回密码界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "toBackPwd.htm")
	public String toBackPwd() {
		return "backPwd";
	}

	/**
	 * 找回密码时检查用户名是否存在
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping("checkLoginNameForPwd.do")
	@ResponseBody
	public String checkLoginNameForPwd(String loginName) {
		if (StringUtil.isNotNullOrEmpty(loginName)) {
			UserInfo userInfo = userInfoService.selectByLoginName(loginName);
			if (userInfo == null) {
				return "false";
			}
		}
		return "true";
	}

	/**
	 * 找回密码发送邮箱验证码
	 * 
	 * @param request
	 * @param mail
	 * @return
	 */
	@RequestMapping(value = "sendMail.do")
	@ResponseBody
	public String sendMail(String mail) {
		try {
			String randowmNum = StringUtil.createRandowmNum(6);
			String content = "<html><body>欢迎SCM-ERP在线销售分析服务：<br />您本次验证码为：<span style=\"color:red\">"
					+ randowmNum + "</span>.请勿直接回复，谢谢！</body></html>";
			 MailUtil email = new MailUtil();
			 email.sendEmail(mail, "SCM-ERP在线销售分析系统", content);

			log.info("找回密码发送邮箱验证码:"+content);
			setSessionAttribute(SecurityConstant.USER_BACKPWD_EMAIL_CODE_KEY,MD5Utils.MD5(randowmNum));
		} catch (Exception e) {
			return errorJson("服务器忙,请稍后再试");
		}
		return successJson();

	}

	/**
	 * 校验找回密码验证码
	 * 
	 * @param request
	 * @param pwdCode
	 * @return
	 */
	@RequestMapping(value = "checkBackPwdverifyCode.do")
	@ResponseBody
	public String checkBackPwdverifyCode(String pwdCode) {
		String backPwdCode = getVerifyCode(SecurityConstant.USER_BACKPWD_VERIFY_CODE_KEY);
		if (backPwdCode == null || !MD5Utils.MD5(pwdCode).equals(backPwdCode)) {
			return "false";
		}
		return "true";
	}

	/**
	 * 校验找回密码邮箱验证码
	 * 
	 * @param request
	 * @param mailCode
	 * @return
	 */
	@RequestMapping(value = "checkBackPwdMailCode.do")
	@ResponseBody
	public String checkBackPwdMailCode(String mailCode) {
		String backPwdCode = (String) getSessionAttribute(SecurityConstant.USER_BACKPWD_EMAIL_CODE_KEY);
		if (backPwdCode == null || !MD5Utils.MD5(mailCode).equals(backPwdCode)) {
			return "false";
		}
		return "true";
	}

	/**
	 * 找回密码
	 * 
	 * @param request
	 * @param loginName
	 * @param verifyCode
	 * @param mailCode
	 * @param newPwd
	 * @return
	 */
	@RequestMapping(value = "backPwd.do")
	@ResponseBody
	public String backPwd(String loginName,
			String verifyCode, String mailCode, String newPwd) {
		String backPwdCode = getVerifyCode(SecurityConstant.USER_BACKPWD_VERIFY_CODE_KEY);
		if (backPwdCode == null
				|| !MD5Utils.MD5(verifyCode).equals(backPwdCode)) {
			return errorJson("验证码错误");
		}
		
		String backPwdMailCode = (String)getSessionAttribute(SecurityConstant.USER_BACKPWD_EMAIL_CODE_KEY);
		if (backPwdMailCode == null
				|| !MD5Utils.MD5(mailCode).equals(backPwdMailCode)) {
			return errorJson("邮箱验证码错误");
		}
		UserInfo userInfo = userInfoService.selectByLoginName(loginName);
		userInfo.setLoginPwd(MD5Utils.MD5(newPwd));
		userInfoService.updateUserInfo(userInfo);
		return successJson();
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
