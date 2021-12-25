package ru.easydonate.easydonate4j.api.v3.data.model.shop;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

/**
 * The interface that represents an additional fields in products.
 * @author soknight
 */
public interface AdditionalField extends PrettyPrintable {

    /**
     * Get the name of this additional field.
     * @return The field name.
     */
    @NotNull String getName();

    /**
     * Get the data type of this additional field.
     * @return The field data type.
     * @see DataType
     */
    @NotNull DataType getDataType();

    /**
     * Get the raw data type of this additional field.
     * <br>
     * This raw data can be used sometimes when the {@link #getDataType()}
     * has returned the unknown constant.
     * @return The raw field data type.
     */
    @NotNull String getDataTypeRaw();

    /**
     * Get the default value of this additional field.
     * @return The field default value.
     */
    @NotNull String getDefaultValue();

    /**
     * Get the description of this additional field.
     * @return The field description.
     */
    @NotNull String getDescription();

    /**
     * The enum that represents all possible and actual additional field data types.
     * @author soknight
     */
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    enum DataType {

        /** Represents the text data type. */
        TEXT("text"),

        /** Represents the number data type.*/
        NUMBER("number"),

        /** Represents a data type that isn't known yet.*/
        UNKNOWN("unknown");

        private final @NotNull String key;

        /**
         * Get the enum constant by the known additional field data type key (can be null).
         * <br>
         * If the key is null/empty or relevant enum constant with this key will not be found then
         * this method will return {@link DataType#UNKNOWN} constant as default.
         * @param key the data type key to find an enum constant.
         * @return The found data type enum constant or {@link DataType#UNKNOWN} by default.
         */
        public static @NotNull DataType getByKey(@Nullable String key) {
            if(key == null || key.isEmpty())
                return UNKNOWN;

            for(DataType dataType : values())
                if(dataType.getKey().equalsIgnoreCase(key))
                    return dataType;

            return UNKNOWN;
        }

    }

}
