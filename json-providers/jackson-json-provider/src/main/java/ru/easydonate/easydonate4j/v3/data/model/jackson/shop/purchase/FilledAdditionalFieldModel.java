package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.jackson.shop.AdditionalFieldModel;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.FilledAdditionalField;

import java.io.IOException;
import java.util.*;

@Getter
@Implementing(FilledAdditionalField.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilledAdditionalFieldModel extends AdditionalFieldModel implements FilledAdditionalField {

    @JsonProperty("value")
    private String specifiedValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilledAdditionalFieldModel that = (FilledAdditionalFieldModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(dataTypeRaw, that.dataTypeRaw) &&
                Objects.equals(defaultValue, that.defaultValue) &&
                Objects.equals(specifiedValue, that.specifiedValue) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataTypeRaw, defaultValue, specifiedValue, description);
    }

    @Override
    public @NotNull String toString() {
        return "FilledAdditionalFieldModel{" +
                "name='" + name + '\'' +
                ", dataTypeRaw='" + dataTypeRaw + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", specifiedValue='" + specifiedValue + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static final class ListDeserializer extends JsonDeserializer<List<FilledAdditionalFieldModel>> {

        @Override
        @SuppressWarnings("unchecked")
        public @Nullable List<FilledAdditionalFieldModel> deserialize(@NotNull JsonParser parser, DeserializationContext context) throws IOException {
            try {
                return parser.readValueAs(List.class);
            } catch (IOException ignored) {
                Map<Integer, FilledAdditionalFieldModel> map = parser.readValueAs(Map.class);
                if(map == null)
                    return null;

                if(map.isEmpty())
                    return Collections.emptyList();

                return new ArrayList<>(map.values());
            }
        }

    }

}
