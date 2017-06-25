import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

class Flattener {

    public  List flatten(List deeplyNestedList){
        if(deeplyNestedList.isEmpty()){
            return new ArrayList();
        }
        else {
            ArrayList finalResult = new ArrayList();
            final Object first = deeplyNestedList.get(0); //get first object
            final List rest = deeplyNestedList.subList(1, deeplyNestedList.size()); // get all sub items

            if(first instanceof List){
                finalResult.addAll(flatten((List) first)); //coerce to List and recurse on List
            }
            else {
                finalResult.add(first);
            }

            finalResult.addAll(flatten(rest)); //recurse and flatten rest of objects
            return filterNulls(finalResult); //return result
        }
    }

    private final List filterNulls(List input){
         return (List) input.stream()
                .filter(item -> item != null)
                .collect(Collectors.toList());
    }

}
