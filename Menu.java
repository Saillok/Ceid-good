import java.util.Scanner;

public class Menu
{
    private Organization y;
    private Donator d;
    private Beneficiary b;
    private Admin a;
   public Menu(Organization org ){
        y=org;
    }
    
   public void Login() throws CustomException {
       int userPhone;
       boolean admin=false;
       boolean beneficiary=false;
       boolean donator=false;
       String name;
       int choice, noP;
       System.out.println("Give your phone number");
       Scanner scanner = new Scanner(System.in);
       userPhone = scanner.nextInt();
       if(userPhone==y.getAdmin().GetPhone())
       admin=true;
       if(y.isDonator(userPhone)==true)
       donator=true;
       else
       beneficiary=true;
       
       if(admin)
       this.AdminMenu(userPhone);
       if(donator)
       this.DonatorMenu(userPhone);
       if(beneficiary)
       this.BeneficiaryMenu(userPhone);
       
        System.out.println("You are not registered,press 0 to become a beneficiary and 1 to become a donator");
        do{
           choice=scanner.nextInt();
        }while(choice!=1&&choice!=0);
        if(choice==0){
        System.out.println("Give your name and the number of you members in your family");
        name=scanner.nextLine();
        noP=scanner.nextInt();
        Beneficiary b = new Beneficiary(name,userPhone,noP);
        y.insertBeneficiary(b);
        this.BeneficiaryMenu(userPhone);
    }
    else{
    System.out.println("Give your name ");
        name=scanner.nextLine();
        Donator d = new Donator(name,userPhone);
        y.insertDonator(d);
        this.DonatorMenu(userPhone);
    }
    }
    
   public void DonatorMenu(int p) throws CustomException {
       int n,m,i=0;
       double k=0;
       d= y.getDonator(p);
       
       System.out.println("Welcome donator, your name is "+y.getDonator(p).GetName()+", your phone is "+y.getDonator(p).GetPhone()+" and this is "+y.getName());
       System.out.println("1. Add Offer ");
       System.out.println("2. Show Offers ");
       System.out.println("3. Commit ");
       System.out.println("4. Back ");
       System.out.println("5. Logout");
       System.out.println("6. Exit");
       Scanner scanner = new Scanner(System.in);
       do{
        n=scanner.nextInt();
    }while(n<1||n>6);
    switch(n){
        case 1:
        System.out.println("Press 0 to donate services and 1 to donate materials");
        do{
           i=scanner.nextInt(); 
        }while(i<0||i>1);
        if(i==0){
            for(m=0;m<y.EntityListSize();m++){
                if(y.getEntityInList(m).getDetails()=="Service")
                System.out.println(m+". "+y.getEntityInList(m).getName());
            }
            do{
              m=scanner.nextInt();  
            }while(y.getEntityInList(m).getDetails()!="Service");
            System.out.println("Are you sure you want to donate "+y.getEntityInList(m).getName()+"? 1=y/0=n");
            do{
              n=scanner.nextInt();  
            }while(n!=1&&n!=0);
            if(n==1)
            System.out.println("Give the quantity of your donation");
            do{
              k=scanner.nextInt();  
            }while(k<=0);
              RequestDonation r = new RequestDonation(y.getEntityInList(m),k);         
              d.add(r,y);
        }
        else
        for(m=0;m<y.EntityListSize();m++){
                if(y.getEntityInList(m).getDetails()!="Service")
                System.out.println(m+". "+y.getEntityInList(m).getName());
            }
            do{
              m=scanner.nextInt();  
            }while(y.getEntityInList(m).getDetails()=="Service");
            System.out.println("Are you sure you want to donate "+y.getEntityInList(m).getName()+"? 1=y/0=n");
            do{
              n=scanner.nextInt();  
            }while(n!=1&&n!=0);
            if(n==1)
            System.out.println("Give the quantity of your donation");
            do{
              k=scanner.nextInt();  
            }while(k<=0);
              RequestDonation r = new RequestDonation(y.getEntityInList(m),k); 
              d.add(r,y);
        case 2:
        if(d.size()==0){
        System.out.println("You have not offered anything yet");
        this.DonatorMenu(p);
    }
        else
        d.show();
        System.out.println("Choose 1 to clear your offers, 2 to confirm your offers and 3 to modify and offer");
        do{
           m=scanner.nextInt(); 
        }while(m<1||m>3);
        switch(m){
            case 1:
            d.clear();
            this.DonatorMenu(p);
            case 2 :
            d.commit(y);
            this.DonatorMenu(p);
            case 3:
            if(d.size()>0){
            System.out.println("Press the number of the offer to modify");
            do{
        i=scanner.nextInt();
        }while(i<0||i>d.size());
        System.out.println("Press 0 to remove that offer or a number other than 0 to change the offering quantity to that");
        do{
           k=scanner.nextDouble(); 
        }while(k<0);
        if(k==0)
        d.remove(d.getDonation(i));
        else
        d.modify(i,k);
        }
        else{
        System.out.println("You have no donations to modify");
        this.DonatorMenu(p);
    }
        }
        case 3:
        d.commit(y);
        System.out.println("You succesfully completed your donations");
        this.DonatorMenu(p);
        case 4:
        this.Login();
        case 5:
        this.Login();
        case 6:
        System.exit(0);
    }
    }
    
