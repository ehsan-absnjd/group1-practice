package group.tamrin;

public class Customer {
    private static int idGen=1;
    private int id;
    private int balance;
    private Toy[] toys = new Toy[10];
    private int toyind=0;

    public Customer( int balance) {
        this.balance=balance;
        this.id = idGen++;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }
    public void addToy(Toy toy){
        toys[toyind++]=toy;
    }
    public String getToyString(){
        String toystring="";
        for(int i=0; i<toyind;i++){
            toystring += toys[i].toString()+ "\n";
        }
        return toystring;
    }

}
