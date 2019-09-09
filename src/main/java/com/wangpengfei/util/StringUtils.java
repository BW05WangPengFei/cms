package com.wangpengfei.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;
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
	
	public static String getOneChinese(){
		String string = "";
		int high;
		int low;
		Random random = new Random();
		
		high = (176+Math.abs(random.nextInt(39)));
		low = (161+Math.abs(random.nextInt(93)));
		byte[] b = new byte[2];
		
		b[0]=(Integer.valueOf(high)).byteValue();
		b[1]=(Integer.valueOf(low)).byteValue();
		
		try {
			string = new String(b,"GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
}
