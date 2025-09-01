import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;


// a generic class which involves a teacher and a group of students
public class Classroom <Thing1 extends Teacher, Thing2> {

	ArrayList<Thing1> leader = new ArrayList<Thing1>();
	ArrayList<Thing2> followers = new ArrayList<Thing2>();
	public Classroom(ArrayList<Thing1> leader, ArrayList<Thing2> followers ) {
		this.leader = leader;
		this.followers = followers;
	}
	
	// displays all students
	public <Thing2> void displayStudents() {
		
		for(int i = 0; i < followers.size(); i++) {
			if(followers.size()-1 != i) {
			System.out.print(((Student) followers.get(i)).getName()+" ");
			}
			else {
				System.out.print(((Student) followers.get(i)).getName()+"\n");
			}
		}
	}
	// displays teacher
	public <Thing1> void displayTeacher() {
		System.out.print(leader.get(0).getName()+"\n");
	}
	
	
	public <Thing2> void displayPercentageRange(int lowestValue, int highestValue){ 
		List<Student> personsFamily = (List<Student>) followers.stream()
				.filter( student -> ((Student) student).getPercentage() >= lowestValue &&
									((Student) student).getPercentage() <= highestValue)
									.collect(Collectors.toList()); 
		
		String results = "[";
		
		for(Student i: personsFamily) {
			results += i.getName() + ": " + i.getPercentage()+ ", ";
		}
		
		if(personsFamily.isEmpty()) {
			results = "[No students with this grade range!";
		}
		else {
			results = results.substring(0,results.length()-2);
		}
		
		System.out.println(results+= "]");
	}

}
