class Employee{  
 String id;  
 String firstName;
 String lastName;    
  
 Employee(String id, String fname, String lname){  
 this.id=id;  
 this.firstName=fname;
 this.lastName=lname;   
 }  
   
 public String toString(){//overriding the toString() method  
  return id+" "+firstName+lastName;  
 }  
 public static void main(String args[]){  
   Employee prathiswaran = new Employee("PT-7568","Prathis","waran");  
  
     
   System.out.println(prathiswaran); // if we print without override we will get an object notation in the console   
 }  
}  
