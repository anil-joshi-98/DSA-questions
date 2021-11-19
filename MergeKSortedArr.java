import java.io.*;
import java.util.*;

public class MergeKSortedArr {
  public static class Pair implements Comparable<Pair>{
     private int ai;
     private int ci;
     private int val;
     public Pair(int ai,int ci,int val){
         this.ai=ai;
         this.ci=ci;
         this.val=val;
     }
     public int compareTo(Pair a){
         return this.val-a.val;
     }
  }
  public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
    ArrayList<Integer> rv = new ArrayList<>();
    PriorityQueue<Pair> pq=new PriorityQueue<>();
    for(int i=0;i<lists.size();i++){
        pq.add(new Pair(i,0,lists.get(i).get(0)));
    }
    while(pq.size()>0){
        Pair p=pq.remove();
        rv.add(p.val);
        p.ci++;
        if(lists.get(p.ai).size()>p.ci){
            p.val=lists.get(p.ai).get(p.ci);
            pq.add(p);
        }
    }
    return rv;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ArrayList<Integer> list = new ArrayList<>();

      int n = Integer.parseInt(br.readLine());
      String[] elements = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        list.add(Integer.parseInt(elements[j]));
      }

      lists.add(list);
    }

    ArrayList<Integer> mlist = mergeKSortedLists(lists);
    for (int val : mlist) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

}