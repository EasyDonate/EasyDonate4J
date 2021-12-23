package ru.easydonate.easydonate4j.callback.data.model.mass.sale;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MassSale extends PrettyPrintable {

    int getId();

    @NotNull String getName();

    double getDiscountPercent();

    @NotNull Optional<LocalDateTime> getStartsAt();

    @NotNull Optional<LocalDateTime> getExpiresAt();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
