package com.valen.lark.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class CommonTool {

	//final Base64.Decoder decoder = Base64.getDecoder();
	//final Base64.Encoder encoder = Base64.getEncoder();
		
	
	public static void main(String[] args)
	{
		//System.out.println(enCodedBase64("123456"));
		//System.out.println(decoderBase64(enCodedBase64("fengling")));
		System.out.println(getSequence());
	}
	//编码Base64
	public static String enCodedBase64(String str) 
	{
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] textByte={};
		try {
			textByte = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    String encodedText = encoder.encodeToString(textByte);
		return encodedText;
	}

	//解码Base64
	public static String decoderBase64(String encodedstr) 
	{
		Base64.Decoder decoder = Base64.getDecoder();
		String str="";
		try {
			str = (new String(decoder.decode(encodedstr), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}	
	
	
	//取时间和随机数字做序列号
	public static String getSequence() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDate = sdf.format(new Date());
		
		int rdm =(int)(Math.random() * 900 + 100);
		Integer integer = new Integer(rdm);
		
		String strSeq = strDate+integer.toString();
		
		System.out.println("把当前时间转换成字符串：" + strDate);
		
		return strSeq;
	}

}
