public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {

        int[] nums = {1,1,2};
        int count=1;
        for(int i=1;i<nums.length;i++){

            if(nums[i-1]!=nums[i]){
                nums[count]=nums[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
