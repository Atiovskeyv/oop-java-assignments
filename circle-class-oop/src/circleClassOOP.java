// This program demonstrates a Circle class.
// It calculates area and circumference based on radius,
// prints object information, and compares two circles by their area.

public class Circle{
    private double pi = 3.14;
    public double radius;

    double calculateArea(double r){
        return pi * r * r;
    }

    double calculateCircumference(double r){
        return 2 * pi * r;
    }

    public String getInfo(){
        return "Radius: " + radius +
                ", Area: " + calculateArea(radius) +
                ", Circumference: " + calculateCircumference(radius);
    }
}

void main(){
    Circle circle1 = new Circle();
    circle1.radius = 5.6777;
    IO.println(circle1.getInfo());

    Circle circle2 = new Circle();
    circle2.radius = 6.14;
    IO.println(circle2.getInfo());

    if (circle1.calculateArea(circle1.radius) > circle2.calculateArea(circle2.radius)){
        IO.println("Circle 1 has a larger area.");
    }
    else if (circle1.calculateArea(circle1.radius) == circle2.calculateArea(circle2.radius)){
        IO.println("Both circles have equal area.");
    }
    else{
        IO.println("Circle 2 has a larger area.");
    }
}