/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

class Solution {
   public boolean isValidSudoku(char[][] board) {
      // check each row, check each column
      for(int i=0; i<board.length; i++){
         Set<Character> sRow = new HashSet<>();
         Set<Character> sCol = new HashSet<>();
         for(int j=0; j<board[i].length; j++){
            if(board[i][j]!='.' && sRow.contains(board[i][j])){
               return false;
            }
            else if(board[i][j]!='.' && !sRow.contains(board[i][j])){
               sRow.add(board[i][j]);
            }

            if(board[j][i]!='.' && sCol.contains(board[j][i])){
               return false;
            }
            else if(board[j][i]!='.' && !sCol.contains(board[j][i])){
               sCol.add(board[j][i]);
            }
         }
      }

      // check each sub-box
      for(int i=0; i<board.length; i+=3){
         // first set of columns, 0-2
         Set<Character> s1 = new HashSet<>();
         Set<Character> s2 = new HashSet<>();
         Set<Character> s3 = new HashSet<>();
         for(int j=0; j<3; j++){
            if(board[i][j]!='.' && s1.contains(board[i][j])){
               return false;
            }
            else if(board[i][j]!='.' && !s1.contains(board[i][j])){
               s1.add(board[i][j]);
            }

            if(board[i+1][j]!='.' && s1.contains(board[i+1][j])){
               return false;
            }
            else if(board[i+1][j]!='.' && !s1.contains(board[i+1][j])){
               s1.add(board[i+1][j]);
            }

            if(board[i+2][j]!='.' && s1.contains(board[i+2][j])){
               return false;
            }
            else if(board[i+2][j]!='.' && !s1.contains(board[i+2][j])){
               s1.add(board[i+2][j]);
            }
         }

         // second set of columns, 3-5
         for(int j=3; j<6; j++){
            if(board[i][j]!='.' && s2.contains(board[i][j])){
               return false;
            }
            else if(board[i][j]!='.' && !s2.contains(board[i][j])){
               s2.add(board[i][j]);
            }

            if(board[i+1][j]!='.' && s2.contains(board[i+1][j])){
               return false;
            }
            else if(board[i+1][j]!='.' && !s2.contains(board[i+1][j])){
               s2.add(board[i+1][j]);
            }

            if(board[i+2][j]!='.' && s2.contains(board[i+2][j])){
               return false;
            }
            else if(board[i+2][j]!='.' && !s2.contains(board[i+2][j])){
               s2.add(board[i+2][j]);
            }
         }

         // third set of columns, 6-8
         for(int j=6; j<9; j++){
            if(board[i][j]!='.' && s3.contains(board[i][j])){
               return false;
            }
            else if(board[i][j]!='.' && !s3.contains(board[i][j])){
               s3.add(board[i][j]);
            }

            if(board[i+1][j]!='.' && s3.contains(board[i+1][j])){
               return false;
            }
            else if(board[i+1][j]!='.' && !s3.contains(board[i+1][j])){
               s3.add(board[i+1][j]);
            }

            if(board[i+2][j]!='.' && s3.contains(board[i+2][j])){
               return false;
            }
            else if(board[i+2][j]!='.' && !s3.contains(board[i+2][j])){
               s3.add(board[i+2][j]);
            }
         }
      }
      
      return true;
   }
}
/*
APPROACH 2: go through each row & go through each column, then go through each sub box
TC: O(81) = O(1)
SC: O(5*9) = O(45) = O(1)
*/


/* 
APPROACH 1: go through each row, then each column, then each sub-box
TC: O(3*9*9) = O(243) = O(1), 3 because we nested loop 3 times
SC: O(5*9) = O(45) = O(1)

public boolean isValidSudoku(char[][] board) {
   // go through each row
   // go through each column
   // somehow go through each sub-box

   // check each row
   for(int i=0; i<board.length; i++){
       Set<Character> s = new HashSet<>();
       for(int j=0; j<board[i].length; j++){
           if(board[i][j]!='.' && s.contains(board[i][j])){
               return false;
           }
           else if(board[i][j]!='.' && !s.contains(board[i][j])){
               s.add(board[i][j]);
           }
       }
   }

   // check each column
   for(int i=0; i<board.length; i++){
       Set<Character> s = new HashSet<>();
       for(int j=0; j<board[i].length; j++){
           if(board[j][i]!='.' && s.contains(board[j][i])){
               return false;
           }
           else if(board[j][i]!='.' && !s.contains(board[j][i])){
               s.add(board[j][i]);
           }
       }
   }

   // check each sub-box
   for(int i=0; i<board.length; i+=3){
       // first set of columns, 0-2
       Set<Character> s1 = new HashSet<>();
       Set<Character> s2 = new HashSet<>();
       Set<Character> s3 = new HashSet<>();
       for(int j=0; j<3; j++){
           if(board[i][j]!='.' && s1.contains(board[i][j])){
               return false;
           }
           else if(board[i][j]!='.' && !s1.contains(board[i][j])){
               s1.add(board[i][j]);
           }

           if(board[i+1][j]!='.' && s1.contains(board[i+1][j])){
               return false;
           }
           else if(board[i+1][j]!='.' && !s1.contains(board[i+1][j])){
               s1.add(board[i+1][j]);
           }

           if(board[i+2][j]!='.' && s1.contains(board[i+2][j])){
               return false;
           }
           else if(board[i+2][j]!='.' && !s1.contains(board[i+2][j])){
               s1.add(board[i+2][j]);
           }
       }

       // second set of columns, 3-5
       for(int j=3; j<6; j++){
           if(board[i][j]!='.' && s2.contains(board[i][j])){
               return false;
           }
           else if(board[i][j]!='.' && !s2.contains(board[i][j])){
               s2.add(board[i][j]);
           }

           if(board[i+1][j]!='.' && s2.contains(board[i+1][j])){
               return false;
           }
           else if(board[i+1][j]!='.' && !s2.contains(board[i+1][j])){
               s2.add(board[i+1][j]);
           }

           if(board[i+2][j]!='.' && s2.contains(board[i+2][j])){
               return false;
           }
           else if(board[i+2][j]!='.' && !s2.contains(board[i+2][j])){
               s2.add(board[i+2][j]);
           }
       }

       // third set of columns, 6-8
       for(int j=6; j<9; j++){
           if(board[i][j]!='.' && s3.contains(board[i][j])){
               return false;
           }
           else if(board[i][j]!='.' && !s3.contains(board[i][j])){
               s3.add(board[i][j]);
           }

           if(board[i+1][j]!='.' && s3.contains(board[i+1][j])){
               return false;
           }
           else if(board[i+1][j]!='.' && !s3.contains(board[i+1][j])){
               s3.add(board[i+1][j]);
           }

           if(board[i+2][j]!='.' && s3.contains(board[i+2][j])){
               return false;
           }
           else if(board[i+2][j]!='.' && !s3.contains(board[i+2][j])){
               s3.add(board[i+2][j]);
           }
       }
   }
   
   return true;
}

*/