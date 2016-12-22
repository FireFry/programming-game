package vlad.proggame.game.cave;

public enum EmptyCell implements Cell {
    INSTANCE;

    @Override
    public boolean blocksMovement() {
        return false;
    }

    @Override
    public void onPlayerEntered(Cave cave) {
        // Nothing happens
    }

}
