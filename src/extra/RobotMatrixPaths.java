package extra;

import java.util.ArrayList;
import java.util.List;

public class RobotMatrixPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<String> robotPaths(int n){
	    List<String> pathList = new ArrayList<String>();
	    getPaths(n, 1,1, "", pathList);
	    return pathList;
	}
	public static void getPaths(int n, int i, int j, String path, List<String> pathList){
	    path += String.format(" (%d,%d)", i , j);
	    if( i ==n && j == n){ //reach the (n,n) point
	        pathList.add(path);
	    }else if( i > n || j > n){//wrong way
	        return;
	    }else {
	        getPaths(n, i +1, j , path, pathList);
	        getPaths(n, i , j +1, path, pathList);
	    }
	}
	
	/*
	 * Backtracking Solution:
The most direct way is to write code that traverses each possible path, which can be done using backtracking. When you reach row=m and col=n, you know youÕve reached the bottom-right corner, and there is one additional unique path to it. However, when you reach row>m or col>n, then itÕs an invalid path and you should stop traversing. For any grid at row=r and col=c, you have two choices: Traverse to the right or traverse to the bottom. Therefore, the total unique paths at grid (r,c) is equal to the sum of total unique paths from the grid to the right and the grid below. Below is the backtracking code in 5 lines of code:


int backtrack(int r, int c, int m, int n) {
  if (r == m && c == n)
    return 1;
  if (r > m || c > n)
    return 0;
 
  return backtrack(r+1, c, m, n) + backtrack(r, c+1, m, n);
}
Improved Backtracking Solution using Memoization:
Although the above backtracking solution is easy to code, it is very inefficient in the sense that it recalculates the same solution for a grid over and over again. By caching the results, we prevent recalculation and only calculates when necessary. Here, we are using a dynamic programming (DP) technique called memoization.

const int M_MAX = 100;
const int N_MAX = 100;
 
int backtrack(int r, int c, int m, int n, int mat[][N_MAX+2]) {
  if (r == m && c == n)
    return 1;
  if (r > m || c > n)
    return 0;
 
  if (mat[r+1][c] == -1)
    mat[r+1][c] = backtrack(r+1, c, m, n, mat);
  if (mat[r][c+1] == -1)
    mat[r][c+1] = backtrack(r, c+1, m, n, mat);
 
  return mat[r+1][c] + mat[r][c+1];
}
 
int bt(int m, int n) {
  int mat[M_MAX+2][N_MAX+2];
  for (int i = 0; i < M_MAX+2; i++) {
    for (int j = 0; j < N_MAX+2; j++) {
      mat[i][j] = -1;
    }
  }
  return backtrack(1, 1, m, n, mat);
}


	 */
}
