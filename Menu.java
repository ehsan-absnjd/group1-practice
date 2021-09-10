package group.tamrin;

import java.util.Locale;
import java.util.Random;

public class Menu {
    Printer printer = new Printer();
    ConsoleScanner scanner = new ConsoleScanner();
    private Toy[] toys =  new Toy[100];
    private int toysIndex = 0;
    private Customer[] customers = new Customer[10];

    {
        Random rn = new Random();

        for (int i = 0; i < 10; i++) {
            customers[i] = new Customer(rn.nextInt(1000) * 1000);
        }
    }

    public void execute() {

        int command;
        do {
            printer.print("enter your command: 1=add toy 2= add ciscount 3=buy toy 4= get toys list 5= get toys by customer 6=get customer balance 7= exit ");
            command = scanner.getInt();
            switch (command) {
                case 1:
                    addToy();
                    break;
                case 2:
                    addDiscount();
                    break;
                case 3:
                    buyToy();
                    break;
                case 4:
                    getToyList();
                    break;
                case 5:
                    getToysByCustomer();
                    break;
                case 6:
                    getBalance();
                    break;
                case 7:
                    printer.print("bye");
                    break;
                default:
                    printer.print("wrong input");

            }
        } while (command != 7);
    }


    private void addToy() {
        printer.print("enter base price");
        int bp = scanner.getInt();
        printer.print("enter size");
        String sizestr = scanner.getString();
        Size size = Size.valueOf(sizestr.toUpperCase());
        printer.print("enter quantity in stock");
        int quan = scanner.getInt();
        toys[toysIndex++] = new Toy(bp, 0, size, quan);
    }

    public void addDiscount() {
        printer.print("enter id for toy");
        int id = scanner.getInt();
        printer.print("add discount %");
        int discount = scanner.getInt();
        toys[id - 1].setDiscount(discount);
    }

    public void buyToy() {
        printer.print("customer id: ");
        int cusid = scanner.getInt();
        printer.print("toy id");
        int toyid = scanner.getInt();
        Customer cs = customers[cusid - 1];
        Toy toy = toys[toyid - 1];
        int cusbal = cs.getBalance();
        int toyprice = toy.getNetPrice();
        if(toy.getQuantity() <1){
            printer.print("sorry we're out of stock");
        }
        if (toyprice > cusbal ){
            printer.print("sorry customer is out of money");
        }
        if (toy.getQuantity() > 0 && toyprice <= cusbal) {
            cs.addToy(toy);
            cs.setBalance(cs.getBalance() - toyprice);
            toy.setQuantity(toy.getQuantity() - 1);
        }


    }

    private void getToyList() {
        for (int i = 0; i < toysIndex; i++) {
            printer.print(toys[i].toString());
        }
    }

    private void getToysByCustomer() {
        printer.print("enter customer id");
        int id = scanner.getInt();
        Customer cs = customers[id - 1];
        printer.print(cs.getToyString());
    }

    private void getBalance() {
        printer.print("enter customer id");

        int id= scanner.getInt();
        printer.print( String.valueOf(customers[id-1].getBalance()));
    }
}
