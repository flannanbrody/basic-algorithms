package extra;

import java.awt.Point;
import java.util.ArrayList;

public class RobotPaths {

    /**
     * @author yakdere
     * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can 
     * only move in two directions: right and down. How many possible paths are there for the robot?
FOLLOW UP
Imagine certain squares are “off limits”, such that the robot can not step on them. 
Design an algorithm to get all possible paths for the robot.
Answer: It is simple recursive algorithm with backtracking
     */
    
    RobotPaths() { }
    static ArrayList<Point> current_path = new ArrayList<Point>();

    public static boolean getPaths(int x, int y) {
            Point p = new Point(x, y);
            current_path.add(p);
            
            //base case
            if(x == 0 && y == 0) {
                    return true;
            }
            boolean success = false;
            if (x >= 1 && is_free(x-1, y)) {
                    success = getPaths(x-1, y);
            }
            if (!success && y >= 1 && is_free(x, y-1)) {
                    success = getPaths(x, y-1);
            }
            if (!success) {
                    current_path.remove(p); // Wrong way!
            }
            printPaths();
            return success;
    }
    private static void printPaths() {
            for(int i = 0; i < current_path.size(); i++) {
                    System.out.println(current_path.get(i).getX() + "," + current_path.get(i).getY());
            }
    }
    private static boolean is_free(int a, int b) {
            Point checkpoint = new Point(a, b);
            return !current_path.contains(checkpoint);
    }

    public static void main(String[] args) {
            System.out.println(getPaths(4, 4));
    }

}