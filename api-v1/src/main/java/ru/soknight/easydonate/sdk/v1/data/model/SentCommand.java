package ru.soknight.easydonate.sdk.v1.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.soknight.easydonate.sdk.v1.data.PrettyPrintable;

import java.util.Objects;

/**
 * The object which represents a command which was sent to the server after payment complete.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SentCommand implements PrettyPrintable {

    @JsonProperty("command")
    private String command;
    @JsonProperty("response")
    private String response;
    
    @Override
    public int hashCode() {
        return Objects.hash(command, response);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        SentCommand other = (SentCommand) obj;
        return Objects.equals(command, other.command) &&
                Objects.equals(response, other.response);
    }

    @Override
    public String toString() {
        return "Command{"
                + "command='" + command + "'"
                + ", response='" + response + "'"
                + "}";
    }
    
}
