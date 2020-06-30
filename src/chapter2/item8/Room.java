package chapter2.item8;

public class Room implements AutoCloseable {
    private static class State {
        int junkPiles;

        State(int junkPiles) {
            this.junkPiles = junkPiles;
        }
    }

    private final State state;

    public Room(int junkPiles) {
        state = new State(junkPiles);
    }

    protected void finalize() {
        this.state.junkPiles = 0;
        System.out.println("Clean Room");
    }

    @Override
    public void close() {
        finalize();
    }
}
