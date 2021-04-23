package ru.soknight.easydonate.sdk.v2;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.soknight.easydonate.sdk.v2.data.model.CreatedPaymentBundle;
import ru.soknight.easydonate.sdk.v2.data.model.PaymentModel;
import ru.soknight.easydonate.sdk.v2.data.model.ProductModel;
import ru.soknight.easydonate.sdk.v2.data.model.ServerModel;
import ru.soknight.easydonate.sdk.v2.data.model.ShopModel;
import ru.soknight.easydonate.sdk.v2.exception.BadResponseException;
import ru.soknight.easydonate.sdk.v2.exception.ErrorResponseException;
import ru.soknight.easydonate.sdk.v2.exception.FailedRequestException;
import ru.soknight.easydonate.sdk.v2.payment.PaymentCreator;
import ru.soknight.easydonate.sdk.v2.payment.PreparedPaymentData;

/**
 * An interface that give access to all API methods.
 * @author soknight
 */
public interface EasyDonateSDK {

    String API_ENDPOINT = "https://easydonate.ru/api/v2/shop/";
    ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Create new SDK instance using your shop key.
     * @param accessKey - shop key that hidden by default.
     * @return Created SDK instance ready to use.
     */
    static EasyDonateSDK create(String accessKey) {
        return new EasyDonateSDKImpl(accessKey);
    }
    
    /**
     * Query available information about your shop.
     * @return The {@link ShopModel} object that contains all information about the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see ShopModel
     */
    ShopModel getShopInfo() throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Query available products in your shop.
     * @return List of {@link ProductModel} objects that represents products in the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see ProductModel
     */
    List<ProductModel> getProductsList() throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Query available information about this product.
     * @param productId - ID of product information about which you want to get.
     * @return The {@link ProductModel} object that represents a product in the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see ProductModel
     */
    ProductModel getProductInfo(int productId) throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Query available servers which added in your shop.
     * @return List of {@link ServerModel} objects that represents servers which added in the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see ServerModel
     */
    List<ServerModel> getServersList() throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Query available information about this added server.
     * @param serverId - ID of server information about which you want to get.
     * @return The {@link ServerModel} object that represents an added server in the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see ServerModel
     */
    ServerModel getServerInfo(int serverId) throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Query available completed payments in your shop.
     * @return List of {@link PaymentModel} objects that represents completed payments in the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see PaymentModel
     */
    List<PaymentModel> getPaymentsList() throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Query available information about this payment.
     * 
     * @param paymentId - ID of payment information about which you want to get.
     * @return The {@link PaymentModel} object that represents a pending or completed payment in the remote shop.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see PaymentModel
     */
    PaymentModel getPaymentInfo(int paymentId) throws BadResponseException, ErrorResponseException, FailedRequestException;
    
    /**
     * Create new pending payment depending on your {@link PreparedPaymentData}.
     * <br>
     * You can use {@link PaymentCreator} as chain-builder to create new payment data.
     * 
     * @param paymentData - any customizable data to prepare payment.
     * @return The data bundle with URL link to created pending payment and a response payment model.
     * 
     * @throws BadResponseException if EasyDonate API server sent invalid or API error response.
     * @throws ErrorResponseException if this request is not successfull.
     * @throws FailedRequestException if this request has been failed due any internal reason.
     * 
     * @see PreparedPaymentData
     * @see PaymentCreator
     */
    CreatedPaymentBundle createPayment(PreparedPaymentData paymentData) throws BadResponseException, ErrorResponseException, FailedRequestException;
    
}
