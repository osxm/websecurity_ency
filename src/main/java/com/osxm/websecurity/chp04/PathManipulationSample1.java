/**  
* @Title: PathManipulationSample1.java
* @Package com.osxm.websecurity.chp04
* @Description: TODO
* @author XM
* @date 2024年6月27日 下午9:59:53
* @Copyright: 2024
* @version V1.0  
*/
package com.osxm.websecurity.chp04;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PathManipulationSample1
 * @Description TODO
 * @author XM 
 * @date 2024年6月27日
 * 
 */
public class PathManipulationSample1 {
	
	public static List<File> findClassesInPackageRisk(String codePath,String packageName, boolean recursive) {
        List<File> classFiles = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        File directory = new File(codePath + "/"+packagePath);
        if (directory.exists() && directory.isDirectory()) {
            // 递归搜索目录和子目录
            //findClassesInDirectory(directory, packageName, recursive, classFiles);
        }
        return classFiles;
    }
	
	public static List<File> findClassesInPackageSafe(String codePath, String packageName, boolean recursive) {
	    List<File> classFiles = new ArrayList<>();
	    if (packageName == null || packageName.contains("..") || packageName.startsWith("/")) {
	        throw new IllegalArgumentException("Invalid package name");
	    }
	    
	    Path basePath = Paths.get(codePath).normalize();
	    String packagePath = packageName.replace('.', File.separatorChar);
	    Path fullPackagePath = basePath.resolve(packagePath).normalize();
	    
	    // Security check: ensure we're not getting out of the code path directory
	    if (!fullPackagePath.startsWith(basePath)) {
	        throw new SecurityException("Resolved path escapes the target directory");
	    }
	    
	    File directory = fullPackagePath.toFile();
	    if (directory.exists() && directory.isDirectory()) {
	        // Recursive search in directory
	        //findClassesInDirectory(directory, packageName, recursive, classFiles);
	    }
	    return classFiles;
	}

}
