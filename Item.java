import java.util.Objects;

/**
 * @author Amos
 * @date 8/10/2020 10:36 PM
 */
public class Item  implements Comparable<Item>{
    private  String description;
    private  int partNumber;

    public Item(String ade,int apartNumber){
        description = ade;
        partNumber = apartNumber;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return "{}";
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }


    @Override
    public boolean equals(Object otherOb){
        if(this ==otherOb){
            return true;
        }
        if(otherOb ==null){
            return false;
        }
        if(getClass() !=otherOb.getClass()){
            return false;
        }
        final Item otherOb1 = (Item) otherOb;
        return Objects.equals(description,otherOb1.description) && partNumber == otherOb1.partNumber;
    }

    @Override
    public int hashCode(){
        return Objects.hash(description,partNumber);
    }


    public int CompareTo(Item other){
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff != 0 ?diff: description.compareTo(other.description);
    }
}
