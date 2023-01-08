/**  
* @Title: SecurityUtil.java
* @Package com.osxm.websecurity.xss
* @Description: TODO
* @author XM
* @date 2023年1月8日 下午8:07:32
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.xss;

/**
 * @ClassName SecurityUtil
 * @Description TODO
 * @author XM 
 * @date 2023年1月8日
 * 
 */
public class SecurityUtil {
	/**
	 * XSS 防御， 黑名单， 将非法字符进行替换
	 * @param content
	 * @return
	 */
	public static String htmlElementContent(String content) {
		if (content == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			if (c == '<') {
				sb.append("&lt;");
			} else if (c == '>') {
				sb.append("&gt;");
			} else if (c == '\'') {
				sb.append("&#39;");
			} else if (c == '&') {
				sb.append("&amp;");
			} else if (c == '"') {
				sb.append("&quot;");
			} else if (c == '/') {
				sb.append("&#47;");
			} else {
				sb.append(c);
			}
		}

		return (sb.length() > content.length()) ? sb.toString() : content;
	}
}
