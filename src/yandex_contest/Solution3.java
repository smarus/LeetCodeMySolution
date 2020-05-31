package yandex_contest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Solution3 {
    private static final byte[] EMPTY_BYTES = new byte[0];

    public static void main(String[] args) {

        System.out.println(rightmostInt(h2b("DF22")));
        System.out.println("");
    }


    public static byte[] oddH2b(String possiblyOddHexes) {
        if (possiblyOddHexes.length() % 2 == 0) {
            return h2b(possiblyOddHexes);
        } else {
            return h2b("0" + possiblyOddHexes);
        }
    }

    public static byte[] h2b(String s) {
        char[] data = s.toCharArray();
        int len = data.length;

        if ((len & 0x1) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        int i = 0;
        for (int j = 0; j < len; ++i) {
            int f = toDigit(data[j], j) << 4;
            ++j;
            f |= toDigit(data[j], j);
            ++j;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    public static int rightmostInt(byte... b) {
        return b.length == 4 ? b2i(b) : b.length < 4 ? b2i(bminLeftPad(b, 4, (byte) 0x00)) : b2i(copyByteArray(b, b.length - 4, 4));
    }

    public static byte[] bminLeftPad(byte[] input, int min, byte pad) {
        return bconcat(bdup(input.length < min ? min - input.length : 0, pad), input);
    }

    public static byte[] barr() {
        return EMPTY_BYTES;
    }

    public static byte[] bdup(int num, byte v) {
        byte[] result = bdup(num);
        if (v != (byte) 0) {
            for (int i = 0; i < num; i++) {
                result[i] = v;
            }
        }
        return result;
    }

    public static byte[] bdup(int num) {
        return num <= 0 ? barr() : new byte[num];
    }

    public static int bsizeOf(byte[]... byteArrays) {
        int size = 0;
        for (byte[] arr : byteArrays) {
            size += arr != null ? arr.length : 0;
        }
        return size;
    }

    public static byte[] bconcat(byte[]... byteArrays) {
        int len = bsizeOf(byteArrays);
        if (len == 0) {
            return barr();
        }
        if (byteArrays.length == 1) {
            return byteArrays[0];
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(len);
        for (byte[] bs : byteArrays) {
            try {
                if (bs != null)
                    out.write(bs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return out.toByteArray();
    }


    public static byte[] copyByteArray(byte[] array2Copy, int startPos, int length) {
        if (array2Copy == null) {
            //return new byte[0] instead?
            throw new IllegalArgumentException("Argument 'array2Copy' cannot be null");
        }
        if (array2Copy.length < startPos + length) {
            throw new IllegalArgumentException("startPos(" + startPos + ")+length(" + length + ") > byteArray.length(" + array2Copy.length + ")");
        }
        byte[] copy = new byte[length];
        System.arraycopy(array2Copy, startPos, copy, 0, length);
        return copy;
    }


    private static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    public static int b2i(byte... b) {
        return ((0xFF & b[0]) << 24) | ((0xFF & b[1]) << 16) | ((0xFF & b[2]) << 8) | ((0xFF & b[3]));
    }
}
