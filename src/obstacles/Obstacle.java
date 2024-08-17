package obstacles;

public interface Obstacle {

    //Returns the symbol that represents the obstacle
    char getSymbol();

    //returns true if the given location is obstructed by the obstacle
    boolean isLocationObstructed(int x, int y);
}


