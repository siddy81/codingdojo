package task3;

import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class ConvertingData {

    static char[] encodingTable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'};
    static int[] decodingTable = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54,
            55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2,
            3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
            48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public String stringToBase64(String dataString) {
        byte[] data = dataString.getBytes();
        StringBuilder base64StringBuilder = new StringBuilder();
        int fillCounter = 0;
        int dataLength = data.length;

        for (int i = 0; i < dataLength; i += 3) {
            int b = ((data[i] & 0xFF) << 16) & 0xFFFFFF;
            if (i + 1 < dataLength) {
                b |= (data[i + 1] & 0xFF) << 8;
            } else {
                fillCounter++;
            }
            if (i + 2 < dataLength) {
                b |= (data[i + 2] & 0xFF);
            } else {
                fillCounter++;
            }
            for (int j = 0; j < 4 - fillCounter; j++) {
                base64StringBuilder.append(encodingTable[(b & 0xFC0000) >> 18]);
                b = b << 6;
            }
        }
        for (int j = 0; j < fillCounter; j++) {
            base64StringBuilder.append("=");
        }
        return base64StringBuilder.toString();
    }

    @SuppressWarnings({"java:S3776","java:S127"})
    public String base64ToString(String data) {
        byte[] bytes = data.getBytes();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        for (int i = 0; i < bytes.length; ) {
            int decodedByte;
            if (decodingTable[bytes[i]] != -1) {
                decodedByte = (decodingTable[bytes[i]] & 0xFF) << 18;
                int counter = 0;
                if (i + 1 < bytes.length && decodingTable[bytes[i + 1]] != -1) {
                    decodedByte = decodedByte | ((decodingTable[bytes[i + 1]] & 0xFF) << 12);
                    counter++;
                }
                if (i + 2 < bytes.length && decodingTable[bytes[i + 2]] != -1) {
                    decodedByte = decodedByte | ((decodingTable[bytes[i + 2]] & 0xFF) << 6);
                    counter++;
                }
                if (i + 3 < bytes.length && decodingTable[bytes[i + 3]] != -1) {
                    decodedByte = decodedByte | (decodingTable[bytes[i + 3]] & 0xFF);
                    counter++;
                }
                while (counter > 0) {
                    int c = (decodedByte & 0xFF0000) >> 16;
                    buffer.write((char) c);
                    decodedByte <<= 8;
                    counter--;
                }
               i += 4;
            } else {
                i++;
            }
        }
        return new String(buffer.toByteArray(), StandardCharsets.UTF_8);
    }
}
