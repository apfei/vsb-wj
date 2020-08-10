/**
 * 
 */
package com.example.anpf.testserver.controller;

import javax.servlet.http.HttpSession;

import com.example.anpf.testserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import com.example.anpf.testserver.bean.User;
import com.example.anpf.testserver.result.Result;

/**
 * @author anpf
 * @date: 2020/08/07
 */

@Controller
public class LoginController {

	@Autowired
	UserService service;

	@CrossOrigin
	@PostMapping(value="api/login")
	@ResponseBody
	public Result login(@RequestBody User reqUser, HttpSession session) {
		String name = reqUser.getName();
		name = HtmlUtils.htmlEscape(name);
		String password = reqUser.getPassword();

		User user = service.getByNameAndPassword(name, password);
		if(null == user) {
			String message = "账号或密码错误";
			System.out.println(message);
			return new Result(400);
		} else {
			System.out.println("登录成功");
			session.setAttribute("user", user);
			return new Result(200);
		}		
	}
}
