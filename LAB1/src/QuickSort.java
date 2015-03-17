import java.util.Arrays;

/*
 * Created by Prasanna on 2/6/2015.
 */
public class QuickSort {

    public static int partitioning(int [] data, int start, int end){

        int left = start+1;
        int right = end;
        int pivot = start;

        while (left<right){
            if (data[pivot]>data[left]){
                left++;
                continue;
            }
            if (data[pivot]<=data[right]){
                right--;
                continue;
            }
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            System.out.println(Arrays.toString(data)+" "+left);
            left++;
            right--;
        }

        int temp = data[left];
        data[left] = data[pivot];
        data[pivot] = temp;

        System.out.println(Arrays.toString(data));

        return left;
    }

    public static void quickSort(int [] data){

        int pivot = partitioning(data,0,data.length-1);
        System.out.println(pivot);

        quickSort(data);

    }


    public static void main(String [] args){

        int [] data = {4,3,9,9,2,4,3,1,2,1,8,9,3,5,6};


    }
}
