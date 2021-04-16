# EasyDonateSDK
An unoffical community SDK for EasyDonate platform API written on Java.

Useful links:
- [**[ ! ]** API request requirements (RU)](https://api.easydonate.ru/request-requirements)
- [EasyDonate API documentation (RU)](https://api.easydonate.ru/)
- [SDK thread on the EasyDonate forum (RU)](https://forum.easydonate.ru/d/65-neofitsialnoe-easydonate-sdk-dlya-java-proektov)

## Introduction
You can see how this library works below :)
```java
import ru.soknight.easydonate.sdk.data.model.ShopModel;
import ru.soknight.easydonate.sdk.exception.BadResponseException;
import ru.soknight.easydonate.sdk.exception.ErrorResponseException;
import ru.soknight.easydonate.sdk.exception.FailedRequestException;

public class Example {

    public static void main(String[] args) {
        // insert here your shop access key
        String accessKey = "<put your access key here>";
        
        // now you can create new sdk instance using your key
        EasyDonateSDK sdk = EasyDonateSDK.create(accessKey);
        
        try {
            // now let's get information about our shop
            // also all throwed exceptions must be handled here
            ShopModel shopInfo = sdk.getShopInfo();
            
            // it's a most simple way to get the name of this shop :D
            String name = shopInfo.getName();
            
            // also let's get the shop domain
            String domain = shopInfo.getDomain();
            
            // and... just use this data to print it
            System.out.println("My shop name is: " + name);
            System.out.println("Visit me: " + domain);
        } catch (BadResponseException ex) {
            // any API error or invalid response has been received
        } catch (ErrorResponseException ex) {
            // an HTTP error has been occured
        } catch (FailedRequestException ex) {
            // internal fails with request preparation and sending
        }
    }
}
```
If you like that, you can use my library in your project, go next.

## Using as Maven dependency
[![](https://jitpack.io/v/SoKnight/EasyDonateSDK.svg)](https://jitpack.io/#SoKnight/EasyDonateSDK)

Sorry, I don't use Gradle currently, so a guide for Gradle isn't posted here.

Firstly you should to add the Jitpack repository if you has no it yet.
```xml
    <repositories>
        <!-- JitPack repository -->
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```
Further you can add the Maven dependency to your project.

You should replace `VERSION` to latest available version, you can see that on the badge above.
```xml
    <dependencies>
        <!-- EasyDonate SDK -->
        <dependency>
            <groupId>com.github.SoKnight</groupId>
            <artifactId>EasyDonateSDK</artifactId>
            <version>VERSION</version>
        </dependency>
    </dependencies>
```
