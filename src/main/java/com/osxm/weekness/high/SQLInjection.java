/**  
* @Title: SQLInjection.java
* @Package com.osxm.weekness.high
* @Description: TODO
* @author XM
* @date 2023年5月26日 上午6:50:46
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.high;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osxm.websecurity.model.User;

@Service
public class SQLInjection {
	
	@Autowired
	private EntityManager em;
	
	public List<User> sqlInjection(String id) {
		String sql = "select * from usr where id = "+id;
		List<User> list = em.createNativeQuery(sql,User.class).getResultList();
		return list;
	}

}
