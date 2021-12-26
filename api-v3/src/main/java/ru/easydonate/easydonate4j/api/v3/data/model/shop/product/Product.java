package ru.easydonate.easydonate4j.api.v3.data.model.shop.product;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.Sorted;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.AdditionalField;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.ProductType;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * The interface that represents a product and contains all related data.
 * @author soknight
 */
public interface Product extends Sorted, PrettyPrintable {

    /**
     * Get the unique ID of this product.
     * @return The product ID.
     */
    int getId();

    /**
     * Get the ID of the product owning shop.
     * @return The owning shop ID.
     */
    int getShopId();

    /**
     * Get the name of this product.
     * @return The product name.
     */
    @NotNull String getName();

    /**
     * Get the type of this product.
     * @return The product type.
     * @see ProductType
     */
    @NotNull ProductType getType();

    /**
     * Get the raw type of this product.
     * <br>
     * Can be used when the {@link #getType()} method
     * has returned the unknown constant.
     * @return The raw product type.
     * @see #getType()
     */
    @NotNull String getTypeRaw();

    /**
     * Get the base price of this product.
     * @return The product price.
     */
    double getPrice();

    /**
     * Get the default amount of this product.
     * @return The product amount.
     */
    int getAmount();

    /**
     * Get the optional-wrapped description of this product.
     * <br>
     * If a description isn't actually specified,
     * this method will return an empty Optional.
     * @return The optional-wrapped product description.
     */
    @NotNull Optional<String> getDescription();

    /**
     * Get the optional-wrapped old price of this product.
     * <br>
     * The old price is a good marketing tool :)
     * @return The optional-wrapped product old price.
     */
    @NotNull OptionalDouble getOldPrice();

    /**
     * Get the optional-wrapped category ID of this product.
     * <br>
     * It's useless now because EasyDonate API hasn't categories related methods.
     * @return The optional-wrapped product category ID.
     */
    @NotNull OptionalInt getCategoryId();

    /**
     * Get the icon image of this product.
     * <br>
     * It's always just a direct URL to some image.
     * @return The product icon image.
     */
    @NotNull String getIconImage();

    /**
     * Check is this product is hidden from the shop web-pages.
     * @return A boolean value: the check result.
     */
    boolean isHidden();

    /**
     * Check is this product may be purchased only one time or not.
     * <br>
     * After the first purchase of this product will be hidden from the shop.
     * @return A boolean value: the check result.
     */
    boolean isOneTimePurchasable();

    /**
     * Get the in-game commands that will be sent after purchase of this product.
     * @return The product configured list of commands.
     * @see Payment#getSentCommands()
     */
    @NotNull List<String> getCommands();

    /**
     * Get the in-game commands for withdraw the purchase after any time.
     * <br>
     * If there are no withdraw commands specified then this list will be empty.
     * @return The product configured list of withdraw commands.
     */
    @NotNull List<String> getWithdrawCommands();

    /**
     * Get the optional-wrapped delay for withdraw commands running.
     * <br>
     * If this method has return an empty Optional
     * then there are no withdraw commands configured.
     * @return The product withdraw commands running delay.
     */
    @NotNull OptionalInt getWithdrawCommandsDelay();

    /**
     * Get the list of additional fields for this product.
     * @return The product configured additional fields.
     * @see AdditionalField
     */
    @NotNull List<AdditionalField> getAdditionalFields();

    /**
     * Get the compatible servers list for this product.
     * @return The product configured servers.
     */
    @NotNull Optional<ServersList> getServers();

    /**
     * Get the creation date of this product.
     * @return The product creation date.
     */
    @NotNull LocalDateTime getCreatedAt();

    /**
     * Get a date of the last product update.
     * @return The last product update date.
     */
    @NotNull LocalDateTime getUpdatedAt();

}
