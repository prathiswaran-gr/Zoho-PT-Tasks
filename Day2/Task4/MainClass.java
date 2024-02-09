public class MainClass {
    public static void main(String[] args) {
        Bank stateBankOfIndia = new SBI();
        Bank hdfc = new HDFC();

        System.out.println("ROI in SBI : "+ stateBankOfIndia.rateOfInterest());
        System.out.println("Minimum balance in SBI : "+ stateBankOfIndia.getMinimumBalanceInSavingsAccount());
        System.out.println("ROI in HDFC : "+ hdfc.rateOfInterest());
        System.out.println("Minimum balance in HDFC : "+ hdfc.getMinimumBalanceInSavingsAccount());


    }
}
