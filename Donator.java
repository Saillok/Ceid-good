import java.util.ArrayList;
public class Donator extends User {
private Offers offersList;

public Donator(String name , int phone){
    super(name,phone);
}
    
public void add(RequestDonation x,Organization y) throws CustomException {
    offersList.add(x,y);
}

public void modify(int i, double y){
    offersList.modify(i,y);
}

public void remove(RequestDonation x){
    offersList.remove(x);
}

public void commit(Organization y) throws CustomException {
    offersList.commit(y);
}

public void show(){
    offersList.show();
}

public int size(){
    return offersList.getSize();
}

public void clear(){
    offersList.clear();
}
public RequestDonation getDonation(int i){
    return offersList.getDonation(i);
}

public boolean GetAdmin(){return false;}
}