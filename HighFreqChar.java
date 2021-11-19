import java.io.*;
import java.util.*;

public class HighFreqChar {

    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        TreeMap<Character,Integer> hs=new TreeMap<>();
        String str=in.nextLine();
        for(int i=0;i<str.length();i++){
            int k=hs.getOrDefault(str.charAt(i),0);
            hs.put(str.charAt(i),k+1);
        }
        Set<Character> keys=hs.keySet();
        Character ch=str.charAt(0);
        for(Character key:keys){
            if(hs.get(ch)<hs.get(key)){
                ch=key;
            }
        }
        System.out.println(ch);
    }

}