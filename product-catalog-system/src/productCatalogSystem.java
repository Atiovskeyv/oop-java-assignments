// This program demonstrates a product catalog system using separate classes for products and operations.
// It lists products, filters them by category, filters by price range, and calculates total stock value.

class Product{
    public String name;
    public String category;
    public double price;
    public int stock;

    Product(String name, String category, double price, int stock){
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}

class Operations{

    void list(ArrayList<Product> list){
        for(Product p : list){
            IO.println("Product name: " + p.name +
                    ", Category: " + p.category +
                    ", Price: " + p.price +
                    ", Stock: " + p.stock);
        }
    }

    void filterByCategory(ArrayList<Product> list, String category){
        for (int i = 0 ; i < list.size() ; i++){
            if (list.get(i).category.equals(category)){
                IO.println("   " + list.get(i).name + " " + list.get(i).category);
            }
        }
        IO.println();
    }

    void filterByPriceRange(ArrayList<Product> list, double min, double max){
        for (int i = 0 ; i < list.size() ; i++){
            if(list.get(i).price >= min && list.get(i).price <= max){
                IO.println("  Product in range: " + list.get(i).name + " " + list.get(i).category);
            }
        }
        IO.println();
    }

    void calculateStockValue(ArrayList<Product> list){
        double total = 0;
        for (int i = 0 ; i < list.size() ; i++){
            total += list.get(i).price * list.get(i).stock;
        }
        IO.println("Total Stock Value: " + total);
    }
}

void main(){
    ArrayList<Product> catalog = new ArrayList<>();
    catalog.add(new Product("Tshirt","Clothing",859,74));
    catalog.add(new Product("Banana","Food",128,270));
    catalog.add(new Product("Jacket","Clothing",12499.99,9));
    catalog.add(new Product("Shower Gel","Hygiene",399,145));
    catalog.add(new Product("RAM","Electronics",6999.99,484));

    Operations op = new Operations();
    op.list(catalog);
    op.filterByCategory(catalog, "Clothing");
    op.filterByPriceRange(catalog, 500, 1500);
    op.calculateStockValue(catalog);
}