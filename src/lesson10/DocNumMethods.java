package lesson10;

public class DocNumMethods {


    public static boolean isDigits(String inputString) {
        return inputString.chars().allMatch(Character::isDigit);
    }

    public static boolean isLetters(String inputString) {
        return inputString.chars().allMatch(Character::isLetter);
    }

    public static String[] splitDocNum(String documentNumber) {
        return documentNumber.split("-");
    }

    public static boolean validateDocNum(String documentNumber) {
        if (documentNumber == null) return false;
        String[] parts = splitDocNum(documentNumber);
        if (parts.length != 5) return false;
        for (int i = 0; i < parts.length; i++) {
            int partLength = parts[i].length();
            switch (i + 1) {
                case 1, 3 -> {
                    if (partLength != 4 || !isDigits(parts[i])) return false;
                }
                case 2, 4 -> {
                    if (partLength != 3 || !isLetters(parts[i])) return false;
                }
                default -> {
                    if (partLength != 4 || !validateDocNumLastPart(parts[i])) return false;
                }
            }
        }
        return true;
    }

    public static boolean validateDocNumLastPart(String lastPart) {
        for (int j = 0; j < lastPart.length(); j++) {
            switch (j + 1) {
                case 1, 3 -> {
                    if (!Character.isDigit(lastPart.charAt(j))) return false;
                }
                case 2, 4 -> {
                    if (!Character.isLetter(lastPart.charAt(j))) return false;
                }
            }
        }
        return true;
    }

    public static String getPartsString(String documentNumber, int... partsNumbers) {
        if (partsNumbers.length == 0) return "Укажите части номера документа!";
        String[] docParts = splitDocNum(documentNumber);
        StringBuilder result = new StringBuilder();
        for (int partNum : partsNumbers) {
            if (partNum >= 1 && partNum <= docParts.length) {
                result.append(docParts[partNum - 1]);
            } else {
                result.append('(').append(partNum).append("й части нет)");
            }
            result.append('/');
        }
        return result.toString().trim();
    }

    public static String getWithMaskedPartsString(String documentNumber, int... partsNumbers) {
        if (partsNumbers.length == 0) return "Укажите скрываемой части номера документа!";
        String[] docParts = splitDocNum(documentNumber);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < docParts.length; i++) {
            if (contains(partsNumbers, i + 1)) {
                result.append("*".repeat(docParts[i].length()));
            } else {
                result.append(docParts[i]);
            }
            result.append('-');
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    private static boolean contains(int[] array, int value) {
        for (int arrayValue : array) {
            if (arrayValue == value) {
                return true;
            }
        }
        return false;
    }

    public static String getOnlyLetterPartsString(String documentNumber, boolean isUppercase, String preComment) {
        String[] docParts = getPartsString(documentNumber, 2, 4, 5).split("/");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < docParts.length; i++) {
            if (i != 2) {
                result.append(docParts[i]).append('/');
            } else {
                docParts[i].chars().filter(Character::isLetter).forEach(c -> result.append((char) c).append('/'));
            }
        }
        result.setLength(result.length() - 1);
        return (preComment != null ? preComment : "") + (!isUppercase ? result : result.toString().toUpperCase());
    }

}
