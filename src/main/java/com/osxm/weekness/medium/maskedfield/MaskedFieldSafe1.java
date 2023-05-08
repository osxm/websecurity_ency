/**  
* @Title: MaskedFieldSafe1.java
* @Package com.osxm.weekness.medium.maskedfield
* @Description: TODO
* @author XM
* @date 2023年5月5日 下午9:44:31
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium.maskedfield;

public class MaskedFieldSafe1 {
	public int secretNumber;

	public void setSecretNumber(int secretNumber) {
		this.secretNumber = secretNumber;
	}

	public int getNumber() {
		return secretNumber & 0xFFFF;
	}

	public void setNumber(int number) {
		secretNumber = (secretNumber & 0xFFFF0000) | (number & 0xFFFF);
	}
}
