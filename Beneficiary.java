import java.util.ArrayList;

public class Beneficiary extends User{
public int noPersons=1;
private ArrayList<Requests> requestsList = new ArrayList<Requests>();
private RequestDonationList recievedList;

public Beneficiary(String name , int phone , int noPersons ){
super(name,phone);
this.noPersons= noPersons;
}

public int getRequestsNumber(){
 return requestsList.size();   
}

public void addRequest(Requests r)throws CustomException{
    int i;
    boolean e=false;
    for(i=0;i<requestsList.size();i++){
        if(requestsList.get(i).getRequest().getEntity()==r.getRequest().getEntity())
        e=true;
    }
    if(e==true)
    throw new CustomException("You have already requested that Entity");
    requestsList.add(r);
}


public void modifyRequest(Requests r){
    int i;
    for(i=0;i<requestsList.size();i++){
        if(requestsList.get(i).getRequest().getEntity()==r.getRequest().getEntity())
        requestsList.remove(requestsList.get(i));
    }
    
    requestsList.add(r);
}

public int GetPersons(){return noPersons;}

public double getReceived(Entity e){
    int i;
    double received=0;
    for(i=0;i<requestsList.size();i++){
        if(requestsList.get(i).getRequest().getEntity()==e)
        received+=requestsList.get(i).getRequest().getQuantity();
    }
    return received;
}

public void addReceived(RequestDonation r,Organization y) throws CustomException {
    recievedList.add(r,y);
}

public void clearReceived(){
 recievedList.reset();   
}

public boolean GetAdmin(){
    return false;
}

public Requests getARequest(){
    return requestsList.get(0);
}
}
