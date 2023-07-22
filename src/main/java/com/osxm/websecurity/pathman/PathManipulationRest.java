/**  
* @Title: PathManipulationRest.java
* @Package com.osxm.websecurity.pathman
* @Description: TODO
* @author XM
* @date 2023年1月10日 下午10:32:20
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.pathman;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PathManipulationRest
 * @Description TODO
 * @author XM 
 * @date 2023年1月10日
 * 
 */
@RestController
public class PathManipulationRest {
	@RequestMapping("/unsafe")
	public void unsafe(String filefullName, HttpServletRequest request) {
		new File(filefullName);
	}

	@RequestMapping("/scanSafe")
	public void scanSafe(String filefullName, HttpServletRequest request) {
		new File(cleanFilePath(filefullName));
	}
	
	@RequestMapping("/safeRightWay")
	public void safeRightWay(String filefullName, HttpServletRequest request) {
		Path path = Paths.get(filefullName);
		path = path.normalize();
		String filePath = path.getParent().toString();
		if(isValidPath(filePath)) {
			File file = path.toFile();
		}
		
	}
	
	public boolean isValidPath(String filePath) {
		List<String> list = new ArrayList<String>();
		list.add("D:\\temp1");
		list.add("D:\\temp2");
		return list.contains(filePath);
	}
	
	

	public static String cleanFilePath(String filePath) {
		if (filePath != null) {
			char[] originalChars = filePath.toCharArray();
			char[] chars = new char[originalChars.length];
			for (int i = 0; i < originalChars.length; i++) {
				chars[i] = originalChars[i];
			}
			return new String(chars);
		} else {
			return null;
		}
	}
	
	@Test
	public void cleanFilePath() {
		String fileFullName = "C:\\temp\\..\\Windows\\system.ini";
		Assertions.assertTrue("C:\\temp\\..\\Windows\\system.ini".equals(cleanFilePath(fileFullName)));
	}

}
