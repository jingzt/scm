package com.scm.controller.region;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.controller.BaseController;
import com.scm.po.SysRegion;
import com.scm.service.SysRegionService;

@Controller
@RequestMapping("/region")
public class SysRegionController extends BaseController {
	private Logger log = Logger.getLogger(SysRegionController.class);
	@Autowired
	private SysRegionService sysRegionService;

	@RequestMapping(value = "getRegion.do")
	@ResponseBody
	public String getRegion(Integer pid) {
		List<SysRegion> list = sysRegionService.getReginByPid(pid);
		return listJson(list);
	}

}
