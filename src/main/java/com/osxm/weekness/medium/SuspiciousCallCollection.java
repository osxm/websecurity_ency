/**  
* @Title: SuspiciousCallCollection.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年2月9日 下午9:12:38
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.util.ArrayList;
import java.util.List;

public class SuspiciousCallCollection {

	
	public void demo() {
		List<String> aList = new ArrayList<String>();
		List<String> bList = new ArrayList<String>();
		if (!aList.contains(bList)) {
			aList.addAll(bList);
		}
	}
}
