package ru.easydonate.sdk.v3.data.model.gson.shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.shop.DeliveryModeType;
import ru.easydonate.sdk.v3.data.model.shop.Shop;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

@Getter
@Implementing(Shop.class)
public class ShopModel implements Shop {

    // --- general
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;
    @SerializedName("domain")
    private String domain;
    @SerializedName("last_domain")
    private String lastDomain;

    @SerializedName("is_active")
    private boolean active;
    @SerializedName("is_premium")
    private boolean premium;
    @SerializedName("is_verified")
    private boolean verified;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    // --- delivery mode
    @SerializedName("delivery_type")
    private String deliveryTypeRaw;
    @SerializedName("is_plugin_installed")
    private boolean pluginInstalled;

    // --- test mode
    @SerializedName("test_mode")
    private boolean testModeEnabled;
    @SerializedName("test_mode_from")
    private String whoEnabledTestMode;

    // --- copyright
    @SerializedName("hide_copyright")
    private boolean copyrightHidden;
    @SerializedName("hide_copyright_till")
    private LocalDateTime copyrightHiddenUntil;

    // --- functional tab
    @SerializedName("pay_comission")
    private boolean paymentComissionAssignedToShop;
    @SerializedName("require_email")
    private boolean emailRequired;
    @SerializedName("use_cart")
    private boolean usesShopCart;
    @SerializedName("allow_nickname_spaces")
    private boolean spacesAllowedInNickNames;
    @SerializedName("https_redirect")
    private boolean httpsRedirectEnabled;

    // --- images tab
    @SerializedName("favicon")
    private String faviconImage;
    @SerializedName("logo")
    private String logoImage;
    @SerializedName("background")
    private String backgroundImage;
    @SerializedName("side")
    private String sideImage;

    // --- links tab
    @SerializedName("vk_link")
    private String vkLink;
    @SerializedName("youtube_link")
    private String youtubeLink;
    @SerializedName("discord_link")
    private String discordLink;
    @SerializedName("twitch_link")
    private String twitchLink;
    @SerializedName("instagram_link")
    private String instagramLink;
    @SerializedName("tiktok_link")
    private String tiktokLink;

    // --- customization tab
    @SerializedName("description")
    private String description;
    @SerializedName("theme_id")
    private int themeId;
    @SerializedName("color")
    private String accentColor;
    @SerializedName("enable_background_overlay")
    private boolean usesBackgroundOverlay;
    @SerializedName("hide_side_image")
    private boolean sideImageHidden;
    @SerializedName("products_image_padding")
    private boolean productImagePaddingsEnabled;
    @SerializedName("hide_servers")
    private boolean serversHidden;
    @SerializedName("hide_general_online")
    private boolean totalOnlineHidden;
    @SerializedName("particles")
    private String particlesTypeRaw;
    @SerializedName("css")
    private String css;
    @SerializedName("payment_instruction")
    private String paymentInstruction;
    @SerializedName("hide_payment_instruction")
    private boolean paymentInstructionHidden;

    // --- extra
    @SerializedName("game_id")
    private int gameId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("key")
    private String accessKey;
    @SerializedName("rating")
    private Double rating;

    // --- proxied instances cache
    @Expose private DeliveryMode cachedDeliveryMode;
    @Expose private TestMode cachedTestMode;
    @Expose private Copyright cachedCopyright;
    @Expose private FunctionalTab cachedFunctionalTab;
    @Expose private ImagesTab cachedImagesTab;
    @Expose private LinksTab cachedLinksTab;
    @Expose private CustomizationTab cachedCustomizationTab;
    @Expose private Extra cachedExtra;

    @Override
    public @NotNull DeliveryMode deliveryMode() {
        if(cachedDeliveryMode == null)
            this.cachedDeliveryMode = new ProxiedDeliveryMode(this);

        return cachedDeliveryMode;
    }

    @Override
    public @NotNull TestMode testMode() {
        if(cachedTestMode == null)
            this.cachedTestMode = new ProxiedTestMode(this);

        return cachedTestMode;
    }

