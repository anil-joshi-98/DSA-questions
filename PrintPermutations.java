import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(printPermutations(str,"",""));
    }

    private static String printPermutations(String str, String s,String total) {
        if(str.length()==0){
            return total+s+"\n";
        }
        for(int i=0;i<str.length();i++){
            total=printPermutations(str.substring(i+1)+str.substring(0,i),s+str.charAt(i),total);
        }
        return total;
    }
}
