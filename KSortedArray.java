import java.io.*;
import java.util.*;

public class KSortedArray {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
         a[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      for(int i:a){
          if(k+1>pq.size()){
              pq.add(i);
          }
          else{
              System.out.println(pq.poll());
              pq.add(i);
          }
      }
      while(pq.size()>0){
          System.out.println(pq.poll());
      }
   }

}