/**  
* @Title: BadCastObjRef.java
* @Package com.osxm.weekness.low
* @Description: TODO
* @author XM
* @date 2023年3月5日 下午8:29:04
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.low;

import java.util.ArrayList;
import java.util.List;

import com.osxm.websecurity.model.User;

/**
 * @ClassName BadCastObjRef
 * @Description TODO
 * @author XM 
 * @date 2023年3月5日
 * 
 */
public class BadCastObjRef {

	public void badCastObjRef(Object obj) {
		List<User> userList = new ArrayList<User>();
		userList.add((User) obj);
		System.out.println(userList.size());
	}

	public void badCastObjRefSafe(Object obj) {
		List<User> userList = new ArrayList<User>();
		if (obj instanceof User) {
			userList.add((User) obj);
		}
		System.out.println(userList.size());
	}
}
