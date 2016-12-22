package vlad.proggame.game.cave;

public enum Wall implements Cell {
    INSTANCE;

    @Override
    public boolean blocksMovement() {
        return true;
    }

}
