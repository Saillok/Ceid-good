
public class RequestDonation
{
    private Entity entity;
    private double quantity;
    private Beneficiary b;
    
    public RequestDonation(Entity x, double y){
    entity = x;
    quantity = y;
    }
    
    public Entity getEntity(){
     return entity;   
    }
    
    public double getQuantity(){
     return quantity;   
    }
    
    public void setQuantity(double x){
        quantity = x;
    }
    
    public Beneficiary getBeneficiary(){
     return b;   
    }
}
