import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.text.DecimalFormat;

public class AutoAssignment extends Thread {

	static ArrayList<Student> autoStudents = new ArrayList<Student>();
	static ArrayList<Teacher> autoTeachers = new ArrayList<Teacher>();
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	double autoStudentPrice = 100;
	double autoTeacherPrice = 100;
	double autoTeacherAmount = 0;
	public AutoAssignment(ArrayList<Student> students, ArrayList<Teacher> teachers, JLabel label) {
		this.students = students;
		this.teachers = teachers;
	}
	
	@Override
	public void run() {
		
		
		while(true) {
			students.get(0).sendPoints((double)autoStudents.size()/100);
			for(int i = 0; i < autoTeachers.size(); i++) {
			teachers.get(0).autoSendAssignment(students, autoTeacherAmount);

			
			}

				try {
					Thread.sleep(10);
				}
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		}
		
	}
	
	public void addAutoStudent(ArrayList<Student> student) {
		if(student.get(0).getPoints() >= autoStudentPrice) {
		student.get(0).takePoints(autoStudentPrice);
		autoStudents.add(new Student("Jimmy",0,0));
		autoStudentPrice *= 1.1;
		autoStudentPrice = Math.round(autoStudentPrice);
		}
	}
	public void addAutoTeacher(ArrayList<Teacher> teacher) {
		
		if(teacher.get(0).getAssignments() >= autoTeacherPrice) {
		teacher.get(0).takeAssignments(autoTeacherPrice);
		autoTeachers.add(new Teacher("Jimmy",0,0));
		autoTeacherPrice *= 1.25;
		autoTeacherAmount += .01;
		autoTeacherPrice = Math.round(autoTeacherPrice);
		
		}
	}
	
	
	public String getAutoStudentButton() {
		
		return "<html>Auto Students: " + autoStudents.size() + "<br />" + "Cost: " + autoStudentPrice +"<html>";
	}
	
	public String getAutoTeacherButton() {
		return "<html>Auto Teacher: " + autoTeachers.size() + "<br />" + "Cost: " + autoTeacherPrice +"<html>";
	}
	
	public void update(JButton button) {
		
		button.setText(getAutoStudentButton());
	}

}
