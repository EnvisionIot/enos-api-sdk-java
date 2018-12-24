# Using EnOS API SDK for Java

This article instructs how to prepare your development environment to use the *EnOS API SDK for Java*.

- [Installing Java JDK SE](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#installjava)
- [Installing Maven](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#installmaven)
- [Obtaining EnOS API SDK for Java](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#installiot)
  - [Include dependency in Maven project](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#installiotmaven)
  - [Building from source](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#installiotsource)
- [Key features](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#featurelist)
- [API reference](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#apiref)
- [Sample code](https://github.com/EnvisionIot/enos-api-sdk-java/tree/V1.1.0#samplecode)

<a name="installjava"></a>
## Installing Java JDK SE

To use the EnOS API SDK for Java, you will need **Java SE 7**.

<a name="installmaven"></a>
## Installing Maven

For EnOS API SDK for Java, we recommend you to use **Maven 3**.

<a name="installiot"></a>
## Obtaining EnOS API SDK for Java

You can obtain the EnOS API SDK through the following methods:

- Include the project as a dependency in your Maven project.
- Download the source code by cloning this repo and build on your machine

<a name="installiotmaven"></a>
### Get EnOS API SDK for Java from Maven (as a dependency)

*This is the recommended method of including the EnOS API SDK in your project.*

- Navigate to [http://search.maven.org](http://search.maven.org/), search for **com.envisioniot.enos** and take note of the latest version number (or the version number of whichever version of the sdk you want to use).
- In your main pom.xml file, add the EnOS API SDK as a dependency as follows:

```
<dependency>
    <groupId>com.envisioniot</groupId>
    <artifactId>enos-api</artifactId>
    <version>1.1.0</version>
    <!--You might need to change the version number as you need.-->
</dependency>
```

<a name="installiotsource"></a>
### Build EnOS API SDK for Java from the source code in this repo

- Get a copy of the **EnOS API SDK for Java** from master branch of the GitHub (current repo). You should fetch a copy of the source from the **V1.1.0** branch of the GitHub repository: https://github.com/EnvisionIot/enos-api-sdk-java

```
	git clone -b V1.1.0 https://github.com/EnvisionIot/enos-api-sdk-java.git
```

- When you have obtained a copy of the source, you can build the SDK for Java.

<a name="featurelist"></a>
## Key features

The EnOS API SDK supports the following functions:

- Generating API request signature automatically
- Assembling API request URL  
- Parsing API response

<a name="apiref"></a>
## API reference

To view the EnOS API Reference documentation, go to API Service > EnOS APIs in the EnOS Console. Summary of APIs is displayed in tables by API service categories. Click the View details link to view documentation of each API, including API function, calling method, requesting URL, parameter description, calling sample, and response sample.

<a name="samplecode"></a>
## Sample code

The following sample code is for connecting to the EnOS API service and getting application resources. 

```
import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.request.AppResourceGetRequest;
import com.envision.eeop.api.request.UserLoginRequest;
import com.envision.eeop.api.response.AppResourceGetResponse;
import com.envision.eeop.api.response.UserLoginResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        String serverUrl = "xxx";
        String appKey = "xxx";
        String appSecret = "xxx";
        EnvisionClient client = new EnvisionDefaultClient(serverUrl, appKey, appSecret);
        String userName = "xxx";
        String userSecret = "xxx";
        //login and get access token
        UserLoginRequest loginRequest = new UserLoginRequest(userName, userSecret);
        UserLoginResponse loginResponse = client.execute(loginRequest);
        String token = loginResponse.getAccessToken();
        //get app resource
        AppResourceGetRequest request = new AppResourceGetRequest("xxx");
        AppResourceGetResponse response = client.execute(request, token);
    }
}
```
