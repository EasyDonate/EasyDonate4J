package ru.easydonate.easydonate4j.v3.testing.json.serialization;

import org.junit.jupiter.api.*;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.response.plugin.discord.widget.DiscordWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.discord.widget.DiscordWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.custom.messages.CustomMessagesGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.last.payments.LastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.last.payments.LastPaymentsGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountsListResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.surcharge.SurchargeGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.messages.widget.VKMessagesWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.messages.widget.VKMessagesWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.news.VKNewsGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.yandex.metrika.YandexMetrikaGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.yandex.metrika.YandexMetrikaGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.shop.*;

public abstract class SimpleJsonSerializationTestingModule extends JsonSerializationTestingModule {

    @Nested
    @Order(1)
    @DisplayName("Parsing shop response models")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ShopModelsParsing {

        @Test
        @Order(1)
        @DisplayName("Shop")
        public void parseShop() {
            parseShopModel("shop", GetShopResponse.class);
        }

        @Test
        @Order(2)
        @DisplayName("Product")
        public void parseProduct() {
            parseShopModel("product", GetProductResponse.class);
        }

        @Test
        @Order(3)
        @DisplayName("ProductsList")
        public void parseProductsList() {
            parseShopModel("products-list", GetProductsListResponse.class);
        }

        @Test
        @Order(4)
        @DisplayName("Server")
        public void parseServer() {
            parseShopModel("server", GetServerResponse.class);
        }

        @Test
        @Order(5)
        @DisplayName("ServersList")
        public void parseServersList() {
            parseShopModel("servers-list", GetServersListResponse.class);
        }

        @Test
        @Order(6)
        @DisplayName("MassSalesList")
        public void parseMassSalesList() {
            parseShopModel("mass-sales-list", GetMassSalesListResponse.class);
        }

        @Test
        @Order(7)
        @DisplayName("CouponsList")
        public void parseCouponsList() {
            parseShopModel("coupons-list", GetCouponsListResponse.class);
        }

        @Test
        @Order(8)
        @DisplayName("Payment")
        public void parsePayment() {
            parseShopModel("payment", GetPaymentResponse.class);
        }

        @Test
        @Order(9)
        @DisplayName("PaymentsList")
        public void parsePaymentsList() {
            parseShopModel("payments-list", GetPaymentsListResponse.class);
        }

        @Test
        @Order(10)
        @DisplayName("PendingPayment")
        public void parsePendingPayment() {
            parseShopModel("pending-payment", CreatePaymentResponse.class);
        }

    }

    @Nested
    @Order(2)
    @DisplayName("Parsing plugin response models")
    class PluginsModelsParsing {

        @Nested
        @Order(1)
        @DisplayName("Surcharge (EasyDonate)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class EasyDonateSurchargeModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.SURCHARGE, "settings", SurchargeGetSettingsResponse.class);
            }

            @Test
            @Order(2)
            @DisplayName("All discounts")
            public void parseDiscounts() {
                parsePluginModel(PluginType.SURCHARGE, "discounts", SurchargeGetDiscountsListResponse.class);
            }

            @Test
            @Order(3)
            @DisplayName("Discount for product")
            public void parseDiscountFor() {
                parsePluginModel(PluginType.SURCHARGE, "discount", SurchargeGetDiscountResponse.class);
            }

        }

        @Nested
        @Order(2)
        @DisplayName("Last Payments (EasyDonate)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class EasyDonateLastPaymentsModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.LAST_PAYMENTS, "settings", LastPaymentsGetSettingsResponse.class);
            }

            @Test
            @Order(2)
            @DisplayName("Last payments")
            public void parsePayments() {
                parsePluginModel(PluginType.LAST_PAYMENTS, "payments", LastPaymentsGetPaymentsListResponse.class);
            }

        }

        @Nested
        @Order(3)
        @DisplayName("Custom Messages (EasyDonate)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class EasyDonateCustomMessagesModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.CUSTOM_MESSAGES, "settings", CustomMessagesGetSettingsResponse.class);
            }

        }

        @Nested
        @Order(4)
        @DisplayName("Discord Widget (Discord)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class DiscordWidgetModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.DISCORD_WIDGET, "settings", DiscordWidgetGetSettingsResponse.class);
            }

            @Test
            @Order(2)
            @DisplayName("Widget embed")
            public void parseEmbed() {
                parsePluginModel(PluginType.DISCORD_WIDGET, "embed", DiscordWidgetGetEmbedResponse.class);
            }

        }

        @Nested
        @Order(5)
        @DisplayName("VK News (VKontakte)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class VKontakteNewsModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.VK_NEWS, "settings", VKNewsGetSettingsResponse.class);
            }

        }

        @Nested
        @Order(6)
        @DisplayName("VK Community Widget (VKontakte)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class VKontakteCommunityWidgetModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.VK_COMMUNITY_WIDGET, "settings", VKCommunityWidgetGetSettingsResponse.class);
            }

            @Test
            @Order(2)
            @DisplayName("Widget embed")
            public void parseEmbed() {
                parsePluginModel(PluginType.VK_COMMUNITY_WIDGET, "embed", VKCommunityWidgetGetEmbedResponse.class);
            }

        }

        @Nested
        @Order(7)
        @DisplayName("VK Messages Widget (VKontakte)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class VKontakteMessagesWidgetModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.VK_MESSAGES_WIDGET, "settings", VKMessagesWidgetGetSettingsResponse.class);
            }

            @Test
            @Order(2)
            @DisplayName("Widget embed")
            public void parseEmbed() {
                parsePluginModel(PluginType.VK_MESSAGES_WIDGET, "embed", VKMessagesWidgetGetEmbedResponse.class);
            }

        }

        @Nested
        @Order(8)
        @DisplayName("Yandex Metrika (Yandex)")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class YandexMetrikaModelsParsing {

            @Test
            @Order(1)
            @DisplayName("Plugin settings")
            public void parsePluginSettings() {
                parsePluginModel(PluginType.YANDEX_METRIKA, "settings", YandexMetrikaGetSettingsResponse.class);
            }

            @Test
            @Order(2)
            @DisplayName("Widget embed")
            public void parseEmbed() {
                parsePluginModel(PluginType.YANDEX_METRIKA, "embed", YandexMetrikaGetEmbedResponse.class);
            }

        }

    }

}
