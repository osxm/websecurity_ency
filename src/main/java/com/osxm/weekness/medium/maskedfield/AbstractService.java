/**  
* @Title: AbstractService.java
* @Package com.osxm.weekness.medium.maskedfield
* @Description: TODO
* @author XM
* @date 2023年5月5日 下午10:09:18
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium.maskedfield;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractService {
	@Autowired
	protected EntityManager em;
}
