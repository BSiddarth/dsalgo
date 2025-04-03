import java.util.Arrays;

public class NewSolution {

    public static void main(String[] args) {
        String data = "Anagram";
        String data2 = "Anagram";

        int []array = new int[256];

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < data.length(); i++) {
            array[data.charAt(i)]++;
            array[data2.charAt(i)]--;
        }
        System.out.println(Arrays.toString(array));

     for (int count : array) {
         if (count != 0) {
             System.out.println(count);
         }
     }


    }


}
