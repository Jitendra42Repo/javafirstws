package com.jiten.ws.soap.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jiten.ws.soap.PaymentProcessorImpl;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endPoint = new EndpointImpl(bus, new PaymentProcessorImpl());
		endPoint.publish("/paymentProcessor");
		
		// 1. Configure the Intercepter Properties
		
		Map<String, Object> interceptProp = new HashMap<>();
		// A. Configure the Action to be taken.
		interceptProp.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		// B. Configure the Password type.
		interceptProp.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		// C. Configure the PW_CALLBACK_CLASS.
		interceptProp.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallBack.class.getName());
		
		// 2. Instantiate the WSS4J-In-Intercepter and pass the HashMap Object configured as the parameter.
		WSS4JInInterceptor secIntercept = new WSS4JInInterceptor(interceptProp);
		
		
		// 3. Add the intercepter to the Incoming intercepter chain.  
		endPoint.getInInterceptors().add(secIntercept);
		return endPoint;
	}

}
