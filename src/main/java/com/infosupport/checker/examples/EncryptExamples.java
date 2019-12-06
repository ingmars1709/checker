package com.infosupport.checker.examples;

import com.infosupport.checker.qual.Encrypted;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class EncryptExamples {

    public static final Charset UTF8 = Charset.forName("UTF-8");

    private static final String CONFIDENTIAL_PLAIN_DATA = "confidential data";
    private static final byte[] CONFIDENTIAL_PLAIN_DATA_BYTES = CONFIDENTIAL_PLAIN_DATA.getBytes(UTF8);
    private static final byte KEY = 3;


    ////////////// EXAMPLE 1 //////////////

    @SuppressWarnings("encrypted") // type system does not inspect method body to see if actual encryption happens
    private @Encrypted byte[] encrypt(final String plaintext) {
        return xorIt(plaintext.getBytes(UTF8), KEY);
    }

    private byte[] decrypt(final @Encrypted byte[] ciphertext) {
        return xorIt(ciphertext, KEY);
    }

    private byte[] xorIt(final byte[] inputBytes, final byte key) {
        byte[] outputBytes = new byte[inputBytes.length];

        for (int i = 0; i < inputBytes.length; i++) {
            outputBytes[i] = (byte) (inputBytes[i] ^ key);
        }
        return outputBytes;
    }



    ////////////// EXAMPLE 2 //////////////

    private void addCipherTexts() {
        final List<@Encrypted byte[]> ciphertexts = new ArrayList<>();
        ciphertexts.add(CONFIDENTIAL_PLAIN_DATA_BYTES);
        ciphertexts.add(encrypt(CONFIDENTIAL_PLAIN_DATA));
    }



    ////////////// EXAMPLE 3 //////////////

    private void sendEncryptedData() {
        @Encrypted byte[] ciphertext = encrypt(CONFIDENTIAL_PLAIN_DATA);
        send(ciphertext);
    }

    private void sendUnencryptedData() {
        send(CONFIDENTIAL_PLAIN_DATA_BYTES);
    }

    private void send(final @Encrypted byte[] ciphertext) {
        System.out.println("sent: " + Base64.getEncoder().encodeToString(ciphertext));
    }



    ////////////// EXAMPLE 4 //////////////

    private void decryptEncryptedData() {
        byte[] plaintext = decrypt(encrypt(CONFIDENTIAL_PLAIN_DATA));

        System.out.println("decrypted plain text = " + new String(plaintext, UTF8));
    }

    private void decryptDecryptedData() {
        byte[] wrong = decrypt(CONFIDENTIAL_PLAIN_DATA_BYTES);
    }

    private void encryptEncryptedData() {
        byte[] twiceEncrypted = encrypt(new String(encrypt(CONFIDENTIAL_PLAIN_DATA), UTF8));
    }
}