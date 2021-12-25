package ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale;

import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.util.List;

/**
 * Just an implementation of generic {@link List} that also is pretty printable.
 * <br>
 * This implementation used only for JSON deserialization, no more.
 * @see MassSale
 * @author soknight
 */
public interface MassSalesList extends List<MassSale>, PrettyPrintable {
}
