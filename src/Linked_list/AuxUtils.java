package Linked_list;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

public class AuxUtils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final String BCD_PAD = "F";

    private static final Charset ASCII = Charset.forName("US-ASCII");

    @SafeVarargs
    public static <T> List<T> list(T... elements) {
        List<T> result = new ArrayList<T>();
        for (T t : elements) {
            if (t != null) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T> T single(Collection<T> c) {
        if (c == null || c.size() != 1) {
            throw new IllegalArgumentException("Expected single-element collection, got " + c);
        }
        return c.iterator().next();
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

    public static byte[] s2a(String s) {
        return s != null ? s.getBytes(ASCII) : null;
    }

    public static String a2s(byte[] a) {
        return a == null ? null : new String(a, ASCII);
    }

    public static String b2h(byte... data) {
        int l = data.length;
        char[] out = new char[l << 1];

        int i = 0;
        for (int j = 0; i < l; ++i) {
            out[(j++)] = HEX_DIGITS[((0xF0 & data[i]) >>> 4)];
            out[(j++)] = HEX_DIGITS[(0xF & data[i])];
        }
        return new String(out);
    }


    private static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    public static byte[] barr() {
        return EMPTY_BYTES;
    }

    public static byte[] bxor(byte[] a, byte[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException(String.format("Arrays lengths are not equal %d != %d", a.length, b.length));
        }
        byte[] result = new byte[a.length];

        for (int i = 0; i < a.length; ++i) {
            result[i] = (byte) (a[i] ^ b[i]);
        }

        return result;
    }

    public static byte[] xor(byte[]... barrs) {
        if (barrs.length == 0) {
            return barr();
        } else {
            byte[] result = new byte[barrs[0].length];
            for (byte[] bar : barrs) {
                result = bxor(result, bar);
            }
            return result;
        }
    }

    public static int b2s(byte... b) {
        return ((0xFF & b[0]) << 8) | ((0xFF & b[1]));
    }


    public static byte[] bxor(byte[] a, int b) {
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ ((byte) b));
        }
        return result;
    }

    public static byte[] bblockpad(byte input[], int block, byte pad) {
        return bconcat(input, bdup((block - (input.length % block)) % block, pad));
    }

    public static byte[] bblockpad(byte input[], int block) {
        return bblockpad(input, block, (byte) 0x00);
    }

    public static String even0Pad(String input) {
        return input.length() % 2 == 0 ? input : "0" + input;
    }

    /**
     * pad to a minimum length on right
     */
    public static byte[] bminpad(byte input[], int min, byte pad) {
        return bconcat(input, bdup(input.length < min ? min - input.length : 0, pad));
    }

    /**
     * pad to a minimum length on left
     */
    public static byte[] bminLeftPad(byte input[], int min, byte pad) {
        return bconcat(bdup(input.length < min ? min - input.length : 0, pad), input);
    }

    public static int b2i(byte... b) {
        return ((0xFF & b[0]) << 24) | ((0xFF & b[1]) << 16) | ((0xFF & b[2]) << 8) | ((0xFF & b[3]));
    }

    public static long b2l(byte... b) {
        return ((long) (0xFF & b[0]) << 56) |
                ((long) (0xFF & b[1]) << 48) |
                ((long) (0xFF & b[2]) << 40) |
                ((long) (0xFF & b[3]) << 32) |
                ((long) (0xFF & b[4]) << 24) |
                ((long) (0xFF & b[5]) << 16) |
                ((long) (0xFF & b[6]) << 8) |
                ((long) (0xFF & b[7]));
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

    public static int bsizeOf(byte[]... byteArrays) {
        int size = 0;
        for (byte[] arr : byteArrays) {
            size += arr != null ? arr.length : 0;
        }
        return size;
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

    public static byte[] barr(byte... b) {
        return b;
    }

    public static byte[] bconcat(Object... any) {
        List<byte[]> result = new ArrayList<byte[]>(any.length);
        for (Object object : any) {
            if (object == null) {
                // NOP
            } else if (object instanceof Byte) {
                result.add(barr((Byte) object));
            } else if (object instanceof Short) {
                result.add(sh2b((Short) object));
            } else if (object instanceof Integer) {
                result.add(i2b((Integer) object));
            } else if (object instanceof Long) {
                result.add(l2b((Long) object));
            } else if (object instanceof String) {
                result.add(h2b((String) object));
            } else if (object instanceof List) {
                for (Object e : (List<?>) object) {
                    result.add(bconcat(e));
                }
            } else if (object instanceof byte[]) {
                result.add((byte[]) object);
            } else if (object.getClass().isArray()) {
                result.add(bconcat((Object[]) object)); // this will expand array
            } else if (object instanceof InputStream) {
                InputStream is = (InputStream) object;
                result.add(bconcat(is));
            } else {
                throw new IllegalArgumentException("Object of " + (object.getClass()) + " is not supported.");
            }
        }
        return bconcat(result);
    }

    public static byte[] bconcat(List<byte[]> byteArrays) {
        int len = bsizeOf(byteArrays);
        if (len == 0) {
            return barr();
        }
        if (byteArrays.size() == 1) {
            return byteArrays.get(0);
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

    public static int bsizeOf(List<byte[]> byteArrays) {
        int size = 0;
        for (byte[] arr : byteArrays) {
            size += arr != null ? arr.length : 0;
        }
        return size;
    }

    public static byte[] l2b(long... is) {
        byte[] r = new byte[is.length * 8];
        for (int index = 0; index < is.length; index++) {
            long i = is[index];
            r[8 * index + 0] = b_8(i);
            r[8 * index + 1] = b_7(i);
            r[8 * index + 2] = b_6(i);
            r[8 * index + 3] = b_5(i);
            r[8 * index + 4] = b_4(i);
            r[8 * index + 5] = b_3(i);
            r[8 * index + 6] = b_2(i);
            r[8 * index + 7] = b_1(i);
        }
        return r;
    }

    public static byte[] sh2b(short s) {
        return barr(b_2(s), b_1(s));
    }

    public static byte b_1(int i) {
        return (byte) ((0xFF) & i);
    }

    public static byte b_2(int i) {
        return (byte) ((0xFF) & (i >> 8));
    }

    public static byte b_3(int i) {
        return (byte) ((0xFF) & (i >> 16));
    }

    public static byte b_4(int i) {
        return (byte) ((0xFF) & (i >> 24));
    }

    public static byte b_1(long i) {
        return (byte) ((0xFF) & i);
    }

    public static byte b_2(long i) {
        return (byte) ((0xFF) & (i >> 8));
    }

    public static byte b_3(long i) {
        return (byte) ((0xFF) & (i >> 16));
    }

    public static byte b_4(long i) {
        return (byte) ((0xFF) & (i >> 24));
    }

    public static byte b_5(long i) {
        return (byte) ((0xFF) & (i >> 32));
    }

    public static byte b_6(long i) {
        return (byte) ((0xFF) & (i >> 40));
    }

    public static byte b_7(long i) {
        return (byte) ((0xFF) & (i >> 48));
    }

    public static byte b_8(long i) {
        return (byte) ((0xFF) & (i >> 56));
    }

    public static byte[] i2b(int... is) {
        byte[] r = new byte[is.length * 4];
        for (int index = 0; index < is.length; index++) {
            int i = is[index];
            r[4 * index + 0] = b_4(i);
            r[4 * index + 1] = b_3(i);
            r[4 * index + 2] = b_2(i);
            r[4 * index + 3] = b_1(i);
        }
        return r;
    }

    public static String b2bcd(byte[] bbcd) {
        if (bbcd == null) {
            return null;
        }
        return substringBefore(b2h(bbcd), BCD_PAD);
    }


    public static String substringBefore(String str, String separator) {
        if (!str.isEmpty() && separator != null) {
            if (separator.isEmpty()) {
                return "";
            } else {
                int pos = str.indexOf(separator);
                return pos == -1 ? str : str.substring(0, pos);
            }
        } else {
            return str;
        }
    }

    public static byte[] bcd2b(String val) {
        if (val == null) {
            return null;
        }
        if (val.length() % 2 == 0) {
            return h2b(val);
        } else {
            return h2b(val + BCD_PAD);
        }
    }

    public static byte[] bcd2bPaddedWith0s(String val) {
        if (val == null) {
            return null;
        }
        if (val.length() % 2 == 0) {
            return h2b(val);
        } else {
            return h2b("0" + val);
        }
    }

    /**
     * Split a String at the first occurrence of the delimiter.
     * Does not include the delimiter in the result.
     *
     * @param toSplit   the string to split
     * @param delimiter to split the string up with
     * @return a two element array with index 0 being before the delimiter, and
     * index 1 being after the delimiter (neither element includes the delimiter);
     * or {@code null} if the delimiter wasn't found in the given input String
     */
    public static String[] split(String toSplit, String delimiter) {
        if (!hasLength(toSplit) || !hasLength(delimiter)) {
            return null;
        }
        int offset = toSplit.indexOf(delimiter);
        if (offset < 0) {
            return null;
        }
        String beforeDelimiter = toSplit.substring(0, offset);
        String afterDelimiter = toSplit.substring(offset + delimiter.length());
        return new String[]{beforeDelimiter, afterDelimiter};
    }

    /**
     * Check that the given CharSequence is neither {@code null} nor of length 0.
     * Note: Will return {@code true} for a CharSequence that purely consists of whitespace.
     * <p><pre class="code">
     * StringUtils.hasLength(null) = false
     * StringUtils.hasLength("") = false
     * StringUtils.hasLength(" ") = true
     * StringUtils.hasLength("Hello") = true
     * </pre>
     *
     * @param str the CharSequence to check (may be {@code null})
     * @return {@code true} if the CharSequence is not null and has length
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean isBitSet(byte val, int bitPos) {
        if (bitPos < 1 || bitPos > 8) {
            throw new IllegalArgumentException("parameter 'bitPos' must be between 1 and 8. bitPos=" + bitPos);
        }
        return (val >>> (bitPos - 1) & 0x1) == 1;
    }

    public static byte setBit(byte data, int bitPos, boolean on) {
        if (bitPos < 1 || bitPos > 8) {
            throw new IllegalArgumentException("parameter 'bitPos' must be between 1 and 8. bitPos=" + bitPos);
        }
        if (on) { //Set bit
            return (byte) (data | 1 << (bitPos - 1));
        } else { //Unset bit
            return (byte) (data & ~(1 << (bitPos - 1)));
        }
    }


    public static byte[] copyByteArray(byte[] array2Copy) {
        if (array2Copy == null) {
            //return new byte[0] instead?
            throw new IllegalArgumentException("Argument 'array2Copy' cannot be null");
        }
        return copyByteArray(array2Copy, 0, array2Copy.length);
    }

    public static byte[] copyByteArray(byte[] array2Copy, int startPos, int length) {
        if (array2Copy == null) {
            //return new byte[0] instead?
            throw new IllegalArgumentException("Argument 'array2Copy' cannot be null");
        }
        if (array2Copy.length < startPos + length) {
            throw new IllegalArgumentException("startPos(" + startPos + ")+length(" + length + ") > byteArray.length(" + array2Copy.length + ")");
        }
        byte[] copy = new byte[array2Copy.length];
        System.arraycopy(array2Copy, startPos, copy, 0, length);
        return copy;
    }

    public static int parseVarLen(InputStream is) throws IOException {
        int len = is.read();
        if ((len & 0x80) != 0) {
            int lenLen = len & 03;
            if (lenLen == 1) {
                len = is.read();
            } else if (lenLen == 2) {
                len = is.read() << 8 | is.read();
            } else {
                throw new RuntimeException("Len " + lenLen + " not supported.");
            }
        }
        return len;
    }

    public static byte[] varlen(Object... byteArrays) {
        byte[] data = bconcat(byteArrays);
        if (data.length <= 127) {
            return varlen1(data);
        } else if (data.length <= 255) {
            return bconcat(h2b("81"), varlen1(data));
        } else {
            return bconcat(h2b("82"), varlen2(data));
        }
    }

    public static byte[] varlen1(Object... byteArrays) {
        byte[] data = bconcat(byteArrays);
        return bconcat(barr(b_1(data.length)), data);
    }

    public static byte[] varlen2(Object... byteArrays) {
        byte[] data = bconcat(byteArrays);
        return bconcat(barr(b_2(data.length), b_1(data.length)), data);
    }

    public static byte[] brandom(int size) {
        Random random = new Random();
        byte[] barr = bdup(size);
        random.nextBytes(barr);
        return barr;
    }

    /**
     * poor man's elvis operator
     */
    public static <T> T either(T opt, T orElse) {
        return opt == null ? orElse : opt;
    }


    public static <K, V> Map.Entry<K, V> entry(final K key, final V value) {
        return new Map.Entry<K, V>() {

            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public V setValue(V newValue) {
                throw new UnsupportedOperationException("Non-mutable entry");
            }

            @Override
            public String toString() {
                return "[" + key + "->" + value + "]";
            }
        };
    }

    @SafeVarargs
    public static <K, V> Map<K, V> map(Map<K, ? extends V> base, Map.Entry<K, ? extends V>... entries) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.putAll(base);
        map.putAll(AuxUtils.<K, V>map(entries));
        return map;
    }

    @SafeVarargs
    public static <K, V> Map<K, V> map(Map.Entry<K, ? extends V>... entries) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        for (Map.Entry<K, ? extends V> entry : entries) {
            if (entry != null) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public static String leftPad(final String str, final int size, String padStr) {
        if (str == null) {
            return null;
        }
        final int padLen = padStr.length();
        final int strLen = str.length();
        final int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            final char[] padding = new char[pads];
            final char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    public static byte[] safeClone(byte[] src) {
        return src == null ? null : src.clone();
    }

}


