package ru.easydonate.easydonate4j.callback.signature.hashed;

import org.jetbrains.annotations.NotNull;

public abstract class HashedSignature {

    public abstract byte[] hash(byte[] rawData);

    public byte[] hash(@NotNull String rawData) {
        return hash(rawData.getBytes());
    }

    public @NotNull String hashToHexString(byte[] rawData) {
        return byteArrayToHex(hash(rawData));
    }

    public @NotNull String hashToHexString(@NotNull String rawData) {
        return hashToHexString(rawData.getBytes());
    }

    public @NotNull String byteArrayToHex(byte[] byteArray) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for(byte b : byteArray)
            hexStringBuilder.append(byteToHex(b));
        return hexStringBuilder.toString();
    }

    protected String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

}
