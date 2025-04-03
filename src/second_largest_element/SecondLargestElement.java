package second_largest_element;

public class SecondLargestElement {

    public static void main(String[] args) {
        int [] data = {9,3,6,7,1,8,10};
        int max = Integer.MIN_VALUE;
        int secondMax =Integer.MIN_VALUE;
        for(int i=0;i<data.length;i++){

            if(data[i]>max){
                secondMax =max;
                max=data[i];
            } else if(data[i]>secondMax&&data[i]<max){
                secondMax=data[i];
            }

        }


        System.out.println(max);
        System.out.println(secondMax);
    }
}
