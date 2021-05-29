package ru.soknight.easydonate.sdk.v2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.soknight.easydonate.sdk.v2.response.PaymentInfoResponse;
import ru.soknight.easydonate.sdk.v2.response.ServersListResponse;
import ru.soknight.easydonate.sdk.v2.response.PaymentCreatedResponse;
import ru.soknight.easydonate.sdk.v2.response.PaymentsListResponse;
import ru.soknight.easydonate.sdk.v2.response.ProductInfoResponse;
import ru.soknight.easydonate.sdk.v2.response.ProductsListResponse;
import ru.soknight.easydonate.sdk.v2.response.ServerInfoResponse;
import ru.soknight.easydonate.sdk.v2.response.ShopInfoResponse;

/**
 * An internal interface which is needed for the
 * <a href="https://github.com/square/retrofit">Retrofit</a> HTTP client.
 * @author soknight
 */
interface EasyDonateAPI {

    @GET("{key}")
    @Headers("User-Agent: EasyDonate4j")
    Call<ShopInfoResponse> getShopInfo(@Path("key") String accessKey);

    @GET("{key}/products")
    @Headers("User-Agent: EasyDonate4j")
    Call<ProductsListResponse> getProductsList(@Path("key") String accessKey);
    
    @GET("{key}/product/{id}")
    @Headers("User-Agent: EasyDonate4j")
    Call<ProductInfoResponse> getProductInfo(@Path("key") String accessKey, @Path("id") int productId);

    @GET("{key}/servers")
    @Headers("User-Agent: EasyDonate4j")
    Call<ServersListResponse> getServersList(@Path("key") String accessKey);
    
    @GET("{key}/server/{id}")
    @Headers("User-Agent: EasyDonate4j")
    Call<ServerInfoResponse> getServerInfo(@Path("key") String accessKey, @Path("id") int serverId);

    @GET("{key}/payments")
    @Headers("User-Agent: EasyDonate4j")
    Call<PaymentsListResponse> getPaymentsList(@Path("key") String accessKey);
    
    @GET("{key}/payment/{id}")
    @Headers("User-Agent: EasyDonate4j")
    Call<PaymentInfoResponse> getPaymentInfo(@Path("key") String accessKey, @Path("id") int paymentId);
    
    @GET("{key}/payment/create")
    @Headers("User-Agent: EasyDonate4j")
    Call<PaymentCreatedResponse> createPayment(
            @Path("key") String accessKey,
            @Query("customer") String customer,
            @Query("server_id") int serverId,
            @Query("products") String products
    );
    
}
