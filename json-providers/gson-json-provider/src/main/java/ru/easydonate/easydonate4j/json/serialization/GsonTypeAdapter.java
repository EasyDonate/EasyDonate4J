package ru.easydonate.easydonate4j.json.serialization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GsonTypeAdapter<T> extends TypeAdapter<T> {

    private final Gson gson;
    private final Class<T> type;

    @Override
    public T read(JsonReader reader) {
        return gson.fromJson(reader, type);
    }

    @Override
    public void write(JsonWriter writer, T value) {
        gson.toJson(value, type, writer);
    }

}
