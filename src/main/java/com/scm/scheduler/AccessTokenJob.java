package com.scm.scheduler;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.scm.constant.SecurityConstant;
import com.scm.utils.HttpUtils;
import com.scm.vo.AccessToken;

/**
 * 定时刷新access_token任务类 7200秒
 * 
 * @author jingzt 2016年3月29日 下午4:22:50
 */
@Component
public class AccessTokenJob {
	private Logger log = Logger.getLogger(AccessTokenJob.class);

	public void refreshAccessToken() {
		log.debug("定时刷新access_token...................................");
		String result = HttpUtils.doGet(SecurityConstant.ACCESS_TOKEN_URL.replace("APPID", SecurityConstant.APPID)
				.replace("APPSECRET", SecurityConstant.APPSECRET));
		AccessToken accessToken = JSON.parseObject(result, AccessToken.class);
		SecurityConstant.ACCESS_TOKE = accessToken.getAccess_token();
	}
}
