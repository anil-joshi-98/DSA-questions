import java.io.*;
import java.util.*;

public class KLargestElem {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      Queue<Integer> pq=new PriorityQueue<>();
      for(int i:arr){
          if(k>pq.size()){
              pq.add(i);
          }
          else{
              if(pq.peek()<i){
                  pq.poll();
                  pq.add(i);
              }
          }
      }
      while(pq.size()>0){
          System.out.println(pq.poll());
      }
    }

}