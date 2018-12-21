# Using EnOS API SDK for Java

This article instructs how to prepare your development environment to use the *EnOS API SDK for Java*.

- [Installing Java JDK SE](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installjava)
- [Installing Maven](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installmaven)
- Obtaining EnOS API SDK for Java
  - [Include dependency in Maven project](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installiotmaven)
  - [Building from source](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installiotsource)
- [Feature list](https://github.com/EnvisionIot/enos-mqtt-java-sdk#featurelist)
- [API reference](https://github.com/EnvisionIot/enos-mqtt-java-sdk#apiref)
- [Sample code](https://github.com/EnvisionIot/enos-mqtt-java-sdk#samplecode)

## Installing Java JDK SE

To use the EnOS API SDK for Java, you will need **Java SE 7**.

## Installing Maven

For EnOS API SDK for Java, we recommend you to use **Maven 3**.

## Obtaining EnOS API SDK for Java

You can obtain the EnOS API SDK through the following methods:

- Include the project as a dependency in your Maven project.
- Download the source code by cloning this repo and build on your machine

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

### Build EnOS API SDK for Java from the source code in this repo

- Get a copy of the **EnOS API SDK for Java** from master branch of the GitHub (current repo). You should fetch a copy of the source from the **master** branch of the GitHub repository: https://github.com/EnvisionIot/enos-api-java-sdk

```
	git clone https://github.com/EnvisionIot/enos-api-java-sdk.git
```

- When you have obtained a copy of the source, you can build the SDK for Java.

## Key features

The EnOS API SDK supports the following functions:

- Generating API request signature automatically
- Assembling API request URL  
- Parsing API response


## API reference

To access the EnOS API documentation, go to **EnOS API > API Documents** in the EnOS Console. Summary of APIs is displayed in tables by API service categories. Click the **More** icon for each API to view details, including API function, calling method, requesting URL, parameter description, calling sample, and response sample. 

## Sample code

The following sample code is for creating a product using the EnOS API SDK. 

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
