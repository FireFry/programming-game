package vlad.proggame.game.cave;

public enum Wall implements Cell {
    INSTANCE;

    @Override
    public boolean blocksMovement() {
        return true;
    }

    @Override
    public void onPlayerEntered(Cave cave) {
        throw new RuntimeException("Player entered wall!");
    }

}
