package lesson16;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.*;
import java.util.stream.Collectors;


/*Задача *:
Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
Среди отобранных значений отобрать только те, которые имеют нечетное количество
букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.*/
public class L16Task2 extends TaskRunnable {

    public L16Task2() {
        super("Фильтрация HashMap");
    }

    @Override
    public void runTask() {
        List<Integer> reservedIds = new ArrayList<>(Arrays.asList(1, 2, 5, 8, 9, 13));
        HashMap<Integer, String> hashMapIdName = new HashMap<>();

        hashMapIdName.put(1, "Olga");
        hashMapIdName.put(3, "Anna");
        hashMapIdName.put(6, "Maxim");
        hashMapIdName.put(13, "David");

        ConsoleUtil.println("Первичный map: \n" + getHashMapLineByLineString(hashMapIdName));

        HashMap<Integer, String> filteredHashMapIdName = new HashMap<>(hashMapIdName.entrySet().stream()
                .filter(value -> reservedIds.contains(value.getKey()) && value.getValue().length() % 2 == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new StringBuilder(entry.getValue()).reverse().toString())));

        ConsoleUtil.println("Отфильтрованный map: \n" + getHashMapLineByLineString(filteredHashMapIdName));
    }

    private String getHashMapLineByLineString(AbstractMap<?, ?> hashMap) {
        StringBuilder resultStringBuilder = new StringBuilder();
        hashMap.forEach((key, value) -> resultStringBuilder.append(key).append('\t').append(value).append('\n'));
        return resultStringBuilder.substring(0, resultStringBuilder.length() - 1);
    }

}