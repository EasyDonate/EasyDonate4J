package ru.easydonate.easydonate4j.api.v3.data.model.shop.server;

import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.util.List;

/**
 * Just an implementation of generic {@link List} that also is pretty printable.
 * <br>
 * This implementation used only for JSON deserialization, no more.
 * @see Server
 * @author soknight
 */
public interface ServersList extends List<Server>, PrettyPrintable {
}
