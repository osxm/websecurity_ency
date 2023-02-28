/**  
* @Title: DereferenceNull.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年2月22日 下午9:10:56
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

public class DereferenceNull {

	public String derefNul(String userName) {
		String rtnStr = "";
		String userName2 = userName.substring(1);
		if (userName != null) { //
			rtnStr += userName2;
		}
		return rtnStr;
	}

	/**
	 * Coverity 扫描不出
	 * 
	 * @param userName
	 * @return
	 */
	public String derefNulNoScan(String userName) {
		String rtnStr = "";
		userName = userName.substring(1);
		if (userName != null) { //
			rtnStr += userName;
		}
		return rtnStr;
	}
}
