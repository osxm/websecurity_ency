/**  
* @Title: DeadCode.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年2月15日 下午11:05:07
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

public class DeadCode {
	void deadcode(Object o) throws Exception {
		if (o == null) {
			throw new Exception();
		}
		if (o == null) {
			// This line cannot be reached!
			System.out.println("o is null"); // 死代码， 永远不会执行
		}
	}
}
