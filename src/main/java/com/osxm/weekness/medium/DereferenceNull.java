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

	public void derefAfterNullCheck() {
		User usr = em.find(User.class, "001");
		// usr可能为空， 这里使用的时候判空了
		if (usr != null) {
			System.out.println("User is not null.");
		} else {
			System.out.println("User is  null.");
		}
		// 这里使用又没有判空
		usr.setName("User1"); // 提示： Dereference after null check
	}

	public void derefAfterNullCheckSafe() {
		User usr = em.find(User.class, "001");
		// usr可能为空， 这里使用的时候判空了
		if (usr != null) {
			System.out.println("User is not null.");
			usr.setName("User1");
		} else {
			System.out.println("User is  null.");
		}
	}

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
	public void  explicitNullDereferenced2() {
		String str = null;
		if(str.length() == 0) {
		    System.out.println("Empty string");
		}
	}
	public void  explicitNullDereferencedSafe() {
		String str = null;
		if(str!=null&&str.length() == 0) {
		    System.out.println("Empty string");
		}
	}
	
	public void explicitNullDereferenced3() {
		String userName = null;
		User usr = em.find(User.class, "001");
		if (usr != null) {
			userName = usr.getName();
		}
		if (userName.equals("User1")) { // Explicit null dereferenced
			System.out.println("Hello.");
		}

	}
	
	public void explicitNullDereferenced3Safe() {
		String userName = null;
		User usr = em.find(User.class, "001");
		if (usr != null) {
			userName = usr.getName();
		}
		if (userName!=null && userName.equals("User1")) { // Explicit null dereferenced
			System.out.println("Hello.");
		}

	}
	
	public String dereferenceNullReturnValue() {
		return getObj().toString();
	}
	private Object getObj() {
		return null;
	}
}
