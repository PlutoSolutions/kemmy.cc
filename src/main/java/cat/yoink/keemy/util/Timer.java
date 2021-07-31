package cat.yoink.keemy.util;

public class Timer {
    private int tick;
    private final int start;

    public Timer() {
        this(0);
    }

    public Timer(int tick) {
        this.tick = tick;
        this.start = tick;
    }

    public void tick() {
        tick(1);
    }

    public void tick(int tick) {
        this.tick += tick;
    }

    public void unTick() {
        unTick(1);
    }

    public void unTick(int tick) {
        this.tick -= tick;
    }

    public boolean hasPassed(int tick) {
        return this.tick >= tick;
    }

    public boolean isBetween(int min, int max) {
        return min <= tick && tick <= max;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {

        this.tick = tick;
    }
    public void reset() {
        tick = start;
    }
}
