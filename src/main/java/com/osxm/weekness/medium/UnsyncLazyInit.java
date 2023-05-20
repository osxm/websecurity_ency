/**  
* @Title: UnsyncLazyInit.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月19日 下午9:44:04
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.util.ArrayList;
import java.util.List;

public class UnsyncLazyInit {

	private static UnsyncLazyInit instance = null;
	
	private static  List<String> list;
	
	private static  List<String> list2;
	
	public static UnsyncLazyInit getInstance() {
		if(instance == null) {
			instance = new UnsyncLazyInit();
		}
		return instance;
	}
	
	public List<String> getList(){
		list = new ArrayList<String>();
		list.add("123");
		return list;
	}
	
	public static synchronized List<String> getListSafe(){
	    if(list2 == null){
	        list2 = new ArrayList<String>();
	        list2.add("123");
	    }
	    return list2;
	}
	
	
	public static List<String> initList() {
		List<String> list = new ArrayList<String>();
		list.add("123");
		return list;
	}

	public static class ListHolder {
		public static final List<String> list = UnsyncLazyInit.initList();
	}
    public List<String> getListSafe2() {
        return ListHolder.list;
    }
}
