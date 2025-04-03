package Dp;


public class RightAndLeftSum {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5, 6, 7, 8};

//      int totalSum =  Arrays.stream(array).sum();
//      System.out.println(totalSum);
//      int leftSum=0;
//      for (int i = 0; i < array.length; i++) {
//          int rightSum = totalSum-leftSum-array[i];
//          if(leftSum==rightSum){
//              System.out.println(i);
//              break;
//          }
//          leftSum+=array[i];
//      }
        int start = 0;
        int end = array.length - 1;
        int starSum=array[start];
        int endSum=array[end];


        while (start < end) {

          if(starSum< endSum){
              start++;
              starSum+=array[start];
          }else {
              end--;
              endSum+=array[end];
          }

          if(starSum==endSum){
              System.out.println(start+1);
              break;
          }

        }
    }
}
