package com.mwb.web.framework.security.crypto.api;

public interface IDataCryptor {
    public String encrypt(String data);

    public String decrypt(String data);
}
