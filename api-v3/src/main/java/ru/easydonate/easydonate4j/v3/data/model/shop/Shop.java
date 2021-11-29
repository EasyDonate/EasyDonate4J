package ru.easydonate.easydonate4j.v3.data.model.shop;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * The object that represents a shop and contains all data about it.
 * @author soknight
 */
public interface Shop extends PrettyPrintable {

    /**
     * Get a unique ID of this shop.
     * @return The shop ID.
     */
    int getId();

    /**
     * Get a displayable name of this shop.
     * @return The shop name.
     */
    @NotNull String getName();

    /**
     * Get a current domain name of this shop.
     * @return The current shop domain.
     */
    @NotNull String getDomain();

    /**
     * Get an original domain name of this shop.
     * <br>
     * It's a domain name that has been set on the shop creation step.
     * @return The original shop domain.
     */
    @NotNull String getLastDomain();

    /**
     * Check is this shop is active or not.
     * <br>
     * If this method returned false that this shop has been blocked.
     * <br>
     * By default every shop will be active.
     * @return The check result (true/false).
     */
    boolean isActive();

    /**
     * Check is this shop has a premium subscription or not.
     * @deprecated This feature will be revised later.
     * @return The check result (true/false).
     */
    @Deprecated
    boolean isPremium();

    /**
     * Check is this shop has been verified or not.
     * <br>
     * <b>Tip:</b> To pass the verification check you need to verify
     * all your servers via special key in the server MOTD.
     * @return The check result (true/false).
     */
    boolean isVerified();

    /**
     * Get a date when this shop was created.
     * @return The shop creation date.
     */
    @NotNull LocalDateTime getCreatedAt();

    /**
     * Get a date when this shop was modified recently.
     * @return The last shop modification date.
     */
    @NotNull LocalDateTime getUpdatedAt();

    /**
     * Get the product delivery mode describing instance.
     * @return The instance that represents the delivery mode settings.
     * @see DeliveryMode
     */
    @NotNull DeliveryMode deliveryMode();

    /**
     * Get the shop test mode describing instance.
     * @return The instance that represents the test mode settings.
     * @see TestMode
     */
    @NotNull TestMode testMode();

    /**
     * Get the copyright settings describing instance.
     * @return The instance that represents the copyright settings.
     * @see Copyright
     */
    @NotNull Copyright copyright();

    /**
     * Get the instance that represents the Functional tab in the shop control panel.
     * @return The instance that represents the functional tab settings.
     * @see FunctionalTab
     */
    @NotNull FunctionalTab functionalTab();

    /**
     * Get the instance that represents the Images tab in the shop control panel.
     * @return The instance that represents the functional tab settings.
     * @see ImagesTab
     */
    @NotNull ImagesTab imagesTab();

    /**
     * Get the instance that represents the Links tab in the shop control panel.
     * @return The instance that represents the links tab settings.
     * @see LinksTab
     */
    @NotNull LinksTab linksTab();

    /**
     * Get the instance that represents the Customization tab in the shop control panel.
     * @return The instance that represents the customization tab settings.
     * @see CustomizationTab
     */
    @NotNull CustomizationTab customizationTab();

    /**
     * Get the instance that store some other extra values from the shop settings.
     * @return The instance that store some additional settings values.
     * @see Extra
     */
    @NotNull Extra extra();

    /**
     * The instance that represents the product delivery mode
     * settings in the shop control panel.
     * @see Shop#deliveryMode()
     */
    interface DeliveryMode {

        /**
         * Parse the raw type as the enum constant.
         * @return The parsed delivery mode enum constant.
         * @see DeliveryModeType#getByKey(String)
         */
        @NotNull DeliveryModeType getType();

        /**
         * Get the raw type of the delivery mode.
         * @return The raw type returned by server.
         */
        @NotNull String getTypeRaw();

