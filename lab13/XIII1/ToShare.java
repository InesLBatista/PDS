package Praticas.lab13.XIII1;


import java.util.*;

public class ToShare implements Iterable<Product> {
    private List<Product> products;
    private Map<String, Client> shared;
    
    public ToShare() {
        products = new ArrayList<>();
        shared = new HashMap<>();
    }
    
    public boolean add(Product p) {
        if (p == null || getProductByCode(p.getCode()) != null) {
            return false;
        }
        products.add(p);
        return true;
    }
    
    public Product remove(String code) {
        Product p = getProductByCode(code);
        if (p != null && !shared.containsKey(code)) {
            products.remove(p);
            return p;
        }
        return null;
    }
    
    public boolean share(String code, Client user) {
        Product p = getProductByCode(code);
        if (p != null && !shared.containsKey(code)) {
            shared.put(code, user);
            return true;
        }
        return false;
    }
    
    public boolean share(Product p, Client user) {
        return share(p.getCode(), user);
    }
    
    public boolean giveBack(String code) {
        if (shared.containsKey(code)) {
            shared.remove(code);
            return true;
        }
        return false;
    }
    
    public boolean giveBack(Product p) {
        return giveBack(p.getCode());
    }
    
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
    
    public String sharedProducts() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total : ").append(shared.size()).append("\n");
        for (Map.Entry<String, Client> entry : shared.entrySet()) {
            Product p = getProductByCode(entry.getKey());
            sb.append("\t").append(p.getClass().getSimpleName())
              .append(" ").append(p.getCode())
              .append(" shared with ").append(entry.getValue())
              .append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
    
    private Product getProductByCode(String code) {
        for (Product p : products) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }
}