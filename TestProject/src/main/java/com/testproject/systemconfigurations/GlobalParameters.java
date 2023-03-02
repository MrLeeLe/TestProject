package com.testproject.systemconfigurations;

import com.testproject.enums.EDriverType;
import com.testproject.enums.EEnvironmentMode;
import com.testproject.enums.EGLobalConfig;
import com.testproject.utils.PropertiesReader;

public class GlobalParameters {
	
	private static PropertiesReader prop = new PropertiesReader();
	
	//General config
	public static final String WAIT_TIMEOUT = prop.getConfigByKey(EGLobalConfig.Wait_Timeout.toString());
	public static final String UPLOADFEATUREURL = prop.getConfigByKey(EGLobalConfig.UploadFeatureURL.toString());
	

	public static EDriverType getBrowser() {
		String browserName = prop.getConfigByKey(EGLobalConfig.Browser.toString());
		if (browserName.equalsIgnoreCase("chrome")) return EDriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return EDriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("edge")) return EDriverType.EDGE;
		else if(browserName.equalsIgnoreCase("android")) return EDriverType.ANDROID;
		else if(browserName.equalsIgnoreCase("ios")) return EDriverType.IOS;
		else throw new RuntimeException("Driver Type Key value in config.properties is not matched : " + browserName);
	}
	
	public static EEnvironmentMode getEnvironmentMode() {
		return EEnvironmentMode.LOCAL;
	}
    
}
