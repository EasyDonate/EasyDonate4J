package ru.easydonate.easydonate4j.callback.data.model.jackson.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.callback.data.model.purchase.AdditionalField;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.io.IOException;
import java.util.*;

@Getter
@Implementing(AdditionalField.class)
public class AdditionalFieldModel implements AdditionalField {

    @JsonProperty("name")
    protected String name;
    @JsonProperty("type")
    protected String dataTypeRaw;
    @JsonProperty("default")
    protected String defaultValue;
    @JsonProperty("description")
    protected String description;
    @JsonProperty("value")
    private String specifiedValue;

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
                Objects.equals(specifiedValue, that.specifiedValue) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataTypeRaw, defaultValue, specifiedValue, description);
    }

    @Override
    public @NotNull String toString() {
        return "AdditionalFieldModel{" +
                "name='" + name + '\'' +
                ", dataTypeRaw='" + dataTypeRaw + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", specifiedValue='" + specifiedValue + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static final class ListDeserializer extends JsonDeserializer<List<AdditionalFieldModel>> {

        @Override
        @SuppressWarnings("unchecked")
        public @Nullable List<AdditionalFieldModel> deserialize(@NotNull JsonParser parser, DeserializationContext context) throws IOException {
            try {
                return parser.readValueAs(List.class);
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
