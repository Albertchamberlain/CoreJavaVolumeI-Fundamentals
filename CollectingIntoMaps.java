import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Amos
 * @date 9/9/2020 11:18 PM
 */
public class CollectingIntoMaps {
    public static class Person{
        private int id;
        private  String name;

        public int getId() {
            return id;
        }

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static Stream<Person> people(){
        return Stream.of(new Person(1001,"Amos"),new Person(1002,"Petter"),new Person(1003,"RR"));
    }

    public static void main(String[] args) {
        Map<Integer,String> idToName = people().collect(
                Collectors.toMap(Person::getId,Person::getName)
        );
        Map<Integer,Person> idToPerson = people().collect(
                Collectors.toMap(Person::getId, Function.identity())
        );
        System.out.println("idToPerson.getClass().getName()+idToPerson = " + idToPerson.getClass().getName()+idToPerson);

        idToPerson = people().collect(
                Collectors.toMap(Person::getId,Function.identity(),(existingValue,newValue)->{throw new IllegalStateException();},TreeMap::new)
        );
        System.out.println("idToPerson.getClass().getName()+idToPerson = " + idToPerson.getClass().getName()+idToPerson);

        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String,String> languageNames = availableLocales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        l->l.getDisplayLanguage(l),
                        (existingValue,newValue)->existingValue
                )
        );

        System.out.println("languageNames = " + languageNames);

        availableLocales = Stream.of(Locale.getAvailableLocales());

        Map<String,String> countryLanSet = availableLocales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l->Set.of(l.getDisplayLanguage()),
                        (a,b)->
                        {
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }));
        System.out.println("countryLanSet = " + countryLanSet);
    }
}
