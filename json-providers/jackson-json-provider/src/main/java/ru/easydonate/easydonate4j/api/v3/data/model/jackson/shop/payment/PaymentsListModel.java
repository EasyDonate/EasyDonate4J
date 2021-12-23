package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.payment;

import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.util.ArrayList;

@Implementing(PaymentsList.class)
public class PaymentsListModel extends ArrayList<Payment> implements PaymentsList {
}
