/**  
* @Title: MeasuresTests.java
* @Package com.osxm.websecurity.pathtrave
* @Description: TODO
* @author XM
* @date 2022年10月13日 上午6:47:07
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.websecurity.pathtrave;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class MeasuresTests {

	
	@Test
	public void normalize() {
		Path path = Paths.get("/usr/local/../../etc/passwd").normalize(); 
		System.out.println(path.toAbsolutePath());
	}
	
	
	@Test
	public void getCanonicalPath() {
		File file = new File("");
	}
}
