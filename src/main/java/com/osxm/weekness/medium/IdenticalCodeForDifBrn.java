/**  
* @Title: IdenticalCodeForDifBrn.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月19日 下午9:07:10
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.util.ArrayList;
import java.util.List;

public class IdenticalCodeForDifBrn {

	
	public void identicalCodeForDifBrn(int i) {
		List<String> list = new ArrayList<String>();
		if( i == 1) {
			list.add("123");
			list.add("456");
			list.add("789");
		}else if(i == 2){
			list.add("123");
			list.add("456");
			list.add("789");
		}else if(i == 3){
			list.add("123");
			list.add("456");
			list.add("789");
		}
		System.out.println(list.size());
	}
	
	public void hello() {
		System.out.println("Hello");
	}
}
