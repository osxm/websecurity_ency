/**  
* @Title: RiskCrypto.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年7月22日 上午10:06:42
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;


/**
 * @ClassName RiskCrypto
 * @Description TODO
 * @author XM 
 * @date 2023年7月22日
 * 
 */
public class RiskCrypto {

	@Test
	public void riskCrypto() throws Exception{
		String  content = "test string";
		content += "hello";
        byte[] bytes = content.getBytes("UTF-8");
        String md5Result = DigestUtils.md5Hex(bytes);
        System.out.println("md5Result="+md5Result);
	}
	
	@Test
	public void safe() throws Exception {
		String content = "hello";
        byte[] bytes = content.getBytes("UTF-8");
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(bytes);
        String hashHex = Hex.encodeHexString(hash);
        System.out.println("sha256Result="+hashHex);
	}
}
