package vlad.proggame.game.cave;

public interface Cell {

    boolean blocksMovement();

    void onPlayerEntered(Cave cave);

}
