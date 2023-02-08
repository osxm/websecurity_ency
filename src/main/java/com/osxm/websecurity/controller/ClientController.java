/**  
* @Title: ClientController.java
* @Package com.osxm.websecurity.controller
* @Description: TODO
* @author XM
* @date 2023年2月8日 下午10:24:48
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

	@RequestMapping("/hi")
	public String hi() {
		return "hi, client can anonymous access.";
	}
}
