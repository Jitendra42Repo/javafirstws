package com.jiten.ws.soap.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CreditCardInfo")
public class CreditCardInfo {
	
	@XmlElement(name="cardNumber")
	private String cardNumber;
	@XmlElement(name="expirtyDate")
	private Date expirtyDate;
	@XmlElement(name="firstName")
	private String firstName;
	@XmlElement(name="lastName")
	private String lastName;
	@XmlElement(name="secCode")
	private String secCode;
	@XmlElement(name="Address")
	private String Address;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getExpirtyDate() {
		return expirtyDate;
	}

	public void setExpirtyDate(Date expirtyDate) {
		this.expirtyDate = expirtyDate;
	}

}
