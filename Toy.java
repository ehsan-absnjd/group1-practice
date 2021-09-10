package group.tamrin;

public class Toy {
    private static int idGen=1;
    private int id;
    private int basePrice;
    private int discount;
    private Size toySize;
    private int quantity;
    public Toy(int basePrice, int discount , Size size,int quantity) {
        this.basePrice = basePrice;
        this.discount = discount;
        this.toySize = size;
        id= idGen++;
        System.out.println("toy created with id:" + id);
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNetPrice(){
        return (int) ((double)basePrice*(100-discount)/100);
    }
    public void setDiscount(int discount){
        this.discount=discount;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", basePrice=" + basePrice +
                ", discount=" + discount +
                ", toySize=" + toySize +
                ", quantity=" + quantity +
                '}';
    }
}


enum Size {
    SMALL,MEDIUM,LARGE
}
