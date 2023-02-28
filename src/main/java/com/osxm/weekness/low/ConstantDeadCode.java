/**  
* @Title: ConstantDeadCode.java
* @Package com.osxm.weekness.low
* @Description: TODO
* @author XM
* @date 2023年2月22日 下午9:17:57
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.low;

public class ConstantDeadCode {

	public void demo() {
		if (false) { // 死代码
			System.out.println("Hello World!");
		}
	}
}
