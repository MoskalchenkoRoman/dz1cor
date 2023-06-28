package dz4;
import java.util.Random;

public class Main {
    static Customer[] customers = null;
    static Product[] products = null;
    static Customer.Gender male = Customer.Gender.мужчина;
    static Customer.Gender female = Customer.Gender.Женщина;
    static Product.Category standart = Product.Category.standard;
    static Product.Category premium = Product.Category.premium;

    enum Discount {zero(0), five(5), ten(10), fifteen(15), twenty(20);
        private int discount;
        Discount(int discount) {
            this.discount = discount;
        }
        public int getDiscount() {
            return discount;
        }
    }
    public static void main(String[] args) {

        customers = new Customer[]{
                new Customer("Ivan", "Semenov", 25, "+79604564444", male),
                new Customer("Petr", "Kolosov", 32, "+79604565432", male)
        };
        products = new Product[]{
                new Product("Milk", 100.5f, standart),
                new Product("Bread", 70.8f, standart),
                new Product("Meat", 1000, premium),
                new Product("Chocolate", 225.6f, premium),
                new Product("Tea", 300, standart),
        };

        Order[] orders = new Order[5];
        String[] phones = {"+79604564444", "+79604565432", "+79604564454", "+79604565432", "+79604564444"};
        String[] productTitles = {"Milk", "Water", "Meat", "Tea", "Chocolate"};
        int[] amounts = {4, 5, 101, 0, -1};

        int count = 0;
        for (int i = 0; i < 5; i++) {
            try {
                orders[i] = makePurchase(phones[i], productTitles[i], amounts[i]);
                count++;
            } catch (ProductException e) {
                System.out.println(e.getMessage());
            } catch (AmountException e) {
                orders[i] = makePurchase(phones[i], productTitles[i], 1);
                count++;
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Количество совершенных покупок: " + count);
    }
    public static Order makePurchase(String phone, String title, int amount) throws CustomerException, ProductException, AmountException{
        Customer customer = null;
        Product product = null;

        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {
                customer = c;
            }
        }
        for (Product p : products) {
            if (p.getTitle().equals(title)) {
                product = p;
            }
        }
        if (customer == null) {
            throw new CustomerException("Покупатель не найден");
        }
        if (product == null) {
            throw new ProductException("Товар не найден");
        }
        if ((amount > 100) || (amount < 1)) {
            throw new AmountException("Не корректное колличество");
        }
        int d = randomDiscount().getDiscount();
        float cost = product.getPrice() * amount;
        float newPrice = cost - (cost * d / 100);
        System.out.println("До скидки: " + cost + "руб" + " С учетом скидки - " + newPrice + "руб");
        return new Order(customer, product, amount, newPrice);
    }

    private static Discount randomDiscount() {
        int pick = new Random().nextInt(Discount.values().length);
        return Discount.values()[pick];
    }
}
