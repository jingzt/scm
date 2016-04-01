package com.scm.controller.shop;

import java.io.File;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.scm.controller.BaseController;
import com.scm.utils.DateUtils;
import com.scm.utils.StringUtil;

/**
 * 文件上传controller
 * 
 * @author jingzt
 *
 */
@Controller
@RequestMapping("/common")
public class UploadController extends BaseController {
	private Logger log = Logger.getLogger(UploadController.class);

	@ResponseBody
	@RequestMapping("/upload.do")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws ParseException {
		String path = request.getSession().getServletContext().getRealPath("/");
		String sysPath = "/upload/" + DateUtils.formatDate(new Date(), "yyyyMMdd") + "/";
		File existFolder = new File(path + sysPath);
		if (!existFolder.exists()) {// 判断文件夹存在不存在，不存在新建一个
			existFolder.mkdir();
		}

		String fileName = file.getOriginalFilename();
		String suffix = "";// 文件后缀
		if (fileName.indexOf(".") > -1) {
			suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		} else {
			suffix = "";
		}
		String createFilename = DateUtils.getShortSystemTime() + StringUtil.createRandowmNum(6) + "." + suffix;
		File targetFile = new File(path + sysPath, createFilename);
		String json = "";
		suffix = suffix.toUpperCase();

		// 保存
		try {
			file.transferTo(targetFile);
			return successJson("msg","上传成功","filePathAndName",sysPath.substring(1) + createFilename);
		} catch (Exception e) {
			log.error("上传文件出错："+e.getMessage());
			return errorJson("上传失败,请联系管理员.");
		}
		

	}

	@RequestMapping("/uploadError")
	public void uploadError(HttpServletRequest request, HttpServletResponse response) {
		log.error("文件超出大小");
		String json = "{success:" + false + ",msgText:'" + "大小查出20M" + "'}";
		// WebUtil.out(response, json);
	}
}
