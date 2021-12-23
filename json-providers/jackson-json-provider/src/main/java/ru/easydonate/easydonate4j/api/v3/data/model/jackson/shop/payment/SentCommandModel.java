package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.SentCommand;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.util.Objects;

@Getter
@Implementing(SentCommand.class)
public class SentCommandModel implements SentCommand {

    @JsonProperty("command")
    private String command;
    @JsonProperty("response")
    private String response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentCommandModel that = (SentCommandModel) o;
        return Objects.equals(command, that.command) &&
                Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, response);
    }

    @Override
    public @NotNull String toString() {
        return "SentCommandModel{" +
                "command='" + command + '\'' +
                ", response='" + response + '\'' +
                '}';
    }

}
