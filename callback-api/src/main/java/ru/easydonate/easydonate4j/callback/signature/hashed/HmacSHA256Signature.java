package ru.easydonate.easydonate4j.callback.signature.hashed;

import org.jetbrains.annotations.NotNull;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public abstract class HmacSHA256Signature extends HashedSignature {

    private final Mac hmacInstance;

    protected HmacSHA256Signature(byte[] saltBytes) throws NoSuchAlgorithmException, InvalidKeyException {
        this.hmacInstance = Mac.getInstance("HmacSHA256");

        if(saltBytes != null) {
            SecretKeySpec secretKey = new SecretKeySpec(saltBytes, "HmacSHA256");
            hmacInstance.init(secretKey);
        }
    }

    protected HmacSHA256Signature() throws NoSuchAlgorithmException, InvalidKeyException {
        this((byte[]) null);
    }

    protected HmacSHA256Signature(@NotNull String salt) throws NoSuchAlgorithmException, InvalidKeyException {
        this(salt.getBytes());
    }

    @Override
    public byte[] hash(byte[] rawData) {
        return hmacInstance.doFinal(rawData);
    }

}
