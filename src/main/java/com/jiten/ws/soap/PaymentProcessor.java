package com.jiten.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.jiten.ws.soap.dto.PaymentProcessorRequest;
import com.jiten.ws.soap.dto.PaymentProcessorResponse;
import com.jiten.ws.soap.exceptions.ServiceException;

@WebService
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name = "paymentProcessorResponse") PaymentProcessorResponse processPayment(
			@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest)
			throws ServiceException;
}
