import java.util.ArrayList;
import java.util.Arrays;

public class RequestDonationList 
{
   private  ArrayList<RequestDonation> rdEntities = new ArrayList<RequestDonation>();
   private int i=0;
   
   public RequestDonation get(int x){
       
       RequestDonation result =null ;
       try{
       for (i=0; i< rdEntities.size();i++){
           if(rdEntities.get(i).getEntity().getID()==x){
            result= rdEntities.get(i);
 }
}
 

}catch(NullPointerException e){
System.out.println("No request of such Entity exists");
}
return result;
}

public void add(RequestDonation x, Organization y)  throws CustomException {
    boolean exists = false;
    boolean alreadyRequested = false;
    for(int i=0;i<y.EntityListSize();i++){
        if(x.getEntity().getName()==y.getEntityInList(i).getName())
        exists = true;
    }
    if (exists==false)
    throw new CustomException("This entity is not provided by the organization");
    
    for (i=0; i< rdEntities.size();i++){
          if( x.getEntity()==rdEntities.get(i).getEntity()){
          rdEntities.set(i, x);
          alreadyRequested = true;
        }
 }
 
 if(alreadyRequested == false)
 rdEntities.add(x);
}

public void remove(RequestDonation x)  {
    try{
       rdEntities.remove(x); 
}catch (Exception e){System.out.println("That entity does not exist ");}
}

public void modify(int i,double x){
    rdEntities.get(i).setQuantity(x);
}

public void monitor(){
    for(i=0;i<rdEntities.size();i++){
        System.out.println(i+rdEntities.get(i).getEntity().getName()+"   "+rdEntities.get(i).getQuantity());
    }
}

public void reset(){
   rdEntities.clear(); 
}



public RequestDonation getListObject(int i){
    return rdEntities.get(i);
}

public int getListSize(){
    return rdEntities.size();
}
}

