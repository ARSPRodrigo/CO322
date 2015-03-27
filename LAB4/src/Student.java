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
        double calc;

        int random=0;

        Credit get = new Credit();

        random = (int)(Math.random() * 100);
        double gpa = get.getCredit(random);
        calc = gpa;
        Course CO321 = new Course("CO321",gpa);
        random = (int)(Math.random() * 100);
        gpa = get.getCredit(random);
        calc += gpa;
        Course CO322 = new Course("CO322",gpa);
        random = (int)(Math.random() * 100);
        gpa = get.getCredit(random);
        calc += gpa;
        Course CO323 = new Course("CO323",gpa);
        random = (int)(Math.random() * 100);
        gpa = get.getCredit(random);
        calc += gpa;
        Course CO324 = new Course("CO324",gpa);
        random = (int)(Math.random() * 100);
        gpa = get.getCredit(random);
        calc += gpa;
        Course CO325 = new Course("CO325",gpa);
        random = (int)(Math.random() * 100);
        gpa = get.getCredit(random);
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
        this.getCourseBTree().in_C_order();

        // make courses min to max
        String [] s = BTree.courses.split(",");
        String minToMax = "";
        for(int i = s.length-1;i>=0;i--){
            minToMax += s[i]+" ";
        }

        // return string
        return this.getStudent()+"\t"+this.getGPA()+"\n"+minToMax+"\n";
    }
}

