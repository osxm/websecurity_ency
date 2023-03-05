/**  
* @Title: IgnoreException.java
* @Package com.osxm.weekness.low
* @Description: TODO
* @author XM
* @date 2023年2月22日 下午9:28:08
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.low;

public class IgnoreException {

	public String demo(String str) {
		String newStr = "";
		try {
			newStr = str.substring(3);
		} catch (Exception e) {
			//没有处理异常
		}
		return newStr;
	}
}
