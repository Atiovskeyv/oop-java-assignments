// This program takes a radius value from the keyboard and calculates
// the area and circumference of a circle, then prints the results.

double calculateArea(double radius){
    double area = Math.PI * radius * radius;
    return area;
}

double calculateCircumference(double radius){
    double circumference = 2 * Math.PI * radius;
    return circumference;
}

void main(){
    IO.print("Enter radius: ");
    double radius = Double.parseDouble(IO.readln());
    IO.println("Circle Area: " + calculateArea(radius));
    IO.println("Circle Circumference: " + calculateCircumference(radius));
}