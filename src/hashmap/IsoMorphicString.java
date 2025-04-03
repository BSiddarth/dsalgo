package hashmap;

import java.util.HashMap;

public class IsoMorphicString {

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        if (isIsomorphic(s, t)) {
            System.out.println("Yes, the strings are isomorphic.");
        } else {
            System.out.println("No, the strings are not isomorphic.");
        }
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check and update mappings in one step
            if ((mapS.containsKey(c1) && mapS.get(c1) != c2) ||
                (mapT.containsKey(c2) && mapT.get(c2) != c1)) {
                return false;
            }

            mapS.put(c1, c2);
            mapT.put(c2, c1);
        }

        return true;
    }
}
