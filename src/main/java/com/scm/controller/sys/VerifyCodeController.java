package com.scm.controller.sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.utils.MD5Utils;



@Controller
@RequestMapping("/")
public class VerifyCodeController extends BaseController{
	private Logger log = Logger.getLogger(VerifyCodeController.class);
	/**
	 * 
	 * @param request
	 * @param response
	 * @param common  login=登录 back=找回密码  register=注册
	 * @throws Exception
	 */
	@RequestMapping(value = "verify.htm")  
	public void getVerifyImage(HttpServletResponse response,String common) throws Exception {  
		// 在内存中创建图象
		int width = 85, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(6位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 13 * i + 6, 16);
		}	
		
		 // login=登录 back=找回密码  register=注册
		Cookie cookie=null;
		if("login".equals(common)){
			 cookie = new Cookie(SecurityConstant.USER_LOGIN_VERIFY_CODE_KEY,MD5Utils.MD5(sRand));
		}else if ("back".equals(common)){
			 cookie = new Cookie(SecurityConstant.USER_BACKPWD_VERIFY_CODE_KEY,MD5Utils.MD5(sRand));
		}else if("register".equals(common)){
			 cookie = new Cookie(SecurityConstant.USER_REGISTER_VERIFY_CODE_KEY,MD5Utils.MD5(sRand));
		}
	    cookie.setPath("/");
	    response.addCookie(cookie);
		
		// 图象生效
		g.dispose();
		ServletOutputStream out = response.getOutputStream();  
		try {
			ImageOutputStream imageOut = ImageIO.createImageOutputStream(out);
			ImageIO.write(image, "JPEG", imageOut);
			imageOut.flush();
			imageOut.close();
		} catch (Exception e) {
			log.error("验证码图片产生出现错误：" + e.toString());
		}

	}

	/*
	 * 给定范围获得随机颜色
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
