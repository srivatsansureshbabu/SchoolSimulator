//import java.io.FileWriter;
//import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;

import java.util.Random;

import javax.swing.JLabel;
public class Main {

    public static void main(String[] args) {
        // initializes random object
        Random random = new Random();
        
        // list of names for teachers and students
        String[] student_names = {"Patrick","Paul","Evelyn","Lauren","Katelyn","Jimmy","John","Henry","Brandon","Thomas"};
        String[] teacher_names = {"Bonagura","Cook","deLeon","Gapusan","Kaping","Marxen","Pierce","Talsky","Kaju","Kaiser"};
        
        // arraylists for teachers and students
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        
        // adds new students
        for( int i = 0; i < 10; i++){
            String student = student_names[random.nextInt(10)];
            int age = random.nextInt(18)+14;
            int percentage = random.nextInt(100);
            students.add(new Student(student,age,percentage));
        }
        
        // adds new teachers
        for( int i = 0; i < 10; i++){
            String teacher = teacher_names[random.nextInt(10)];
            int age = random.nextInt(65)+22;
            int salary = random.nextInt(87000)+48000;
            teachers.add(new Teacher(teacher,age,salary));
        }	
        
        
        // adds a principal
        
        Principal principal = new Principal("Srivatsan Suresh Babu", 17 , 130234);

        

		JFrame frame = new MyFrame(principal,teachers,students);
		
		

		
        // makes a classroom full of students
        Classroom<Teacher,Student> classroom = new Classroom<>(teachers,students);
        
        classroom.displayTeacher();
        classroom.displayStudents();
        
        frame.setVisible(true);
    }

}
