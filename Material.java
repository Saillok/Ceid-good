public class Material extends Entity
{
    private double level1, level2, level3;
    
    public Material(double x, double y, double z,int i, String n, String d){
        super(i,n,d);
        level1=x;
        level2=y;
        level3=z;
        }

    public String getDetails(){
     return "level1 = "+level1+",level2 = "+level2+",level3 = "+level3+", Material";   
    }
    
    public double getLevel(int x){
        if(x==1)
        return level1;
        if(x>=2&&x<=4)
        return level2;
        else
        return level3;
    }
    
    
}
