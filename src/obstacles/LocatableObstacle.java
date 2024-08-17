package obstacles;

import common.Location;

public abstract class LocatableObstacle implements Obstacle {
    protected final Location location;

    public LocatableObstacle(Location location){
        this.location = location;
    }

    public LocatableObstacle(int x, int y){
        this.location = new Location(x, y);
    }

    public Location getLocation(){
        return location;
    }

    public abstract boolean isLocationObstructed(int x, int y);
    public abstract char getSymbol();


}
