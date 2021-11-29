package ru.easydonate.easydonate4j.util;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public final class Wrapper {

    public static <T> @NotNull Optional<T> wrapNullable(T object) {
        return Optional.ofNullable(object);
    }

    public static <T> @NotNull Optional<T> wrapNullable(T object, Predicate<T> condition) {
        return object != null && condition.test(object) ? Optional.of(object) : Optional.empty();
    }

    public static @NotNull Optional<String> wrapNullableOrEmpty(String object) {
        return wrapNullable(object, string -> !string.isEmpty());
    }

    public static @NotNull OptionalInt wrapNullableInt(Integer object) {
        return object != null ? OptionalInt.of(object) : OptionalInt.empty();
    }

    public static @NotNull OptionalInt wrapNullableInt(Integer object, IntPredicate condition) {
        return object != null && condition.test(object) ? OptionalInt.of(object) : OptionalInt.empty();
    }

    public static @NotNull OptionalLong wrapNullableLong(Long object) {
        return object != null ? OptionalLong.of(object) : OptionalLong.empty();
    }

    public static @NotNull OptionalLong wrapNullableLong(Long object, LongPredicate condition) {
        return object != null && condition.test(object) ? OptionalLong.of(object) : OptionalLong.empty();
    }

    public static @NotNull OptionalDouble wrapNullableDouble(Double object) {
        return object != null ? OptionalDouble.of(object) : OptionalDouble.empty();
    }

    public static @NotNull OptionalDouble wrapNullableDouble(Double object, DoublePredicate condition) {
        return object != null && condition.test(object) ? OptionalDouble.of(object) : OptionalDouble.empty();
    }

}
