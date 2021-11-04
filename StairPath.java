import java.util.Scanner;

public class StairPath {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        printStairPath(n,"");
    }

    private static void printStairPath(int n,String ans) {
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(ans);
            return;
        }
        printStairPath(n-1,ans+1);
        printStairPath(n-2,ans+2);
        printStairPath(n-3,ans+3);
    }
}
