
import java.util.Scanner;
public class Subsequences {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(printSubsequences(str,"",0));
    }

    private static int printSubsequences(String str, String ans,int count) {
        if(str.length()==0){
            System.out.println(ans);
            count++;
            return count;
        }
        return printSubsequences(str.substring(1),ans+str.charAt(0),count)+printSubsequences(str.substring(1),ans,count);
    }
}
