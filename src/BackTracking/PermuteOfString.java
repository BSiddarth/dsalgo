package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class PermuteOfString {
    public static void main(String[] args) {
        String input = "abc";
        Set<String> list = new HashSet<>();
        permute(input,"",list);
        System.out.println(list);
    }


    public static void permute(String input, String str, Set<String> list) {

        if(input.isEmpty()) {//bc
            list.add(str);
            return;
        }
        for(int i = 0; i <=input.length()-1; i++) {
            String newip=input.substring(0,i)+input.substring(i+1);
            System.out.println("newIp---------------->"+newip);
            System.out.println("input---------------->"+input);
            String optString= str+input.charAt(i);
            System.out.println("optString---------------->"+optString);
            permute(newip,optString,list);
        }
    }
}
