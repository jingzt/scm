package com.scm.controller.wx;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.utils.StringUtil;

/**
 * 类说明
 * 
 * @author jingzt 2016年3月25日 下午1:56:28
 */

@Controller
@RequestMapping("/init")
public class InitController extends BaseController {
	private static final Logger log = Logger.getLogger(InitController.class);

	@RequestMapping("/verificationToken")
	@ResponseBody
	public String verificationToken(String signature, String timestamp, String nonce, String echostr) throws Exception {

		String[] array = { SecurityConstant.token, timestamp, nonce, };
		Arrays.sort(array);
		StringBuffer sb = new StringBuffer();
		for (String s : array) {
			sb.append(s);
		}

		String sha1 = StringUtil.Sha1(sb.toString());
		if (sha1.equals(signature)) {
			log.info("结果一致...");
			return echostr;
		}
		return null;
	}

	@RequestMapping("/getAccessToken")
	@ResponseBody
	public String getAccessToken() {
		return SecurityConstant.ACCESS_TOKE;
	}

}
