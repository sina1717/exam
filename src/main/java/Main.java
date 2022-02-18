import Entity.Account;
import repository.MyConnection;
import service.AccountService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static AccountService accountService;
    public static void main(String[] args) {
        accountService = new AccountService();
        Scanner scanner = new Scanner(System.in);
        boolean state =true ;
        while (state){
            System.out.println("1 : sign in \n 2 : sign up \n 3 : exit");
            int n = getNumber();
            switch (n){
                case 1 :
                    System.out.println("enter username :");
                    String username = scanner.nextLine();
                    System.out.println("enter password :");
                    String password = scanner.nextLine();
                    accountService.signIn(username,password);
                    break;
                case 2 :
                    System.out.println("enter a username :");
                    String user = scanner.nextLine();
                    System.out.println("enter a password :");
                    String pass = scanner.nextLine();
                    accountService.save(new Account(-1,user,pass));
                    break;
                case 3 :
                    state =false;
                    break;
                default:
                    System.out.println("enter number 1 or 2 or 3");
            }
        }

        try {
            MyConnection.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int getNumber(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                return scanner.nextInt();
            }catch (Exception e){
                System.out.println( "enter number !!!!");
            }
        }
    }

    private static void page(Account account){
        boolean state = true;
        while (state){
            System.out.println("1 : see posts \n 2 : add post \n 3 : add comment \n 4 : see comments \n ");
        }
    }
}
