package yandex_contest;

import Linked_list.AuxUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static javax.crypto.Cipher.ENCRYPT_MODE;
import static javax.crypto.Cipher.getInstance;

public class Sum {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] cryptoPin = AuxUtils.h2b("5707");
        byte[] otpkKey = AuxUtils.h2b("336B3FE3E071609B447104CCEC5D0819");
        byte[] cryptoPin2 = new byte[]{120, -105, 35, 38, 102, 70};
        String cryptoPinString = AuxUtils.b2h(cryptoPin);
        StringBuilder sb = new StringBuilder(cryptoPinString);
        sb.insert(0, "2");
        sb.insert(1, Integer.toHexString(cryptoPin.length * 2));
        byte[] ccc = AuxUtils.h2b(sb.toString());
        System.out.println(Arrays.toString(AuxUtils.h2b("789723266646")));
        System.out.println(AuxUtils.b2h(new byte[]{102, 102}));
        System.out.println(minimalMultipleOf8(cryptoPin.length));
        byte[] paddedData = AuxUtils.bminpad(cryptoPin, minimalMultipleOf8(cryptoPin.length), (byte) 0x00);
        byte[] paddedData2 = AuxUtils.bminpad(ccc, minimalMultipleOf8(ccc.length), (byte) 0xFF);
        byte[] paddedData4 = AuxUtils.bconcat(paddedData2, (byte) 0xF0);
        System.out.println(AuxUtils.b2h(paddedData4) + " padded 4");

        byte[] paddedData3 = AuxUtils.bminpad(paddedData4, 16, (byte) 0x00);
        System.out.println(AuxUtils.b2h(paddedData2) + " padded");
        System.out.println(AuxUtils.b2h(paddedData3) + " padded3");
        System.out.println(Arrays.toString(paddedData2));
        buildCryptoPin(cryptoPin);

        System.out.println("-------------");
        byte[] paddedData8 = AuxUtils.copyByteArray(paddedData3, 0, 8);
        System.out.println(AuxUtils.b2h(paddedData8) + " size" + paddedData8.length);
        byte[] paddedData8_2 = AuxUtils.copyByteArray(paddedData3, paddedData3.length - 8, 8);
        System.out.println(AuxUtils.b2h(paddedData8_2));

        byte[] SK = encryptDes(otpkKey, paddedData8);
        byte[] SL = encryptDes(otpkKey, paddedData8_2);
        System.out.println(AuxUtils.b2h(AuxUtils.bconcat(SK, SL)) + "finish");


    }

    private static int minimalMultipleOf8(int i) {
        int mod = i % 8;
        return mod == 0 ? i : i + 8 - mod;
    }


    private static byte[] buildCryptoPin(byte[] cryptoPin) {
        StringBuilder sb = new StringBuilder();
        sb.append("2");
        sb.append(Integer.toHexString(cryptoPin.length * 2).toUpperCase());
        sb.append(AuxUtils.b2h(cryptoPin));
        for (int i = 0; i < 16; i++) {
            if (i > sb.length() - 1) {
                sb.append("F");
            }
        }
        System.out.println(sb.toString());

        byte[] paddedData = new byte[16];
        return paddedData;
    }

    public static byte[] encrypt(byte[] hexKey, byte[] hexData) throws NoSuchPaddingException, NoSuchAlgorithmException {

        Cipher cp = Cipher.getInstance("DESede/ECB/NoPadding");
        try {
            cp.init(ENCRYPT_MODE, new SecretKeySpec(hexKey, "DESede"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            return cp.doFinal(hexData);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return hexKey;
    }

    public static byte[] encryptDes(byte[] hexKey, byte[] hexData) throws NoSuchPaddingException, NoSuchAlgorithmException {

        Cipher cp = Cipher.getInstance("DESede/ECB/NoPadding");
        try {
            cp.init(ENCRYPT_MODE, new SecretKeySpec(hexKey, "TripleDES"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            return cp.doFinal(hexData);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return hexKey;
    }

}
