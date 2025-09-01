import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class MyFrame extends JFrame implements MouseListener{
	
	JButton principalButton;
	JButton teacherButton;
	JButton studentButton;
	JButton buyStudentButton;
	JButton buyTeacherButton;
	JButton autoStudentButton;
	JButton autoTeacherButton;
	AutoAssignment autoAssigner;
	JLabel label;
	ClickPopUp popUp;
	int x = 300;
	int y = 300;
	MyFrame(Principal principal,ArrayList<Teacher> teacher,ArrayList<Student> student){
		


		JLabel label = new JLabel();
		this.add(label);
		

		
		
		
		
		
		// myFrame attributes
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	    this.setSize(screenSize.width, screenSize.height);
		this.setVisible(true);
		this.setForeground(Color.MAGENTA);
		// principal button attributes
		principalButton = new JButton();
		principalButton.setBounds(650,100,250,100);
		principalButton.addActionListener(e -> principal.sendJob(teacher, student));
		principalButton.setFocusable(false);
		principalButton.setEnabled(false);
		principalButton.setVisible(false);
		
		
		ImageIcon principalImage = new ImageIcon("Principal.jpg");
		Image image_Principal = principalImage.getImage(); // transform it 
		Image newPrincipal = image_Principal.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		principalImage = new ImageIcon(newPrincipal);  // transform it back
		principalButton.setIcon(principalImage);		
		this.add(principalButton);
		
		// teacher button attributes
		teacherButton = new JButton();
		teacherButton.setBounds(650,400,250,100);
		ImageIcon teacherImage = new ImageIcon("teacher.png");
		Image imageTeacher = teacherImage.getImage(); // transform it 
		Image newimgg = imageTeacher.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		teacherImage = new ImageIcon(newimgg);  // transform it back
		teacherButton.setIcon(teacherImage);

		this.add(teacherButton);
		

		
		
		
		// student button attributes
		studentButton = new JButton();  
		studentButton.setBounds(650,700,250,100);
		ImageIcon studentImage = new ImageIcon("download.png");
		Image image = studentImage.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		studentImage = new ImageIcon(newimg);  // transform it back
		studentButton.setIcon(studentImage);

		this.add(studentButton);
		
		// to buy a student
		buyStudentButton = new JButton();
		buyStudentButton.setBounds(1100,700,250,100);
		buyStudentButton.setVisible(true);
		
		this.add(buyStudentButton);
		
		
		// to buy a teacher
		buyTeacherButton = new JButton();
		buyTeacherButton.setBounds(1100,400,250,100);
		buyTeacherButton.setVisible(true);
		
		this.add(buyTeacherButton);
		
		
		// autoAssignmenters
		autoStudentButton = new JButton();
		autoAssigner = new AutoAssignment(student,teacher,label);
		autoAssigner.start();
		autoStudentButton.setBounds(200,700,250,100);
		autoStudentButton.setVisible(true);
		this.add(autoStudentButton);
		
		
		autoTeacherButton = new JButton();
		autoTeacherButton.setBounds(200,400,250,100);
		
		this.add(autoTeacherButton);
		// when teacher button is clicked update all assignments
		teacherButton.addActionListener(e -> teacher.get(0).sendAssignment(student,teacher));
		
		// principal is unlocked at 1000 teacher assignments
		teacherButton.addActionListener(e -> teacher.get(0).isOverAmount(1000, teacher.get(0), principal, principalButton));
		
		// to buy a Student 
		buyStudentButton.addActionListener(e -> student.get(0).buyStudent(student)); 

		// to buy a Teacher
		buyTeacherButton.addActionListener(e -> teacher.get(0).buyTeacher(teacher));

		// auto Students
		autoStudentButton.addActionListener(e -> autoAssigner.addAutoStudent(student));
		
		// auto Teachers
		autoTeacherButton.addActionListener(e -> autoAssigner.addAutoTeacher(teacher));
		principalButton.addMouseListener(this);
		
		ArrayList<Principal> principals = new ArrayList<Principal>();
		principals.add(principal);
		for(int i = 0; i < 9; i++) {
			principals.add(new Principal("g", 2, 2));
		}
		teacherButton.addActionListener(e -> new ClickPopUp(teacherButton, teacher.get(0), teacher, new JLabel(), this));
		principalButton.addActionListener(e -> new ClickPopUp(principalButton, principal, principals, new JLabel(), this));
		while(true) {
			
			studentButton.setText(student.get(0).displayStats());
			teacherButton.setText(teacher.get(0).getTeacherButton());
			principalButton.setText(principal.getPrincipalButton());
			autoStudentButton.setText(autoAssigner.getAutoStudentButton());
			autoTeacherButton.setText(autoAssigner.getAutoTeacherButton());
			buyTeacherButton.setText(teacher.get(0).buyTeacherButton(teacher));
			buyStudentButton.setText(student.get(0).buyStudentButton(student));
			teacher.get(0).isOverAmount(1000, teacher.get(0), principal, principalButton);
				
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		principalButton.setBackground(Color.PINK);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		principalButton.setBackground(null);

		
	}
	
}

//