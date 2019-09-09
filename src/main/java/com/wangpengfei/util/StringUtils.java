package com.wangpengfei.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 王鹏飞
 *
 * 2019年9月9日上午9:39:02
 */
public class StringUtils {
public static String toHtml(String text){
		
		String[] strings = text.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append("<p>").append(string).append("</p>");
		}
		
		String[] split = text.split("\\\r");
		for (String string : split) {
			sb.append(string).append("<br/>");
		}
		
		return sb.toString();
	}
	
	public static boolean isEmail(String str){
		Pattern pattern = Pattern.compile("\\w+@\\w+.\\w{2,3}");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static boolean isPhone(String str){
		Pattern pattern = Pattern.compile("(13|15|17|18)\\d{9}");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static boolean hasText(String text){
		return !(text==null||"".equals(text));
	}
}
