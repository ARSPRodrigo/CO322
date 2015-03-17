/****************************
 *  Rodrigo A.R.S.P.        *
 *  E/11/343                *
 *  2015-02-10              *
 ****************************/

import java.sql.*;
import java.util.ArrayList;

public class oddMan
{

	static final String DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1/co322data"; //replace e11500 with your registration number 10.40.18.170

	static final String USERNAME = "root"; // replace e11500 with your registration number e11343
	static final String PASSWORD = "";

    /** MERGE SORT ALGORITHM */
    static void mergeSort(int[][] A) {
        if (A.length > 1) {
            int[][] leftArray = new int[A.length/2][2];
            int[][] rightArray = new int[A.length - leftArray.length][2];
            int i;
            for(i=0;i<leftArray.length;i++){
                leftArray[i][0] = A[i][0];
                leftArray[i][1] = A[i][1];
            }
            int k = i;
            for(i=0;i<rightArray.length;i++){
                rightArray[i][0] = A[k][0];
                rightArray[i][1] = A[k][1];
                k++;
            }

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    static void merge(int[][] a, int[][] l, int[][] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li][1] < r[ri][1]) {
                    a[i][0] = l[li][0];
                    a[i][1] = l[li][1];
                    i++;
                    li++;
                }
                else {
                    a[i][0] = r[ri][0];
                    a[i][1] = r[ri][1];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i][0] = r[ri][0];
                        a[i][1] = r[ri][1];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i][0] = l[li][0];
                        a[i][1] = l[li][1];
                        li++;
                        i++;
                    }
                }
            }
        }
    }
    /** END OF MERGE SORT */

    /** FIND THE ODD MAN */
    static int index = 2;
    public static void oddMan(ArrayList<int[]> data){
        if(data.size()%2 !=0) {
            while (data.size() > 1) {
                //for(int i=0;i< data.size();i++) {System.out.print(data.get(i)[1]+" ");}System.out.println();
                int prew_dist = data.get(index-1)[1] - data.get(index-2)[1];
                int next_dist = data.get(index)[1] - data.get(index-1)[1];
                if(prew_dist>next_dist){
                    index++;
                    if(data.size()>index) {
                    }
                    else {
                        index-=2;
                        if(index>=0) {
                            data.remove(index);
                            data.remove(index);
                            index=2;
                        }
                    }
                }else {
                    index -= 2;
                    if (index>=0){
                        data.remove(index);
                        data.remove(index);
                        index=2;
                    }
                }
            }
            System.out.println("Odd man is: E/11/"+data.get(0)[0]);
        }
        else {
            System.out.println("No odd man");
        }
    }
    /** END OF ODD MAN*/

    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<int[]> data = new ArrayList<int[]>();
        ArrayList<int[]> sorted_data = new ArrayList<int[]>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			String sql;

			sql = "SELECT * FROM studentdata";
			rs = stmt.executeQuery(sql);
            int i = 0;
  			while(rs.next()){
                String gender = rs.getString("gender");
                String regno = rs.getString("regno");
                int eNnum = Integer.parseInt(regno.split("/")[2]);
				int height  = rs.getInt("height");
                int weight  = rs.getInt("weight");
                int age  = rs.getInt("age");
                if(gender.equals("Male")) {
                    int[] record = {eNnum, (height + weight + age)};
                    data.add(i, record);
                }
                else if(gender.equals("Female")){
                    int[] record = {eNnum, (int) Math.floor((height + weight + age) * 1.25)};
                    data.add(i, record);
                }
                i++;
			}
            int [][] sData = new int[data.size()][2];
            for(i=0;i<data.size();i++) {
                //System.out.println(Arrays.toString(data.get(i)));
                sData[i][0] = data.get(i)[0];
                sData[i][1] = data.get(i)[1];
            }
            mergeSort(sData);
            for(i=0;i<sData.length;i++) {
                sorted_data.add(i, sData[i]);
                //System.out.print(sorted_data.get(i)[1]+" ");
            }
            oddMan(sorted_data);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!= null)
					rs.close();
				if(stmt!=null)
					conn.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
