/**
 * @author Amos
 */
//定义一个方法，将Arraylist集合当做参数赋值给方法
//
import java.util.ArrayList;

public class Demo03ArrayListPrint {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("liu");
        list.add("zeng");
        list.add("chen");
        list.add("li");
        System.out.println(list);
        printArrayList(list);

        //返回值类型：只是进行打印而已，没有运算，没有结果，所以用void
    }
    public static void printArrayList(ArrayList<String> list){
        System.out.print("{");
        for (int i = 0; i <list.size(); i++) {
            String name= list.get(i);
        }
    }

}
