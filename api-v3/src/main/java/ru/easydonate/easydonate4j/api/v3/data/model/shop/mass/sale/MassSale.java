package ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * The interface that represents a mass sale and contains all related data.
 * @author soknight
 */
public interface MassSale extends PrettyPrintable {

    /**
     * Get the unique ID of this mass sale.
     * @return The mass sale ID.
     */
    int getId();

    /**
     * Get the optional-wrapped ID of the owning shop.
     * <br>
     * This field sometimes isn't exists in the response object.
     * @return The optional-wrapped owning shop ID.
     */
    @NotNull OptionalInt getShopId();

    /**
     * Get the name of this mass sale.
     * @return The mass sale name.
     */
    @NotNull String getName();

    /**
     * Get the discount percent of this mass sale.
     * <br>
     * It's a number from 1 to 100.
     * @return The mass sale discount percent.
     */
    double getDiscountPercent();

    /**
     * Get the optional-wrapped list of related products.
     * @return The optional-wrapped compatibly products list.
     */
    @NotNull Optional<ProductsList> getProducts();

    /**
     * Get the starting date of this mass sale.
     * <br>
     * If the starting date wasn't actually specified,
     * this method will return an empty Optional.
     * @return The optional-wrapped mass sale starting date.
     */
    @NotNull Optional<LocalDateTime> getStartsAt();

    /**
     * Get the expiration date of this mass sale.
     * <br>
     * If the expiration date wasn't actually specified,
     * this method will return an empty Optional.
     * @return The optional-wrapped mass sale expiration date.
     */
    @NotNull Optional<LocalDateTime> getExpiresAt();

    /**
     * Get the creation date for this mass sale.
     * @return The mass sale creation date.
     */
    @NotNull LocalDateTime getCreatedAt();

    /**
     * Get the date of last mass sale update.
     * @return The last mass sale update date.
     */
    @NotNull LocalDateTime getUpdatedAt();

}
