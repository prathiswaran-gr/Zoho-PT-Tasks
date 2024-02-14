public class BasicHashCodeExample {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";

        // Print the default hash codes
        System.out.println("Hash code of str1: " + str1.hashCode());
        System.out.println("Hash code of str2: " + str2.hashCode());

        // Check if hash codes are different (likely to be true)
        if (str1.hashCode() != str2.hashCode()) {
            System.out.println("str1 and str2 have different hash codes.");
        }
    }
}
