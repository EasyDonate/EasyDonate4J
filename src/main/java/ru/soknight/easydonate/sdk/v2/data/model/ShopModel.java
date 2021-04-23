package ru.soknight.easydonate.sdk.v2.data.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import ru.soknight.easydonate.sdk.v2.data.PrettyPrintable;
import ru.soknight.easydonate.sdk.v2.json.deserialize.DateDeserializer;
import ru.soknight.easydonate.sdk.v2.json.deserialize.DateSerializer;

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
    @JsonProperty("require_email")
    private boolean emailRequired;
    @JsonProperty("pay_comission")
    private boolean hasPaymentComission;
    @JsonProperty("cs_protected")
    private boolean cloudShieldProtected;
    
    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
    
    @Override
    public int hashCode() {
        return Objects.hash(
                accessKey, active, backgroundImage, backgroundOverlayEnabled, cloudShieldProtected,
                color, copyrightHidden, createdAt, css, description, discordLink, domain, emailRequired,
                faviconImage, generalOnlineHidden, hasPaymentComission, instagramLink, lastDomain,
                logoImage, name, particles, premium, productsImagePaddingEnabled, recordId, serversHidden,
                shopId, sideImage, sideImageHidden, testModeEnabled, themeId, tiktokLink, twitchLink,
                updatedAt, userId, verified, vkLink, youtubeLink
        );
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        ShopModel other = (ShopModel) obj;
        return Objects.equals(accessKey, other.accessKey) &&
                active == other.active &&
                Objects.equals(backgroundImage, other.backgroundImage) &&
                backgroundOverlayEnabled == other.backgroundOverlayEnabled &&
                cloudShieldProtected == other.cloudShieldProtected &&
                Objects.equals(color, other.color) &&
                copyrightHidden == other.copyrightHidden &&
                Objects.equals(createdAt, other.createdAt) &&
                Objects.equals(css, other.css) &&
                Objects.equals(description, other.description) &&
                Objects.equals(discordLink, other.discordLink) &&
                Objects.equals(domain, other.domain) &&
                emailRequired == other.emailRequired &&
                Objects.equals(faviconImage, other.faviconImage) &&
                generalOnlineHidden == other.generalOnlineHidden &&
                hasPaymentComission == other.hasPaymentComission &&
                Objects.equals(instagramLink, other.instagramLink) &&
                Objects.equals(lastDomain, other.lastDomain) &&
                Objects.equals(logoImage, other.logoImage) &&
                Objects.equals(name, other.name) &&
                Objects.equals(particles, other.particles) &&
                premium == other.premium &&
                productsImagePaddingEnabled == other.productsImagePaddingEnabled &&
                Objects.equals(recordId, other.recordId) &&
                serversHidden == other.serversHidden &&
                shopId == other.shopId &&
                Objects.equals(sideImage, other.sideImage) &&
                sideImageHidden == other.sideImageHidden &&
                testModeEnabled == other.testModeEnabled &&
                themeId == other.themeId &&
                Objects.equals(tiktokLink, other.tiktokLink) &&
                Objects.equals(twitchLink, other.twitchLink) &&
                Objects.equals(updatedAt, other.updatedAt) &&
                userId == other.userId &&
                verified == other.verified &&
                Objects.equals(vkLink, other.vkLink) &&
                Objects.equals(youtubeLink, other.youtubeLink);
    }
    
    @Override
    public String toString() {
        return "Shop{"
                + "userId=" + userId
                + ", shopId=" + shopId
                + ", name='" + name + "'"
                + ", description='" + description + "'"
                + ", domain=" + domain
                + ", lastDomain=" + lastDomain
                + ", active=" + active
                + ", premium=" + premium
                + ", copyrightHidden=" + copyrightHidden
                + ", verified=" + verified
                + ", recordId=" + recordId
                + ", vkLink=" + vkLink
                + ", youtubeLink=" + youtubeLink
                + ", discordLink=" + discordLink
                + ", twitchLink=" + twitchLink
                + ", instagramLink=" + instagramLink
                + ", tiktokLink=" + tiktokLink
                + ", themeId=" + themeId
                + ", color=" + color
                + ", backgroundImage=" + backgroundImage
                + ", logoImage=" + logoImage
                + ", faviconImage=" + faviconImage
                + ", sideImage=" + sideImage
                + ", css=" + css
                + ", backgroundOverlayEnabled=" + backgroundOverlayEnabled
                + ", sideImageHidden=" + sideImageHidden
                + ", generalOnlineHidden=" + generalOnlineHidden
                + ", productsImagePaddingEnabled=" + productsImagePaddingEnabled
                + ", serversHidden=" + serversHidden
                + ", particles='" + particles + "'"
                + ", accessKey=" + accessKey
                + ", testModeEnabled=" + testModeEnabled
                + ", emailRequired=" + emailRequired
                + ", hasPaymentComission=" + hasPaymentComission
                + ", cloudShieldProtected=" + cloudShieldProtected
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + "}";
    }
    
}
