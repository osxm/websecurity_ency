/**  
* @Title: ReferenceEquality.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月9日 下午10:27:44
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

public class ReferenceEquality {

	public void referenceEquality() {
		String str1 = "hello";
		String str2 = new String("hello");

		if (str1 == str2) {
			System.out.println("str1 and str2 are the same object");
		}
	}

	public void referenceEquality2(long maxNo) {
	    Long selectNo = maxNo +1;
	    Long nextNo = 0L;
	    if(selectNo==nextNo) {
	    	System.out.println("Hello.");
	    }
	}
	
	public void referenceEqualitySafe() {
		String str1 = "hello";
		String str2 = new String("hello");

		if (str1.equals(str2)) {
			System.out.println("str1 and str2 are the same object");
		}
	}
	
}
