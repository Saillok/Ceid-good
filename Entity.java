public abstract class Entity
{
    
    private String name, description;
    private int id;
    
    public Entity(int x, String t, String z){
        id=x;
        name=t;
        description=z;
    }
    
    public String getEntityInfo(){
     return name+", "+description+","+id;   
    }
    
    abstract String getDetails();
    
    public String toString(){
      return String.format(getEntityInfo()+", "+getDetails());  
    }
    
    public int getID(){
      return id;  
    }
    
    public String getName(){
     return name;   
    }
    
    abstract double getLevel(int x)throws CustomException;
}