/*
 * Created by Prasanna on 3/23/2015.
 */
import java.util.Random;

public class Student implements Comparable<Student> {
    private String student;
    private BTree<Course> courseBTree = new BTree<Course>();
    private double GPA;

    public Student(String name){
        this.student = name;

        double rangeMin = 2;
        double rangeMax = 4;
        double calc;
        Random r = new Random();

        double gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        calc = gpa;
        Course CO321 = new Course("CO321",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        calc += gpa;
        Course CO322 = new Course("CO322",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        calc += gpa;
        Course CO323 = new Course("CO323",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        calc += gpa;
        Course CO324 = new Course("CO324",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        calc += gpa;
        Course CO325 = new Course("CO325",gpa);
        gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
        calc += gpa;
        Course EE386 = new Course("EE386",gpa);

        this.courseBTree.insert(CO321);
        this.courseBTree.insert(CO322);
        this.courseBTree.insert(CO323);
        this.courseBTree.insert(CO324);
        this.courseBTree.insert(CO325);
        this.courseBTree.insert(EE386);

        this.GPA = (double) Math.round((calc/6.0)*100)/100;
    }

    public String getStudent(){
        return this.student;
    }

    public double getGPA(){
        return this.GPA;
    }

    public BTree getCourseBTree(){
        return this.courseBTree;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGPA(),this.getGPA());
    }

    @Override
    public String toString(){
        return this.getStudent()+" "+this.getGPA();
    }
}

