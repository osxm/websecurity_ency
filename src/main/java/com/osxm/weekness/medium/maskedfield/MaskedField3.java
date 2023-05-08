/**  
* @Title: MaskedField3.java
* @Package com.osxm.weekness.medium.maskedfield
* @Description: TODO
* @author XM
* @date 2023年5月5日 下午10:09:51
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium.maskedfield;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaskedField3 extends AbstractService{

	@Autowired
	protected EntityManager em;
}
