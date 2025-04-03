package BackTracking;

public class WordSearch {
    // A 2D array to mark cells that have been visited in the current search path
    boolean[][] visited;

    public static void main(String[] args) {
        // Instantiate the WordSearch class and test the bacKtrack function with a target word
        WordSearch w = new WordSearch();
        String word = "ABCB";
        // Check if the word exists in the board
        if(w.backTrack(word))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // The function that initiates backtracking search for the word in the board
    public boolean backTrack(String word){

        // Initialize the board
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        // Initialize the visited matrix to keep track of visited cells
        visited = new boolean[board.length][board[0].length];

        // Iterate over each cell to start the search from each potential starting point
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the cell matches the first character of the word, initiate backtracking
                if(board[i][j] == word.charAt(0) && isWordSearch(board, word, i, j, 0)){
                    return true; // Word found
                }
            }
        }
        return false; // Word not found in any path
    }

    // Recursive helper method to perform the backtracking search
    public boolean isWordSearch(char[][] board, String word, int x, int y, int depth) {
        // Base case: if depth equals the word length, the word has been found
        if(word.length() == depth){
            return true;
        }
        // Boundary and validity checks for the current cell
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length ||
                visited[x][y] || board[x][y] != word.charAt(depth)) {
            return false; // Out of bounds, already visited, or character mismatch
        }
        // Mark the current cell as visited to avoid revisiting in the same path
        visited[x][y] = true;
        // Recursive calls to explore all four possible directions: down, right, up, left
             if(isWordSearch(board, word, x + 1, y, depth + 1) ||  // Down
                isWordSearch(board, word, x, y + 1, depth + 1) ||  // Right
                isWordSearch(board, word, x, y - 1, depth + 1) ||  // Left
                isWordSearch(board, word, x - 1, y, depth + 1)) {  // Up
            return true; // If any direction finds the word, return true
        }
        // Backtrack by unmarking the current cell as visited
        visited[x][y] = false;
        return false; // No path from this cell found the word
    }
}


/*
Initial Setup
visited: A 2D boolean array to mark cells already used in the current search path to prevent revisits.
        Step-by-Step Execution with Comments
Main Method Execution:

A WordSearch instance w is created.
bacKtrack("ABCB") is called.
bacKtrack Method:

Initializes visited as a 3x4 matrix (board dimensions).
Loops through each cell in board to find the starting point that matches word.charAt(0) (i.e., 'A').
First Matching Cell Found (i=0, j=0):

The first character 'A' matches board[0][0].
Calls isWordSearch(board, "ABCB", 0, 0, 0) with coordinates (0,0) and depth=0 to start searching.
isWordSearch Method Execution (Recursive Exploration)
Recursive call 1: isWordSearch(board, "ABCB", 0, 0, 0)

Current State:
depth=0, board[0][0] = 'A', matching word.charAt(0) = 'A'.
Mark visited[0][0] = true.
Next Moves (depth increments to 1):
Move Down: Calls isWordSearch(board, "ABCB", 1, 0, 1).
Recursive call 2: isWordSearch(board, "ABCB", 1, 0, 1)

Current State:
depth=1, board[1][0] = 'S', does not match word.charAt(1) = 'B'.
Returns false.
Backtrack to isWordSearch(board, "ABCB", 0, 0, 0).

Next Moves:
Move Right: Calls isWordSearch(board, "ABCB", 0, 1, 1).
Recursive call 3: isWordSearch(board, "ABCB", 0, 1, 1)

Current State:
depth=1, board[0][1] = 'B', matching word.charAt(1) = 'B'.
Mark visited[0][1] = true.
Next Moves (depth increments to 2):
Move Down: Calls isWordSearch(board, "ABCB", 1, 1, 2).
Recursive call 4: isWordSearch(board, "ABCB", 1, 1, 2)

Current State:
depth=2, board[1][1] = 'F', does not match word.charAt(2) = 'C'.
Returns false.
Backtrack to isWordSearch(board, "ABCB", 0, 1, 1).

Next Moves:
Move Right: Calls isWordSearch(board, "ABCB", 0, 2, 2).
Recursive call 5: isWordSearch(board, "ABCB", 0, 2, 2)

Current State:
depth=2, board[0][2] = 'C', matching word.charAt(2) = 'C'.
Mark visited[0][2] = true.
Next Moves (depth increments to 3):
Move Down: Calls isWordSearch(board, "ABCB", 1, 2, 3).
Recursive call 6: isWordSearch(board, "ABCB", 1, 2, 3)

Current State:
depth=3, board[1][2] = 'C', does not match word.charAt(3) = 'B'.
Returns false.
Backtrack to isWordSearch(board, "ABCB", 0, 2, 2).

Next Moves:
Move Left: Calls isWordSearch(board, "ABCB", 0, 1, 3).
Recursive call 7: isWordSearch(board, "ABCB", 0, 1, 3)

Current State:
depth=3, visited[0][1] = true (cell already visited in this path).
Returns false.
Backtrack to isWordSearch(board, "ABCB", 0, 2, 2).

Other Moves: All fail due to out-of-bounds or mismatches.
Backtrack Entirely to bacKtrack("ABCB") and continue checking the remaining cells.

Final Result
After checking all paths, no valid path for "ABCB" is found.
bacKtrack("ABCB") returns false, and the output is "No".
This dry run shows how the backtracking algorithm attempts various paths while respecting visited cells, but ultimately fails to find the word due to the repeated 'C' at board[0][2] and board[1][2].*/
