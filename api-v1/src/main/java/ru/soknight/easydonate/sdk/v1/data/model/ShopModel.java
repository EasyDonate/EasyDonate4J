package ru.soknight.easydonate.sdk.v1.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.soknight.easydonate.sdk.v1.data.PrettyPrintable;
import ru.soknight.easydonate.sdk.v1.json.deserialize.DateDeserializer;
import ru.soknight.easydonate.sdk.v1.json.deserialize.DateSerializer;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The object which represents remote shop.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true, value = { "sort_index" })
public class ShopModel implements PrettyPrintable {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("id")
    private int shopId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("last_domain")
    private String lastDomain;
    
    @JsonProperty("is_active")
    private boolean active;
    @JsonProperty("is_premium")
    private boolean premium;
    @JsonProperty("hide_copyright")
    private boolean copyrightHidden;
    @JsonProperty("is_verified")
    private boolean verified;
    
    @JsonProperty("record_id")
    private String recordId;
    @JsonProperty("vk_link")
    private String vkLink;
    @JsonProperty("youtube_link")
    private String youtubeLink;
    @JsonProperty("discord_link")
    private String discordLink;
    @JsonProperty("twitch_link")
    private String twitchLink;
    @JsonProperty("instagram_link")
    private String instagramLink;
    @JsonProperty("tiktok_link")
    private String tiktokLink;
    
    @JsonProperty("theme_id")
    private int themeId;
    @JsonProperty("color")
    private String color;
    @JsonProperty("background")
    private String backgroundImage;
    @JsonProperty("logo")
    private String logoImage;
    @JsonProperty("favicon")
    private String faviconImage;
    @JsonProperty("side")
    private String sideImage;
    @JsonProperty("css")
    private String css;
    @JsonProperty("enable_background_overlay")
    private boolean backgroundOverlayEnabled;
    @JsonProperty("hide_side_image")
    private boolean sideImageHidden;
    @JsonProperty("hide_general_online")
    private boolean generalOnlineHidden;
    @JsonProperty("products_image_padding")
    private boolean productsImagePaddingEnabled;
    @JsonProperty("hide_servers")
    private boolean serversHidden;
    @JsonProperty("particles")
    private String particles;
    
