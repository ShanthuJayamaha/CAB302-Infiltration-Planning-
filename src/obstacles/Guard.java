package obstacles;

import common.Location;

public class Guard extends LocatableObstacle {

    public Guard(Location location){
        super(location);
    }

    @Override
    public boolean isLocationObstructed(int x, int y) {
        return location.getX() == x && location.getY() == y;
    }

    @Override
    public char getSymbol() {
        return ObstacleType.GUARD.getSymbol();
    }

    public static Guard parse(String arg){
        Location location = Location.parse(arg);
        return new Guard(location);
    }

}
