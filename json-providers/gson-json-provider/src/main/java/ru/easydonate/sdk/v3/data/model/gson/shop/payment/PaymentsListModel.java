package ru.easydonate.sdk.v3.data.model.gson.shop.payment;

import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.Payment;
import ru.easydonate.sdk.v3.data.model.shop.payment.PaymentsList;

import java.util.ArrayList;

@Implementing(PaymentsList.class)
public class PaymentsListModel extends ArrayList<Payment> implements PaymentsList {
}
