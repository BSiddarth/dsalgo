package BinarySearchApplication;

public class NumberOfRotationsInRotatedArray {

    public static void main(String[] args) {

        int [] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int start=0;
        int end=nums.length-1;
        int target=5;

        for (int i = 0; i < nums.length-1; i++) {

            if(target==nums[i]&&target!=nums[i-1]){
                System.out.println("StartIndex"+i);
            } else if (target==nums[i]&&target!=nums[i+1]) {
                System.out.println("EndIndex"+i);
            }
        }
        while (start<=end) {
            int mid = (start+end)/2;

            if(nums[mid]==target &&target!=nums[mid-1]){
                System.out.println(mid);
            } else if (target==nums[mid]&&target!=nums[mid+1]) {
                System.out.println(mid);
            }

        }





    }

}
