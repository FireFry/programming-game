package vlad.proggame.game.cave;

public enum Exit implements Cell {
    INSTANCE;

    @Override
    public boolean blocksMovement() {
        return false;
    }

}
