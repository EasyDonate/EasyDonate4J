package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.ProductType;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * The interface that represents a purchased product.
 * <br>
 * You can receive this object from the purchases list in the {@link Payment}.
 * @see Payment#getProducts()
 * @author soknight
 */
public interface PurchasedProduct extends PrettyPrintable {

    /**
     * Get the ID of this purchase.
     * @return The purchase ID.
     */
    int getId();

    /**
     * Get the ID of the purchased product.
     * @return The purchased product ID.
     */
    int getProductId();

    /**
     * Get the ID of the related payment.
     * @return The purchase payment ID.
     */
    int getPaymentId();

    /**
     * Get the name of the purchased product.
     * @return The purchased product name.
     */
    @NotNull String getName();

    /**
     * Get the type of the purchased product.
     * @return The purchased product type.
     * @see ProductType
     */
    @NotNull ProductType getType();

    /**
     * Get the raw type of the purchased product.
     * <br>
     * Can be used when the {@link #getType()} method
     * has returned the unknown constant.
     * @return The raw purchased product type.
     * @see #getType()
     */
    @NotNull String getTypeRaw();

    /**
     * Get the price of this purchase.
     * @return The purchase price.
     */
    double getPrice();

    /**
     * Get the default amount of the purchased product.
     * @return The purchased product default amount.
     */
    long getDefaultAmount();

    /**
     * Get the actual bought amount of the purchased product.
     * @return The purchased product amount.
     */
    long getBoughtAmount();

    /**
     * Get the optional-wrapped description of the purchased product.
     * @return The optional-wrapped purchased product description.
     */
    @NotNull Optional<String> getDescription();

    /**
     * Get the optional-wrapped old price of the purchased product.
     * @return The optional-wrapped purchased product old price.
     */
    @NotNull OptionalDouble getOldPrice();

    /**
     * Get the icon image of the purchased product.
     * <br>
     * Usually it's just a direct link to image hosted by platform servers.
     * @return The purchased product icon image.
     */
    @NotNull String getIconImage();

    /**
     * Check is the purchased product may be purchased only one time or not.
     * <br>
     * After the first purchase of this product will be hidden from the shop.
     * @return A boolean value: the check result.
     */
    boolean isOneTimePurchasable();

    /**
     * Get the in-game commands that will be sent after purchase of this product.
     * @return The purchased product configured list of commands.
     * @see Payment#getSentCommands()
     */
    @NotNull List<String> getCommands();

    /**
     * Get the list of filled additional fields for this purchase.
     * @return The purchased product filled additional fields.
     * @see FilledAdditionalField
     */
    @NotNull List<FilledAdditionalField> getAdditionalFields();

    /**
     * Get the optional-wrapped applied discounts of this purchase.
     * <br>
     * Sometimes a coupon discount or a mass sale discount may be here.
     * @return The optional-wrapped purchase discounts.
     * @see Discounts
     * @see CouponDiscount
     * @see MassSaleDiscount
     */
    @NotNull Optional<Discounts> getDiscounts();

    /**
     * Get the creation date of this purchase.
     * @return The purchase creation date.
     */
    @NotNull LocalDateTime getCreatedAt();

    /**
     * Get a date of the last purchase update.
     * @return The last purchase update date.
     */
    @NotNull LocalDateTime getUpdatedAt();

}
