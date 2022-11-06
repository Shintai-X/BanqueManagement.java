package Utilites;

import Model.Banque;
import Model.Client;
import Model.Compte;

import java.lang.ref.Cleaner;
import java.util.Scanner;
import java.util.Arrays;

public class ServiceCrud {
    Banque banque;

    public void verificationid(int id , Scanner clavier){
        while (true) {
            System.out.println("Please insert the id of the client: ");
            try {
                id = Integer.parseInt(clavier.next());

                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please write a int!");
            }
        }
    }
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
        System.out.println("Please insert the lastname of the client: ");
        nom = clavier.nextLine();
        cl.setNom(nom);
        System.out.println("Please insert the firstname of the client: ");
        prenom = clavier.nextLine();
        cl.setPrenom(prenom);
        System.out.println("Please insert the email of the client: ");
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
        while (true) {
            System.out.println("Please insert the balance:");
            try {
                solde = Double.parseDouble(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a double value!");
            }
        }
        System.out.println("Is this account for a new client ? (y/n)");
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
            System.out.println("Please insert the id of the client:");
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
            System.out.println("Only Answer with yes or no please (y/n):");
        }


    }
    public  void linkCompte(){
        int idcl , idcp;
        Scanner clavier = new Scanner(System.in);
        Scanner clavier2 = new Scanner(System.in);
        while (true) {
            System.out.println("Please insert the id of the client: ");
            try {
                idcl = Integer.parseInt(clavier.next());

                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please write a int!");
            }
        }
        while (true) {
            System.out.println("Please insert the id of the account: ");
            try {
                idcp = Integer.parseInt(clavier.next());

                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please write a int!");
            }
        }
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
        while (true) {
            System.out.println("Please insert the id of the client: ");
            try {
                id = Integer.parseInt(clavier.next());

                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please write a int!");
            }
        }
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
        System.out.println("Please insert the id of the account:");
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
        while (true) {
            System.out.println("Please insert the id of the client:");
            try {
                id = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
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
        System.out.println("Please insert the id of the account:");
        id = clavier.nextInt();
        for(Compte elem : banque.getComptes()){
            if(elem != null && elem.getIdcompte() == id){
                cp = elem;
            }
        }
        System.out.println( cp.toString());
    }
    public static Client[] removeclient(Client[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        Client[] anotherArray = new Client[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public static Compte[] removecompte(Compte[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        Compte[] anotherArray = new Compte[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public void deleteclient(){
        int id;
        Scanner clavier = new Scanner(System.in);
        while (true) {
            System.out.println("Please insert the id of the client: ");
            try {
                id = Integer.parseInt(clavier.next());

                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please write a int!");
            }
        }
        for(int i=0 ; i<banque.getClients().length ; i++){
            if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
               Client[] clts = new Client[10];
               clts = removeclient(banque.getClients(),i);
               banque.setarraycl(clts);

            }
        }

    }
    public void deletecompte(){
        int id;
        Scanner clavier = new Scanner(System.in);
        while (true) {
            System.out.println("Please insert the id of the account:");
            try {
                id = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
        for(int i=0 ; i<banque.getComptes().length ; i++){
            if(banque.getComptes()[i]!=null && banque.getComptes()[i].getIdcompte()==id){
                Compte[]  cpts = new Compte[20];
                cpts  = removecompte(banque.getComptes() , i);
                banque.setarraycp(cpts);
            }
        }

    }
    public void modifycompte(){
        int id , id2;
        Scanner clavier = new Scanner(System.in);
        System.out.println("What do you want to modify?:");
        System.out.println("-Enter[1] to modify the owner-");
        System.out.println("-Enter[2] to modify the balance-");
        id = clavier.nextInt();
        switch (id){
            case 1:
                System.out.println("Please insert the id of the account: ");
                id = clavier.nextInt();
                System.out.println("Please insert the id of the new owner : ");
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
                System.out.println("Please insert the id of the account: ");
                id = clavier.nextInt();
                System.out.println("Please insert the new balance: ");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getComptes().length ; i++){
                    System.out.println("this is"+i);
                        if(banque.getComptes()[i]!=null && banque.getComptes()[i].getIdcompte()==id) {
                            banque.getComptes()[i].setSolde(id2);
                            banque.getComptes()[i].setJournalisation("Modification of the balance to: "+id2);

                        }


                }
                break;

        }



    }
    public  void modifyclient(){
        int id , id2 ;
        String var;
        Scanner clavier = new Scanner(System.in);
        System.out.println("What do you want to modify?:");
        System.out.println("-Enter[1] to modify the firstname-");
        System.out.println("-Enter[2] to modify the lastname-");
        System.out.println("-Enter[3] to modify the email-");
        id = clavier.nextInt();
        switch (id){
            case 1:
                System.out.println("Please insert the id of the client:");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getClients().length ; i++){
                    if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                        System.out.println("Please insert the new lastname: ");
                        var = clavier.next();

                        banque.getClients()[i].setNom(var);
                    }
                }
                break;
            case 2:
                System.out.println("Please insert the id of the client:");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getClients().length ; i++){
                    if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                        System.out.println("Please insert the new firstname: ");
                        var = clavier.next();
                        banque.getClients()[i].setPrenom(var);
                    }
                }
                break;
            case 3:
                System.out.println("Please insert the id of the client:");
                id2 = clavier.nextInt();
                for(int i=0 ; i<banque.getClients().length ; i++){
                    if(banque.getClients()[i]!=null && banque.getClients()[i].getIdclient()==id){
                        System.out.println("Please insert the new email: ");
                        var = clavier.next();
                        banque.getClients()[i].setEmail(var);
                    }
                }
                break;
        }

    }
    }



