import java.util.Scanner;
import static java.lang.System.out;

class Rectangle{
    //-------- members ---------//
    float length, width;


    //-------- constructor -------//
    Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }

    //--------- methods ---------//

    float calculateArea(){
        return length * width;
    }

    float calculatePerimeter(){
        return 2 * (length + width);
    }

    boolean isSquare(){
        return length == width;
    }

    void printDetails() {
        out.println("Length: " + length + " | Width: " + width);
        out.println("Area: " + this.calculateArea() + " | Perimeter: " + this.calculatePerimeter());
    }
}

public class L1Q2{
    public static void main(String[] args){
        Rectangle r1 = new Rectangle(5, 6);
        Rectangle r2 = new Rectangle(12, 12);

        out.println("Rectangle 1:"); r1.printDetails();
        out.print("Is Square? ");
        if(r1.isSquare()) out.println("Yes.");
        else out.println("No.");

        out.println("\nRectangle 2:"); r2.printDetails();
        out.print("Is Square? ");
        if(r2.isSquare()) out.println("Yes.");
        else out.println("No.");

    }
}