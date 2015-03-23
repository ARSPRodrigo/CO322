import java.util.Random;

/*
 * Created by Prasanna on 3/23/2015.
 */
public class Course {

    String courseName;
    double gpa;

    public void Course(String name){

        double rangeMin = 2;
        double rangeMax = 4;

        this.courseName = name;
        Random r = new Random();
        this.gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
    }

    public void print(){
        System.out.print(courseName+": ");
        System.out.println(gpa);
    }
}
