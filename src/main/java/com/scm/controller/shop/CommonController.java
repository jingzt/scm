package com.scm.controller.shop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/common")
@Controller
public class CommonController {

	/**
	 * 下拉列表，公共方法
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/listCombobox.do")
	public void listCombobox(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("<option value=\"\" >请选择</option><option value=\"1\" >测试一</option><option value=\"2\" >测试二</option>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
