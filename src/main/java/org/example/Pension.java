package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;
import org.example.user.*;

public class Pension
{
    //Preparing the System to write in our Database
    private static final String URL = "jdbc:sqlserver://162.19.246.106";
    private static final String USER = "sa";
    private static final String PASS = "securepassword123!";

    public static Connection getConnection() throws Exception
    {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(URL, USER, PASS);
        return con;
    }

    public static void main(String[] args) throws Exception
    {


        UserDao userDao = new UserDaoImpl();
        String menuChoice = "";

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            showMainMenu();
            //Preparing the system for input
            menuChoice = scanner.nextLine();
            System.out.println(menuChoice);
            if(menuChoice.equalsIgnoreCase("quit"))
            {
                break;
            }
            else if(menuChoice.equals("1"))
            {
                showSubMenuCustomer();
                menuChoice = scanner.nextLine();
                if(menuChoice.equals("1"))
                {
                    createNewCustomerInDB(userDao, scanner);
                }
                else if(menuChoice.equals("2"))
                {
                    List<User> users =printListOfUsersWithID(userDao);
                    System.out.println("Enter ID of the user you want to delete");


                    while (scanner.hasNextInt())
                    {
                        try
                        {
                            int userID = scanner.nextInt();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid ID");
                        }
                    }
                }
                else if(menuChoice.equals("3"))
                {


                }
                else if(menuChoice.equals("4"))
                {

                }

            }
        }


    }

    private static void showMainMenu()
    {
        //Show the menu.
        System.out.println("Welcome to Rosa´s Dog Pension ");
        System.out.println("Please select what type of query you have:");
        System.out.println("1. Customer");
        System.out.println("2. Dog");
        System.out.println("Type \"quit\" to exit.");
    }
    private static void showSubMenuCustomer()
    {
        System.out.println("Please select what type of query you have:");
        System.out.println("1. Add Customer");
        System.out.println("2. Delete Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Go back to main menu.");
    }
    private static void createNewCustomerInDB(UserDao userDao, Scanner scanner)
    {
        String status = "";
        User user = new User();
        System.out.println("Enter first name:");
        user.setFirstName(scanner.nextLine());

        System.out.println("Enter last name:");
        user.setLastName(scanner.nextLine());

        System.out.println("Enter Username:");
        user.setUserName(scanner.nextLine());

        System.out.println("Enter Adress:");
        user.setAdress(scanner.nextLine());

        System.out.println("Enter Postal Code:");
        user.setPostalCode(scanner.nextLine());

        System.out.println("Enter Phone Number:");
        user.setPhoneNo(scanner.nextLine());

        System.out.println("Enter CPR-Number:");
        user.setCprNumber(scanner.nextLine());

        System.out.println("Is the customer a employee? Press 1 for YES Press 2 for NO:");
        status = scanner.nextLine();
        if(status.equals("1"))
        {
            user.setEmployee(true);
        }
        else
        {
            user.setEmployee(false);
        }

        System.out.println("Is the customer CPR verified? Press 1 for YES Press 2 for NO:");
        status = scanner.nextLine();
        if(status.equals("1"))
        {
            user.setVerified(true);
        }
        else
        {
            user.setVerified(false);
        }

        try
        {
            userDao.createUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static List<User>  printListOfUsersWithID(UserDao userDao)
    {
        try
        {
            List<User> Users = userDao.getAllUsers();
            for (User u : Users)
            {
                System.out.println(u.getUserID() + " = " + u.getFirstName() + " " + u.getLastName());
            }
            return Users;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }



    }

}
