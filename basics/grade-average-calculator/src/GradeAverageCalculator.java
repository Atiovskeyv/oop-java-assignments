// This program takes midterm and final exam grades from the user,
// calculates the weighted average, and determines whether the student
// passes, conditionally passes, or fails.

void main(){
    IO.print("Midterm Grade: ");
    int midterm = Integer.parseInt(IO.readln());

    String finalInput = IO.readln("Final Grade: ");
    int finalExam = Integer.parseInt(finalInput);

    double average = midterm * 0.3 + finalExam * 0.7;

    if (average >= 60)
        IO.println("Your Grade: " + average + " You passed.");
    else if (average >= 50)
        IO.println("Your Grade: " + average + " Conditional pass.");
    else
        IO.println("Your Grade: " + average + " You failed.");
}