    @Override
    public @NotNull Copyright copyright() {
        if(cachedCopyright == null)
            this.cachedCopyright = new ProxiedCopyright(this);

        return cachedCopyright;
    }

    @Override
    public @NotNull FunctionalTab functionalTab() {
        if(cachedFunctionalTab == null)
            this.cachedFunctionalTab = new ProxiedFunctionalTab(this);

        return cachedFunctionalTab;
    }

    @Override
    public @NotNull ImagesTab imagesTab() {
        if(cachedImagesTab == null)
            this.cachedImagesTab = new ProxiedImagesTab(this);

        return cachedImagesTab;
    }

    @Override
    public @NotNull LinksTab linksTab() {
        if(cachedLinksTab == null)
            this.cachedLinksTab = new ProxiedLinksTab(this);

        return cachedLinksTab;
    }

    @Override
    public @NotNull CustomizationTab customizationTab() {
        if(cachedCustomizationTab == null)
            this.cachedCustomizationTab = new ProxiedCustomizationTab(this);

        return cachedCustomizationTab;
    }

    @Override
    public @NotNull Extra extra() {
        if(cachedExtra == null)
            this.cachedExtra = new ProxiedExtra(this);

        return cachedExtra;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ShopModel shopModel = (ShopModel) o;
        return id == shopModel.id &&
                userId == shopModel.userId &&
                pluginInstalled == shopModel.pluginInstalled &&
                active == shopModel.active &&
                premium == shopModel.premium &&
                copyrightHidden == shopModel.copyrightHidden &&
                verified == shopModel.verified &&
                themeId == shopModel.themeId &&
                usesBackgroundOverlay == shopModel.usesBackgroundOverlay &&
                sideImageHidden == shopModel.sideImageHidden &&
                totalOnlineHidden == shopModel.totalOnlineHidden &&
                productImagePaddingsEnabled == shopModel.productImagePaddingsEnabled &&
                serversHidden == shopModel.serversHidden &&
                gameId == shopModel.gameId &&
                testModeEnabled == shopModel.testModeEnabled &&
                emailRequired == shopModel.emailRequired &&
                paymentComissionAssignedToShop == shopModel.paymentComissionAssignedToShop &&
                httpsRedirectEnabled == shopModel.httpsRedirectEnabled &&
                spacesAllowedInNickNames == shopModel.spacesAllowedInNickNames &&
                paymentInstructionHidden == shopModel.paymentInstructionHidden &&
                usesShopCart == shopModel.usesShopCart &&
                Objects.equals(rating, shopModel.rating) &&
                Objects.equals(deliveryTypeRaw, shopModel.deliveryTypeRaw) &&
                Objects.equals(name, shopModel.name) &&
                Objects.equals(description, shopModel.description) &&
                Objects.equals(domain, shopModel.domain) &&
                Objects.equals(lastDomain, shopModel.lastDomain) &&
                Objects.equals(vkLink, shopModel.vkLink) &&
                Objects.equals(youtubeLink, shopModel.youtubeLink) &&
                Objects.equals(discordLink, shopModel.discordLink) &&
                Objects.equals(twitchLink, shopModel.twitchLink) &&
                Objects.equals(instagramLink, shopModel.instagramLink) &&
                Objects.equals(tiktokLink, shopModel.tiktokLink) &&
                Objects.equals(accentColor, shopModel.accentColor) &&
                Objects.equals(backgroundImage, shopModel.backgroundImage) &&
                Objects.equals(logoImage, shopModel.logoImage) &&
                Objects.equals(faviconImage, shopModel.faviconImage) &&
                Objects.equals(sideImage, shopModel.sideImage) &&
                Objects.equals(css, shopModel.css) &&
                Objects.equals(particlesTypeRaw, shopModel.particlesTypeRaw) &&
                Objects.equals(accessKey, shopModel.accessKey) &&
                Objects.equals(whoEnabledTestMode, shopModel.whoEnabledTestMode) &&
                Objects.equals(paymentInstruction, shopModel.paymentInstruction) &&
                Objects.equals(createdAt, shopModel.createdAt) &&
                Objects.equals(updatedAt, shopModel.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, userId, rating, deliveryTypeRaw, pluginInstalled, name, description, domain,
                lastDomain, active, premium, copyrightHidden, verified, vkLink, youtubeLink, discordLink,
                twitchLink, instagramLink, tiktokLink, themeId, accentColor, backgroundImage, logoImage,
                faviconImage, sideImage, css, usesBackgroundOverlay, sideImageHidden, totalOnlineHidden,
                productImagePaddingsEnabled, serversHidden, particlesTypeRaw, gameId, accessKey,
                testModeEnabled, whoEnabledTestMode, emailRequired, paymentComissionAssignedToShop,
                httpsRedirectEnabled, spacesAllowedInNickNames, paymentInstructionHidden,
                paymentInstruction, usesShopCart, createdAt, updatedAt
        );
    }

