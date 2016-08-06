package com.codecrane.core.controller;

import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Crane(hehebaiy@gmail.com)
 * <br/>
 * <br/>
 */
@Controller
public class PingController {

	@RequestMapping("/index")
	public String ping(Model model){
		return "/login";
	}
	
	@RequestMapping("/pingpage")
	public ModelAndView pingpage(){
		ModelAndView view = new ModelAndView("/ping");
		view.addObject("hello", "hello world");
		return view;
	}
	
	/**
	 * 文件上传示例页面
	 * @param file
	 * @return
	 */
	@RequestMapping("/exp/uploadpage")
	public String fileUploadExpPage(){
		return "/example/fileupload";
	}
	
	/**
	 * 文件上传解析
	 * @param mfile
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/exp/upload",method=RequestMethod.POST)
	public AjaxReturn fileUploadExp(@RequestParam("mfile")MultipartFile mfile){
		AjaxReturn result = Ajax.fail();
		if( !mfile.isEmpty() ){ 
			Map<String, Object> fileInfo = new HashMap<String, Object>();
			fileInfo.put("name", mfile.getName());
			fileInfo.put("type", mfile.getContentType());
			fileInfo.put("size", mfile.getSize());
			fileInfo.put("originalname", mfile.getOriginalFilename());
			result.setOk(true).setData(fileInfo);
		}
		return result;
	}
}
