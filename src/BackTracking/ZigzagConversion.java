package BackTracking;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Initialize rows as an array of empty StringBuilder
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        // Place characters into the correct rows
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            // Change direction if we're at the top or bottom row
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move up or down
            currRow += goingDown ? 1 : -1;
        }

        // Combine rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // Output: PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); // Output: PINALSIGYAHRPI
    }
}
