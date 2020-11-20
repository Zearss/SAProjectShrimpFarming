public class Account {
    private String firstname;
    private String lastname;
    private String tel;
    private String username;
    private String password;
    private  String address;
    public Account(String firstname,String lastname,String username,String password,String address,String tel){
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.lastname=lastname;
        this.tel=tel;
        this.password=password;
        this.address=address;
    }
    public Account(){
        this.username=null;
        this.password=null;
        this.firstname=null;
        this.lastname=null;
        this.tel=null;
        this.address=null;
    }
    public void setAccount(String firstname,String lastname,String username,String password,String address,String tel){
        this.username=username;
        this.password=password;
        this.firstname=firstname;
        this.lastname=lastname;
        this.tel=tel;
        this.password=password;
        this.address=address;
    }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() { return address; }

    public String getTel() { return tel; }

    @Override
    public String toString() {
        return "Account{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\''+
                 ", tel='" + tel + '\''+
                '}';
    }
}
