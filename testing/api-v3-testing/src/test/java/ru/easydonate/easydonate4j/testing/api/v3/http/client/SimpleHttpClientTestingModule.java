package ru.easydonate.easydonate4j.testing.api.v3.http.client;

import org.junit.jupiter.api.*;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginManager;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.news.VKNewsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;

public abstract class SimpleHttpClientTestingModule extends HttpClientTestingModule {

    private static final int PRODUCT_ID = 94649;
    private static final int SERVER_ID = 12597;
    private static final int PAYMENT_ID = 717642;

    private static final String CUSTOMER = "SoKnight";
    private static final String EMAIL = "easydonate4j@easydonate.ru";
    private static final String COUPON = "EASYDONATE4J";
    private static final String REDIRECT_URL = "https://github.com/SoKnight/EasyDonate4J";

    @Nested
    @Order(1)
    @DisplayName("Executing shop related API requests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ShopRequestsExecuting {

        @Test
        @Order(1)
        @DisplayName("#getShop()")
        public void getShop() {
            makeShopRequestAndValidateNotNull(EasyDonateClient::getShop);
        }

        @Test
        @Order(2)
        @DisplayName("#getProduct(id)")
        public void getProduct() {
            makeShopRequestAndValidateNotNull(client -> client.getProduct(PRODUCT_ID));
        }

        @Test
        @Order(3)
        @DisplayName("#getProductsList()")
        public void getProductsList() {
            makeShopRequestAndValidateNotNull(EasyDonateClient::getProductsList);
        }

        @Test
        @Order(4)
        @DisplayName("#getServer(id)")
        public void getServer() {
            makeShopRequestAndValidateNotNull(client -> client.getServer(SERVER_ID));
        }

        @Test
        @Order(5)
        @DisplayName("#getServersList()")
        public void getServersList() {
            makeShopRequestAndValidateNotNull(EasyDonateClient::getServersList);
        }

        @Test
        @Order(6)
        @DisplayName("#getMassSalesList()")
        public void getMassSalesList() {
            makeShopRequestAndValidateNotNull(EasyDonateClient::getMassSalesList);
        }

        @Test
        @Order(7)
        @DisplayName("#getCouponsList()")
        public void getCouponsList() {
            makeShopRequestAndValidateNotNull(EasyDonateClient::getCouponsList);
        }

        @Test
        @Order(8)
        @DisplayName("#getPayment(id)")
        public void getPayment() {
            makeShopRequestAndValidateNotNull(client -> client.getPayment(PAYMENT_ID));
        }

        @Test
        @Order(9)
        @DisplayName("#getPaymentsList()")
        public void getPaymentsList() {
            makeShopRequestAndValidateNotNull(EasyDonateClient::getPaymentsList);
        }

        @Test
        @Order(10)
        @DisplayName("#createPayment()")
        public void createPayment() {
            makeShopRequestAndValidateNotNull(client -> client.createPayment()
                    .addProduct(PRODUCT_ID)
                    .setCoupon(COUPON)
                    .setCustomer(CUSTOMER)
                    .setEmail(EMAIL)
                    .setRedirectUrl(REDIRECT_URL)
                    .setServerId(SERVER_ID)
            );
        }

    }

    @Nested
    @Order(2)
    @DisplayName("Executing plugins related API requests")
    @TestClassOrder(ClassOrderer.OrderAnnotation.class)
    class PluginsRequestsExecuting {

        @Nested
        @Order(1)
        @DisplayName("Surcharge (EasyDonate)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class EasyDonateSurchargeRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getSurchargePlugin, SurchargePlugin::getSettings);
            }

            @Test
            @Order(2)
            @DisplayName("#getDiscountsList()")
            public void getDiscountsList() {
                makePluginRequestAndValidateNotNull(PluginManager::getSurchargePlugin, plugin -> plugin.getDiscountsList(CUSTOMER));
            }

            @Test
            @Order(3)
            @DisplayName("#getDiscountFor()")
            public void getDiscountFor() {
                makePluginRequestAndValidateNotNull(PluginManager::getSurchargePlugin, plugin -> plugin.getDiscount(CUSTOMER, PRODUCT_ID));
            }

        }

        @Nested
        @Order(2)
        @DisplayName("Last Payments (EasyDonate)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class EasyDonateLastPaymentsRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getLastPaymentsPlugin, LastPaymentsPlugin::getSettings);
            }

            @Test
            @Order(2)
            @DisplayName("#getLastPaymentsList()")
            public void getLastPaymentsList() {
                makePluginRequestAndValidateNotNull(PluginManager::getLastPaymentsPlugin, LastPaymentsPlugin::getLastPaymentsList);
            }

        }

        @Nested
        @Order(3)
        @DisplayName("Custom Messages (EasyDonate)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class EasyDonateCustomMessagesRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getCustomMessagesPlugin, CustomMessagesPlugin::getSettings);
            }

        }

        @Nested
        @Order(4)
        @DisplayName("Discord Widget (Discord)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class DiscordWidgetRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getDiscordWidgetPlugin, DiscordWidgetPlugin::getSettings);
            }

            @Test
            @Order(2)
            @DisplayName("#getEmbed()")
            public void getEmbed() {
                makePluginRequestAndValidateNotNull(PluginManager::getDiscordWidgetPlugin, DiscordWidgetPlugin::getEmbed);
            }

        }

        @Nested
        @Order(5)
        @DisplayName("VK News (VKontakte)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class VKontakteNewsRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getVKNewsPlugin, VKNewsPlugin::getSettings);
            }

        }

        @Nested
        @Order(6)
        @DisplayName("VK Community Widget (VKontakte)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class VKontakteCommunityWidgetRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getVKCommunityWidgetPlugin, VKCommunityWidgetPlugin::getSettings);
            }

            @Test
            @Order(2)
            @DisplayName("#getEmbed()")
            public void getEmbed() {
                makePluginRequestAndValidateNotNull(PluginManager::getVKCommunityWidgetPlugin, VKCommunityWidgetPlugin::getEmbed);
            }

        }

        @Nested
        @Order(7)
        @DisplayName("VK Messages Widget (VKontakte)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class VKontakteMessagesWidgetRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getVKMessagesWidgetPlugin, VKMessagesWidgetPlugin::getSettings);
            }

            @Test
            @Order(2)
            @DisplayName("#getEmbed()")
            public void getEmbed() {
                makePluginRequestAndValidateNotNull(PluginManager::getVKMessagesWidgetPlugin, VKMessagesWidgetPlugin::getEmbed);
            }

        }

        @Nested
        @Order(8)
        @DisplayName("Yandex Metrika (Yandex)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class YandexMetrikaRequestsExecuting {

            @Test
            @Order(1)
            @DisplayName("#getSettings()")
            public void getSettings() {
                makePluginRequestAndValidateNotNull(PluginManager::getYandexMetrikaPlugin, YandexMetrikaPlugin::getSettings);
            }

            @Test
            @Order(2)
            @DisplayName("#getEmbed()")
            public void getEmbed() {
                makePluginRequestAndValidateNotNull(PluginManager::getYandexMetrikaPlugin, YandexMetrikaPlugin::getEmbed);
            }

        }
        
    }

}
