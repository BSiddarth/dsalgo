public class MajorityElement {

    public static void main(String[] args) {

        int [] nums = {2,2,1,1,1,2,2};

        int majority = nums[0];
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (majority == nums[i]) {
                count++;
            } else  {
                count--;
            }
            if (count == 0) {
                majority = nums[i];
            }
        }
        System.out.println(majority);
    }
}
