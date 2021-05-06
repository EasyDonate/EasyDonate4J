Здесь описаны все доступные методы в интерфейсе EasyDonateSDK для самых маленьких :)

# Список методов
* [Информация о магазине](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getShopInfo)
* [Список товаров](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getProductsList)
* [Информация о товаре](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getProductInfo)
* [Список серверов](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getServersList)
* [Информация о сервере](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getServerInfo)
* [Список **удачных** платежей](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getPaymentsList)
* [Информация о платеже](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#getPaymentInfo)
* [**Создание платежа**](https://github.com/SoKnight/EasyDonateSDK/wiki/Available-methods#createPayment)

## #getShopInfo()
> [Получение информации о магазине.](https://api.easydonate.ru/methods/shop) 

Позволяет получить всю доступную информацию о магазине, начиная с имени или домена и заканчивая CSS-стилем и соц. сетями.
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            ShopModel shopInfo = sdk.getShopInfo();
            System.out.printf(
                    "Для перехода в магазин %s используйте данный URL-адрес: %s\n",
                    shopInfo.getName(), // имя магазина
                    shopInfo.getDomain() // актуальный домен магазина
            );
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
Для перехода в магазин Test используйте данный URL-адрес: soktest.easydonate.ru
```

## #getProductsList()
> [Получение списка товаров в магазине.](https://api.easydonate.ru/methods/products) 

Позволяет получить список всех добавленных товаров в магазине с информацией о подключённых серверах.
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            List<ProductModel> products = sdk.getProductsList();
            System.out.println("Товары в магазине:");
            for(ProductModel product : products) {
                System.out.printf(
                        "%s x %d стоимостью %.1f / шт.\n",
                        product.getName(), // название товара
                        product.getAmount(), // кол-во товара
                        product.getPrice() // стоимость товара
                );
            }
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
Товары в магазине:
Diamond Sword x 1 стоимостью 100.5 / шт.
```

## #getProductInfo()
> [Получение информации о товаре в магазине.](https://api.easydonate.ru/methods/product) 

Позволяет получить информацию о конкретном товаре, добавленном в магазин, по его ID.
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            ProductModel product = sdk.getProductInfo(8452);
            System.out.printf(
                    "Товар '%s' x %d стоимостью %.1f / шт.\n",
                    product.getName(), // название товара
                    product.getAmount(), // кол-во товара
                    product.getPrice() // стоимость товара
            );
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
Товар 'Diamond Sword' x 1 стоимостью 100.5 / шт.
```

## #getServersList()
> [Получение списка серверов в магазине.](https://api.easydonate.ru/methods/servers) 

Позволяет получить список всех подключённых к магазину серверов и всю доступную информацию о каждом из них.
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            List<ServerModel> servers = sdk.getServersList();
            System.out.println("Список серверов:");
            for(ServerModel server : servers) {
                System.out.printf(
                        "%s - размещён по адресу %s:%d.",
                        server.getName(),
                        server.getAddress(),
                        server.getPort()
                );
            }
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
My best server - размещён по адресу 66.254.114.41:25565.
```

## #getServerInfo()
> [Получение информации о подключенном сервере.](https://api.easydonate.ru/methods/server) 

Позволяет получить информацию о конкретном сервере, подключенном к магазину, по его ID.
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            ServerModel server = sdk.getServerInfo(1334);
            System.out.printf(
                    "Сервер '%s' размещён по адресу %s:%d.",
                    server.getName(),
                    server.getAddress(),
                    server.getPort()
            );
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
Сервер 'My best server' размещён по адресу 66.254.114.41:25565.
```

## #getPaymentsList()
> [Получение списка **успешных** платежей в магазине.](https://api.easydonate.ru/methods/payments) 

Позволяет получить список всех **успешно проведённых** платежей в вашем магазине.

Параметр `status` сообщает текущий статус платежа:
- `0` - не оплачен (только создан)
- `1` - оплачен, но ожидает выдачи
- `2` - успешно оплачен
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            List<PaymentModel> payments = sdk.getPaymentsList();
            System.out.println("Список успешных платежей:");
            for(PaymentModel payment : payments) {
                System.out.printf(
                        "Покупатель %s - %d товар(а) на сумму %.1f рублей (зачислено: %.1f).",
                        payment.getCustomer(),
                        payment.getProducts().size(),
                        payment.getCost(),
                        payment.getEnrolledAmount()
                );
            }
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
Список успешных платежей:
Покупатель SoKnight - 1 товар(а) на сумму 100.0 рублей (зачислено: 100.0).
```

## #getPaymentInfo()
> [Получение информации о платеже по его ID.](https://api.easydonate.ru/methods/payment) 

Позволяет получить информацию о конкретном платеже, созданном в магазине, по его ID.

Параметр `status` сообщает текущий статус платежа:
- `0` - не оплачен (только создан)
- `1` - оплачен, но ожидает выдачи
- `2` - успешно оплачен
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            PaymentModel payment = sdk.getPaymentInfo(50766);
            System.out.printf("Информация о платеже #%d:\n", payment.getPaymentId());
            System.out.println("Покупатель: " + payment.getCustomer());
            System.out.println("E-mail: " + payment.getEmail());
            System.out.println("Статус: " + payment.getStatus());
            System.out.println("Кол-во товаров: " + payment.getProducts().size());
            System.out.println("Сумма: " + payment.getCost());
            System.out.println("Доход магазина: " + payment.getEnrolledAmount());
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```
Код из примера выше выведет на экран сообщение такого типа:
```
Информация о платеже #50766:
Покупатель: SoKnight
E-mail: null
Статус: 2
Кол-во товаров: 1
Сумма: 100.0
Доход магазина: 100.0
```

## #createPayment()
> [Создание нового платежа.](https://api.easydonate.ru/methods/payment-create) 

Позволяет вам создать новый платёж в вашем магазине для проведения оплаты игроком.
Может быть полезно, если вы хотите только принимать платежи через EasyDonate.

Метод принимает объект данных о платеже, где должен содержаться `никнейм покупателя`, `ID сервера` и `список покупаемых товаров`.
В случае отсутствия какого-либо параметра из списка выше вы получите `IllegalArgumentException` ещё до отправки платежа.
```java
        EasyDonateSDK sdk = EasyDonateSDK.create("007bc81144edff3aebdf8ea50bee1c34"); // замените на свой ключ

        try {
            PreparedPaymentData paymentData = PaymentCreator.newCreator()
                    .setCustomer("SoKnight") // устанавливаем никнейм покупателя
                    .setServerId(1334) // устанавливаем ID сервера
                    .addProduct(8452, 2) // добавляем ID продукта и указываем кол-во
                    .create(); // создаём объект данных о платеже

            CreatedPaymentBundle createdPayment = sdk.createPayment(paymentData);
            
            int paymentId = createdPayment.getPayment().getPaymentId(); // ID платежа для отслеживания
            String url = createdPayment.getUrl();// ссылка на оплату платежа, которую нужно будет дать игроку
        } catch (BadResponseException | ErrorResponseException | FailedRequestException ex) {
            ex.printStackTrace();
        }
```