import java.util.Random;

/*
 * Created by Prasanna on 3/23/2015.
 */
public class Course implements Comparable<Course> {

    String courseName;
    double gpa;

    public Course(String name){

        double rangeMin = 2;
        double rangeMax = 4;

        this.courseName = name;
        Random r = new Random();
        this.gpa = (double) Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100)/100;
    }

    /*public void ge(){
        System.out.print(courseName + ": ");
        System.out.println(gpa);
    }*/

    public String getCourseName(){
        return courseName;
    }

    public double getGpa(){
        return gpa;
    }

    @Override
    public int compareTo(Course o) {
        return Double.compare(o.getGpa(), this.getGpa());
    }
}
