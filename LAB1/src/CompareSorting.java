import java.util.Arrays;
import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**************************************************
 * Simple sorting algorithms 
 * Modified by E/11/343
 **************************************************/

class CompareSorting { 

    static void insertion_sort(int [] data) {
        int i,j,tmp;
        for(i=0;i<data.length;i++){
            tmp = data[i];
            j = i-1;
            while ( (j > -1) && ( data [j] > tmp ) ) {
                data [j+1] = data [j];
                j--;
            }
            data[j+1] = tmp;
        }
    }

    static void selection_sort(int [] data) {
        int i,j,tmp,min,count=0;
        for(i=0;i<data.length;i++){
            min = data[i];
            count = i;
            for (j=data.length-1;j>i;j--){
                if(min > data[j]){
                    min = data[j];
                    count = j;
                }
            }
            tmp = data[i];
            data[i] = data[count];
            data[count] = tmp;
        }
    }

    static void bubble_sort(int [] data) {
        int i,j,tmp;
        for(i=0;i<data.length;i++){
            for(j=data.length-1;j>i;j--){
                if(data[j]<data[j-1]){
                    tmp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = tmp;
                }
            }
        }
    }

    static int [] generate_data(int sizeOfData) { 
        /* create an array of sizeOfData and
         * populate with random integers betweem 0-1000
         */
        int[] randomArray = new int[sizeOfData];
        Random rand = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            int n = rand.nextInt(1000);
            randomArray[i] = n;
        }
        return randomArray;
    }

    static int [] duplicate_array(int [] data) { 
        /* create a duplicate array of the given
         * useful when sending the same array to different
         * algorithms.
         */
        return data.clone();
    }

    static void postCondition(int [] data) { 
        /* if sorted, for any i data[i] > data[i-1]
         * Need to run this with java -ea CompareSorting
         */
        int i;
        for(i=1; i < data.length; i++)
            if(data[i] > data[i-1]) break;

        assert i == data.length : "Algorithm is broken";
    }

    public static void main(String [] ar) {

        int i = 10000;
        int[] d1 = null;
        int[] d2 = null;
        int[] d3 = null;
        while(i<=400000){

            System.out.println("\nIteration with array size: "+i);

            d1 = generate_data(i);
            //System.out.println("HG" + d.length);
            d2 = duplicate_array(d1);
            d3 = duplicate_array(d1);

            long start_time;
            long end_time;

            start_time = currentTimeMillis();
            //System.out.println("Starting of bubble sort: "+ start_time);
            bubble_sort(d1);
            end_time = currentTimeMillis();
            //System.out.println("End of bubble sort: "+end_time);
            System.out.println("time taken to bubble sort: " + (end_time - start_time));
            postCondition(d1);

            start_time = currentTimeMillis();
            //System.out.println("Starting of selection sort: "+start_time);
            bubble_sort(d2);
            end_time = currentTimeMillis();
            //System.out.println("End of selection sort: "+end_time);
            System.out.println("time taken to selection sort: " + (end_time - start_time));
            postCondition(d2);

            start_time = currentTimeMillis();
            //System.out.println("Starting of insertion sort: "+start_time);
            bubble_sort(d3);
            end_time = currentTimeMillis();
            //System.out.println("End of insertion sort: "+end_time);
            System.out.println("time taken to insertion sort: " + (end_time - start_time));
            postCondition(d3);

            i+=10000;
        }
    }
}

	   
