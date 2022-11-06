package Utilites;

import Model.Banque;
import Model.Client;
import Model.Compte;

import java.lang.ref.Cleaner;
import java.util.Scanner;
import java.util.Arrays;

public class ServiceCrud {
    Banque banque;

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Banque getBanque() {
        return banque;
    }

    public ServiceCrud(){}
    public ServiceCrud(Banque bq){
        this.banque=bq;
    }
    public Client addclient(){
        Client cl = new Client();
        String nom , prenom , email;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir  le nom du client: ");
        nom = clavier.nextLine();
        cl.setNom(nom);
        System.out.println("Veuillez saisir  le prénom du client: ");
        prenom = clavier.nextLine();
        cl.setPrenom(prenom);
        System.out.println("Veuillez saisir  l'email  du client: ");
        email = clavier.nextLine();
        banque.setClients(cl);
        cl.setEmail(email);
        return  cl;
    }
    public void addCompte(){
        String reponse1 , nom , prenom , email;
        int reponse2;
        double solde;
        Scanner clavier = new Scanner(System.in);
        Scanner clavier2 = new Scanner(System.in);
        Scanner clavier3 = new Scanner(System.in);
        System.out.println("Donnez le solde :");
        solde = clavier.nextDouble();
        System.out.println("Est ce que l'utilisateur de ce compte est un nouveau clients ? (y/n)");
        reponse1 = clavier2.nextLine();
        if(reponse1.equals("y")){
           Client cl = addclient();
           Compte cp = new Compte(cl ,solde);
           cl.setComptes(cp);
            cp.setJournalisation("Creation of the account with a balance of  "+ solde +"!");
            banque.setComptes(cp);
            banque.setClients(cl);
        }
        else if(reponse1.equals("n")){
            System.out.println("Donnez l'id de l'utilisateur");
            reponse2 = clavier3.nextInt();
            for(Client elem : banque.getClients()){
                if(elem != null && elem.getIdclient()==reponse2 ){

                    Compte cp = new Compte(elem , solde);
                    cp.setJournalisation("Creation of the account with a balance of  "+ solde +"!");
                    elem.setComptes(cp);
                    banque.setComptes(cp);

                    break;
                }
                else{
                    continue;
                }
            }
        }
        else{
            System.out.println("Repondez par y/n s'il vous plait:");
        }


    }
    public  void linkCompte(){
        int idcl , idcp;
        Scanner clavier = new Scanner(System.in);
        Scanner clavier2 = new Scanner(System.in);
        System.out.println("Donnez l'identifiant du client: ");
        idcl = clavier.nextInt();
        System.out.println("Donnez l'indentifiant du compte: ");
        idcp = clavier.nextInt();
        for(Client elem: banque.getClients()){
            if(elem != null && elem.getIdclient()==idcl){
                for(Compte elem2 : banque.getComptes()){
                    if(elem2 != null && elem2.getIdcompte()==idcp){
                        System.out.println("clt:"+elem.getIdclient() +"cp"+elem2.getIdcompte());
                        elem.setComptes(elem2);
                        elem2.setProprio(elem);
                    }


            }
        }


        }

    }
    public Client searchclient(){
        int id;
        Scanner clavier = new Scanner(System.in);
        Client cl = new Client();
        System.out.println("Donnez l'identifiant du client:");
        id = clavier.nextInt();
        for(Client elem : banque.getClients()){
            if(elem != null && elem.getIdclient() == id){
                cl = elem;
            }
        }
        return  cl;
    }
    public Compte searchcompte(){
        int id;
        Scanner clavier = new Scanner(System.in);
        Compte cp = new Compte();
        System.out.println("Donnez l'identifiant du compte:");
        id = clavier.nextInt();
        for(Compte elem : banque.getComptes()){
            if(elem != null && elem.getIdcompte() == id){
                cp = elem;
            }
        }
        return  cp;
    }

    public  void infoclient(){
        int id;
        Scanner clavier = new Scanner(System.in);
        Client cl = new Client();
        System.out.println("Donnez l'identifiant du client:");
        id = clavier.nextInt();
        for(Client elem : banque.getClients()){
            if(elem != null && elem.getIdclient() == id){
                cl = elem;
            }
        }
        System.out.println( cl.toString());

    }
    public void infocompte(){
        int id;
        Scanner clavier = new Scanner(System.in);
        Compte cp = new Compte();
        System.out.println("Donnez l'identifiant du compte:");
        id = clavier.nextInt();
        for(Compte elem : banque.getComptes()){
            if(elem != null && elem.getIdcompte() == id){
                cp = elem;
            }
        }
        System.out.println( cp.toString());
    }

