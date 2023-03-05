/**  
* @Title: ApiController.java
* @Package com.osxm.websecurity.controller
* @Description: TODO
* @author XM
* @date 2023年2月8日 下午10:24:57
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/hi")
	public String hi() {
		return "hi, api with basic Auth";
	}
}
