package chapter4.item16;

// No need to change API when internal implementation changes.
public class PublicPoint {
    // Fields made private
    private int x;
    private int y;

    public PublicPoint(int x, int y) {
        // Ability to enforce invariants
        this.x = x;
        this.y = y;
    }

    // Accessors to take action when fields accessed
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Mutators to enforce invariants.
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
