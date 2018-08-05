import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomSet<T> {
    private HashMap<Integer, T> elements;

    public CustomSet(List<T> input){
        this.elements = new HashMap<>();
        for(T element : input){
            add(element);
        }
    }

    public void add(T value){
        if(!contains(value)){
            this.elements.put(value.hashCode(), value);
        }
    }

    public boolean contains(T value){
        return this.elements.containsKey(value.hashCode());
    }

    public boolean isEmpty(){
        return this.elements.isEmpty();
    }

    public boolean isSubset(CustomSet<T> otherSet){
        for(Map.Entry<Integer, T> entry : otherSet.elements.entrySet()){
            if(!contains(entry.getValue())){
                return false;
            }
        }
        return true;
    }

    public boolean isDisjoint(CustomSet<T> otherSet){
        for(Map.Entry<Integer, T> entry : otherSet.elements.entrySet()){
            if(contains(entry.getValue())){
                return false;
            }
        }
        return true;
    }

    public CustomSet<T> getUnion(CustomSet<T> otherSet){
        List<T> values = new LinkedList<>(this.elements.values());
        values.addAll(otherSet.elements.values());
        return new CustomSet<T>(values);
    }

    public CustomSet<T>getIntersection(CustomSet<T> otherSet){
        List<T> values = new LinkedList<>();

        this.elements.forEach((element, val) -> {
            if(otherSet.contains(val)){
                values.add(val);
            }
        });
        return new CustomSet<T>(values);
    }

    public CustomSet<T>getDifference(CustomSet<T> otherSet){
        List<T> values = new LinkedList<>();

        this.elements.forEach((element, val) -> {
            if(!otherSet.contains(val)){
                values.add(val);
            }
        });
        return new CustomSet<T>(values);
    }

    public boolean equals(Object other){
        if (other instanceof CustomSet<?>){
            if (((CustomSet<?>)other).elements.keySet().equals(elements.keySet())){
                return true;
            }
        }
        return false;
    }

}
