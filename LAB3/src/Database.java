/*
 * Created by Prasanna on 3/14/2015.
 */

import java.sql.*;
public class Database <T extends Comparable<T>> implements Interface<Integer>{

    static final String DB_URL = "jdbc:mysql://127.0.0.1/heap";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();

            String sql = "CREATE TABLE heap(ID INT NOT NULL, number TEXT NOT NULL, PRIMARY KEY (ID);";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int size() {
        int value=0;
        try {
            rs = stmt.executeQuery("SELECT COUNT(*) FROM heap");
            rs.next();
            value=rs.getInt("COUNT(*)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value ;
    }

    public void swap(int a, int b) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT number FROM heap WHERE ID="+Integer.toString(a);
            rs = stmt.executeQuery(sql);
            rs.next();
            int tmp=rs.getInt("number");
            sql = "SELECT number FROM heap WHERE ID="+Integer.toString(b);
            rs = stmt.executeQuery(sql);
            rs.next();
            int value_b=rs.getInt("number");
            sql = "UPDATE heap\n" +
                    "SET number="+Integer.toString(value_b)+"\n" +
                    "WHERE ID="+Integer.toString(a);
            stmt.executeUpdate(sql);

            sql = "UPDATE heap\n" +
                    "SET number="+Integer.toString(tmp)+"\n" +
                    "WHERE ID="+Integer.toString(b);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public boolean isEmpty(){ return  (size() == 0);}
    boolean isRoot(int index) {	return (index == 0);}
    int leftChild(int index)  { return 2 * index + 1;  }
    int parent(int index)     { return (index - 1) / 2; }
    int rightChild(int index) { return 2 * index + 2;   }

    int myParent(int index) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT number FROM heap WHERE ID=" + Integer.toString(parent(index));
            rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt("number");
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }


    // return what the heap has
    boolean hasLeftChild(int i) { return leftChild(i) < size(); }
    boolean hasRightChild(int i){ return rightChild(i) < size(); }


    @Override
    public void addElement(Integer value) {
        try {
            stmt.executeUpdate("INSERT INTO heap VALUES ("+size()+","+value+")");
            bubbleUp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bubbleUp() {
        int parent;
        for (int i=size()-1; i!=0; i=parent) {
            parent=(i-1)/2;
            T temp = get(parent);
            T now = get(i);
            if (temp.compareTo(now)>0) {
                set(parent, now);
                set(i, temp);
            }
        }
    }

    T get(int value){
        try {
            rs = stmt.executeQuery("SELECT number FROM heap WHERE ID = "+value);
            rs.next();
            return (T) new Integer(Integer.parseInt(res.getString("data")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void set(int a, int b) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT number FROM heap WHERE ID="+Integer.toString(b);
            rs = stmt.executeQuery(sql);
            rs.next();
            int value_b=rs.getInt("number");
            String sql2 = "UPDATE heap\n" +
                    "SET number="+Integer.toString(value_b)+"\n" +
                    "WHERE ID="+Integer.toString(a);

            stmt.executeUpdate(sql2);
            sql="DELETE FROM heap\n" +
                    "WHERE ID="+Integer.toString(b);
            stmt.executeUpdate(sql);
            sql = "UPDATE heap\n" +
                    "SET ID=ID-1\n" +
                    "WHERE ID>="+Integer.toString(b);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeElement() {
        int index = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT number FROM heap WHERE ID=" + Integer.toString(size()-1);
            rs = stmt.executeQuery(sql);
            rs.next();
            int value = rs.getInt("number");

            sql="DELETE FROM heap\n" +"WHERE counter="+Integer.toString(size()-1);
            stmt.executeQuery(sql);
            if (size() > 0) {
                while (hasLeftChild(index)) {
                    int minChild = leftChild(index);
                    sql = "SELECT number FROM heap WHERE ID=" + Integer.toString(rightChild(index));
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    int rc = rs.getInt("number");
                    sql = "SELECT number FROM heap WHERE ID=" + Integer.toString(leftChild(index));
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    int lc = rs.getInt("number");
                    if (hasRightChild(index) && (rc - lc) < 0) {
                        minChild = rightChild(index);
                    }
                    sql = "SELECT number FROM heap WHERE ID=" + Integer.toString(minChild);
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    int mc = rs.getInt("number");

                    if ((value-mc) > 0) {
                        set(index, mc);
                        index = minChild;
                    } else {
                        break;
                    }
                }
                set(index, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer root() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT number FROM heap WHERE ID=" + Integer.toString(0);
            rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt("number");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String [] args){

        Database heap = new Database<Integer>();
        for(int i=0; i<10; i++) {
            heap.addElement((int) (Math.random() * 10));
        }
    }
}
