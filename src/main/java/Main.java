import Entity.Account;
import Entity.Comment;
import Entity.Post;
import repository.MyConnection;
import service.AccountService;
import service.CommentService;
import service.PostService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static AccountService accountService;
    private static PostService postService;
    private static CommentService commentService;
    public static void main(String[] args) {
        accountService = new AccountService();
        postService = new PostService();
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
                    page(accountService.signIn(username,password));
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
        Scanner scanner = new Scanner(System.in);
        while (state){
            System.out.println("1 : see posts \n 2 : add post \n 3 : add comment \n 4 : see comments \n 5 : exit");
            int n =getNumber();
            switch (n) {
                case 1 :
                    List<Post> postList = postService.findAll();
                    System.out.println(postList);
                    break;
                case 2 :
                    System.out.println("enter text :");
                    String description = scanner.nextLine();
                    postService.save(new Post(-1,account,description));
                    break;
                case 3 :
                    System.out.println("enter post id :");
                    int id = getNumber();
                    System.out.println("enter comment text :");
                    String text = scanner.nextLine();
                    commentService.save(new Comment(-1,account,new Post(id,null,null),text));
                    break;
                case 4 :
                    System.out.println("enter post id :");
                    int postId = getNumber();
                    List<Comment> commentList = commentService.findCommentByPost(postService.findById(postId));
                    System.out.println(commentList);
                    break;
                case 5 :
                    state = false;
                    break;
                default:
                    System.out.println("enter correct number");
            }

        }
    }
}
