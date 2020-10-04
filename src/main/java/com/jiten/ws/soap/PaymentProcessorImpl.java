package com.jiten.ws.soap;

import org.apache.cxf.feature.Features;

import com.jiten.ws.soap.dto.PaymentProcessorRequest;
import com.jiten.ws.soap.dto.PaymentProcessorResponse;
import com.jiten.ws.soap.exceptions.ServiceException;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
		// Business Logic or a call to a Business Logic Class Goes Here.
		if(paymentProcessorRequest.getCreditCardInfo().getCardNumber()== null || 
				paymentProcessorRequest.getCreditCardInfo().getCardNumber().length()==0) {
			
			throw new ServiceException("Credit card number is required !");
		}
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
