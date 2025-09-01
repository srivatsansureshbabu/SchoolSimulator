import java.util.ArrayList;

import javax.swing.JButton;

public class Principal extends Teacher implements Authority{
	// assignments sent
	 double assignments = 0;
	
	public Principal(String name, int age, int salary) {
		super(name, age, salary);
	}
	// gets name of principal
    public String getName(){
        return super.getName();
    }
    // gets age of principal
    public int getAge(){
        return super.getAge();
    }
    // gets salary of principal
    public int getSalary(){
        return super.getSalary();
    }
    // sends an assignment to teacher
	public void sendJob(ArrayList<Teacher> teachers ,ArrayList<Student> students) {
		
		assignments+= teachers.size();
		
		for(int i = 0; i < teachers.size(); i++) {
			teachers.get(i).sendAssignment(students,teachers);
		}
	}
	
	// gets total assignments sent
	public double getAssignments() {
		return assignments;
	}
	
	public String getPrincipalButton() {
		return "PA: " + getAssignments();
	}
	
}
