/**  
* @Title: OpenRedirectServlet.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年3月2日 下午10:38:05
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenRedirectServlet extends HttpServlet {

	private static final long serialVersionUID = -7525759240751953173L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirectUrl = request.getParameter("redirectUrl");
		if (redirectUrl != null && !redirectUrl.isEmpty()) {
			response.sendRedirect(redirectUrl);
		}
	}
	
	
	protected void doGetSafe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("redirectUrl");
		if (url != null && !url.isEmpty()) {
			if (!url.startsWith("http://") && !url.startsWith("https://")) {
				throw new IllegalArgumentException("Invalid URL");
			}
			// 检查 URL 是否与预期的域名匹配
			URI uri;
			try {
				uri = new URI(url);
				if (!"example.com".equals(uri.getHost())) {
					throw new IllegalArgumentException("Invalid URL");
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(url);
		}
	}
	
	
	/*protected void doGetSafe2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirectUrl = request.getParameter("redirectUrl");
		if (redirectUrl != null && !redirectUrl.isEmpty()) {
		    // 过滤重定向 URL，只保留需要的参数
		    String filteredUrl = filterUrl(redirectUrl);

		    // 验证重定向 URL，确保它是合法的
		    if (isValidUrl(filteredUrl)) {
		        // 使用相对路径进行重定向
		        response.sendRedirect(filteredUrl);
		    } else {
		        // 如果 URL 不合法，则返回错误页面
		        response.sendRedirect("/error");
		    }
		}
	}*/
}
