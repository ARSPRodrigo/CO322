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

        double rangeMin = 2;
        double rangeMax = 4;
        Random r = new Random();
        String [] courses = {"CO321","CO322","CO323","CO324","CO325","EE386"};

        double gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO321 = new Course(courses[0],gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO322 = new Course(courses[1],gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO323 = new Course(courses[2],gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO324 = new Course(courses[3],gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO325 = new Course(courses[4],gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course EE386 = new Course(courses[5],gpa);

        courseBTree.insert(CO321);
        courseBTree.insert(CO322);
        courseBTree.insert(CO323);
        courseBTree.insert(CO324);
        courseBTree.insert(CO325);
        courseBTree.insert(EE386);

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
        /*Student s1 = new Student("aaaa");
        Student s2 = new Student("bbbb");
        Student s3 = new Student("cccc");
        Student s4 = new Student("dddd");

        studentBTree.insert(s1);
        studentBTree.insert(s2);
        studentBTree.insert(s3);
        studentBTree.insert(s4);*/

        studentBTree.in_order();
    }
}
