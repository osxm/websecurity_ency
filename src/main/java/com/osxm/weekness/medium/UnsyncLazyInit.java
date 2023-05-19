/**  
* @Title: UnsyncLazyInit.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月19日 下午9:44:04
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.util.ArrayList;
import java.util.List;

public class UnsyncLazyInit {

	private static UnsyncLazyInit instance = null;
	
	private static  List<String> list;
	
	public static UnsyncLazyInit getInstance() {
		if(instance == null) {
			instance = new UnsyncLazyInit();
		}
		return instance;
	}
	
	public List<String> getList(){
		list = new ArrayList<String>();
		list.add("123");
		return list;
	}
}
