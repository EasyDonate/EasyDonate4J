package ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * The interface that represents a coupon and contains all related data.
 * @author soknight
 */
public interface Coupon extends PrettyPrintable {

    /**
     * Get the unique ID of this coupon.
     * @return The coupon ID.
     */
    int getId();

    /**
     * Get an ID of the owning shop.
     * @return The shop ID.
     */
    int getShopId();

    /**
     * Get the name of this coupon.
     * @return The coupon name.
     */
    @NotNull String getName();

    /**
     * Get the code of this coupon.
     * <br>
     * This code must be specified in the promo code field to use this coupon.
     * @return The coupon code.
     */
    @NotNull String getCode();

    /**
     * Get the discount percent of this coupon.
     * <br>
     * It's a number from 1 to 100.
     * @return The coupon discount percent.
     */
    double getDiscountPercent();

    /**
     * Get the optional-wrapped amount of max usages for this coupon.
     * <br>
     * If the usages amount limit wasn't actually specified,
     * this method will return an empty Optional.
     * @return The optional-wrapped coupon max usages limit.
     */
    @NotNull OptionalInt getMaxUsages();

    /**
     * Get the list of related products for this coupon.
     * <br>
     * Only for these products this coupon may be applied.
     * @return The coupon compatibly products list.
     */
    @NotNull ProductsList getProducts();

    /**
     * Get the optional-wrapped expiration date of this coupon.
     * <br>
     * If the expiration date wasn't actually specified,
     * this method will return an empty Optional.
     * @return The optional-wrapped coupon expiration date.
     */
    @NotNull Optional<LocalDateTime> getExpiresAt();

    /**
     * Get the creation date for this coupon.
     * @return The coupon creation date.
     */
    @NotNull LocalDateTime getCreatedAt();

    /**
     * Get the date of last coupon update.
     * @return The last coupon update date.
     */
    @NotNull LocalDateTime getUpdatedAt();

}
