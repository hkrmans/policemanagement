package sample;

public class StandardUser extends Account {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int SSN;
    private int phoneNumber;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public StandardUser(int accountNumber, String username, String password, String firstName, String lastName, int SSN, int phoneNumber) {
        super(accountNumber);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.phoneNumber = phoneNumber;
    }
}
