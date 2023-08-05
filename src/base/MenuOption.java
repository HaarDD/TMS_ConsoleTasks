package base;

abstract class MenuOption {
    private final int number;
    private final String name;

    public MenuOption(int number, String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
