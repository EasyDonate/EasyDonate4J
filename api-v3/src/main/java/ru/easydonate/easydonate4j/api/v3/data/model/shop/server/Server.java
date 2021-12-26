package ru.easydonate.easydonate4j.api.v3.data.model.shop.server;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.Sorted;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The interface that represents a server connected to your shop.
 * @author soknight
 */
public interface Server extends Sorted, PrettyPrintable {

    /**
     * Get the unique ID of this server.
     * @return The server ID.
     */
    int getId();

    /**
     * Get the ID of the owning shop.
     * @return The owning shop ID.
     */
    int getShopId();

    /**
     * Get the name of this server.
     * @return The server name.
     */
    @NotNull String getName();

    /**
     * Get the IP address of this server.
     * @return The server IP address.
     */
    @NotNull String getAddress();

    /**
     * Get the port of this server.
     * @return The server port.
     */
    int getPort();

    /**
     * Get the actual server software version.
     * <br>
     * A version will be available after the first server ping.
     * <br>
     * <b>Example:</b> Paper 1.16.5
     * @return The server software version.
     */
    @NotNull String getVersion();

    /**
     * Check is the IP address of this server is hidden for the shop web-page.
     * @return A boolean value: the check result.
     */
    boolean isAddressHidden();

    /**
     * Check is the port of this server is hidden for the shop web-page.
     * @return A boolean value: the check result.
     */
    boolean isPortHidden();

    /**
     * Check is this server is hidden for the shop web-page.
     * @return A boolean value: the check result.
     */
    boolean isHidden();

    /**
     * Check is any payments are disabled for this server.
     * @return A boolean value: the check result.
     */
    boolean isPaymentsDisabled();

    /**
     * Get the list of all configured products for this server.
     * @return The configured products list.
     */
    @NotNull Optional<ProductsList> getProducts();

    /**
     * Get the creation date of this server.
     * @return The server creation date.
     */
    @NotNull LocalDateTime getCreatedAt();

    /**
     * Get the date of the last update of this server.
     * @return The last server update date.
     */
    @NotNull LocalDateTime getUpdatedAt();

}
