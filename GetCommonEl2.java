import java.io.*;
import java.util.*;

public class GetCommonEl2{

public static void main(String[] args) throws Exception {
    Scanner in=new Scanner(System.in);
    int n1=in.nextInt();
    int []a1=new int[n1];
    for(int i=0;i<n1;i++){
        a1[i]=in.nextInt();
    }
    int n2=in.nextInt();
    int []a2=new int[n2];
    for(int i=0;i<n2;i++){
        a2[i]=in.nextInt();
    }
    Map<Integer,Integer> hs=new HashMap<>();
    
    for(Integer i:a1){
        hs.put(i,hs.getOrDefault(i,0)+1);
    }
    
    for(Integer i:a2){
        if(hs.getOrDefault(i,0)>0){
            System.out.println(i);
            hs.put(i,hs.get(i)-1);
        }
    }
    
 }

}