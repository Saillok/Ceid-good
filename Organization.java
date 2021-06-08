import java.util.Scanner;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

class Organization extends Exception{
    
    private String name;
    private Admin admin;
    private static ArrayList<Entity> entitylist = new  ArrayList<Entity>();
    private List<Donator> donatorList = new ArrayList<Donator>(); 
    private RequestDonationList currentDonations ;
    private List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
    
    
    
    public void setAdmin(Admin admin){this.admin = admin;}
    public Admin getAdmin(){return admin;}
    
    public static void addEntity(Entity x)throws CustomException{
       int i;
       boolean exists = false;
       for(i=0;i<entitylist.size();i++){
           if(x.getID()==entitylist.get(i).getID())
           exists = true;
        }
    if(exists == true)
    throw new CustomException("Your input already exist in our entity list!");
    else
    entitylist.add(x);
}

void removeEntity(Entity x)throws CustomException{
       int i;
       boolean exists = false;
       for(i=0;i<entitylist.size();i++){
           if(x.getID()==entitylist.get(i).getID())
           exists = true;
        }
    if(exists == false)
    throw new CustomException("This entity does not exist in the list");
    else
    entitylist.remove(x);
}
void insertDonator(Donator d){
    try{
        donatorList.add(d);
    }catch(Exception e){System.out.println("This donator already exists.");}
}

void removeDonator(Donator d){
    try{
        donatorList.remove(d);
    }catch(Exception e){System.out.println("This donator doesn't exists.");}
}

void insertBeneficiary(Beneficiary b){
    try{
        beneficiaryList.add(b);
    }catch(Exception e){System.out.println("This beneficiary already exists.");}
}

void removeBeneficiary(Beneficiary b){
    try{
        beneficiaryList.remove(b);
    }catch(Exception e){System.out.println("This beneficiary doesn't exists.");}
}

void listDonators(){
    for(int i=0;i<donatorList.size(); i++){
        System.out.println(donatorList.get(i).GetName());
    }
}

public int EntityListSize(){
  return   entitylist.size();
}

public  Entity getEntityInList(int i){
    return entitylist.get(i);
}

public void listEntities(){
    int i;
    System.out.println("Materials:");
    for(i=0;i<entitylist.size();i++){
        if(entitylist.get(i).getDetails()!="Service")
        System.out.println(entitylist.get(i).getName());
    }
    System.out.println("Services:");
    for(i=0;i<entitylist.size();i++){
        if(entitylist.get(i).getDetails()=="Service")
        System.out.println(entitylist.get(i).getName());
    }
}

public void listBeneficiaries(){
  int i;
  for(i=0;i<beneficiaryList.size();i++){
    System.out.println(beneficiaryList.get(i).GetName());      
    }
}

public  RequestDonationList getCurrentDonations(){
    return currentDonations;
}

public boolean isDonator(int p){
    int i;
    for(i=0;i<donatorList.size();i++){
        if(donatorList.get(i).GetPhone()==p)
        return true;
    }
    return false;
}

public Donator getDonator(int p)throws CustomException{
    int i;
    for(i=0;i<donatorList.size();i++){
        if(donatorList.get(i).GetPhone()==p)
        return donatorList.get(i);
    }
    throw new CustomException("This donator does not exist in the list");
}

public Beneficiary getBeneficiary(int p)throws CustomException{
    int i;
    for(i=0;i<beneficiaryList.size();i++){
        if(beneficiaryList.get(i).GetPhone()==p)
        return beneficiaryList.get(i);
    }
    throw new CustomException("This beneficiary does not exist in the list");
}

public String getName(){
   return name; 
}

public int getBeneficiariesNumber(){
    return beneficiaryList.size();
}

public int getDonatorsNumber(){
    return donatorList.size();
}
}