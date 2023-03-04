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

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;

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

	@RequestMapping("/openRedirectRepair1")
	public String openRedirectRepair1(String url) throws Exception {
		// 检查 URL 是否以“http://”或“https://”开头
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
			throw new IllegalArgumentException("Invalid URL");
		}
		// 检查 URL 是否与预期的域名匹配
		URI uri = new URI(url);
		if (!"example.com".equals(uri.getHost())) {
			throw new IllegalArgumentException("Invalid URL");
		}
		// 发送请求并返回结果
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
	}

	@RequestMapping("/openRedirectRepair2")
	public String openRedirectRepair2(String url) throws Exception {
		String host = "example.com"; // 预期的域名
		// 检查 URL 是否以“http://”或“https://”开头
		if (!url.toLowerCase().startsWith("http://") && !url.toLowerCase().startsWith("https://")) {
			throw new IllegalArgumentException("Invalid URL");
		}
		// 解析 URL
		URI uri;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Invalid URL");
		}
		String protocol = uri.getScheme();
		String authority = uri.getAuthority();
		String path = uri.getPath();
		String query = uri.getQuery();
		String fragment = uri.getFragment();
		// 检查 URL 是否与预期的域名匹配
		if (!host.equals(uri.getHost())) {
			throw new IllegalArgumentException("Invalid URL");
		}
		// 根据需求自定义查询参数
		StringBuilder queryParams = new StringBuilder();
		if (query != null) {
			String[] pairs = query.split("&");
			for (String pair : pairs) {
				int idx = pair.indexOf("=");
				String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
				if (!"redirect".equals(key)) { // 如果参数名不是"redirect"，则加入查询参数列表
					if (queryParams.length() > 0) {
						queryParams.append("&");
					}
					queryParams.append(pair);
				}
			}
		}
		// 构造安全的 URL
		StringBuilder safeUrl = new StringBuilder();
		safeUrl.append(protocol).append("://").append(authority);
		if (path != null) {
			safeUrl.append(path);
		}
		if (queryParams.length() > 0) {
			safeUrl.append("?").append(queryParams);
		}
		if (fragment != null) {
			safeUrl.append("#").append(fragment);
		}
		// 发送请求并返回结果
		ResponseEntity<String> response = restTemplate.getForEntity(safeUrl.toString(), String.class);
		return response.getBody();
	}

}
