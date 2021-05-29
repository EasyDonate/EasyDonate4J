package ru.soknight.easydonate.sdk.v1.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.soknight.easydonate.sdk.v1.data.PrettyPrintable;

import java.util.Objects;

/**
 * The object which represents additional field.
 * <br>
 * For example, this fields used by {@link ProductModel} objects.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalField implements PrettyPrintable {
    
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("default")
    private String defaultValue;
    @JsonProperty("description")
    private String description;
    
    @Override
    public int hashCode() {
        return Objects.hash(defaultValue, description, name, type);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        AdditionalField other = (AdditionalField) obj;
        return Objects.equals(defaultValue, other.defaultValue) &&
                Objects.equals(description, other.description) &&
                Objects.equals(name, other.name) &&
                Objects.equals(type, other.type);
    }

    @Override
    public String toString() {
        return "Field{"
                + "name='" + name + "'"
                + ", type=" + type
                + ", default='" + defaultValue + "'"
                + ", description='" + description + "'"
                + "}";
    }
    
}