    public void deleteclient(){
        int id;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Donnez l'identifiant du client:");
        id = clavier.nextInt();
        for(int i=0 ; i<10 ; i++){
            if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                banque.getClients()[i]=null;
            }
        }

    }

    public void deletecompte(){
        int id;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Donnez l'identifiant du compte a supprimer:");
        id = clavier.nextInt();
        for(int i=0 ; i<10 ; i++){
            if(banque.getComptes()[i]!=null && banque.getComptes()[i].getIdcompte()==id){
                banque.getComptes()[i]=null;
            }
        }

    }
    /*public void verser(){
        double montant;
        int id;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Donnez l'identifiant du compte':");
        id = clavier.nextInt();
        System.out.println("Donnez le montant a verser:");
        montant = clavier.nextDouble();
        for(Compte cp : banque.getComptes()){
            if(cp!=null && cp.getIdcompte()==id){
                cp.setSolde(cp.getSolde()+montant);
                cp.setJournalisation("Account filled with "+ montant + "!");
            }
        }

    }
    public void retier(){
        double montant;
        int id;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Donnez l'identifiant du compte':");
        id = clavier.nextInt();
        System.out.println("Donnez le montant a retirer:");
        montant = clavier.nextDouble();
        for(Compte cp : banque.getComptes()){
            if(cp!=null && cp.getIdcompte()==id){
                double var = cp.getSolde()-montant;
                if(var>0){cp.setSolde(var);}
                else {
                    System.out.println("Pas Assez d'argent");
                    break;
                }

                cp.setJournalisation("Account withdrawal with "+ montant + "!");
            }
        }

    }
    public void virement(){
        int id1,id2;
        double montant;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Donnez l'identifiant du compte a créditer':");
        id1 = clavier.nextInt();
        System.out.println("Donnez l'identifiant du compte a débiter':");
        id2 = clavier.nextInt();
        System.out.println("Donnez le montant':");
        montant = clavier.nextDouble();
        for(Compte cp : banque.getComptes()){
            if(cp!=null && cp.getIdcompte() ==id1){
                System.out.println("HADI WAHD");
                for(Compte cp2 : banque.getComptes()){
                    if(cp2!=null && cp2.getIdcompte()==id2){
                        System.out.println("HADI ZOUJ");
                        cp.setSolde(cp.getSolde() + montant);
                        cp.setJournalisation("Received  "+ montant + "from Account"+cp2.getIdcompte());
                        cp2.setSolde(cp.getSolde() -montant);
                        cp2.setJournalisation("Sent   "+ montant + "to Account number: "+cp.getIdcompte());



                    }
                }

            }
        }



    }*/
    public void modifycompte(){
        int id , id2;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Que voulez vous modifier?:");
        System.out.println("-Enter[1] to modify the owner-");
        System.out.println("-Enter[2] to modify the balance-");
        id = clavier.nextInt();
        switch (id){
            case 1:
                System.out.println("Donnez l'identifiant du compte: ");
                id = clavier.nextInt();
                System.out.println("Donnez l'identifiant du nouveau proprio: ");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getComptes().length; i++){
                    for(int j=0 ; j<banque.getClients().length ; j++){
                    if(banque.getComptes()[i]!=null && banque.getComptes()[i].getIdcompte()==id) {
                        if (banque.getClients()[j] != null && banque.getClients()[j].getIdclient() == id2) {
                            banque.getComptes()[i].setProprio(banque.getClients()[j]);
                            banque.getComptes()[i].setJournalisation("Modification of the owner to :"+banque.getClients()[j].getNom()+" "+banque.getClients()[j].getPrenom());
                        }
                    }
                }
                    }
                break;
            case 2:
                System.out.println("Donnez l'identifiant du compte: ");
                id = clavier.nextInt();
                System.out.println("Donnez le nouveau solde: ");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getComptes().length ; i++){
                    System.out.println("this is"+i);
                        if(banque.getComptes()[i]!=null && banque.getComptes()[i].getIdcompte()==id) {
                            banque.getComptes()[i].setSolde(id2);
                            banque.getComptes()[i].setJournalisation("Modification of the balanceto: "+id2);

                        }


                }
                break;

        }



    }
    public  void modifyclient(){
        int id , id2 ;
        String var;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Que voulez vous modifier?:");
        System.out.println("-Enter[1] to modify the firstname-");
        System.out.println("-Enter[2] to modify the lastname-");
        System.out.println("-Enter[3] to modify the email-");
        id = clavier.nextInt();
        switch (id){
            case 1:
                System.out.println("Donnez l'identifiant du client: ");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getClients().length ; i++){
                    if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                        System.out.println("Donnez le nom du client: ");
                        var = clavier.next();

                        banque.getClients()[i].setNom(var);
                    }
                }
                break;
            case 2:
                System.out.println("Donnez l'identifiant du client: ");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getClients().length ; i++){
                    if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                        System.out.println("Donnez le prenom du client: ");
                        var = clavier.next();
                        banque.getClients()[i].setPrenom(var);
                    }
                }
                break;
            case 3:
                System.out.println("Donnez l'identifiant du client: ");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getClients().length ; i++){
                    if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                        System.out.println("Donnez l'email du client: ");
                        var = clavier.next();
                        banque.getClients()[i].setEmail(var);
                    }
                }
                break;
        }

    }



    public static void main(String[] args) {
        Banque bq = new Banque();
       ServiceCrud sc = new ServiceCrud(bq);
      // sc.banque.setClients(sc.addclient());
       // sc.banque.setClients(sc.addclient());
        //sc.banque.setClients(sc.addclient());
       // sc.addCompte();
        //sc.addCompte();
        //sc.verser();
       // sc.addCompte();
        //sc.modifycompte();
      /* for(Compte elem : sc.banque.getComptes()) {
            if (elem != null) {
                System.out.println(elem.toString());
            }
        }*/
        //sc.modifyclient();
     /*   for(Client elem : sc.banque.getClients()) {
            if (elem != null) {
                System.out.println(elem.toString());
            }
        }*/

    }
       // sc.modifycompte();
        //sc.retier();
        //sc.addCompte();
        //sc.addCompte();
        //sc.virement();
        // sc.infoclient();
       //sc.infocompte();
        //sc.infocompte();
       // sc.addCompte();
       //sc.addCompte();

       // System.out.println(Arrays.toString(sc.banque.getClients()));







    }



