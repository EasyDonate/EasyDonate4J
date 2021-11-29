package ru.easydonate.easydonate4j.v3.data.model.jackson.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.AdditionalField;

import java.io.IOException;
import java.util.*;

@Getter
@Implementing(AdditionalField.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalFieldModel implements AdditionalField {

    @JsonProperty("name")
    protected String name;
    @JsonProperty("type")
    protected String dataTypeRaw;
    @JsonProperty("default")
    protected String defaultValue;
    @JsonProperty("description")
    protected String description;

    @JsonIgnore
    @Override
    public @NotNull DataType getDataType() {
        return DataType.getByKey(dataTypeRaw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionalFieldModel that = (AdditionalFieldModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(dataTypeRaw, that.dataTypeRaw) &&
                Objects.equals(defaultValue, that.defaultValue) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataTypeRaw, defaultValue, description);
    }

    @Override
    public @NotNull String toString() {
        return "AdditionalFieldModel{" +
                "name='" + name + '\'' +
                ", dataTypeRaw='" + dataTypeRaw + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static final class ListDeserializer extends JsonDeserializer<List<AdditionalFieldModel>> {

        @Override
        @SuppressWarnings("unchecked")
        public @Nullable List<AdditionalFieldModel> deserialize(@NotNull JsonParser parser, DeserializationContext context) throws IOException {
            try {
                return parser.readValueAs(ArrayList.class);
            } catch (IOException ignored) {
                Map<Integer, AdditionalFieldModel> map = parser.readValueAs(Map.class);
                if(map == null)
                    return null;

                if(map.isEmpty())
                    return Collections.emptyList();

                return new ArrayList<>(map.values());
            }
        }

    }

}
