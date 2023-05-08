/**  
* @Title: RepeatCondTest.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月1日 下午8:08:37
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.osxm.websecurity.model.User;

public class RepeatCondTest {

	
	@Autowired
	private EntityManager em;
	
	public void repeatCondTest(int x) {
		if(x >0) {
			System.out.print("x="+x);
		}
		
		if(x >0) {
			System.out.print("x="+x);
		}
	}
	

	public void repeatCondTest2() {
		User usr = em.find(User.class, "001");	
		if(usr.getName().equals("User1")||usr.getName().equals("User1")) {
			System.out.println("Hello.");
		}
		
		if(usr.getName()!=null) {
			if(usr.getName()!=null) {
				System.out.println("Hello.");
			}
		}
	}

}
