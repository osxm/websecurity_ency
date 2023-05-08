/**  
* @Title: MaskedField.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月5日 下午9:35:12
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium.maskedfield;

public class MaskedField {

	private int secretNumber;

	public int getNumber() {
		return secretNumber & 0xFFFF;
	}

	public void setNumber(int number) {
		secretNumber = number & 0xFFFF0000;
	}
}
