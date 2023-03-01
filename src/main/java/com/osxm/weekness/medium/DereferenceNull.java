/**  
* @Title: DereferenceNull.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年2月22日 下午9:10:56
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osxm.websecurity.model.User;

@Service
public class DereferenceNull {

	@Autowired
	private EntityManager em;

	public String derefNul(String userName) {
		String rtnStr = "";
		String userName2 = userName.substring(1);
		if (userName != null) { //
			rtnStr += userName2;
		}
		return rtnStr;
	}

	/**
	 * Coverity 扫描不出
	 * 
	 * @param userName
	 * @return
	 */
	public String derefNulNoScan(String userName) {
		String rtnStr = "";
		userName = userName.substring(1);
		if (userName != null) { //
			rtnStr += userName;
		}
		return rtnStr;
	}

	/**
	 * 显式空指针间接引用
	 */
	public void explicitNullDereferenced() {
		String userName = null;
		User usr = em.find(User.class, "001");
		if (usr != null) {
			userName = usr.getName();
		}
		if (userName.equals("User1")) { // Explicit null dereferenced
			System.out.println("Hello.");
		}

	}
}
