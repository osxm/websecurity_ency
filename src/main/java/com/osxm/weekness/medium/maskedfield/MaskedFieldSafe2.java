/**  
* @Title: MaskedFieldSafe2.java
* @Package com.osxm.weekness.medium.maskedfield
* @Description: TODO
* @author XM
* @date 2023年5月5日 下午9:47:25
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium.maskedfield;

public class MaskedFieldSafe2 {

	public int getNumber(int secretNumber) {
		return secretNumber & 0xFFFF;
	}

	public int setNumber(int secretNumber, int number) {
		return (secretNumber & 0xFFFF0000) | (number & 0xFFFF);
	}
}
