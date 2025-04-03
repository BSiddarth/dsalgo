package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

class DistinctSubarrays {

    public static void main(String[] args) {

        DistinctSubarrays distinctSubarrays = new DistinctSubarrays();

        int [] array =  {1,5,4,2,9,9,9};
        int k=3;
        System.out.println( distinctSubarrays.distinctSubarrays(array,k));
    }



    List<List<Integer>> distinctSubarrays(int[] arr, int k) {

        // To store unique subarrays
        List<List<Integer>> arraylist = new ArrayList<>();
        LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>();

        // Collect unique elements to form a distinct array
        for (int value : arr) {
            uniqueElements.add(value);
        }

        // Convert the set back to a list
        List<Integer> newlist = new ArrayList<>(uniqueElements);

        System.out.println("Distinct Elements: " + newlist);

        // Sliding window logic
        int i = 0, j = 0;
        List<Integer> temp = new ArrayList<>();

        while (j < newlist.size()) {
            // Add the current element to the temporary window
            temp.add(newlist.get(j));

            // Check if the window size is less than k
            if (j - i + 1 < k) {
                j++;
            }
            // If the window size is exactly k
            else if (j - i + 1 == k) {
                // Add the current window to the result list
                arraylist.add(new ArrayList<>(temp));

                // Slide the window
                temp.removeFirst(); // Remove the leftmost element
                i++;
                j++;
            }
        }

        return arraylist;
    }

}
