package fantasy;
public class User{
    int id;
    String name;
    String email;
    String mobileNumber;
    boolean isVerified;
    Wallet wallet;
    public User(int id, String name, String email, String mobileNumber,Wallet wallet){
      this.id = id;
      this.name = name;
      this.email = email;
      this.mobileNumber = mobileNumber;
      this.isVerified = false;
      this.wallet = wallet;
    }
  }
