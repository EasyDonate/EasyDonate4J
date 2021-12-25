package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import org.jetbrains.annotations.NotNull;

/**
 * The interface that represents sent command of any purchased product.
 * @see Payment#getSentCommands()
 * @author soknight
 */
public interface SentCommand {

    /**
     * Get the original command that has been sent.
     * @return The original command.
     */
    @NotNull String getCommand();

    /**
     * Get the command feedback from the game server.
     * @return The command feedback.
     */
    @NotNull String getResponse();

}
