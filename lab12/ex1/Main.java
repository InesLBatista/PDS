package Praticas.lab12.ex1;

public class Main {
    public static void main(String[] args) {

        MobileList list = new MobileList();
        list.add(new Mobile("Samsung", 900, 128, 50));
        list.add(new Mobile("Apple", 1300, 256, 48));
        list.add(new Mobile("Xiaomi", 400, 128, 64));

        list.setStrategy(new SortByBrand());
        list.sort();
        list.show();

        list.setStrategy(new SortByPrice());
        list.sort();
        list.show();
    }
}
