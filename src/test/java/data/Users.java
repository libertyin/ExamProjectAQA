package data;

public enum Users {

    USER_POSITIVE("autotest.test1234@gmail.com", "qwertyui", "Ivan ", "Kurochkin1"),
    USER_NEGATIVE("autotest2.testgmail.com", "qwerty2", "Ivan ", "Kurochkin2");

    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;

    Users(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
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


}
