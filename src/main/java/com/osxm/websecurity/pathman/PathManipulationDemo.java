/**  
* @Title: PathManipulationDemo.java
* @Package com.osxm.websecurity.pathman
* @Description: TODO
* @author XM
* @date 2023年1月10日 下午10:28:12
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.websecurity.pathman;

import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

/**
 * @ClassName PathManipulationDemo
 * @Description TODO
 * @author XM 
 * @date 2023年1月10日
 * 
 */
public class PathManipulationDemo {
	
	
	//@Test
	public void cleanFilePath() {
		String fileFullName = "C:\\temp\\..\\Windows\\system.ini";
		//fileFullName = cleanFilePath(fileFullName);
		//System.out.println(fileFullName);
		
		fileFullName = normalizeFilePath(fileFullName);
		System.out.println(fileFullName);
	}
	
	
	@Test
	public void cleanString() {
		String fileFullName = "C:\\temp\\..\\Windows\\system.ini";
		fileFullName = cleanString(fileFullName);
		System.out.println(fileFullName);  //C%%temp%..%Windows%system.ini
	}
	
	@Test
	public void normalize() {
		String fileFullName = "C:\\temp\\..\\Windows\\system.ini";
		fileFullName = FilenameUtils.normalize(fileFullName);
		System.out.println(fileFullName); // C:\Windows\system.ini

	}
	
	
	
	public static String normalizeFilePath(String filePath) {
		if (filePath != null) {
			char[] originalChars = filePath.toCharArray();
			char[] chars = new char[originalChars.length];
			for (int i = 0; i < originalChars.length; i++) {
				if (isValidPathChar(originalChars[i])) {
					chars[i] = originalChars[i];
				} else {
					chars[i] = '-';
				}
			}
			return new String(chars);
		} else {
			return null;
		}
	}

	public static boolean isValidPathChar(char c) {
		boolean isValid = false;
		String whiteListpathChars = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/_-:\\.";
		if (whiteListpathChars.indexOf(c) > 0) {
			isValid = true;
		}
		return isValid;
	}

	public static boolean isChineseChar(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION;
	}


	public static String cleanString(String aString) {
		if (aString == null)
			return null;
		String cleanString = "";
		for (int i = 0; i < aString.length(); ++i) {
			cleanString += cleanChar(aString.charAt(i));
		}
		return cleanString;
	}

	private static char cleanChar(char aChar) {

		// 0 - 9
		for (int i = 48; i < 58; ++i) {
			if (aChar == i)
				return (char) i;
		}

		// 'A' - 'Z'
		for (int i = 65; i < 91; ++i) {
			if (aChar == i)
				return (char) i;
		}

		// 'a' - 'z'
		for (int i = 97; i < 123; ++i) {
			if (aChar == i)
				return (char) i;
		}

		// other valid characters
		switch (aChar) {
		case '/':
			return '/';
		case '.':
			return '.';
		case '-':
			return '-';
		case '_':
			return '_';
		case ' ':
			return ' ';
		}
		return '%';
	}
}
