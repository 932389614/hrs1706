package com.mlz.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
/**
 * 常用工具类
 * @author Administrator
 *
 */
public final class CommonUtil {
	private CommonUtil () {
		throw new AssertionError();
	}
	/**
	 * 字符串转时间
	 * @param pattern	格式
	 * @param str	时间字符串
	 * @return	Date
	 */
	public static Date stringToDate(String pattern,String str) {
		
		SimpleDateFormat formatter =new SimpleDateFormat(pattern);
		try {
			return formatter.parse(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}		
	}
	
	public static String dateToString(String pattern,Date date) {
		
		SimpleDateFormat formatter =new SimpleDateFormat(pattern);
		try {
			return formatter.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}		
	}
	
	/**
	 * 取文件后缀
	 * @param fileName
	 * @return
	 */
	public static String getFilenameSuffix(String fileName) {
		int index=fileName.lastIndexOf(".");
		return index>0 && index<fileName.length()-1? fileName.substring(index):"";
		
	}
	/**
	 * 获取全局唯一的文件名
	 * @return
	 */
	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
		
	}
	/**
	 * 图片压缩
	 * @param inputStream	图片二进制输入流
	 * @param file			目标文件
	 * @param width			压缩的目标宽度
	 * @param height		压缩的目标高度
	 * @throws IOException	读写文件可能产生IO异常
	 */
	
	public static void compressImage(InputStream inputStream,File file,int width,int height) throws IOException {
		BufferedImage oldImage=ImageIO.read(inputStream);
		BufferedImage newImage=new BufferedImage(150,200,1);
		newImage.getGraphics().drawImage(oldImage, 0, 0, width,height,null);
		ImageIO.write(newImage, "PNG", file);
	}
}

