/**
 * 
 */
package com.example.anpf.testserver.controller;

import java.util.Objects;

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

	@CrossOrigin
	@PostMapping(value="api/login")
	@ResponseBody
	public Result login(@RequestBody User reqUser) {
		String name = reqUser.getName();
		name = HtmlUtils.htmlEscape(name);
		String pwd = reqUser.getPassword();
		if(!Objects.equals("admin",name) && !Objects.equals("123456", pwd)) {
			String message = "账号或密码错误";
			System.out.print(message);
			return new Result(400);
		} else {
			return new Result(200);
		}		
	}
}
