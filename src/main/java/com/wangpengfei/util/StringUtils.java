package com.wangpengfei.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.tools.classfile.StackMapTable_attribute.same_frame;

/**
 * @author ������
 *
 * 2019��9��9������9:39:02
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
	
	public static int getRemainDays(Date futureDate) {
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;	
	}
	
	public static boolean isToday(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	public static List fileToBean(String fileName,Constructor constructor) throws Exception{
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s = null;
		ArrayList<Object> list = new ArrayList<Object>();
		while((s = br.readLine())!=null){
			String[] split = s.split("\\|");
			Object object = constructor.newInstance(split);
			list.add(object);
		}
		return list;
	}
	
}
