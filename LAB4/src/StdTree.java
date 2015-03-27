import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/*
 * Created by Prasanna on 3/18/2015.
 */
public class StdTree {

    public static void main(String [] args){

        BTree<Course> courseBTree = new BTree<Course>();

        String [] courses = {"CO321","CO322","CO323","CO324","CO325","EE386"};

        Credit GPA = new Credit();
        int random = 0;
        for(int i=0; i < courses.length; i++) {
            random = (int)(Math.random() * 100);
            courseBTree.insert(new Course(courses[i],GPA.getCredit(random)));
        }

        //courseBTree.in_order();

        BTree<Student> studentBTree = new BTree<Student>();
        String content = "";
        try {
            content = new Scanner(new File("students.txt")).useDelimiter("\\Z").next();
            //System.out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String [] students = content.split(",");
        for(String x:students){
            studentBTree.insert(new Student(x));
        }

        studentBTree.in_order();
    }
}
