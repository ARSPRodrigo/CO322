import java.util.Arrays;

/*
 * Created by Prasanna on 1/25/2015.
 */
public class Class1 {

    static void insertion_sort(int [] data){


        int i,j,tmp;
        for(i=0;i<data.length;i++){
            tmp = data[i];
            j = i-1;
            while ( (j > -1) && ( data [j] > tmp ) ) {
                data [j+1] = data [j];
                j--;
            }
            data[j+1] = tmp;
            System.out.println(Arrays.toString(data));
        }

    }

    static void swap(int i,int j,int[] data){
        int k;
        for(k=i;k>j;k--){
            data[k] = data[k-1];
        }
    }

    public static void main(String []args){
        int [] a = {6, 2, 1, 5, 1, 4, 7, 7};
        insertion_sort(a);
    }
}
