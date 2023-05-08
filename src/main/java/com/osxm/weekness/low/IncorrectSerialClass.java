/**  
* @Title: IncorrectSerialClass.java
* @Package com.osxm.weekness.low
* @Description: TODO
* @author XM
* @date 2023年4月24日 下午9:14:15
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.low;


import java.beans.Transient;
import java.io.Serializable;
import java.util.List;


import com.osxm.websecurity.model.User;

public class IncorrectSerialClass implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;

	@Transient
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
