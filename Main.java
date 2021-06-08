

public class Main
{
    public static void main(String args[]) throws CustomException {
        Organization org = new Organization();
        Service BabySitting = new Service(1,"babysitting","babies");
        Service MedicalSupport = new Service(2,"medicalsupport","health");
        Service NurserySupport = new Service(3,"nursurysupport","elderly");        
        Material milk = new Material(1,3,5,4,"milk","calcium");
        Material sugar = new Material(10,30,50,5,"sugar","sweet");
        Material rice = new Material(20,40,70,6,"rice","food");
        
        org.addEntity(milk);
        org.addEntity(rice);
        org.addEntity(sugar);
        org.addEntity(BabySitting);
        org.addEntity(MedicalSupport);
        org.addEntity(NurserySupport);
        
        Admin admin = new Admin("John", 6943,true);
        org.setAdmin(admin);
        
        Donator don1 = new Donator("Jim", 2716);
        Beneficiary ben1 = new Beneficiary("Jack",2749, 1);
        Beneficiary ben3 = new Beneficiary("James",2379, 4);
    }
}
