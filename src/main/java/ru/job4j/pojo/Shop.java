package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            /* проверяем, что объект не равен null. Т.к. у нас массив не заполнен целиком. */
            if (product != null) {
                System.out.println(product.getName());
            }
        }
        System.out.println(indexOfNull(products));
    }

    public static int indexOfNull(Product[] products) {
        int temp = -1;
        for (int i = 0; i < products.length; i++) {
            if(products[i] == null) {
                temp = i;
                break;
            }
        }
        return temp;
    }
}