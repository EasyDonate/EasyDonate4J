package ru.soknight.easydonate.sdk.v1;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.soknight.easydonate.sdk.v1.data.model.PaymentModel;
import ru.soknight.easydonate.sdk.v1.data.model.ProductModel;
import ru.soknight.easydonate.sdk.v1.data.model.ServerModel;
import ru.soknight.easydonate.sdk.v1.data.model.ShopModel;
import ru.soknight.easydonate.sdk.v1.exception.*;
import ru.soknight.easydonate.sdk.v1.payment.PreparedPaymentData;
import ru.soknight.easydonate.sdk.v1.response.AbstractResponse;
import ru.soknight.easydonate.sdk.v1.response.deserialize.JacksonConverterFactory;
import ru.soknight.easydonate.sdk.v1.util.Validate;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

final class EasyDonateSDKImpl implements EasyDonateSDK {
    
    private final String accessKey;
    private final EasyDonateAPI api;
    
    EasyDonateSDKImpl(String accessKey) {
        this.accessKey = accessKey;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addConverterFactory(JacksonConverterFactory.create(OBJECT_MAPPER))
                .build();
        
        this.api = retrofit.create(EasyDonateAPI.class);
    }
    
    @Override
    public ShopModel getShopInfo() throws BadResponseException, ErrorResponseException, FailedRequestException {
        return execute(() -> api.getShopInfo(accessKey));
    }
    
    @Override
    public List<ProductModel> getProductsList() throws BadResponseException, ErrorResponseException, FailedRequestException {
        return execute(() -> api.getProductsList(accessKey));
    }
    
    @Override
    public ProductModel getProductInfo(int productId) throws BadResponseException, ErrorResponseException, FailedRequestException {
        Validate.isNotNegative("productId", productId);
        return execute(() -> api.getProductInfo(accessKey, productId));
    }
    
    @Override
    public List<ServerModel> getServersList() throws BadResponseException, ErrorResponseException, FailedRequestException {
        return execute(() -> api.getServersList(accessKey));
    }
    
    @Override
    public ServerModel getServerInfo(int serverId) throws BadResponseException, ErrorResponseException, FailedRequestException {
        Validate.isNotNegative("serverId", serverId);
        return execute(() -> api.getServerInfo(accessKey, serverId));
    }
    
    @Override
    public List<PaymentModel> getPaymentsList() throws BadResponseException, ErrorResponseException, FailedRequestException {
        return execute(() -> api.getPaymentsList(accessKey));
    }
    
    @Override
    public PaymentModel getPaymentInfo(int paymentId) throws BadResponseException, ErrorResponseException, FailedRequestException {
        Validate.isNotNegative("paymentId", paymentId);
        return execute(() -> api.getPaymentInfo(accessKey, paymentId));
    }
    
    @Override
    public String createPayment(PreparedPaymentData paymentData) throws BadResponseException, ErrorResponseException, FailedRequestException {
        String customer = paymentData.getCustomer();
        int serverId = paymentData.getServerId();
        String products = paymentData.productsAsString();
        
        Validate.isNotNull("customer", customer);
        Validate.isNotNegative("serverId", serverId);
        Validate.isNotNull("products", products);
        
        return execute(() -> api.createPayment(accessKey, customer, serverId, products));
    }
    
    private <T> T execute(Supplier<Call<? extends AbstractResponse<T>>> supplier) throws BadResponseException, ErrorResponseException, FailedRequestException {
        try {
            Call<? extends AbstractResponse<T>> call = supplier.get();
            Response<? extends AbstractResponse<T>> response = call.execute();
            
            if(!response.isSuccessful())
                throw new ErrorResponseException(response.code(), response.message(), response.errorBody());
            
            return response.body() != null ? response.body().getResponseObject() : null;
        } catch (ApiException | InvalidResponseException ex) {
            throw ex;
        } catch (IOException ex) {
            throw new FailedRequestException(ex);
        }
    }
    
}
