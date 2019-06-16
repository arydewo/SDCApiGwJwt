# SDCApiGwJwt
Software AG Developer Community - API Gateway - JWT
Author : Harry Prasetyo K | @arydewo

----
Description :
This is an Integration Server based package containing REST Service that can be used to retrieve JWT from API Gateway without using Basic Auth. The REST Service will call the built in getJsonWebToken interface, but using more advance security feature - by supplying applicationID, timestamp and hashed credential with salt.

HowTo Use :
1. Download this package
2. Deploy on webMethods API Gateway
3. You may want change the ACL of the REST Service to Anonymous
4. You may want to change the credential used in pub.client:http used within the getJwt flow service to suit your implementation

HowTo Test :
1. Please prepare the following HTTP Header Parameter :
   X-APP-ID : application ID in API Gateway
   X-TIME : client timestamp in format of YYYYMMDDHH24MISS e.g : 20190615230530
   X-APP-TOKEN : MD5 of concat(clientID,'|',X-APP-TIME) salted with clientSecret
2. Call the following REST API
   GET http://[serveraddress]:[serverport]/restv2/sdc.apigw.jwt.restwss:api/token
   Supply with the above HTTP Header
   
Disclaimer :
- This version only support default JWT implementation. 
- Support of Custom Claim might be provided within next update of this Package
   
