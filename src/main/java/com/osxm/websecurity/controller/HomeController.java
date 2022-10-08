/**  
* @Title: HomeController.java
* @Package com.osxm.websecurity.controller
* @Description: TODO
* @author XM
* @date 2022年10月7日 下午8:29:20
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.websecurity.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private HttpServletRequest request;
	
	
	@RequestMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password) throws IOException {
		if("oscar".equals(username) && "123456".equals(password)) {
			request.getSession().setAttribute("username", username);
			return "index";
		}else {
			return "login";
		}
	}

}
