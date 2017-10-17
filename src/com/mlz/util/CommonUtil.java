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
 * ���ù�����
 * @author Administrator
 *
 */
public final class CommonUtil {
	private CommonUtil () {
		throw new AssertionError();
	}
	/**
	 * �ַ���תʱ��
	 * @param pattern	��ʽ
	 * @param str	ʱ���ַ���
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
	 * ȡ�ļ���׺
	 * @param fileName
	 * @return
	 */
	public static String getFilenameSuffix(String fileName) {
		int index=fileName.lastIndexOf(".");
		return index>0 && index<fileName.length()-1? fileName.substring(index):"";
		
	}
	/**
	 * ��ȡȫ��Ψһ���ļ���
	 * @return
	 */
	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
		
	}
	/**
	 * ͼƬѹ��
	 * @param inputStream	ͼƬ������������
	 * @param file			Ŀ���ļ�
	 * @param width			ѹ����Ŀ����
	 * @param height		ѹ����Ŀ��߶�
	 * @throws IOException	��д�ļ����ܲ���IO�쳣
	 */
	
	public static void compressImage(InputStream inputStream,File file,int width,int height) throws IOException {
		BufferedImage oldImage=ImageIO.read(inputStream);
		BufferedImage newImage=new BufferedImage(150,200,1);
		newImage.getGraphics().drawImage(oldImage, 0, 0, width,height,null);
		ImageIO.write(newImage, "PNG", file);
	}
}

