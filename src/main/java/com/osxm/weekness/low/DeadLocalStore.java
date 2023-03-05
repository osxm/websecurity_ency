/**  
* @Title: DeadLocalStore.java
* @Package com.osxm.weekness.low
* @Description: TODO
* @author XM
* @date 2023年2月8日 下午9:02:02
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.low;

import com.osxm.websecurity.model.User;

public class DeadLocalStore {
	
	public void dls(User user) {
		String s ="123";  // 变量定义未使用(Eclipse 提示)
		String username = user.getName(); //变量定义未使用(Eclipse 提示) + 本地变量存储了闲置不用的对象（静态扫描）
	}

}
