import java.util.LinkedList;
import java.util.Objects;

public class PracticeHashMap<S,I> {


    public static class Item<S,I>{
        S key;
        I value;

        public Item(S key,I value){
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

    public int hash(S key){
        return key == null ? 0 : Math.abs(key.hashCode() % bucket.length);
    }
    public void put(S key, I value){
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

public I get(S key){
    int index = hash(key);

    if(bucket[index]==null){
        return null;
    }

    for(Item<S,I> item : bucket[index]){
        if(Objects.equals(item.key,key)){

            return item.value;
        }
    }
    return null;
}

public boolean containsKey(S key){
       return  this.get(key) != null;
}

//    remove

    public void remove(S key){
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


          for(Item<S,I> item  :list){
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

     PracticeHashMap hashMap2 = new PracticeHashMap();
        hashMap2.put(1, "OONLY NE");
        System.out.println(hashMap2.get(1));
    }


}

