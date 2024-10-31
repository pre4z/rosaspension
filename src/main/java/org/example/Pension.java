package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;
import org.example.user.*;

public class Pension
{
    /**
     * Preparing the System to write in our Database
     */
    private static final String URL = "jdbc:sqlserver://162.19.246.106";
    private static final String USER = "sa";
    private static final String PASS = "securepassword123!";



    /**
     * Establish connection to the DB.
     * @return
     * @throws Exception
     */
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
            /**
             * Show the Menu in the console.
             */
            showMainMenu();
            /**
             * Preparing the system for input, and getting User input, using our methods to gain full CRUD for User.
             */
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
                    printListOfUsersWithID(userDao);
                    System.out.println("Enter ID of the user you want to delete");


                    while (scanner.hasNextInt())
                    {
                        try
                        {
                            int userID = scanner.nextInt();

                            userDao.deleteUsers(userID);
                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid ID");
                        }
                    }
                }
                else if(menuChoice.equals("3"))
                {
                    printListOfUsersWithID(userDao);

                    System.out.println("Enter ID of the user you want to update");


                    while (scanner.hasNextInt())
                    {
                        try
                        {
                            int userID = scanner.nextInt();

                            updateUserPrompt(userDao, scanner, userID);

                            break;
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid ID");
                        }
                    }
                }
                else if(menuChoice.equals("4"))
                {

                }

            }
        }


    }

    /**
     * Method to show the Main Menu to the user.
     */
    private static void showMainMenu()
    {
        System.out.println("Welcome to Rosa´s Dog Pension ");
        System.out.println("Please select what type of query you have:");
        System.out.println("1. Customer");
        System.out.println("2. Dog");
        System.out.println("Type \"quit\" to exit.");
    }

    /**
     * Method to print the Sub Menu after the first choice.
     */
    private static void showSubMenuCustomer()
    {
        System.out.println("Please select what type of query you have:");
        System.out.println("1. Add Customer");
        System.out.println("2. Delete Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Go back to main menu.");
    }

    /**
     * Method to Create a user through DAO.
     * @param userDao
     * @param scanner
     */
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

    /**
     * Method to print list of users in our DB, uses DAO.
     * @param userDao
     */
    private static void printListOfUsersWithID(UserDao userDao)
    {
        try
        {
            List<User> Users = userDao.getAllUsers();
            for (User u : Users)
            {
                System.out.println(u.getUserID() + " = " + u.getFirstName() + " " + u.getLastName());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to update the user entries in our DB.
     * @param userDao
     * @param scanner
     * @param userID
     */
    private static void updateUserPrompt (UserDao userDao, Scanner scanner, int userID)
    {
        try
        {
            scanner = new Scanner(System.in);
            String newValue = "";
            User user = userDao.getUserByID(userID);
            System.out.println("The user chosen is: " + user.getFirstName());
            System.out.println("Enter new name or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setFirstName(newValue);
                newValue = "";
            }

            System.out.println("The lastname of the chosen user is: " + user.getLastName());
            System.out.println("Enter new lastname or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setLastName(newValue);
                newValue = "";
            }

            System.out.println("The username of the chosen user is:" + user.getUserName());
            System.out.println("Enter new username or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setUserName(newValue);
                newValue = "";
            }

            System.out.println("The adress of the chosen user is:" + user.getAdress());
            System.out.println("Enter new adress or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setAdress(newValue);
                newValue = "";
            }

            System.out.println("The postalcode of the chosen user is:" + user.getPostalCode());
            System.out.println("Enter new postalcode or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setPostalCode(newValue);
                newValue = "";
            }

            System.out.println("The phonenumber of the chosen user is:" + user.getPhoneNo());
            System.out.println("Enter new phonenumber or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setPhoneNo(newValue);
                newValue = "";
            }

            System.out.println("The CPR-number of the chosen user is:" + user.getCprNumber());
            System.out.println("Enter new CPR-number or leave empty to keep as is");

            newValue = scanner.nextLine();
            if (!newValue.isEmpty())
            {
                user.setCprNumber(newValue);
                newValue = "";
            }


            System.out.println("Do you want to change the employment status? Current status is:" + user.getEmployee());
            System.out.println("If you want to change PRESS 1 - PRESS 2 to keep as is");

            newValue = scanner.nextLine();
            if (newValue.equals("1"))
            {
                user.setEmployee(!user.getEmployee());
                newValue = "";
            }

            userDao.updateUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
