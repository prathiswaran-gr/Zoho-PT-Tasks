class PrivateClass {
 
   //Private nested class
   protected class InnerDisplay {
      public void display() {
         System.out.println("Private inner class method called");
      }
   }
 
   void display() {
      System.out.println("Outer class (PrivateClass) method called");
      // Access the private inner class
      InnerDisplay innerDisplay = new InnerDisplay();
      innerDisplay.display();
   }
    public static void main(String args[]) {
      // Create object of the outer class (Display)
      PrivateClass object = new PrivateClass();
 
      // method invocation
      object.display();
   }
}
 
 
  

