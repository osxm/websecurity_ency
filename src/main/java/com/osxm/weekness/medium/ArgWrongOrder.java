/**  
* @Title: ArgWrongOrder.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年2月28日 下午9:50:31
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import com.osxm.websecurity.model.User;

public class ArgWrongOrder {
	public void argWrongOrder(User user) {
		boolean isAdmin = checkUser(user.getId(), user.getName());
		System.out.println(isAdmin);
	}

	public boolean checkUser(String name, String id) {
		boolean isAdmin = false;
		if ("user1".equals(name) && "1234".equals(id)) {
			isAdmin = true;
		}
		return isAdmin;
	}
}
