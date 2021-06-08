public class Admin extends User {
private boolean isadmin ;
public  Admin (String name , int phone , boolean isadmin){
 super(name, phone);
}

public boolean GetAdmin(){return isadmin;}

}