        /**
         * Check is the payment processing plugin is installed for this shop or not.
         * <br>
         * Actually only when the delivery mode is {@link DeliveryModeType#PLUGIN}.
         * @return The check result (true/false).
         * @see #getType()
         */
        boolean isPluginInstalled();

    }

    /**
     * The instance that represents the test mode
     * settings in the shop control panel.
     * @see Shop#testMode()
     */
    interface TestMode {

        /**
         * Check is the test mode is enabled for this shop or not.
         * @return The check result (true/false).
         */
        boolean isEnabled();

        /**
         * Get the IP address of user who enabled the test mode for this shop.
         * <br>
         * It's wrapped in the Optional because can be null.
         * @return The IP address of user who enabled the test mode.
         * @see #isEnabled()
         */
        @NotNull Optional<String> getWhoEnabled();

    }

    /**
     * The instance that represents the copyright
     * settings in the shop control panel.
     * @see Shop#copyright()
     */
    interface Copyright {

        /**
         * Check is the copyright is currently hidden in this shop or not.
         * @return The check result (true/false).
         */
        boolean isHidden();

        /**
         * Get the date when copyright hiding subscription expire.
         * @return The copyright hiding inactive date.
         * @see #isHidden()
         */
        @NotNull Optional<LocalDateTime> getHiddenUntil();

    }

    /**
     * The instance that represents the functional tab
     * settings in the shop control panel.
     * @see Shop#functionalTab()
     */
    interface FunctionalTab {

        /**
         * Check is the payment comission was assigned to shop instead of customer or not.
         * @return The check result (true/false).
         */
        boolean isPaymentComissionAssignedToShop();

        /**
         * Check is the email is required for customer to perform purchase or not.
         * @return The check result (true/false).
         */
        boolean isEmailRequired();

        /**
         * Check is this shop uses the shop cart or not.
         * @return The check result (true/false).
         */
        boolean isUsesShopCart();

        /**
         * Check is the spaces are allowed to use in the nicknames or not.
         * @return The check result (true/false).
         */
        boolean isSpacesAllowedInNickNames();

        /**
         * Check is the HTTPS redirect enabled for this shop or not.
         * @return The check result (true/false).
         */
        boolean isHttpsRedirectEnabled();

    }
    /**
     * The instance that represents the images tab
     * settings in the shop control panel.
     * @see Shop#imagesTab()
     */
    interface ImagesTab {

        /**
         * Get the favicon image that used in this shop.
         * @return The favicon image.
         */
        @NotNull Optional<String> getFaviconImage();

        /**
         * Get the logo image that used in this shop.
         * @return The logo image.
         */
        @NotNull Optional<String> getLogoImage();

        /**
         * Get the background image that used in this shop.
         * @return The background image.
         */
        @NotNull Optional<String> getBackgroundImage();

        /**
         * Get the side image that used in this shop.
         * @return The side image.
         */
        @NotNull Optional<String> getSideImage();

    }

    /**
     * The instance that represents the links tab
     * settings in the shop control panel.
     * @see Shop#linksTab()
     */
    interface LinksTab {

        /**
         * Get the VK link that used in this shop.
         * @return The VK link.
         */
        @NotNull Optional<String> getVKontakteLink();

        /**
         * Get the YouTube link that used in this shop.
         * @return The YouTube link.
         */
        @NotNull Optional<String> getYouTubeLink();

        /**
         * Get the Discord link that used in this shop.
         * @return The Discord link.
         */
        @NotNull Optional<String> getDiscordLink();

        /**
         * Get the Twitch link that used in this shop.
         * @return The Twitch link.
         */
        @NotNull Optional<String> getTwitchLink();

        /**
         * Get the Instagram link that used in this shop.
         * @return The Instagram link.
         */
        @NotNull Optional<String> getInstagramLink();

        /**
         * Get the TikTok link that used in this shop.
         * @return The TikTok link.
         */
        @NotNull Optional<String> getTikTokLink();

    }

    /**
     * The instance that represents the customization tab
     * settings in the shop control panel.
     * @see Shop#customizationTab()
     */
    interface CustomizationTab {

