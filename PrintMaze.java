package DSA;

import java.util.Scanner;

public class PrintMaze {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        printMaze(0,0,n,m,"");
    }

    private static void printMaze(int row, int col, int n, int m, String s) {
        if(row==n || col==m){
            return;
        }
        if(row==n-1 && col==m-1){
            System.out.println(s);
            return;
        }
        printMaze(row+1,col,n,m,s+'v');
        printMaze(row,col+1,n,m,s+'h');
    }
}
