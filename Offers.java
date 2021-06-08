
public class Offers extends RequestDonationList
{
    
    
    public Offers(){
        
    }
    
    public void commit(Organization y) throws CustomException {
        int i,j;
        boolean e;
        double a;
        for(i=0;i<super.getListSize();i++){
            e=false;
            a=0;
            for(j=0;j<y.getCurrentDonations().getListSize();i++){
                if(super.getListObject(i).getEntity()==y.getCurrentDonations().getListObject(j).getEntity()&&e==false){
                  e=true;
                  a=super.getListObject(i).getQuantity()+y.getCurrentDonations().getListObject(j).getQuantity();
                  y.getCurrentDonations().modify(i,a);
                }
                if(e==false)
                super.add(super.getListObject(i),y);
                super.remove(super.getListObject(i));
            }
        }
    }
    
    public void add(RequestDonation x, Organization y)throws CustomException {
        super.add(x,y);
    }
    
    public void remove(RequestDonation x){
        super.remove(x);
    }
    
    public void modify(int i, double x){
        super.modify(i,x);
    }
    
    public void show(){
        super.monitor();
    }
    
    public int getSize(){
        return super.getListSize();
    }
    
    public void clear(){
        super.reset();
    }
    
    public RequestDonation getDonation(int i){
        return super.getListObject(i);
    }
}
