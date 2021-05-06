Здесь описан процесс создания объекта доступа EasyDonateSDK и некоторые нюансы, связанные с этим.

## Create new SDK instance
Для создания и использования объекта доступа `EasyDonateSDK` вам нужно иметь ключ доступа от вашего магазина.

![](https://raw.githubusercontent.com/SoKnight/EasyDonateSDK/master/wiki/images/where-is-shop-key.png)

Затем, после [подключения библиотеки](https://github.com/SoKnight/EasyDonateSDK/wiki/Import-SDK-into-your-project) к вашему проекту вы можете создать новый объект доступа, заменив мой ключ на свой:
```java
EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34");
```

Имея объект доступа, вы можете обращаться к методам SDK через него.
Все доступные методы описаны [здесь](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods).