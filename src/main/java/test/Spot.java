package test;

public class Spot {

    private SpotType type;
    private boolean free;



    private Spot (SpotType type) {
        this.type = type;
        this.free = true;
    }
    public static Spot create(String type) {
        SpotType spotType = SpotType.valueOfType(type);
        if(spotType == null) {
            return null;
        }
        return new Spot(spotType);
    }
    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
