import java.io.*;
import java.util.*;

public class LongestConsSeq{

public static void main(String[] args) throws Exception {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    int []a=new int[n];
    for(int i=0;i<n;i++){
        a[i]=in.nextInt();
    }
    HashMap<Integer,Boolean> hs=new HashMap<>();
    
    for(Integer i:a){
        hs.put(i,true);
    }
    for(Integer i:a){
        if(hs.containsKey(i-1)){
            hs.put(i,false);
        }
    }
    int mp=0;
    int low=0;
    for(Integer i:a){
        if(hs.get(i)==true){
            int temp=i;
            int t=1;
            while(hs.containsKey(temp+t)){
                t++;
            }
            if(t>mp){
                mp=t;
                low=i;
            }
        }
    }
    
    for(int i=0;i<mp;i++){
        System.out.println(low+i);
    }
    
 }
}