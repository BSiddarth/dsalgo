import java.util.Scanner;

public class PatternProgrmses {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input number m");
        int m = input.nextInt();

        for (int i = 0; i < m; i++) {

            for (int j = m; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }


            System.out.println();
        }


//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }

//        for (int i = 0; i <= m; i++) {
//            for (int j = m; j > i; j--) {
//                int n = m-j+1;
//                System.out.print(n);
//            }
//            System.out.println();
//        }
    }
}