    public void BeneficiaryMenu(int p)throws CustomException{
       int n,m,i=0;
       double k=0;
       b=y.getBeneficiary(p);
       
       System.out.println("Welcome beneficiary, your name is "+y.getBeneficiary(p).GetName()+", your phone is "+y.getBeneficiary(p).GetPhone()+" and this is "+y.getName());
       System.out.println("1. Add Request ");
       System.out.println("2. Show Requests ");
       System.out.println("3. Commit ");
       System.out.println("4. Back ");
       System.out.println("5. Logout");
       System.out.println("6. Exit");
       Scanner scanner = new Scanner(System.in);
       do{
        n=scanner.nextInt();
    }while(n<1||n>6);
    switch(n){
        case 1:
        System.out.println("Press 0 to request services and 1 to request materials");
        do{
           i=scanner.nextInt(); 
        }while(i<0||i>1);
        if(i==0){
            for(m=0;m<y.EntityListSize();m++){
                if(y.getEntityInList(m).getDetails()=="Service")
                System.out.println(m+". "+y.getEntityInList(m).getName());
            }
            do{
              m=scanner.nextInt();  
            }while(y.getEntityInList(m).getDetails()!="Service");
            System.out.println("Are you sure you want to donate "+y.getEntityInList(m).getName()+"? 1=y/0=n");
            do{
              n=scanner.nextInt();  
            }while(n!=1&&n!=0);
            if(n==1)
            System.out.println("Give the quantity of your request");
            do{
              k=scanner.nextInt();  
            }while(k<=0);
              RequestDonation r = new RequestDonation(y.getEntityInList(m),k);         
              Requests x = new Requests(r);
              b.addRequest(x);
        }
        else
        for(m=0;m<y.EntityListSize();m++){
                if(y.getEntityInList(m).getDetails()!="Service")
                System.out.println(m+". "+y.getEntityInList(m).getName());
            }
            do{
              m=scanner.nextInt();  
            }while(y.getEntityInList(m).getDetails()=="Service");
            System.out.println("Are you sure you want to donate "+y.getEntityInList(m).getName()+"? 1=y/0=n");
            do{
              n=scanner.nextInt();  
            }while(n!=1&&n!=0);
            if(n==1)
            System.out.println("Give the quantity of your donation");
            do{
              k=scanner.nextInt();  
            }while(k<=0);
              RequestDonation r = new RequestDonation(y.getEntityInList(m),k);         
              Requests x = new Requests(r);
              b.addRequest(x);
        case 2:
        if(d.size()==0){
        System.out.println("You have not requested anything yet");
        this.BeneficiaryMenu(p);}
        else
        d.show();
        System.out.println("Choose 1 to clear your requests, 2 to confirm your requests and 3 to modify a request");
        do{
           m=scanner.nextInt(); 
        }while(m<1||m>3);
        switch(m){
            case 1:
            d.clear();
            this.DonatorMenu(p);
            case 2 :
            b.getARequest().commit(b,y);
            this.DonatorMenu(p);
            case 3:
            if(d.size()>0){
            System.out.println("Press the number of the offer to modify");
            do{
        i=scanner.nextInt();
        }while(i<0||i>d.size());
        System.out.println("Press 0 to remove that offer or a number other than 0 to change the offering quantity to that");
        do{
           k=scanner.nextDouble(); 
        }while(k<0);
        if(k==0)
        d.remove(d.getDonation(i));
        else
        d.modify
        (i,k);
        }
        else{
        System.out.println("You have no donations to modify");
        this.BeneficiaryMenu(p);
    }
        }
        case 3:
        b.getARequest().commit(b,y);
        System.out.println("You succesfully completed your requests");
        this.BeneficiaryMenu(p);
        case 4:
        this.Login();
        case 5:
        this.Login();
        case 6:
        System.exit(0);
    }
    }
    
