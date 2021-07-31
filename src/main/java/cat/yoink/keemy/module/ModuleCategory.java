package cat.yoink.keemy.module;

public enum ModuleCategory {
    COMBAT("Combat"),
    VISUALS("Visuals"),
    MISCELLANEOUS("Miscellaneous"),
    KEEMY("Keemy.cc");

    private final String name;

    ModuleCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
