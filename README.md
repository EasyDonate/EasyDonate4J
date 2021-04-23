# EasyDonateSDK
An unoffical community SDK for EasyDonate platform API written on Java.

Supported API versions:
- EasyDonate API v1 [Documentation (RU)](https://api.easydonate.ru/)
- EasyDonate API v2 [Documentation (RU)](https://api.easydonate.ru/v/v2)

## Before you start
Firstly, you should to read about API restrictions related to requests frequency
- [**[ ! ]** API request requirements (RU)](https://api.easydonate.ru/request-requirements)
- [SDK thread on the EasyDonate forum (RU)](https://forum.easydonate.ru/d/65-neofitsialnoe-easydonate-sdk-dlya-java-proektov)

## Introduction
You can see how this library works below :)
```java
import ru.soknight.easydonate.sdk.v2.EasyDonateSDK;
import ru.soknight.easydonate.sdk.v2.data.model.CreatedPaymentBundle;
import ru.soknight.easydonate.sdk.v2.data.model.CreatedPaymentModel;
import ru.soknight.easydonate.sdk.v2.exception.BadResponseException;
import ru.soknight.easydonate.sdk.v2.exception.ErrorResponseException;
import ru.soknight.easydonate.sdk.v2.exception.FailedRequestException;
import ru.soknight.easydonate.sdk.v2.payment.PaymentCreator;
import ru.soknight.easydonate.sdk.v2.payment.PreparedPaymentData;

public class Example {

    public static void main(String[] args) {
        
        // insert here your shop access key
        String accessKey = "<put your access key here>";
        
        // now you can create new sdk instance using your key
        EasyDonateSDK sdk = EasyDonateSDK.create(accessKey);
        
        // determine a customer, a server and an ID of our product
        String customer = "SoKnight";
        int serverId = 228;
        int productId = 1488;
        
        try {
            // now we must create the payment data object for #createPayment method from SDK
            PreparedPaymentData paymentData = PaymentCreator.newCreator()
                    .setCustomer(customer)
                    .setServerId(serverId)
                    .addProduct(productId, 1) // 1 is amount
                    .create();
            
            // now let's create a new payment
            CreatedPaymentBundle createdPayment = sdk.createPayment(paymentData);
            
            // extract the response payment data
            String url = createdPayment.getUrl();
            CreatedPaymentModel payment = createdPayment.getPayment();
            
            // and... let's use that... and print the URL to console
            System.out.printf("Hello, dear %s!\n", payment.getCustomer());
            System.out.printf("Go to this link to finish purchase: %s\n", url);
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
