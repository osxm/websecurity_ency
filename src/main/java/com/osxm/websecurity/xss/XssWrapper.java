/**  
* @Title: XssWrapper.java
* @Package com.osxm.websecurity.xss
* @Description: TODO
* @author XM
* @date 2023年1月8日 下午8:10:49
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.xss;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName XssWrapper
 * @Description TODO
 * @author XM 
 * @date 2023年1月8日
 * 
 */

public class XssWrapper extends HttpServletRequestWrapper {

	public static final String JSON_TYPE = "application/json";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CHARSET = "UTF-8";
	private String mBody;
	HttpServletRequest originalRequest = null;

	public XssWrapper(HttpServletRequest request) throws IOException {
		super(request);
		originalRequest = request;
		setRequestBody(request.getInputStream());
	}

	/**
	 * 获取最原始的request。已经被getInputStream()了。
	 *
	 * @return
	 */
	public HttpServletRequest getOrgRequest() {
		return originalRequest;
	}

	/**
	 * 获取最原始的request的静态方法。已经被getInputStream()了。
	 *
	 * @return
	 */
	public static HttpServletRequest getOriginalRequest(HttpServletRequest req) {
		if (req instanceof XssWrapper) {
			return ((XssWrapper) req).getOrgRequest();
		}
		return req;
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (StringUtils.isBlank(value)) {
			return value;
		}
		return StringEscapeUtils.escapeHtml4(value);
	}

	@Override
	public String getQueryString() {
		return StringUtils.isBlank(super.getQueryString()) ? "" : StringEscapeUtils.escapeHtml4(super.getQueryString());
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (StringUtils.isBlank(value)) {
			return value;
		}
		return StringEscapeUtils.escapeHtml4(value);
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values == null) {
			return values;
		}

		for (int i = 0; i < values.length; i++) {
			values[i] = StringEscapeUtils.escapeHtml4(values[i]);
		}
		return values;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = new LinkedHashMap<String, String[]>();
		Map<String, String[]> parameterMap = super.getParameterMap();

		if (parameterMap == null) {
			return super.getParameterMap();
		}

		for (String key : parameterMap.keySet()) {
			String[] values = parameterMap.get(key);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					values[i] = StringEscapeUtils.escapeHtml4(values[i]);
				}
			}
			map.put(key, values);
		}
		return map;
	}

	private void setRequestBody(InputStream stream) throws JsonMappingException, JsonProcessingException {
		String line = "";
		StringBuilder body = new StringBuilder();

		// 读取POST提交的数据内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.forName(CHARSET)));
		try {
			while ((line = reader.readLine()) != null) {
				body.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mBody = body.toString();

		if (StringUtils.isBlank(mBody)) {// 为空时，直接返回
			return;
		}
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(mBody, Map.class);

		Map<String, Object> resultMap = new HashMap<>(map.size());
		for (String key : map.keySet()) {
			Object val = map.get(key);

			if (map.get(key) instanceof String) {
				resultMap.put(key, StringEscapeUtils.escapeHtml4(val.toString()));
			} else {
				resultMap.put(key, val);
			}
		}
		mBody = objectMapper.writeValueAsString(resultMap);
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		if (!JSON_TYPE.equalsIgnoreCase(super.getHeader(CONTENT_TYPE))) {// 非json类型，直接返回
			return super.getInputStream();
		}

		if (StringUtils.isBlank(mBody)) {// 为空时，直接返回
			return super.getInputStream();
		}

		final ByteArrayInputStream bais = new ByteArrayInputStream(mBody.getBytes(CHARSET));
		return new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {
			}
		};
	}
}
