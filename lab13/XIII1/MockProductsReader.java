package Praticas.lab13.XIII1;

import java.util.ArrayList;
import java.util.List;

public class MockProductsReader implements ProductsReader {
    @Override
    public List<Product> getItems() {
        List<Product> products = new ArrayList<>();
        products.add(new Car("ZA11ZB", "Tesla, Grey, 2021", 100));
        products.add(new Van("AA22BB", "Chevrolet Chevy, 2020", 180));
        products.add(new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85));
        products.add(new Car("BB44ZB", "Ford Mustang, Red, 2021", 150));
        return products;
    }
}