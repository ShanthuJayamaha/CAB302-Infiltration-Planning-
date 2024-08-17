import obstacles.Guard;
import obstacles.Obstacle;
import obstacles.ObstacleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


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
        ObstacleType type = ObstacleType.GUARD;
        String key = "-" + type.getArgumentName();
        ArrayList<String> args = parsedArgs.get(key);
        if (args == null){
            return obstacles;
        }

        for (String arg : args) {
            String cleanedArg = stripParentheses(arg);
            Obstacle obstacle = Guard.parse(cleanedArg);
            obstacles.add(obstacle);
        }

        return obstacles;
    }
}


