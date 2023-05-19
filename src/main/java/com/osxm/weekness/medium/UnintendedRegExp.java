/**  
* @Title: UnintendedRegExp.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月18日 下午10:34:40
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnintendedRegExp {
	

	/*
	 * . 在正则表达式中代表任意一个字符
	 */
	@Test
	public void regexConfusion() {
		String s = "D:/temp/../dd";
		s = s.replaceAll("..", "-");
		Assertions.assertEquals("------d", s);
		System.out.println(s); //------d
	}
	
	
	@Test
	public void regexRight() {
		String s = "D:/temp/../dd";
		s = s.replaceAll("\\.\\.", "-");
		Assertions.assertEquals("D:/temp/-/dd", s);
	}
}
