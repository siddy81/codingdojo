package task7;

public class RotNEncryption {

    private static String regex = "\\w";

    public static String cipher(int offset, String inputString) {
        if (offset == 0) {
            return inputString;
        }
        char[] data = inputString.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            if (String.valueOf(data[i]).matches(regex)) {
                char firstChar = Character.isUpperCase(data[i]) ? 'A':'a';
                int originalAlphabetPosition = data[i] - firstChar;
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) (firstChar + newAlphabetPosition);

                sb.append(newCharacter);
            } else {
                sb.append(data[i]);
            }
        }
        return sb.toString();
    }

    public static String decipher(int offset, String inputString) {
        if (offset == 0) {
            return inputString;
        }
        char[] data = inputString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != ' ') {
                char newCharacter = (char) ((data[i] - offset));
                sb.append(newCharacter);
            } else {
                sb.append(data[i]);
            }
        }
        return sb.toString();

    }
}
