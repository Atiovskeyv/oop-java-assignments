// This program demonstrates basic class usage in Java.
// It creates Student objects, assigns values manually, prints their information,
// and compares their GPA (average grade).

public class Student{
  public String name;
  public String surname;
  public int studentNumber;
  public double average;
}

void main(){
  Student student1 = new Student();
  Student student2 = new Student();

  student1.name = "Atilla Alper";
  student1.surname = "Kizilarslan";
  student1.studentNumber = 1241602087;
  student1.average = 3.37;

  student2.name = "Ahmet";
  student2.surname = "Erdincer";
  student2.studentNumber = 1241602053;
  student2.average = 3.3;

  IO.println("Student name: " + student1.name + ", surname: " + student1.surname + ", number: " + student1.studentNumber + ", GPA: " + student1.average);
  IO.println("Student name: " + student2.name + ", surname: " + student2.surname + ", number: " + student2.studentNumber + ", GPA: " + student2.average);

  if(student1.average > student2.average){
    IO.println("First student has higher GPA: " + student1.average);
  }
  else{
    IO.println("Second student has higher GPA: " + student2.average);
  }
}