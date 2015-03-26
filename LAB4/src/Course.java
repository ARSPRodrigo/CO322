import java.util.Random;

/*
 * Created by Prasanna on 3/23/2015.
 */
public class Course implements Comparable<Course> {

    private String courseName;
    private double gpa;

    public Course(String name, double gpa){

        this.courseName = name;
        this.gpa = gpa;
    }

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

    @Override
    public String toString(){
        return this.getCourseName()+" "+this.getGpa();
    }
}