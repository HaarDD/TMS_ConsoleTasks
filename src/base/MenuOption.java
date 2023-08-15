package base;

abstract class MenuOption {
    private final String name;

    public MenuOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
