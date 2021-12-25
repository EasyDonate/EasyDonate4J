package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.util.List;

/**
 * Just an implementation of generic {@link List} that also is pretty printable.
 * <br>
 * This implementation used only for JSON deserialization, no more.
 * @see Payment
 * @author soknight
 */
public interface PaymentsList extends List<Payment>, PrettyPrintable {
}
