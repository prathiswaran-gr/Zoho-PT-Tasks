public abstract class Bank {

    Bank(){
        System.out.println("Constructor called!!");
    }
    void helper(){
        System.out.println("We can create a method with body inside the abstract class (without specifiying the keyword abstract)");
    }
    abstract int rateOfInterest(); // those method body should be implemented in the inherited class
    abstract int getMinimumBalanceInSavingsAccount(); // those method body should be implemented in the inherited class
}
