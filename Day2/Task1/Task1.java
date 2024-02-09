public class Task1 {
    public static void main(String[] args) {
        float number = 4.5f;
        Integer floatToInt = Float.valueOf(number).intValue();
        Double floatToDouble = Float.valueOf(number).doubleValue();
        System.out.println("Float value converted into Int : "+floatToInt);
        System.out.println("Float value converted into Double : "+floatToDouble);
    }
}   
