package com.suns.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suns.entity.User;
import com.suns.service.UserService;
import com.suns.utils.MD5Utils;
import com.suns.utils.UUIDUtils;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	//首页
//	@RequestMapping("index")
//	public String index(){
//		return "index";
//	}
	//跳转注册页面
	@RequestMapping("registerUI")
	public String registerUI(){
		return "register";
	}
	
	//用户注册
	@RequestMapping("register")
	public String register(User user){
		
		//加密用户密码
		user.setPassword(MD5Utils.md5(user.getPassword()));
		//设置用户id
		user.setUid(UUIDUtils.getId());
		//设置激活码
		user.setCode(UUIDUtils.getCode());
		
		service.regist(user);
		return "login";
	}
	//跳转登录界面
	@RequestMapping("loginUI")
	public String loginUI(){
		return "login";
	}
	@RequestMapping("login")
	public String login(String username,String password,Model model){
		password = MD5Utils.md5(password);
		User user = service.login(username, password);
		if(user == null){
			model.addAttribute("msg", "用户名密码不匹配");
			return "msg";
		}
		model.addAttribute("user", user);
		return "index";
	}
	//退出
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		
		return "index";
		
	}
	
	//日期转换器
    @InitBinder
    public void initBinder(WebDataBinder binder){
    	binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    	
    }

}
