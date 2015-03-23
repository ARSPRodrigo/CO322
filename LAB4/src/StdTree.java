/*
 * Created by Prasanna on 3/18/2015.
 */
public class StdTree {

    public static void main(String [] args){

        BTree<Course> courseBTree = new BTree<Course>();

        Course CO321 = new Course("CO321");
        Course CO322 = new Course("CO322");
        Course CO323 = new Course("CO323");
        Course CO324 = new Course("CO324");
        Course CO325 = new Course("CO325");
        Course EE386 = new Course("EE386");

        courseBTree.insert(CO321);
        courseBTree.insert(CO322);
        courseBTree.insert(CO323);
        courseBTree.insert(CO324);
        courseBTree.insert(CO325);
        courseBTree.insert(EE386);

        courseBTree.in_order();
    }
}
