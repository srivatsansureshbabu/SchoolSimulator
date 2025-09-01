import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.*;

public class Student extends Person implements Compliant{

    String name;
    int age;
    int percentage;
    double points = 0;
    double studentCost = 100;
    static LinkedList<String> studentsAttended = new LinkedList<String>();
    
    public Student(String name, int age, int percentage){
        super(name,age);
        this.percentage = percentage;
        studentsAttended.push(name);
    }
    // gets name of student
    public String getName(){
        return super.getName();
    }
    // gets age of student
    public int getAge(){
        return super.getAge();
    }
    public void buyStudent(ArrayList<Student> student) {
		if(points >= studentCost) {
    	points-= studentCost;
    	student.add(new Student("Jimmy",0,0));
    	studentCost = studentCost*1.1;
    	points = Math.round(points);
    	studentCost = Math.round(studentCost);
		}
    }
    
    public String buyStudentButton(ArrayList<Student> student) {
    	return "<html>Students:" + student.size()+"<br />"+student.get(0).getStudentCost()+"<html>";
    }
    // gets percentage of student
    public int getPercentage(){
        return percentage;
    }
    
    public void takePoints(double autoStudentPrice) {
    	
    	if(points >= autoStudentPrice) {
    		points -= autoStudentPrice;
    	}
    }
    
    public double getPoints() {
    	return points;
    }
    
    // total students attended
    public LinkedList<String> studentsAttended(){
    	return studentsAttended;
    }
    
    public String welcome(Student student) {
    	return "Welcome " + student.getName()+"!";
    
    }
    public String displayStats() {
		DecimalFormat f = new DecimalFormat("0.00");
    	return "SA: "+ f.format(getAssignments());
    }
    // total points (assignments completed)
    public void sendPoints(double d) {
    	points+=d;
    }
    public String getStudentCost() {
    	return "Cost: " + studentCost;
    }
    // returns assignments completed
    @Override
    public double getAssignments() {
    	return points;
    }
    
   
    

}