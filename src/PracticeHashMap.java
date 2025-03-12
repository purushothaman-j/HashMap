import java.util.LinkedList;
import java.util.Objects;

public class PracticeHashMap {


    public static class Item{
        String key;
        Integer value;

        public Item(String key,Integer value){
            this.key=key;
            this.value=value;
        }
    }

     public  LinkedList<Item>[] bucket;
     public int INITIAL_CAPACITY = 2;
    int size = 0;
    public PracticeHashMap(){
        bucket = new LinkedList[INITIAL_CAPACITY];
    }

    public int hash(String key){
        return key == null ? 0 : Math.abs(key.hashCode() % bucket.length);
    }
    public void put(String key, Integer value){
    System.out.println("size "+ this.size);
        System.out.println("bucket length: "+ this.bucket.length);
        System.out.println(key+ " " +value);

        int index = hash(key);

        if(bucket[index]==null){
            bucket[index] = new LinkedList<>();
            bucket[index].add(new Item(key,value));
            this.size++;
            return;
        }
        for(Item item : bucket[index]){
            if(Objects.equals(item.key,key)){
                item.value = value;
                return;
            }
        }
       // System.out.println(bucket[index].length);
        bucket[index].add(new Item(key,value));
        this.size++;

        if(this.size  > bucket.length * 2){
            resize();
        }

return;
    }

public Integer get(String key){
    int index = hash(key);

    if(bucket[index]==null){
        return null;
    }

    for(Item item : bucket[index]){
        if(Objects.equals(item.key,key)){

            return item.value;
        }
    }
    return null;
}

public boolean containsKey(String key){
       return  this.get(key) != null;
}

//    remove

    public void remove(String key){
        int index = hash(key);

        if(bucket[index]==null){
            return;
        }
      bucket[index].removeIf(item -> Objects.equals(item.key,key));
        this.size--;

    }

//            resize

    public void resize(){
        System.out.println("resize happening");
        LinkedList<Item>[] oldBucket = bucket;
      this.bucket = new LinkedList[oldBucket.length * 2];
      this.size=0;
      for( LinkedList<Item> list : oldBucket){
          if(list != null){


          for(Item item  :list){
              this.put(item.key, item.value);
          }
          }
      }
    }

//    size


//
    public static void main(String[] args){
        System.out.println("hello, welcome!");

        PracticeHashMap hashMap1 = new PracticeHashMap();
        hashMap1.put("One",1);
        hashMap1.put("Two",1);
        hashMap1.put("Three",1);
        hashMap1.put("Four",1);
        hashMap1.put("Five",55);
        hashMap1.put("Six",1);
       System.out.println(hashMap1.get("Five")+ "" + hashMap1.containsKey("One")+ "" +hashMap1.containsKey("Two"));

   //  PracticeHashMap hashMap2 = new PracticeHashMap();
     //   hashMap2.put(1, "ONE");
    }


}

