/**  
* @Title: STCAL.java
* @Package com.osxm.weekness.medium
* @Description: TODO
* @author XM
* @date 2023年5月8日 下午9:30:50
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.weekness.medium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class STCAL {

	private static SimpleDateFormat ldf;

	public static SimpleDateFormat stacl() {
		ldf = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		ldf.setTimeZone(TimeZone.getDefault()); // 提示有风险1
		String dateStr = ldf.format(new Date()); // 提示有风险2
		System.out.println(dateStr);
		return ldf;
	}

	public static String formatDate2(Calendar calendar, String format) {
		ldf = new SimpleDateFormat(format);
		return ldf.format(calendar.getTime()); // 提示有风险
	}

	public SimpleDateFormat staclSafe() {
		SimpleDateFormat ldf2 = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		String dateStr = ldf2.format(new Date());
		System.out.println(dateStr);
		return ldf2;
	}

	private static final ThreadLocal<Calendar> threadLocalCalendar = new ThreadLocal<Calendar>() {
		@Override
		protected Calendar initialValue() {
			return Calendar.getInstance();
		}
	};

	public static String formatDate(Calendar calendar, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}

	public static String formatDateThreadSafe(String format) {
		Calendar calendar = threadLocalCalendar.get();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}
}
