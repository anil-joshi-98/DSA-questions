import java.io.*;
import java.util.*;

public class HashMapCode {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() throws Exception {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) throws Exception{
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      int di=hashFun(key);
      int index=findIndex(key,di);
      if(index==-1){
          HMNode hm=new HMNode(key,value);
          buckets[di].add(hm);
          size++;
      }
      else{
          buckets[di].get(index).value=value;
      }
      double lambda = (double)(size) / buckets.length;
      if (lambda > 2.0) {
        rehash();
      }
    }

    public int hashFun(K key){
        int code=key.hashCode();
        return Math.abs(code%buckets.length);
    }
    
    private int findIndex(K key,int index){
        int i=0;
        for(HMNode node:buckets[index]){
            if(key.equals(node.key)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public V get(K key) throws Exception {
        int index=findIndex(key,hashFun(key));
      if(index==-1){
          return null;
      }
      return buckets[hashFun(key)].get(index).value;
    }

    public boolean containsKey(K key) throws Exception {
      if(findIndex(key,hashFun(key))==-1){
          return false;
      }
      return true;
    }

    public V remove(K key) throws Exception {
      int index=findIndex(key,hashFun(key));
      if(index==-1){
          return null;
      }
      HMNode nm=buckets[hashFun(key)].remove(index);
      size--;
      return nm.value;
    }
    
    private void rehash() throws Exception {
      LinkedList<HMNode>[] oba = buckets;
      initbuckets(2 * oba.length);
      size = 0;

      for (int bi = 0; bi < oba.length; bi++) {
        for (HMNode onode : oba[bi]) {
          put(onode.key, onode.value);
        }
      }
    }
    
    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> ar=new ArrayList<>();
      for(LinkedList<HMNode> ll:buckets){
          for(HMNode hm:ll){
              ar.add(hm.key);
          }
      }
      return ar;
    }

    public int size() {
      return size;
    }

    public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
    }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}