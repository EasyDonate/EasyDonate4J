package ru.soknight.easydonate.sdk.v1.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ErrorResponse {
    
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("response")
    private String message;
    
    @Override
    public int hashCode() {
        return Objects.hash(message, success);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        ErrorResponse other = (ErrorResponse) obj;
        return Objects.equals(message, other.message) &&
                success == other.success;
    }

    @Override
    public String toString() {
        return "ErrorResponse{"
                + "success=" + success
                + ", message=" + message
                + "}";
    }

}
