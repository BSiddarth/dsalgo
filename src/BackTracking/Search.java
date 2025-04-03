package BackTracking;

public class Search {

    public static void main(String[] args) {

//        1 2 3 4 5 6 7 8
        int [] array = {6,7,8,9,10,1 ,2, 3, 4, 5};// logn(n);
        int target = 6;                        // o(1)
        int start = 0;
        int end = array.length-1;
        while(start <= end){

            int mid = (start + end)/2;

            if(array[mid] == target){
                System.out.println(mid);
            }

            if (array[mid] >=array[start]) {
                start = mid + 1;
            }else{
                if (target > array[mid] && target <= array[end]) {

                    start = mid + 1;
                } else {
                    end = mid - 1;

                }



        }
        }


/*

  int [] array = {6,7,8,9,10,1 ,2, 3, 4, 5};// logn(n);
        int target = 7;



          0           1            2        3          4       5        6        7         8         9
          6,          7,           8,       9,        10,      1 ,      2,       3,        4,        5
         start                                       mid                                           end

         mid =end+start/2;

      if (array[mid] >=array[start]) {
                start = mid + 1;
            }else{
            if (target > array[mid] && target <= array[end]) {

                start = mid + 1;
            } else {
                end = mid - 1;

            }

        }





*/


    }
}
