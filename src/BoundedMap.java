import java.util.HashMap;
import java.util.Map;

public class BoundedMap extends HashMap<Integer, String> {
    private final int capacity;



    public BoundedMap(int capacity){
        if(this.isEmpty())
            this.put(1,"initial");
        this.capacity = capacity;
        if(capacity < 1)
            capacity = 1;



    }

    @Override
    public String remove(Object o) {
        for(Entry<Integer, String> entry: entrySet()){
            if(entry.getKey() == o.hashCode()){
                if(entrySet().contains(entry)){
                    entrySet().remove(entry);
                    return entry.getValue();
                }

            }

        };
        return super.remove(o);
    }

    @Override
    public String put(Integer integer, String s) {
        for(int i = 0; i < capacity; i++)
        {

        }


        return super.put(integer, s);
    }

    @Override
    public void clear() {
        super.clear();
    }
}
