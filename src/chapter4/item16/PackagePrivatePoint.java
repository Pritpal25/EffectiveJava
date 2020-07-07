package chapter4.item16;

// If change is required in the internal implementation, scope of change only propagates to
// package or to the encapsulating class.

class PackagePrivatePoint {
    public int x;
    public int y;

    public PackagePrivatePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
