import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;

public class Teacher extends Person implements Authority{
    
    String name;
    int age;
    int salary;
    double assignments = 0;
    double teacherCost = 100;
    public Teacher(String name, int age, int salary){
        super(name,age);
        this.salary = salary;
    }

    // returns name of teacher
    public String getName(){
        return super.getName();
    }

    // returns age of teacher
    public int getAge(){
        return super.getAge();
    }
    
    public void buyTeacher(ArrayList<Teacher> teacher) {
    	if(assignments >= teacherCost) {
    	assignments -= teacherCost;
    	teacher.add(new Teacher("Jimmy",0,0));
    	teacherCost = teacherCost * 1.25;
    	teacherCost = Math.round(teacherCost);
    	}
    }
    // returns salary of teacher
    public int getSalary(){
        return salary;
    }
    
    public String getTeacherCost() {
    	
    	return "Cost: " + teacherCost;
    }

    // sends an assignment for student to complete
	public void sendAssignment(ArrayList<Student> students, ArrayList<Teacher> teacher) {
		
		assignments += teacher.size();
		for( int i = 0; i < students.size(); i++) {
		students.get(i).sendPoints(students.size());
		}
	}
	
	public void autoSendAssignment(ArrayList<Student> students, double autoTeacherAmount) {
		
		assignments += autoTeacherAmount;
		
	}
	public String getTeacherButton() {
		DecimalFormat f = new DecimalFormat("0.00");

		return "TA: " + f.format(getAssignments());
	}
	
	public String buyTeacherButton(ArrayList<Teacher> teacher) {
		return "<html>Teachers:" + teacher.size()+"<br />"+getTeacherCost()+"<html>";
	}
	// returns assignments sent
	public double getAssignments() {
		return assignments;
	}
    public void takeAssignments(double autoTeacherPrice) {
    	
    	if(assignments >= autoTeacherPrice) {
    		assignments -= autoTeacherPrice;
    	}
    }
	public void isOverAmount(int amount, Teacher teacher, Principal principal, JButton button) {
		if( teacher.getAssignments() >= amount) {
			button.setEnabled(true);
			button.setVisible(true);	
			}

		
	}
    
}