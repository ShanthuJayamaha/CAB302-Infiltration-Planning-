import obstacles.*;

import java.util.ArrayList;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> parseArgs = parseArgs(args);

        System.out.println(parseArgs);
    }

    // Creating a new method called parseArgs which takes a list of strings as input
    // Returns a tuple of type hashmap
    // Tuple is a key-value pair of string
    public static HashMap<String, ArrayList<String>> parseArgs(String[] args) {
        HashMap<String, ArrayList<String>> parsedArgs = new HashMap<>();
        ArrayList<String> argValues = null;

        for (String arg : args) {

            //This statement checks if it is another object
            //If the string starts with the "-" char then create a new key-value pair
            if (arg.startsWith("-")) {
                argValues = new ArrayList<>();
                parsedArgs.put(arg, argValues);
                continue;
            }

            if (argValues != null) {
                argValues.add(arg);
            }
        }

        return parsedArgs;
    }

    private static String stripParentheses(String arg){
        return arg.substring(1, arg.length() - 1);
    }

    public static ArrayList<Obstacle> parseObstacles(HashMap<String, ArrayList<String>> parsedArgs){
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        for (ObstacleType type : ObstacleType.values()) {
            String key = "-" + type.getArgumentName();
            ArrayList<String> args = parsedArgs.get(key);
            if (args == null) {
                continue;
            }
            for (String arg : args) {
                // Remove the parentheses from the argument
                String cleanedArg = stripParentheses(arg);
                Obstacle obstacle = switch (type) {
                    case GUARD -> Guard.parse(cleanedArg);
                    case FENCE -> Fence.parse(cleanedArg);
                    case SENSOR -> Sensor.parse(cleanedArg);
                    case CAMERA -> Camera.parse(cleanedArg);
                };
                obstacles.add(obstacle);
            }
        }
        return obstacles;
    }
}


