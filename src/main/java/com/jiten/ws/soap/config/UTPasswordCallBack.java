package com.jiten.ws.soap.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallBack implements CallbackHandler {

	private Map<String, String> usrPwd = new HashMap<>();
	
	public UTPasswordCallBack() {
		this.usrPwd.put("jiten", "jiten");
		this.usrPwd.put("mvnDependency", "cxfWsSecurity");
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		
		for(Callback callback : callbacks) {
			
			WSPasswordCallback pwdCallBack = (WSPasswordCallback) callback;
			String pwd= usrPwd.get(pwdCallBack.getIdentifier());
			if(pwd!= null) {
				pwdCallBack.setPassword(pwd);
				return;
			}
		}
		

	}

}
