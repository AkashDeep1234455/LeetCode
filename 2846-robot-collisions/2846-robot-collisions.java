import java.util.*;
class Robot {
    private int position;
    private int health;
    private char direction;
    private int initialIndex;
    public Robot(int position,int health,char direction, int initialIndex){
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.initialIndex = initialIndex;
    }
     public int getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }
    public void decreaseHealth(){
        this.health = this.health-1;
    }

    public char getDirection() {
        return direction;
    }
     public int getInitialIndex() {
        return initialIndex;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> output = new ArrayList<>();
        int size = positions.length;
        Robot[] robotData = new Robot[size];
        for(int i=0;i<size;i++){
            Robot newEntry = new Robot(positions[i],healths[i],directions.charAt(i),i);
            robotData[i] = newEntry;
        }
        ///sorting Robot data based on their position
        Arrays.sort(robotData,Comparator.comparingInt(Robot::getPosition));
        ///Stack for making collisions and finding the left robots
        Stack<Robot> collisionController = new Stack<>();

        ///impleting collision handling functionality
        for(int i=0;i<size;i++){
            Robot curr = robotData[i];
            while (!collisionController.isEmpty() && curr.getDirection() == 'L' && collisionController.peek().getDirection() == 'R') {
                Robot poppedOne = collisionController.pop();
                if (poppedOne.getHealth() > curr.getHealth()) {
                    poppedOne.decreaseHealth();
                    curr = null;
                    collisionController.push(poppedOne);
                    break;
                } else if (poppedOne.getHealth() < curr.getHealth()) {
                    curr.decreaseHealth();
                } else {
                    curr = null;
                    break;
                }
            }
            if (curr != null) {
                collisionController.push(curr);
            }
        }
         // Collect surviving robots
        List<Robot> survivingRobots = new ArrayList<>(collisionController);

           // Sort surviving robots by their initial indices
        survivingRobots.sort(Comparator.comparingInt(Robot::getInitialIndex));
         // Extract health values in order of original positions
        for (Robot robot : survivingRobots) {
            output.add(robot.getHealth());
        }

        return output;
        
    }
}