    @JsonProperty("key")
    private String accessKey;
    @JsonProperty("test_mode")
    private boolean testModeEnabled;
    @JsonProperty("test_mode_from")
    private String whoEnabledTestMode;
    @JsonProperty("require_email")
    private boolean emailRequired;
    @JsonProperty("pay_comission")
    private boolean hasPaymentCommission;
    @JsonProperty("cs_protected")
    private boolean cloudShieldProtected;
    @JsonProperty("https_redirect")
    private boolean httpsRedirectEnabled;
    @JsonProperty("allow_nickname_spaces")
    private boolean nicknameSpacesAllowed;
    @JsonProperty("game_id")
    private int gameId;
    @JsonProperty("hide_payment_instruction")
    private boolean paymentInstructionHidden;
    @JsonProperty("payment_instruction")
    private String paymentInstruction;
    
    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ShopModel shopModel = (ShopModel) o;
        return userId == shopModel.userId &&
                shopId == shopModel.shopId &&
                active == shopModel.active &&
                premium == shopModel.premium &&
                copyrightHidden == shopModel.copyrightHidden &&
                verified == shopModel.verified &&
                themeId == shopModel.themeId &&
                backgroundOverlayEnabled == shopModel.backgroundOverlayEnabled &&
                sideImageHidden == shopModel.sideImageHidden &&
                generalOnlineHidden == shopModel.generalOnlineHidden &&
                productsImagePaddingEnabled == shopModel.productsImagePaddingEnabled &&
                serversHidden == shopModel.serversHidden &&
                testModeEnabled == shopModel.testModeEnabled &&
                emailRequired == shopModel.emailRequired &&
                hasPaymentCommission == shopModel.hasPaymentCommission &&
                cloudShieldProtected == shopModel.cloudShieldProtected &&
                httpsRedirectEnabled == shopModel.httpsRedirectEnabled &&
                nicknameSpacesAllowed == shopModel.nicknameSpacesAllowed &&
                gameId == shopModel.gameId &&
                paymentInstructionHidden == shopModel.paymentInstructionHidden &&
                Objects.equals(name, shopModel.name) &&
                Objects.equals(description, shopModel.description) &&
                Objects.equals(domain, shopModel.domain) &&
                Objects.equals(lastDomain, shopModel.lastDomain) &&
                Objects.equals(recordId, shopModel.recordId) &&
                Objects.equals(vkLink, shopModel.vkLink) &&
                Objects.equals(youtubeLink, shopModel.youtubeLink) &&
                Objects.equals(discordLink, shopModel.discordLink) &&
                Objects.equals(twitchLink, shopModel.twitchLink) &&
                Objects.equals(instagramLink, shopModel.instagramLink) &&
                Objects.equals(tiktokLink, shopModel.tiktokLink) &&
                Objects.equals(color, shopModel.color) &&
                Objects.equals(backgroundImage, shopModel.backgroundImage) &&
                Objects.equals(logoImage, shopModel.logoImage) &&
                Objects.equals(faviconImage, shopModel.faviconImage) &&
                Objects.equals(sideImage, shopModel.sideImage) &&
                Objects.equals(css, shopModel.css) &&
                Objects.equals(particles, shopModel.particles) &&
                Objects.equals(accessKey, shopModel.accessKey) &&
                Objects.equals(whoEnabledTestMode, shopModel.whoEnabledTestMode) &&
                Objects.equals(paymentInstruction, shopModel.paymentInstruction) &&
                Objects.equals(createdAt, shopModel.createdAt) &&
                Objects.equals(updatedAt, shopModel.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                userId, shopId, name, description, domain, lastDomain, active, premium,
                copyrightHidden, verified, recordId, vkLink, youtubeLink, discordLink,
                twitchLink, instagramLink, tiktokLink, themeId, color, backgroundImage,
                logoImage, faviconImage, sideImage, css, backgroundOverlayEnabled,
                sideImageHidden, generalOnlineHidden, productsImagePaddingEnabled,
                serversHidden, particles, accessKey, testModeEnabled, whoEnabledTestMode,
                emailRequired, hasPaymentCommission, cloudShieldProtected, httpsRedirectEnabled,
                nicknameSpacesAllowed, gameId, paymentInstructionHidden, paymentInstruction,
                createdAt, updatedAt
        );
    }

    @Override
    public String toString() {
        return "ShopModel{" +
                "userId=" + userId +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", domain='" + domain + '\'' +
                ", lastDomain='" + lastDomain + '\'' +
                ", active=" + active +
                ", premium=" + premium +
                ", copyrightHidden=" + copyrightHidden +
                ", verified=" + verified +
                ", recordId='" + recordId + '\'' +
                ", vkLink='" + vkLink + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", discordLink='" + discordLink + '\'' +
                ", twitchLink='" + twitchLink + '\'' +
                ", instagramLink='" + instagramLink + '\'' +
                ", tiktokLink='" + tiktokLink + '\'' +
                ", themeId=" + themeId +
                ", color='" + color + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", logoImage='" + logoImage + '\'' +
                ", faviconImage='" + faviconImage + '\'' +
                ", sideImage='" + sideImage + '\'' +
                ", css='" + css + '\'' +
                ", backgroundOverlayEnabled=" + backgroundOverlayEnabled +
                ", sideImageHidden=" + sideImageHidden +
                ", generalOnlineHidden=" + generalOnlineHidden +
                ", productsImagePaddingEnabled=" + productsImagePaddingEnabled +
                ", serversHidden=" + serversHidden +
                ", particles=" + particles +
                ", accessKey=" + accessKey +
                ", testModeEnabled=" + testModeEnabled +
                ", whoEnabledTestMode=" + whoEnabledTestMode +
                ", emailRequired=" + emailRequired +
                ", hasPaymentCommission=" + hasPaymentCommission +
                ", cloudShieldProtected=" + cloudShieldProtected +
                ", httpsRedirectEnabled=" + httpsRedirectEnabled +
                ", nicknameSpacesAllowed=" + nicknameSpacesAllowed +
                ", gameId=" + gameId +
                ", paymentInstructionHidden=" + paymentInstructionHidden +
                ", paymentInstruction='" + paymentInstruction + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
