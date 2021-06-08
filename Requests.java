
public class Requests extends RequestDonationList
{
   private RequestDonation request ;
   
   public Requests(RequestDonation x){
       request = x;
    }
    
   public boolean validRequestDonation( Beneficiary b,Organization y, RequestDonation r){
        if(this.getRequest().getEntity().getDetails()=="Service")
        return true;
        
        try{
        double a = this.getRequest().getQuantity();
        double c = this.getRequest().getEntity().getLevel(b.GetPersons());
        double d = b.getReceived(this.getRequest().getEntity());
    
        
        if(a>c)
        return false;
        if(a+d>c)
        return false;
        else 
        return true;
        }catch(Exception e){System.out.println("something went wrong");}
        return true;
    }
    
    public void add(Organization y, Beneficiary b) throws CustomException{
        boolean stock = false;
        int i =0;
        RequestDonation r=this.getRequest();
        
        for(i=0;i<b.getRequestsNumber();i++){
           if(super.getListObject(i).getEntity()==this.getRequest().getEntity()&&super.getListObject(i).getQuantity()>=this.getRequest().getQuantity())
           stock=true;
        }
        
        if(!validRequestDonation(b,y,r))
        throw new CustomException("You have requested more Enities than you have a right to");
        if(!stock)
        throw new CustomException("There are not enough entities to fulfill you request");
                
        
        b.addRequest(this);
        
    }
    
    public void modify(Beneficiary b, Organization y) throws CustomException {
        boolean stock = false;
        int i =0;
        RequestDonation r=this.getRequest();
        
        for(i=0;i<b.getRequestsNumber();i++){
           if(super.getListObject(i).getEntity()==this.getRequest().getEntity()&&super.getListObject(i).getQuantity()>=this.getRequest().getQuantity())
           stock=true;
        }
        
        if(!validRequestDonation(b,y,r))
        throw new CustomException("You have requested more Enities than you have a right to");
        if(!stock)
        throw new CustomException("There are not enough entities to fulfill you request");
                
        
        b.modifyRequest(this);
    }
    
    public RequestDonation getRequest(){
        return request;
    }
    
    public void commit(Beneficiary e, Organization y)throws CustomException{
        int i,j;
        boolean a,b ;
        for(i=0;i<getListSize();i++){
        a=false;
        b=false;
        for(j=0;j<y.getCurrentDonations().getListSize();j++){
            if(super.getListObject(i).getEntity()==y.getCurrentDonations().getListObject(j).getEntity()&&super.getListObject(i).getQuantity()<=y.getCurrentDonations().getListObject(j).getQuantity())
            a=true;
        }
        if(validRequestDonation(e,y,super.getListObject(i)))
        b=true;
        
        if(!a)
        throw new CustomException("The amount of "+this.getListObject(i).getEntity().getName()+" requested is not available");
        if(!b)
        throw new CustomException("You are not entitled to that amount of "+this.getListObject(i).getEntity().getName());
        
        super.remove(this.getRequest());
        e.addReceived(this.getRequest(),y);
    }
    }
}
