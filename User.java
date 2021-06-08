public abstract class User{
private String name ;
private int phone ;
public User (String name , int phone ){
this.name = name ;
this.phone= phone;
} 
public String GetName(){return name;}
public int GetPhone(){return phone;}
public abstract boolean GetAdmin();

    

}