package com.infosupport.checker.examples;

import com.infosupport.checker.qual.Encrypted;

import java.nio.charset.Charset;
import java.util.Base64;

public class EncryptExamples {

    private static final String UTF_8 = "UTF-8";

    public static void main(String[] args) {
        EncryptExamples encryptExamples = new EncryptExamples();

        encryptExamples.sendEncryptedData();
        encryptExamples.sendPassword();

        @Encrypted byte[] cipherText = encryptExamples.encrypt("myPlainText");
        System.out.println("plainText = " + new String(encryptExamples.decrypt(cipherText), Charset.forName(UTF_8)));
    }

    private void sendOverInternet(final @Encrypted byte[] ciphertext) {
        Base64.getEncoder().encode(ciphertext);
    }

    private void sendEncryptedData() {
        @Encrypted byte[] ciphertext = encrypt("myPassword");
        sendOverInternet(ciphertext);
    }

    @SuppressWarnings("encrypted") // type system does not inspect method body to see if actual encryption happens
    private @Encrypted byte[] encrypt(final String plaintext) {
        byte[] bytesOfPlainText = plaintext.getBytes(Charset.forName(UTF_8));
        byte[] bytesOfCipherText = new byte[bytesOfPlainText.length];

        for (int i = 0; i < bytesOfPlainText.length; i++) {
            bytesOfCipherText[i] = (byte) (bytesOfPlainText[i] ^ (byte) 3);
        }
        return bytesOfCipherText;
    }

    private byte[] decrypt(final @Encrypted byte[] ciphertext) {
        byte[] bytesOfPlaintText = new byte[ciphertext.length];

        for (int i = 0; i < ciphertext.length; i++) {
            bytesOfPlaintText[i] = (byte) (ciphertext[i] ^ (byte) 3);
        }
        return bytesOfPlaintText;
    }

    private void sendPassword() {
        byte[] password = getUserPassword();
        sendOverInternet(password);
    }

    private byte[] getUserPassword() {
        return "plaintextPassword".getBytes(Charset.forName(UTF_8));
    }
}