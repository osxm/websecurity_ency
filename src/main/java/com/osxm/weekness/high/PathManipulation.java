/**  
* @Title: PathManipulation.java
* @Package com.osxm.weekness.high
* @Description: TODO
* @author XM
* @date 2023年2月9日 下午9:27:32
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.high;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathManipulation {

	@Test
	public void javaPathNormalize(String filePath) {
		Path path = Paths.get(filePath);
		Assert.assertTrue("C:\\myapp\\myfile\\..\\..\\Windows\\system.ini".equals(path.toString()));
		//
		path = path.normalize();
		Assert.assertTrue("C:\\Windows\\system.ini".equals(path.toString()));

	}

	public void demo() {
		FilenameUtils.normalize("/foo/../bar/../baz");
	}

	@RequestMapping("/canScan")
	public void canScan(String fileName) {
		Path path = Paths.get(fileName).normalize().toAbsolutePath();
		path.toFile();
	}

	public void noScan(String fileName) {
		Path path = Paths.get(fileName).normalize().toAbsolutePath();
		path.toFile();
	}

//////////////////////////////////////////////
	public boolean isValidPath(String filePath) {
		return filePath.startsWith("D:\\myapp");
	}

	@RequestMapping("/whilteListSafeButScan")
	public void whilteListSafeButScan(String fileName) {
		Path path = Paths.get(fileName).normalize().toAbsolutePath();
		if (isValidPath(path.toString())) {
			path.toFile();
		}
	}

	///////////////////////////////////////////////
	public List<String> getWhiteListFile() {
		List<String> list = new ArrayList<String>();
		list.add("D:\\temp1\1.txt");
		list.add("D:\\temp2\2.txt");
		return list;
	}

	@RequestMapping("/whilteListSafeButScan2")
	public void whilteListSafeButScan2(String fileName) {
		if (getWhiteListFile().contains(fileName)) {
			File file = new File(fileName);
			file.notify();
		}
	}

	@RequestMapping("/whilteListSafeButScan3")
	public void whilteListSafeButScan3(String fileName) {
		if ("D:\\temp2\2.txt".equals(fileName)) {
			File file = new File(fileName);
			file.notify();
		}
	}

	//////////////////////////////
	@RequestMapping("/blackListSafeNoScan")
	public void blackListSafeNoScan(String fileName) {
		if (fileName.indexOf("..") < 0) {
			File file = new File(fileName);
			file.notify();
		}

	}

	@RequestMapping("/blackListSafeButScan")
	public void blackListSafeButScan(String fileName) {
		if (isValid(fileName)) {
			File file = new File(fileName);
			file.notify();
		}

	}

	public boolean isValid(String fileName) {
		boolean isValid = false;
		if (fileName.indexOf("..") < 0) {
			isValid = true;
		}
		return isValid;
	}

	@RequestMapping("/blackListSafeButScan2")
	public void blackListSafeButScan2(String fileName) {
		fileName = fileName.replaceAll("\\.\\.", "-");
		File file = new File(fileName);
		file.notify();

	}

	@RequestMapping("/blackListSafeButScan3")
	public void blackListSafeButScan3(String fileName) throws Exception {
		char[] originalChars = fileName.toCharArray();
		for (int i = 0; i < originalChars.length; i++) {
			if (originalChars[i] == '.') {
				throw new Exception("invalid file path");
			}
		}
		File file = new File(fileName);
		file.notify();
	}

	public static String fileNameClone(String fileName) {
		String newFileName = "";
		if (fileName != null && fileName.length() > 0) {
			char[] originalChars = fileName.toCharArray();
			char[] chars = new char[originalChars.length];
			for (int i = 0; i < originalChars.length; i++) {
				chars[i] = originalChars[i];
			}
			return new String(chars);
		} else {
			return newFileName;
		}
	}

	@RequestMapping("/noSafeButNoScan")
	public void noSafeButNoScan(String fileName) {
		fileName = fileNameClone(fileName);
		File file = new File(fileName);
		file.notify();
	}

	@RequestMapping("/noSafeAndScan")
	public void noSafeAndScan(String fileName) {
		String newFileName = "";
		if (fileName != null && fileName.length() > 0) {
			char[] originalChars = fileName.toCharArray();
			char[] chars = new char[originalChars.length];
			for (int i = 0; i < originalChars.length; i++) {
				chars[i] = originalChars[i];
			}
			newFileName = new String(chars);
		}
		File file = new File(newFileName);
		file.notify();
	}

	public static String getSecurityFileName(String fileName) throws Exception {
		String newFileName = null;
		if (fileName != null && fileName.length() > 0) {
			//
			fileName = FilenameUtils.normalize(fileName);
			char[] originalChars = fileName.toCharArray();
			char[] chars = new char[originalChars.length];
			for (int i = 0; i < originalChars.length; i++) {
				chars[i] = originalChars[i];
			}
			newFileName = new String(chars);
			if (!newFileName.startsWith("D:\\myapp")) {
				throw new Exception("invalid file path.");
			}
		}

		return newFileName;
	}

	@RequestMapping("/safeNoScan")
	public void safeNoScan(String fileName) throws Exception {
		fileName = getSecurityFileName(fileName);
		File file = new File(fileName);
		file.notify();
	}
}
