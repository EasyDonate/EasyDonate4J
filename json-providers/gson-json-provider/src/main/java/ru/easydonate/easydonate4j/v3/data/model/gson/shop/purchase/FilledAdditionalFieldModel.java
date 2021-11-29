package ru.easydonate.easydonate4j.v3.data.model.gson.shop.purchase;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.AdditionalFieldModel;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.FilledAdditionalField;

import java.lang.reflect.Type;
import java.util.*;

@Getter
@Implementing(FilledAdditionalField.class)
public class FilledAdditionalFieldModel extends AdditionalFieldModel implements FilledAdditionalField {

    @SerializedName("value")
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

    public static final class ListDeserializer implements JsonDeserializer<List<FilledAdditionalFieldModel>> {

        @Override
        public @Nullable List<FilledAdditionalFieldModel> deserialize(
                @Nullable JsonElement json,
                @NotNull Type type,
                @NotNull JsonDeserializationContext context
        ) throws JsonParseException {
            try {
                return context.deserialize(json, ArrayList.class);
            } catch (JsonParseException ignored) {
                Map<Integer, FilledAdditionalFieldModel> map = context.deserialize(json, HashMap.class);
                if(map == null)
                    return null;

                if(map.isEmpty())
                    return Collections.emptyList();

                return new ArrayList<>(map.values());
            }
        }

    }

}
