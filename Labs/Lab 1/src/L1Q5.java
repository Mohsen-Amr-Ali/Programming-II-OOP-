import java.util.Scanner;
import static java.lang.System.out;

class TrafficLight{
    //------ attributes -------//
    String color;
    static Integer count = 0;

    //------- constructor -------//
    TrafficLight(String color){
        this.color = color;
        this.count++;
    }

    //------- change color ------//
    void changeColor(){
        if(this.color.equals("Green")) this.color = "Yellow";
        else if(this.color.equals("Yellow")) this.color = "Red";
        else if(this.color.equals("Red")) this.color = "Green";
    }

    void showAction(){
        if(this.color.equals("Green")) out.print("Go!");
        if(this.color.equals("Yellow")) out.print("Be Ready!");
        if(this.color.equals("Red")) out.print("Stop!");
    }

    static int getTrafficLightCount(){
        return count;
    }
}

public class L1Q5 {

    public static void main(String[] args) {
        TrafficLight t1 = new TrafficLight("Red");
        TrafficLight t2 = new TrafficLight("Yellow");
        TrafficLight t3 = new TrafficLight("Green");

        for (int i = 0; i < 4; i++) {
            out.println("\n\nT1's color is: " + t1.color);
            out.print("Action: "); t1.showAction();
            t1.changeColor();
        }

        out.println("\nThere are " + TrafficLight.getTrafficLightCount() + "traffic lights.");
    }

}