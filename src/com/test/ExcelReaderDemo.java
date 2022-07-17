package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelReaderDemo {
   
	@Test
	@Parameters({"DeviceReference"})
	public void Test(String DeviceReference) throws Exception {
	
		GetDeviceBean deviceBean = new GetDeviceBean(DeviceReference);		
    	System.out.println(deviceBean.getDeviceName());
    	System.out.println(deviceBean.getVendor());
    	System.out.println(deviceBean.getModule());
	}
}
