# javafirstws: Payment Gateway Spring Boot SOAP service

1. javafirstws is a legacy application thus, use "Bottom-Up approach (java first)" to convert it to web service so that other consumer application can also 
use this soap service.
2. Payment Gateway has "processPayment" method inorder to process the payment request.
3. Implement UserNameToken Profile (from WS-Security Standard) to authenticate the incoming request.

## Tech Stack
1. Converting the lagecy application into SOAP service:
    I. Add "Apache CXF JAX-WS dependency" in pom.xml for JAX-WS support.
    II. Mark the existing Java Beans (DTO) with JAXB annotation. And mark the endpoint with JAX-WS annotation (@WebService, @WebMethod, @WebParam, @WebResult).
    III. Write the configuration file to publish the endpoint. 
              EndpointImpl(new PaymentProcessorImpl()).publish("/paymentProcessor");
 
 2. Implement the WS-Security from WS-Standard for Authentication:
    I. Add "CXF WS Security" dependency in pom.xml for WS-Securiy support.
    II. Instantiate WSS4JInInterceptor and add it to the enpoint for enabling the Security Interceptor. Configure "WSSecurity ACTION" as USERNAME_TOKEN PROFILE.  
    III. Configure the "CallbackHandler" as UTPasswordCallBack class. Implement "handle(Callback[] callbacks)" method from CallbackHandler (interface) to 
    autheticate the username in the request from in-memory database. 

3. SOAP UI Testing: Add the following <wsse:security> tag in the request <soapenv:Header>. Otherwise the serice will return <soap:Fault>. 

 <soapenv:Header>
    <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" soapenv:mustUnderstand="1">
      <wsse:UsernameToken xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org
      /wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
        <wsse:Username xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">mvnDependency</wsse:Username>
        <wsse:Password xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" Type="http://docs.oasis-open.org
        /wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">cxfWsSecurity</wsse:Password>
      </wsse:UsernameToken>
    </wsse:Security>
  </soapenv:Header>
