package com.qtt.wx.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CMyUtils {
	public CMyUtils() {
	}

	// format:yyyy-MM-dd HH:mm:ss
	static public Date StringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	static public Date DateAdd(Date date1, int days) {
		Date newdate = null;

		newdate = new Date(date1.getTime() + days * 24 * 60 * 60 * 1000);

		return newdate;
	}

	static public String DateToString(Date date, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		String dateStr = "";
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateStr;
	}

	
	static public String GetCurrentDateTime() {
		String split_char = "";
		String split_char2 = "";

		Calendar p_cal = Calendar.getInstance();
		String timestr = p_cal.get(Calendar.YEAR) + split_char
				+ String.format("%02d", p_cal.get(Calendar.MONTH) + 1)
				+ split_char
				+ String.format("%02d", p_cal.get(Calendar.DAY_OF_MONTH))
				+ String.format("%02d", p_cal.get(Calendar.HOUR_OF_DAY))
				+ split_char2
				+ String.format("%02d", p_cal.get(Calendar.MINUTE))
				+ split_char2
				+ String.format("%02d", p_cal.get(Calendar.SECOND));
		// + "." +
		// p_cal.get(Calendar.MILLISECOND);

		p_cal = null;

		return timestr;
	}

	static public boolean isNumber(String data) {
		boolean ret = true;
		int len = data.length();
		for (int i = 0; i < len; i++) {
			// System.out.println(data.charAt(i)+":"+data.codePointAt(i));
			if (data.codePointAt(i) < 48 || data.codePointAt(i) > 57) {
				ret = false;
			}
		}

		return ret;
	}

	public static String GetMD5(String data) {
		String ret = "";

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}

				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}

			ret = buf.toString();

			//System.out.println("result: " + ret);// 32位的加密
		} catch (Exception e) {
		}
		return ret;
	}


	static public String HZ2UTF8(String data)
	{
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < data.length(); i++)
        {
            output.append("\\u" +Integer.toString(data.charAt(i), 16));
        }
		
		return output.toString();
	}
	
	public static String getStrTime(){
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	}
	
	public static String getNumTime(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	public static String getNumDate(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	public static boolean isValidDate(String str) {
	      boolean convertSuccess=true;
	// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
	       SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	       try {
	// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}
}
