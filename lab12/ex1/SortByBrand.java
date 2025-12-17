package Praticas.lab12.ex1;
import java.util.*;

public class SortByBrand implements SortStratergy {
    @Override
    public void sort(List<Mobile> list) {
        System.out.println("Sorting by Brand (A to Z): ");
        list.sort(Comparator.comparing(Mobile::getBrand));
    }
}
