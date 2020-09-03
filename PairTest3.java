package javabasestructure;

/**
 * @author Amos
 * @date 8/9/2020 6:35 PM
 */
public class PairTest3 {
    public static void main(String[] args) {
        final Manager tom = new Manager("Tom", 800000, 2003, 12, 2);
        final Manager Vom = new Manager("Vm", 800000, 2003, 12, 2);
        final Pair<Manager> managerPair = new Pair<>(tom, Vom);


    }


    public static  void printBuddy(Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println("second.getName()t = " + second.getName());
        System.out.println("first.getgetName = " + first.getName());
    }

    public static void minmaxBonus(Manager[] managers,Pair<? super Manager> result){
        if(managers.length ==0){
            return;
        }
        Manager min = managers[0];
        Manager max = managers[0];

        for (int i = 1; i <managers.length ; i++) {
            if(min.getBonus()>managers[i].getBonus()){
                min = managers[i];
            }
            if(max.getBonus()<managers[i].getBonus()){
                max= managers[i];
            }
            result.setFirst(min);
            result.setSecond(max);
        }
    }
}

class PairAlg{
    public static boolean hasulls(Pair<?> p){
        return p.getFirst()==null || p.getSecond() ==null;
    }

    public static void swap(Pair<?> p){
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p){
        T t =p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
