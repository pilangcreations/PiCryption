/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pilang;

/**
 *
 * @author Ravindu Denuwan
 */
public class PiKrypt {

    private final KeyCode keyCode;

    /**
     * 
     * @param keyCode
     */
    public PiKrypt(KeyCode keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * Returns encrypted data
     * @param bytes
     * @return encryptedData
     */
    public byte[] encrypt(byte[] bytes) {
        byte[] keyBytes = keyCode.getKey().getBytes();
        byte[] newKeyBytes = new byte[keyBytes.length];
        byte[] encryptedData = new byte[bytes.length];

        int keylen = 0;
        int keyleninc = 1;

        for (int i = 0; i < newKeyBytes.length; i++) {
            newKeyBytes[i] = (byte) Math.floor(keyBytes[i] / 2);
        }

        for (int i = 0; i < bytes.length; i++) {
            keylen += keyleninc;
            if (keylen >= newKeyBytes.length || keylen < 0) {
                keyleninc = -keyleninc;
                keylen += keyleninc;
            }
 
            encryptedData[i] = (byte) (bytes[i] + newKeyBytes[keylen]);
        }

        return encryptedData;
    }

    /**
     * Returns decrypted data
     * @param bytes
     * @return decryptedData
     */
    public byte[] decode(byte[] bytes) {
        byte[] keyBytes = keyCode.getKey().getBytes();
        byte[] newKeyBytes = new byte[keyBytes.length];
        byte[] decryptedData = new byte[bytes.length];

        int keylen = 0;
        int keyleninc = 1;

        for (int i = 0; i < newKeyBytes.length; i++) {
            newKeyBytes[i] = (byte) Math.floor(keyBytes[i] / 2);
        }

        for (int i = 0; i < bytes.length; i++) {
            keylen += keyleninc;
            if (keylen >= newKeyBytes.length || keylen < 0) {
                keyleninc = -keyleninc;
                keylen += keyleninc;
            }
 
            decryptedData[i] = (byte) (bytes[i] - newKeyBytes[keylen]);
        }

        return decryptedData;
    }
}
