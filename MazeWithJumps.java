import java.util.Scanner;

public class MazeWithJumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        printMazeWithJumps(0,0,n-1,m-1,"");
    }

    private static void printMazeWithJumps(int row, int col, int n, int m, String s) {
        if(row>n || col>m){
            return;
        }
        if(row==n && col==m){
            System.out.println(s);
            return;
        }
        for(int i=1;i<=n-row;i++)
            printMazeWithJumps(row+i,col,n,m,s+'v'+i);
        for(int i=1;i<=m-col;i++)
            printMazeWithJumps(row,col+i,n,m,s+'h'+i);
        for(int i=1;i<=n-row && i<=m-col;i++)
            printMazeWithJumps(row+i,col+i,n,m,s+'d'+i);
    }
}
