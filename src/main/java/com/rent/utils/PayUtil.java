package com.rent.utils;

import java.util.HashMap;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

public class PayUtil {
	private static String clientId = "AbSXgniEeSDe6rkslxEvyO5-p6cxm-7qOdi0D7NQub1nZ9TpOup8r-SYYCs7PhDTW_wMG4bUVK3mpOyd";
    private static String clientSecret = "EO7c2HqZ-omIdOCBXMLf4AKy6RGXrU-qwJvwtmYGkSouH2ohj9mW1glrLYR2kEk4-ssIpOWG45ca5uC2";
    private static String mode="sandbox";
    
    private static APIContext apiContext = null;
    public static APIContext getAPIContext(){
    	try {
			if(apiContext ==null) {
				HashMap<String,String> map = new HashMap<String,String>();
				map.put("mode",mode);
				OAuthTokenCredential authTokenCredential = new OAuthTokenCredential(clientId, clientSecret,map);
				apiContext = new APIContext(authTokenCredential.getAccessToken());
				apiContext.setConfigurationMap(map);
			}
		} catch (PayPalRESTException e) {
    		e.printStackTrace();
			System.out.println("Init pay fail>>>>>>>>>>>>>>>");
		}
    	return apiContext;
    }
    
    
}
