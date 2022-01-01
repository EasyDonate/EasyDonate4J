package ru.easydonate.easydonate4j.api.v3.response;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.exception.ApiResponseFailureException;
import ru.easydonate.easydonate4j.api.v3.exception.UnknownApiResponseException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;

public final class ResponseContentDeserializer {

    public static <T> @NotNull T deserializeResponseContent(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType,
            @NotNull EasyHttpResponse httpResponse
    ) throws HttpResponseException {
        String content = httpResponse.getContent();
        JsonSerializationService serializationService = ModuleRegistrator.jsonSerializationService();

        // trying to parse content as normal response
        try {
            ApiResponse<T> apiResponse = serializationService.deserialize(responseObjectType, content);
            if(apiResponse.isSuccess())
                return apiResponse.getContent();
        } catch (JsonSerializationException ignored) {
        }

        // trying to parse content as error response
        try {
            ErrorResponse errorResponse = serializationService.deserialize(ErrorResponse.class, content);
            throw new ApiResponseFailureException(httpResponse, errorResponse);
        } catch (JsonSerializationException ex) {
            throw new UnknownApiResponseException(httpResponse, ex);
        }
    }

}
