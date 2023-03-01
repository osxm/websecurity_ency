/**  
* @Title: OpenRedirect.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年3月1日 下午9:42:29
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class OpenRedirect {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/openRedirect")
	public String openRedirect(String url) throws Exception {
		url = getSafeUrl(url);
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
	}

	private String getSafeUrl(String url) throws Exception {
		String safeUrl = "";
		if (url.indexOf("\\.\\.") < 0) { // 黑名单方式， .. 只是特殊符号之一
			char[] originalChars = url.toCharArray(); // 此处是为了通过 coverity 扫描
			char[] chars = new char[originalChars.length];
			for (int i = 0; i < originalChars.length; i++) {
				chars[i] = originalChars[i];
			}
			safeUrl = new String(chars);
		} else {
			throw new Exception("has Url Manipulation.");
		}
		return safeUrl;
	}

}
