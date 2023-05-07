package test;

public enum SpotType {
    MOTORCYCLE_TYPE("M"),
    COMPACT_TYPE("C"),
    LARGE_TYPE("L");

    public String getType() {
        return type;
    }

    private final String type;

    private SpotType (String type) {
        this.type = type;
    }
    public static SpotType valueOfType(String type) {
        for(SpotType s: values()) {
            if(s.type.equals(type)) {
                return s;
            }
        }
        return null;
    }

}