/**  
* @Title: CopyPasterError.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年3月1日 下午10:22:04
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

public class CopyPasterError {
	boolean foo(int k) {
		return true;
	}

	boolean bar(int k) {
		return true;
	}

	void stuff() {
	}

	int key1 = 1, key2 = 1;

	void bar() {
		if (foo(key1) && bar(key1)) {
			stuff();
		}
		// A COPY_PASTE_ERROR defect occurs here.
		if (foo(key2) && bar(key1)) {
			stuff();
		}
	}
}
