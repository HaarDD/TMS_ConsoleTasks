package lesson13.task4star;


/*Задача *:
Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
классов(т.е. это generic).
Предусмотреть операции(методы):
1. добавления элемента;
2. удаления элемента;
3. получение элемента по индексу;
4. проверка есть ли элемент в коллекции;
5. очистка всей коллекции.
Предусмотреть конструктор без параметров - создает массив размером
по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего
массива. Предусмотреть возможность автоматического расширения коллекции при
добавлении элемента в том случае, когда коллекция уже заполнена.*/
public class ArrayListCustom<T> {

    private static final int DEFAULT_ARRAY_SIZE = 10;
    private Object[] array;
    private int size;

    public ArrayListCustom() {
        this(DEFAULT_ARRAY_SIZE);
    }

    public ArrayListCustom(int length) {
        if (length > 0) {
            this.array = new Object[length];
            this.size = 0;
        }
    }

    public void add(T element) {
        if (size == array.length) {
            expandArray();
        }
        array[size++] = element;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(element)) {
                shiftElements(i);
            }
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) return true;
        }
        return false;
    }

    @SuppressWarnings("ReassignedVariable")
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private void shiftElements(int startIndex) {
        for (int i = startIndex; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    private void expandArray() {
        array = copyArray(array, array.length * 2);
    }

    private Object[] copyArray(Object[] originalArray, int newLength) {
        Object[] newArray = new Object[newLength];
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('(');
        for (int i = 0; i < size; i++) {
            result.append(array[i]).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append(')');
        return result.toString();
    }
}
