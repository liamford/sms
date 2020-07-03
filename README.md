# Twilio-Sms-Api-SpringBoot
* Using Twilio Sms api, you can send sms locally or internationally.
### Twilio registration and configuration:
* Register on [Twilio](https://twilio.com/) .
* Sign up there with required credentials. 
* After signing up, a page will appear to verify your identity. 
* Provide your real phone number because,a verification code will sent to this phone number.
* Now, on Dashboard page, you'll get your **ACCOUNT SID** and **AUTH TOKEN** . These will be used to connect to twilio's api.
* Get the **Trial Number** which will be used as your twilio's phone number. It will be the sender number when we'll send a sms to a recipient using twilio's api.
 
###### API endpoint: http://localhost:PORT_NUMBER/api/v1/sms
###### Method: POST
###### Payload:
```
{  
    "phoneNumber": "<recipient mobile number>",  
    "content": "<message body>" 
}
```
