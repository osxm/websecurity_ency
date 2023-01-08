/**  
* @Title: XssController.java
* @Package com.osxm.websecurity.xss
* @Description: TODO
* @author XM
* @date 2023年1月8日 下午8:38:09
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.xss;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName XssController
 * @Description TODO
 * @author XM 
 * @date 2023年1月8日
 * 
 */
@RestController
@RequestMapping("/xss")
public class XssController {

	@RequestMapping("/unsafe")
	public String unsafe(@RequestParam(required = false) String input) {
		String s = "Hello";
		s += input;
		return s;
	}

	@RequestMapping("/safe")
	public String safe(@RequestParam(required = false) String input) {
		String s = "Hello";
		s += input;
		return SecurityUtil.htmlElementContent(s);
	}
}