    public void AdminMenu(int p ) throws CustomException {
       System.out.println("Welcome Admin, your name is "+y.getAdmin().GetName()+", your phone is "+y.getAdmin().GetPhone()+" and this is "+y.getName());
        Scanner scanner = new Scanner(System.in);
    
        int n,i,k,m;
        do{
            n=scanner.nextInt();
        }while(n<1||n>5);
    
        switch(n){
            
            case 1:
            System.out.println("Materials:");
            for(i=0;i<y.getCurrentDonations().getListSize();i++){
            if(y.getCurrentDonations().getListObject(i).getEntity().getDetails()!="Service")
            System.out.println(y.getCurrentDonations().getListObject(i).getEntity().getName()+" "+y.getCurrentDonations().getListObject(i).getQuantity());
            }
            System.out.println("Services:");
            for(i=0;i<y.getCurrentDonations().getListSize();i++){
            if(y.getCurrentDonations().getListObject(i).getEntity().getDetails()=="Service")
            System.out.println(y.getCurrentDonations().getListObject(i).getEntity().getName()+" "+y.getCurrentDonations().getListObject(i).getQuantity());
            }
            System.out.println("Press 0 to request services and 1 to request materials");
        do{
           i=scanner.nextInt(); 
        }while(i<0||i>1);
        if(i==0){
            for(m=0;m<y.EntityListSize();m++){
                if(y.getEntityInList(m).getDetails()=="Service")
                System.out.println(m+". "+y.getEntityInList(m).getName());
            }
            System.out.println("Choose one for details");
            do{
           i=scanner.nextInt(); 
        }while(y.getEntityInList(i).getDetails()!="Service");
        System.out.println(y.getEntityInList(i).getEntityInfo());
        }
        else{
        for(m=0;m<y.EntityListSize();m++){
                if(y.getEntityInList(m).getDetails()!="Service")
                System.out.println(m+". "+y.getEntityInList(m).getName());
            }
            System.out.println("Choose one for details");
            do{
           i=scanner.nextInt(); 
        }while(y.getEntityInList(i).getDetails()=="Service");
        System.out.println(y.getEntityInList(i).getEntityInfo());}
             this.AdminMenu(p);
            case 2:
            System.out.println("Pres 1 to manage Beneficiaries, 2 for Donators and 3 to to emptie the Beneficieries's received list");
            do{
                m=scanner.nextInt();
            }while(m<1||m>3);
            switch(m){
               case 1:
               for(i=0;i<y.getBeneficiariesNumber();i++){
                        System.out.println(i+y.getBeneficiary(i).GetName());
                    }
                    System.out.println("Give the number of the Beneficiary to be modified");
                    do{
                m=scanner.nextInt();
            }while(m<0||m>y.getBeneficiariesNumber());
                    System.out.println("Press 1 to see what he has received,  2 to clear his received list  and 3 to delete him");
               do{
                i=scanner.nextInt();
            }while(i<1||i>3);
            switch(i){
                case 1:
                
                case 2:
                y.getBeneficiary(m).clearReceived();
                case 3:
                y.removeBeneficiary(y.getBeneficiary(m));
            }
                    
                case 2:
                for(i=0;i<y.getDonatorsNumber();i++){
                        System.out.println(i+y.getDonator(i).GetName());
                    }
                        System.out.println("Give the number of the Donator to be modified");
                    do{
                m=scanner.nextInt();
            }while(m<0||m>y.getBeneficiariesNumber());
                    System.out.println("Press 1 to see what he is donating and  2 to delete him");
               do{
                i=scanner.nextInt();
            }while(i<1||i>2);
            switch(i){
                case 1:
                y.getDonator(m).show();
                
                case 2:
                y.removeDonator(y.getDonator(m));
            }
               case 3:
                    for(i=0;i<y.getBeneficiariesNumber();i++){
                        y.getBeneficiary(i).clearReceived();
                    }
                
            }
            this.AdminMenu(p);
            
            case 3:
            this.Login();
            case 4:
            this.Login();
            case 5:
            System.exit(0);
            
        }
    }
}