        /**
         * Get the optional description of this shop.
         * @return The shop description.
         */
        @NotNull Optional<String> getDescription();

        /**
         * Get the theming accent color used in this shop.
         * @return The theme accent color in this shop.
         */
        @NotNull String getAccentColor();

        /**
         * Get the ID of used webpage pattern (a.k.a. theme).
         * @return The shop webpage theme ID.
         */
        int getThemeId();

        /**
         * Check is this shop uses the background overlay or not.
         * @return The check result (true/false).
         */
        boolean isUsesBackgroundOverlay();

        /**
         * Check is the side image hidden in this shop or not.
         * @return The check result (true/false).
         */
        boolean isSideImageHidden();

        /**
         * Check is this shop has a paddings in the product images or not.
         * @return The check result (true/false).
         */
        boolean isProductImagePaddingsEnabled();

        /**
         * Check is the servers list is hidden in this shop or not.
         * @return The check result (true/false).
         */
        boolean isServersHidden();

        /**
         * Check is the total servers online is hidden in this shop or not.
         * @return The check result (true/false).
         */
        boolean isTotalOnlineHidden();

        /**
         * Parse the raw particles type as the enum constant.
         * @return The parsed particles type enum constant.
         * @see ParticlesType#getByKey(String)
         */
        @NotNull ParticlesType getParticlesType();

        /**
         * Get the raw type of the used particles.
         * @return The raw type returned by server.
         */
        @NotNull String getParticlesTypeRaw();

        /**
         * Get the hosted URL to custom CSS file used in this shop.
         * @return The direct URL to custom CSS file.
         */
        @NotNull Optional<String> getCustomCSS();

        /**
         * Get the payment instruction located on the webpage as HTML code snippet.
         * @return The payment instruction HTML code snippet.
         */
        @NotNull String getPaymentInstruction();

        /**
         * Check is the payment instruction is hidden in this shop or not.
         * @return The check result (true/false).
         */
        boolean isPaymentInstructionHidden();

    }

    /**
     * The instance that represents the additional
     * extra settings in the shop control panel.
     * @see Shop#extra()
     */
    interface Extra {

        /**
         * Get the internal used game ID.
         * @return The game ID.
         */
        int getGameId();

        /**
         * Get the ID of user who owned this shop.
         * @return The shop owner ID.
         */
        int getUserId();

        /**
         * Get the shop access key (a.k.a. API key).
         * @return The shop access key.
         */
        @NotNull String getAccessKey();

        /**
         * Get the shop rating that optionally represented by a double value from 0.0 to 5.0.
         * @return The shop rating.
         */
        @NotNull OptionalDouble getRating();

    }

    /**
     * The enum that represents all possible & actual particles types.
     */
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    enum ParticlesType {

        /**
         * Represents the snow particles.
         */
        SNOW("snow"),

        /**
         * Represents the rain particles.
         */
        RAIN("rain"),

        /**
         * Represents the autumn leaf fall particles.
         */
        AUTUMN("autumn"),

        /**
         * Means that particles is disabled there.
         */
        NOTHING("none"),

        /**
         * Represents an unknown particles type, not known yet.
         */
        UNKNOWN("unknown");

        private final @NotNull String key;

        /**
         * Get the enum constant by the known particles key (can be null).
         * <br>
         * If the key is null/empty or relevant enum constant with this key will not be found then
         * this method will return {@link ParticlesType#UNKNOWN} constant as default.
         * @param key the particles key to find an enum constant.
         * @return The found particles enum constant or {@link ParticlesType#UNKNOWN} by default.
         */
        public static @NotNull ParticlesType getByKey(@Nullable String key) {
            if(key == null || key.isEmpty())
                return UNKNOWN;

            for(ParticlesType particlesType : values())
                if(particlesType.getKey().equalsIgnoreCase(key))
                    return particlesType;

            return UNKNOWN;
        }

    }

}
