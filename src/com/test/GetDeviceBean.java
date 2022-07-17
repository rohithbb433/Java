package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GetDeviceBean {
	
	private String DeviceName;
	private String Vendor;
	private String Module;
	
	public  GetDeviceBean(String reference) throws Exception {
		
		ExcelUtil util = new ExcelUtil("sdet_devices",reference);
		initialiseBean(util.initialiseRowValue());
	}
	
	public void initialiseBean(Map<String,String> initialBean) {
		DeviceName = initialBean.get("DeviceName");
		Vendor = initialBean.get("Vendor");
		Module = initialBean.get("Modules");
		
	}
	
	public String getDeviceName() {
		return DeviceName;
	}
	
	public String getVendor() {
		return Vendor;
	}
	
	public String getModule() {
		return Module;
	}
}
