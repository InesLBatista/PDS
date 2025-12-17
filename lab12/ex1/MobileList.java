package Praticas.lab12.ex1;
import java.util.*;

public class MobileList {
    private List<Mobile> phones = new ArrayList<>();
    private SortStratergy stratergy;

    public void add(Mobile mobile) {
        phones.add(mobile);
    }

    public void setStrategy(SortStratergy stratergy) {
        this.stratergy=stratergy;
    }

    public void sort() {
        if (stratergy == null) {
            System.out.println("No stratergy selected");
            return;
        }

        stratergy.sort(phones);
    }


    public void show() {
        phones.forEach(System.out::println);
    }
}
