import java.io.*;
import java.util.*;

public class PriorityQ {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public void heapify(int index){
        int ind=index/2;
        if(index==ind){
            return;
        }
        if(data.get(index)<data.get(ind)){
            swap(index,ind);
            heapify(ind);
        }
        else {
            return;
        }
    }
    public void swap(int i1,int i2){
        int temp=data.get(i1);
        data.set(i1,data.get(i2));
        data.set(i2,temp);
    }
    
    public void add(int val) {
      data.add(val);
      int index=data.size()-1;
      heapify(index);
    }

    public int remove() {
        if(data.size()==0){
            System.out.println("Underflow");
            return -1;
        }
        heapify(data.size()-1);
      return data.remove(0);
    }

    public int peek() {
        if(data.size()==0){
            System.out.println("Underflow");
            return -1;
        }
      return data.get(0);
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}