    @Override
    public String toString() {
        return "ShopModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", lastDomain='" + lastDomain + '\'' +
                ", active=" + active +
                ", premium=" + premium +
                ", verified=" + verified +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deliveryTypeRaw='" + deliveryTypeRaw + '\'' +
                ", pluginInstalled=" + pluginInstalled +
                ", testModeEnabled=" + testModeEnabled +
                ", whoEnabledTestMode='" + whoEnabledTestMode + '\'' +
                ", copyrightHidden=" + copyrightHidden +
                ", copyrightHiddenUntil=" + copyrightHiddenUntil +
                ", paymentComissionAssignedToShop=" + paymentComissionAssignedToShop +
                ", emailRequired=" + emailRequired +
                ", usingShopCart=" + usesShopCart +
                ", spacesAllowedInNickNames=" + spacesAllowedInNickNames +
                ", httpsRedirectEnabled=" + httpsRedirectEnabled +
                ", faviconImage='" + faviconImage + '\'' +
                ", logoImage='" + logoImage + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", sideImage='" + sideImage + '\'' +
                ", vkLink='" + vkLink + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", discordLink='" + discordLink + '\'' +
                ", twitchLink='" + twitchLink + '\'' +
                ", instagramLink='" + instagramLink + '\'' +
                ", tiktokLink='" + tiktokLink + '\'' +
                ", description='" + description + '\'' +
                ", accentColor='" + accentColor + '\'' +
                ", themeId=" + themeId +
                ", usesBackgroundOverlay=" + usesBackgroundOverlay +
                ", sideImageHidden=" + sideImageHidden +
                ", productImagePaddingsEnabled=" + productImagePaddingsEnabled +
                ", serversHidden=" + serversHidden +
                ", totalOnlineHidden=" + totalOnlineHidden +
                ", particlesTypeRaw='" + particlesTypeRaw + '\'' +
                ", css='" + css + '\'' +
                ", paymentInstruction='" + paymentInstruction + '\'' +
                ", paymentInstructionHidden=" + paymentInstructionHidden +
                ", gameId=" + gameId +
                ", userId=" + userId +
                ", accessKey='" + accessKey + '\'' +
                ", rating=" + rating +
                '}';
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedDeliveryMode implements DeliveryMode {

        private final ShopModel shop;

        @Override
        public @NotNull DeliveryModeType getType() {
            return DeliveryModeType.getByKey(shop.deliveryTypeRaw);
        }

        @Override
        public @NotNull String getTypeRaw() {
            return shop.deliveryTypeRaw;
        }

        @Override
        public boolean isPluginInstalled() {
            return shop.pluginInstalled;
        }

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedTestMode implements TestMode {

        private final ShopModel shop;

        @Override
        public boolean isEnabled() {
            return shop.testModeEnabled;
        }

        @Override
        public @NotNull Optional<String> getWhoEnabled() {
            return Wrapper.wrapNullable(shop.whoEnabledTestMode);
        }

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedCopyright implements Copyright {

        private final ShopModel shop;

        @Override
        public boolean isHidden() {
            return shop.copyrightHidden;
        }

        @Override
        public @NotNull Optional<LocalDateTime> getHiddenUntil() {
            return Wrapper.wrapNullable(shop.copyrightHiddenUntil);
        }

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedFunctionalTab implements FunctionalTab {

        private final ShopModel shop;

        @Override
        public boolean isPaymentComissionAssignedToShop() {
            return shop.paymentComissionAssignedToShop;
        }

        @Override
        public boolean isEmailRequired() {
            return shop.emailRequired;
        }

        @Override
        public boolean isUsesShopCart() {
            return shop.usesShopCart;
        }

        @Override
        public boolean isSpacesAllowedInNickNames() {
            return shop.spacesAllowedInNickNames;
        }

        @Override
        public boolean isHttpsRedirectEnabled() {
            return shop.httpsRedirectEnabled;
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedImagesTab implements ImagesTab {

        private final ShopModel shop;

        @Override
        public @NotNull Optional<String> getFaviconImage() {
            return Wrapper.wrapNullable(shop.faviconImage);
        }

        @Override
        public @NotNull Optional<String> getLogoImage() {
            return Wrapper.wrapNullable(shop.logoImage);
        }

        @Override
        public @NotNull Optional<String> getBackgroundImage() {
            return Wrapper.wrapNullable(shop.backgroundImage);
        }

        @Override
        public @NotNull Optional<String> getSideImage() {
            return Wrapper.wrapNullable(shop.sideImage);
        }

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedLinksTab implements LinksTab {

        private final ShopModel shop;

        @Override
        public @NotNull Optional<String> getVKontakteLink() {
            return Wrapper.wrapNullable(shop.vkLink);
        }

        @Override
        public @NotNull Optional<String> getYouTubeLink() {
            return Wrapper.wrapNullable(shop.youtubeLink);
        }

        @Override
        public @NotNull Optional<String> getDiscordLink() {
            return Wrapper.wrapNullable(shop.discordLink);
        }

        @Override
        public @NotNull Optional<String> getTwitchLink() {
            return Wrapper.wrapNullable(shop.twitchLink);
        }

        @Override
        public @NotNull Optional<String> getInstagramLink() {
            return Wrapper.wrapNullable(shop.instagramLink);
        }

        @Override
        public @NotNull Optional<String> getTikTokLink() {
            return Wrapper.wrapNullable(shop.tiktokLink);
        }

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedCustomizationTab implements CustomizationTab {

        private final ShopModel shop;

        @Override
        public @NotNull Optional<String> getDescription() {
            return Wrapper.wrapNullable(shop.description);
        }

        @Override
        public @NotNull String getAccentColor() {
            return shop.accentColor;
        }

        @Override
        public int getThemeId() {
            return shop.themeId;
        }

        @Override
        public boolean isUsesBackgroundOverlay() {
            return shop.usesBackgroundOverlay;
        }

        @Override
        public boolean isSideImageHidden() {
            return shop.sideImageHidden;
        }

        @Override
        public boolean isProductImagePaddingsEnabled() {
            return shop.productImagePaddingsEnabled;
        }

        @Override
        public boolean isServersHidden() {
            return shop.serversHidden;
        }

        @Override
        public boolean isTotalOnlineHidden() {
            return shop.totalOnlineHidden;
        }

        @Override
        public @NotNull ParticlesType getParticlesType() {
            return ParticlesType.getByKey(shop.particlesTypeRaw);
        }

        @Override
        public @NotNull String getParticlesTypeRaw() {
            return shop.particlesTypeRaw;
        }

        @Override
        public @NotNull Optional<String> getCustomCSS() {
            return Wrapper.wrapNullable(shop.css);
        }

        @Override
        public @NotNull String getPaymentInstruction() {
            return shop.paymentInstruction;
        }

        @Override
        public boolean isPaymentInstructionHidden() {
            return shop.paymentInstructionHidden;
        }

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class ProxiedExtra implements Extra {

        private final ShopModel shop;

        @Override
        public int getGameId() {
            return shop.gameId;
        }

        @Override
        public int getUserId() {
            return shop.userId;
        }

        @Override
        public @NotNull String getAccessKey() {
            return shop.accessKey;
        }

        @Override
        public @NotNull OptionalDouble getRating() {
            return Wrapper.wrapNullableDouble(shop.rating);
        }

    }

}
