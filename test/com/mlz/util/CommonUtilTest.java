package com.mlz.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CommonUtilTest {

	@Test
	public void testGetFilenameSuffix() {
		String fileName="hello.";
		String suffix1=CommonUtil.getFilenameSuffix(fileName);
		//Assert.assertEquals(���н��, Ԥ�ڽ��);
		Assert.assertEquals(suffix1, ".jpg");
	}

	@Test
	public void testGetUniqueFilename() {
	}

}
