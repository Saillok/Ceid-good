public class Service extends Entity
{
    public Service(int x, String y, String z){
        super(x,y,z);
    }
    
    public String getDetails(){
     return "Service";   
    }
    
    public double getLevel(int x)throws CustomException{
        throw new CustomException("this should never happen");
    }
}
