package Linked_list;

import java.util.Base64;

public class Convert {
    public static void main(String[] args) {
        byte[] valueDecoded = Base64.getDecoder().decode("nwIGAAAAAIAAXyoCCECaAxUIIZwBAJ8aAghA32ABUZ83BAECAwQ=");
        System.out.println(valueDecoded);

        System.out.println(AuxUtils.h2b("9000").length);
        byte[] id = new byte[]{1, 1, 1};
        System.out.println(AuxUtils.h2b("01150000000000000000000000002A10").length);

        System.out.println(normalizeSfi((byte) 14));

        System.out.println(Integer.toHexString(0x9000).length());
    }


    public static byte normalizeSfi(byte p2) {
        return (byte) ((p2 >>> 3) & 0x1F);
    }


}
