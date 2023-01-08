/**  
* @Title: XssFilter.java
* @Package com.osxm.websecurity.xss
* @Description: TODO
* @author XM
* @date 2023年1月8日 下午8:09:35
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.xss;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName XssFilter
 * @Description TODO
 * @author XM 
 * @date 2023年1月8日
 * 
 */
public class XssFilter {
    FilterConfig filterConfig = null;  
    
    public void init(FilterConfig filterConfig) throws ServletException {  
        this.filterConfig = filterConfig;  
    }  
  
    public void destroy() {  
        this.filterConfig = null;  
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssWrapper((HttpServletRequest) request), response);  
    }  
}
