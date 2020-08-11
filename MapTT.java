import javabasestructure.Employee;

import java.util.HashMap;

/**
 * @author Amos
 * @date 8/11/2020 11:16 AM
 */
public class MapTT {
    public static void main(String[] args) {
        final HashMap<String, Employee> stringEmployeeHashMap = new HashMap<>();
        stringEmployeeHashMap.put("144-12-12",new Employee("Amt lee",12));
        stringEmployeeHashMap.put("324-1-6",new Employee("Amos tt",12));
        stringEmployeeHashMap.put("753-8-12",new Employee("Cat uu",12));
        stringEmployeeHashMap.put("935-12-21",new Employee("Dom pp",12));
        System.out.println(stringEmployeeHashMap);

        stringEmployeeHashMap.remove("753-8-12");

        stringEmployeeHashMap.put("935-12-21",new Employee("Tpm",13));

        System.out.println("stringEmployeeHashMap.get(\"753-8-12\") = " + stringEmployeeHashMap.get("753-8-12"));

        stringEmployeeHashMap.forEach((k,v)-> System.out.println("key ="+k+",value ="+v));
    }
}
