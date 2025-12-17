package Praticas.lab12.ex1;
import java.util.*;

public class SortByPrice implements SortStratergy {
    @Override
    public void sort(List<Mobile> list) {
        System.out.println("Sorting by Price (Low to High): ");
        list.sort(Comparator.comparingDouble(Mobile::getPrice));
    }
}
