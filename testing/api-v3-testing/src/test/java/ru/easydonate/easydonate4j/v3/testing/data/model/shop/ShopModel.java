package ru.easydonate.easydonate4j.v3.testing.data.model.shop;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.shop.Shop;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Builder(buildMethodName = "create", setterPrefix = "set")
public final class ShopModel implements Shop {

    // --- general
    private int id;

    private String name;
    private String domain;
    private String lastDomain;

    private boolean active;
    private boolean premium;
    private boolean verified;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // --- delivery mode
    private String deliveryTypeRaw;
    private boolean pluginInstalled;

    // --- test mode
    private boolean testModeEnabled;
    private String whoEnabledTestMode;

    // --- copyright
    private boolean copyrightHidden;
    private LocalDateTime copyrightHiddenUntil;

    // --- functional tab
    private boolean paymentComissionAssignedToShop;
    private boolean emailRequired;
    private boolean usesShopCart;
    private boolean spacesAllowedInNickNames;
    private boolean httpsRedirectEnabled;

    // --- images tab
    private String faviconImage;
    private String logoImage;
    private String backgroundImage;
    private String sideImage;

    // --- links tab
    private String vkLink;
    private String youtubeLink;
    private String discordLink;
    private String twitchLink;
    private String instagramLink;
    private String tiktokLink;

    // --- customization tab
    private String description;
    private int themeId;
    private String accentColor;
    private boolean usesBackgroundOverlay;
    private boolean sideImageHidden;
    private boolean productImagePaddingsEnabled;
    private boolean serversHidden;
    private boolean totalOnlineHidden;
    private String particlesTypeRaw;
    private String css;
    private String paymentInstruction;
    private boolean paymentInstructionHidden;

    // --- extra
    private int gameId;
    private int userId;
    private String accessKey;
    private Double rating;

    @Override
    public @NotNull DeliveryMode deliveryMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull TestMode testMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull Copyright copyright() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull FunctionalTab functionalTab() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull ImagesTab imagesTab() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull LinksTab linksTab() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull CustomizationTab customizationTab() {
        throw new UnsupportedOperationException();
    }

    @Override
    public @NotNull Extra extra() {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean equals(Object other) {
        if(this == other) return true;
        if(other == null || !other.getClass().isInstance(Shop.class)) return false;

        Shop shop = (Shop) other;
        return id == shop.getId() &&
                userId == shop.extra().getUserId() &&
                pluginInstalled == shop.deliveryMode().isPluginInstalled() &&
                active == shop.isActive() &&
                premium == shop.isPremium() &&
                copyrightHidden == shop.copyright().isHidden() &&
                verified == shop.isVerified() &&
                themeId == shop.customizationTab().getThemeId() &&
                usesBackgroundOverlay == shop.customizationTab().isUsesBackgroundOverlay() &&
                sideImageHidden == shop.customizationTab().isSideImageHidden() &&
                totalOnlineHidden == shop.customizationTab().isTotalOnlineHidden() &&
                productImagePaddingsEnabled == shop.customizationTab().isProductImagePaddingsEnabled() &&
                serversHidden == shop.customizationTab().isServersHidden() &&
                gameId == shop.extra().getGameId() &&
                testModeEnabled == shop.testMode().isEnabled() &&
                emailRequired == shop.functionalTab().isEmailRequired() &&
                paymentComissionAssignedToShop == shop.functionalTab().isPaymentComissionAssignedToShop() &&
                httpsRedirectEnabled == shop.functionalTab().isHttpsRedirectEnabled() &&
                spacesAllowedInNickNames == shop.functionalTab().isSpacesAllowedInNickNames() &&
                paymentInstructionHidden == shop.customizationTab().isPaymentInstructionHidden() &&
                usesShopCart == shop.functionalTab().isUsesShopCart() &&
                Objects.equals(rating, shop.extra().getRatingRaw()) &&
                Objects.equals(deliveryTypeRaw, shop.deliveryMode().getTypeRaw()) &&
                Objects.equals(name, shop.getName()) &&
                Objects.equals(description, shop.customizationTab().getDescription().orElse(null)) &&
                Objects.equals(domain, shop.getDomain()) &&
                Objects.equals(lastDomain, shop.getLastDomain()) &&
                Objects.equals(vkLink, shop.linksTab().getVKontakteLink().orElse(null)) &&
                Objects.equals(youtubeLink, shop.linksTab().getYouTubeLink().orElse(null)) &&
                Objects.equals(discordLink, shop.linksTab().getDiscordLink().orElse(null)) &&
                Objects.equals(twitchLink, shop.linksTab().getTwitchLink().orElse(null)) &&
                Objects.equals(instagramLink, shop.linksTab().getInstagramLink().orElse(null)) &&
                Objects.equals(tiktokLink, shop.linksTab().getTikTokLink().orElse(null)) &&
                Objects.equals(accentColor, shop.customizationTab().getAccentColor()) &&
                Objects.equals(backgroundImage, shop.imagesTab().getBackgroundImage().orElse(null)) &&
                Objects.equals(logoImage, shop.imagesTab().getLogoImage().orElse(null)) &&
                Objects.equals(faviconImage, shop.imagesTab().getFaviconImage().orElse(null)) &&
                Objects.equals(sideImage, shop.imagesTab().getSideImage().orElse(null)) &&
                Objects.equals(css, shop.customizationTab().getCustomCSS().orElse(null)) &&
                Objects.equals(particlesTypeRaw, shop.customizationTab().getParticlesTypeRaw()) &&
                Objects.equals(accessKey, shop.extra().getAccessKey()) &&
                Objects.equals(whoEnabledTestMode, shop.testMode().getWhoEnabled().orElse(null)) &&
                Objects.equals(paymentInstruction, shop.customizationTab().getPaymentInstruction()) &&
                Objects.equals(createdAt, shop.getCreatedAt()) &&
                Objects.equals(updatedAt, shop.getUpdatedAt());
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
    public @NotNull String toString() {
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
    
}
