package org.example.user;

/**
 * Preparing the class "User" for later use in the program.
 */
public class User
{
    private int userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String adress;
    private String postalCode;
    private String phoneNo;
    private String cprNumber;
    private Boolean isEmployee;
    private Boolean isVerified;

    /**
     * Constructor with all the variables we need to gain full CRUD
     * @return
     */
    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getCprNumber()
    {
        return cprNumber;
    }

    public void setCprNumber(String cprNumber)
    {
        this.cprNumber = cprNumber;
    }

    public Boolean getEmployee()
    {
        return isEmployee;
    }

    public void setEmployee(Boolean employee)
    {
        isEmployee = employee;
    }

    public Boolean getVerified()
    {
        return isVerified;
    }

    public void setVerified(Boolean verified)
    {
        isVerified = verified;
    }

    /**
     *  Empty constructor, so we can create an instance of the class without the variables.
     */
    public User()
    {

    }

}
