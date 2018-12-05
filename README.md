# Using EnOS Service SDK for Java

This article instructs how to prepare your development environment to use the *EnOS Service SDK for Java*.

- [Installing Java JDK SE](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installjava)
- [Installing Maven](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installmaven)
- Obtaining EnOS Service SDK for Java
  - [Including Dependency in Maven Project](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installiotmaven)
  - [Building from Source Code](https://github.com/EnvisionIot/enos-mqtt-java-sdk#installiotsource)
- [Feature List](https://github.com/EnvisionIot/enos-mqtt-java-sdk#featurelist)
- [API Reference](https://github.com/EnvisionIot/enos-mqtt-java-sdk#apiref)
- [Sample Code](https://github.com/EnvisionIot/enos-mqtt-java-sdk#samplecode)

## Installing Java JDK SE

To use the EnOS Service SDK for Java, you will need **Java SE 8**.

## Installing Maven

For EnOS Service SDK for Java, we recommend you to use **Maven 3**.

## Obtaining EnOS Service SDK for Java

You can obtain the EnOS Service SDK through the following methods:

- Include the project as a dependency in your Maven project
- Download the source code by cloning this repo and build on your machine

### Including Dependency in Maven Project

*This is the recommended method of including the EnOS Service SDK for Java in your project.*

- Navigate to [http://search.maven.org](http://search.maven.org/), search for **com.envisioniot.enos** and take note of the latest version number (or the version number of whichever version of the sdk you want to use).

- In your main pom.xml file, add the EnOS Service SDK for Java as a dependency as follows:

  ```
  <dependency>
      <groupId>com.envisioniot</groupId>
      <artifactId>enos-api</artifactId>
      <version>2.1.0</version>
      <!--You might need to change the version number as you need.-->
  </dependency>
  ```

### Building from Source Code

- Get a copy of the **EnOS Service SDK for Java** from master branch of the GitHub (current repo). You should fetch a copy of the source from the **master** branch of the GitHub repository: https://github.com/EnvisionIot/enos-api-sdk-java

  ```
  git clone https://github.com/EnvisionIot/enos-api-sdk-java.git
  ```

- When you have obtained a copy of the source, you can build the SDK for Java.

## Key Features

The EnOS Service SDK for Java supports the following functions:

- Generating API request signature automatically
- Assembling API request URL  
- Parsing API response
- Open API services, including device connection service, model service, asset service, data service, and common file service.

## API Reference

To access the EnOS API documentation, go to **EnOS API > API Documents** in the EnOS Console. Summary of APIs is displayed in tables by API service categories. Click the **More** icon for each API to view details, including API function, calling method, requesting URL, parameter description, calling sample, and response sample. 

## Sample Code

The following sample code is for creating a product using the EnOS Service SDK for Java. 

```
import com.envisioniot.enos.enosapi.api.request.connectservice.CreateProductRequest;
import com.envisioniot.enos.enosapi.api.resource.connectservice.Product;
import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.sdk.client.EnOSDefaultClient;

public class Main {
    public static void main(String[] args) {
    String serverUrl = "xxx";
    String accessKey = "xxx";
    String secretKey = "xxx";
    int connectTimeout = 5000;
    int readTimeout = 5000;
    product.setProductName("XXX");
    product.setProductDesc("XXX");
    product.setModelId("XXXXX");
    product.setDataType(1);
    product.setNodeType(1);
    EnOSDefaultClient client = new EnOSDefaultClient(serverUrl, accessKey,secretKey,connectTimeout,readTimeout);
    Product product = new Product();
    CreateProductRequest request = new CreateProductRequest(orgId, product);
    try {
        EnOSResponse response = client.defaultClient().execute(request);
    } catch (EnOSApiException e) {
        e.printStackTrace();
    }
  }
 }
```
