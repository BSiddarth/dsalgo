public class SortedArray {

    public static void main(String[] args) {
        int [] A= {1,2,3,4,5};
        int [] B= {4,5,6,7};

        if (A.length> B.length)
        {
            int [] temp = A;
            A = B;
            B = temp;
        }

        int l=0,r=A.length-1;
        int total=A.length+B.length;
        int half = (total)/2;

        while (true){

            int i=l+r/2;
            int j=half-i-2;
            int aleft=i>=0?A[i]:Integer.MIN_VALUE;
            int aright=i+1<A.length?A[i+1]:Integer.MAX_VALUE;
            int bleft=j>=0?B[j]:Integer.MIN_VALUE;
            int bright=j+1<B.length?B[j+1]:Integer.MAX_VALUE;

            if(aleft<=bright&&bleft<=aright){

                if (total%2!=0){
                    System.out.println(Math.min(aright,bright));
                }

                double result = (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
            }else if (aleft>bright){
                r=i-1;
            }else {
                l=i+1;
            }





        }


    }
}
