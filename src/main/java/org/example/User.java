package org.example;

public class User
{
    private int UserID;
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Adress;
    private String PostalCode;
    private String PhoneNo;
    private String CPRNumber;
    private Boolean IsEmployee;
    private Boolean IsVerified;

    public int getUserID()
    {
        return UserID;
    }

    public void setUserID(int userID)
    {
        UserID = userID;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String userName)
    {
        UserName = userName;
    }

    public String getAdress()
    {
        return Adress;
    }

    public void setAdress(String adress)
    {
        Adress = adress;
    }

    public String getPostalCode()
    {
        return PostalCode;
    }

    public void setPostalCode(String postalCode)
    {
        PostalCode = postalCode;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
    public String getCPRNumber() {
        return CPRNumber;
    }

    public void setCPRNumber(String CPRNumber) {
        this.CPRNumber = CPRNumber;
    }

    public Boolean getIsEmployee() {
        return IsEmployee;
    }

    public void setIsEmployee(Boolean IsEmployee) {
        IsEmployee = IsEmployee;
    }

    public Boolean getIsVerified()
    {
        return IsVerified;
    }

    public void setIsVerified(Boolean verified)
    {
        IsVerified = verified;
    }

}
