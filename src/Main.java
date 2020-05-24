public class Main {

    public static void main(String[] args){

        Customer customer = new Customer("Shima", 23.54);
        Customer anotherCustomer = customer;
        anotherCustomer.setBalance(12.8);
        System.out.println("Blanace for customer " + customer.getName() + " is " + customer.getBalance());

    }
}
