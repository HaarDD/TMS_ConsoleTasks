package lesson17;

import base.ConsoleUtil;
import base.Pair;
import base.TaskRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/*Задача *:
Программа на вход получает произвольный текст. В этом тексте может быть номер
документа(один или несколько), емейл и номер телефона. Номер документа в формате:
xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
может содержать не всю информацию, т.е. например, может не содержать номер
телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
формате:
email: teachmeskills@gmail.com
document number: 1423-1512-51
и т.д*/
public class L17Task2 extends TaskRunnable {

    public static final String REGEX_GROUP_DOCUMENT_NUMBER = "docnum";
    public static final String REGEX_GROUP_PHONE_NUMBER = "phone";
    public static final String REGEX_GROUP_EMAIL = "email";

    public static final Map<String, String> REGEX_GROUPES_NAMES_MAP = new HashMap<>() {
    };

    public static final Pattern regexDocNumPhoneEmail = Pattern.compile("(?<" + REGEX_GROUP_DOCUMENT_NUMBER + ">\\d{4}-\\d{4}-\\d{2})" +
            "|(?<" + REGEX_GROUP_PHONE_NUMBER + ">\\+\\(\\d{2}\\)\\d{7})" +
            "|(?<" + REGEX_GROUP_EMAIL + ">[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+)");

    static {
        REGEX_GROUPES_NAMES_MAP.put(REGEX_GROUP_DOCUMENT_NUMBER, "document number");
        REGEX_GROUPES_NAMES_MAP.put(REGEX_GROUP_PHONE_NUMBER, "phone number");
        REGEX_GROUPES_NAMES_MAP.put(REGEX_GROUP_EMAIL, "email");
    }

    public L17Task2() {
        super("Поиск номеров документов, телефонов и email");
    }

    @Override
    public void runTask() {
        String regexTestCase1 = "Привет! Мой номер документа: 1245-1243-52, " +
                "номер: +(33)3656994, почта: maxgalitskiy@gmail.com";
        String regexTestCase2 = "Привет! У меня нет номера документа. " +
                "Вот мой номер: +(33)3656994 и почта: maxgalitskiy@gmail.com";
        String regexTestCase3 = "Привет! У меня есть два номера документа," +
                " первый: 1245-1243-52, второй: 1245-4443-12. " +
                "Вот номера, обычный: +(33)3656994, рабочий: +(33)4236554 и почта: maxgalitskiy@gmail.com";
        String regexTestCase4 = "Привет! Мой номер документа: 1245-12g3-52, " +
                "номер: +375(33)3656994, почта: maxgalitskiy@gmail.com";

        String result1 = pairsListToLines(findAllDocNumPhoneEmail(regexTestCase1));
        String result2 = pairsListToLines(findAllDocNumPhoneEmail(regexTestCase2));
        String result3 = pairsListToLines(findAllDocNumPhoneEmail(regexTestCase3));
        String result4 = pairsListToLines(findAllDocNumPhoneEmail(regexTestCase4));

        ConsoleUtil.println("Тест-кейс №1: \n" + regexTestCase1 + "\n" + result1);
        ConsoleUtil.println("Тест-кейс №2: \n" + regexTestCase2 + "\n" + result2);
        ConsoleUtil.println("Тест-кейс №3: \n" + regexTestCase3 + "\n" + result3);
        ConsoleUtil.println("Тест-кейс №4: \n" + regexTestCase4 + "\n" + result4);
    }

    private String pairsListToLines(List<Pair<String, String>> inputList) {
        return inputList.stream()
                .map(value -> value.getFirst() + ": " + value.getSecond())
                .collect(Collectors.joining("\n"));
    }

    private List<Pair<String, String>> findAllDocNumPhoneEmail(String inputString) {
        List<Pair<String, String>> resultList = new ArrayList<>();
        Matcher matcher = regexDocNumPhoneEmail.matcher(inputString);
        while (matcher.find()) {
            resultList.add(getGroupAndValue(matcher, REGEX_GROUP_DOCUMENT_NUMBER, REGEX_GROUP_PHONE_NUMBER, REGEX_GROUP_EMAIL));
        }
        return resultList;
    }

    private Pair<String, String> getGroupAndValue(Matcher matcher, String... groupNames) {
        for (String groupName : groupNames) {
            if (matcher.group(groupName) == null) {
                return new Pair<>(REGEX_GROUPES_NAMES_MAP.get(groupName), matcher.group(groupName));
            }
        }
        return null;
    }
}
