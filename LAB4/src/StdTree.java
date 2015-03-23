import java.util.Random;

/*
 * Created by Prasanna on 3/18/2015.
 */
public class StdTree {

    public static void main(String [] args){

        BTree<Course> courseBTree = new BTree<Course>();

        double rangeMin = 2;
        double rangeMax = 4;
        Random r = new Random();

        double gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO321 = new Course("CO321",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO322 = new Course("CO322",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO323 = new Course("CO323",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO324 = new Course("CO324",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course CO325 = new Course("CO325",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        Course EE386 = new Course("EE386",gpa);

        courseBTree.insert(CO321);
        courseBTree.insert(CO322);
        courseBTree.insert(CO323);
        courseBTree.insert(CO324);
        courseBTree.insert(CO325);
        courseBTree.insert(EE386);

        //courseBTree.in_order();

        BTree<Student> studentBTree = new BTree<Student>();

        Student s1 = new Student("aaaa");
        Student s2 = new Student("bbbb");
        Student s3 = new Student("cccc");
        Student s4 = new Student("dddd");

        studentBTree.insert(s1);
        studentBTree.insert(s2);
        studentBTree.insert(s3);
        studentBTree.insert(s4);

        studentBTree.in_order();
    }
}
