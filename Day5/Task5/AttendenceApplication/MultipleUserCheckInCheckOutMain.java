package AttendenceApplication;
import redis.clients.jedis.Jedis;
import java.util.Scanner;

public class MultipleUserCheckInCheckOutMain{
    public static void punchInLogic (int numberOfUsers, User[] users, Jedis jedis){
        for (int i = 0; i < numberOfUsers; i++) {

            MultipleUserCheckIn checkInThread = new MultipleUserCheckIn(users[i], jedis);
            checkInThread.start();
        }
    }

    public static void punchOutLogic (int numberOfUsers, User[] users, Jedis jedis){
        for (int i = 0; i < numberOfUsers; i++) {
            MultipleUserCheckOut checkOutThread = new MultipleUserCheckOut(users[i], jedis);
            checkOutThread.start();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jedis jedis = new Jedis("localhost", 6379);

        System.out.print("Enter the number of users: ");
        int numberOfUsers = scanner.nextInt();
        User[] users = new User[numberOfUsers];
        for(int i = 0; i<numberOfUsers; i++){
            System.out.print("Enter the user id "+ (i+1) +" : ");
            users[i] = new User(scanner.next());
        }
        try{
            int choice;
            do{
                System.out.print("Enter your choice to check-in / check-out :\n 1. Check-in\n 2. Check-out\n 3. Quit\n");
                choice = scanner.nextInt();
                switch (choice){
                    case 1 :
                        punchInLogic( numberOfUsers,users,jedis);

                        break;
                    case 2:
                        punchOutLogic(numberOfUsers, users, jedis);

                        break;
                    default:
                        System.out.println("Quitting application");
                }
            } while(choice != 3);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            jedis.close();
        }
    }
}

