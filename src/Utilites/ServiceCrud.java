package Utilites;

import Model.Banque;
import Model.Client;
import Model.Compte;

import java.util.Scanner;
import java.util.Arrays;

public class ServiceCrud {
    Banque banque;

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
    ServiceCrud(){}
    ServiceCrud(Banque bq){
        this.banque=bq;
    }
    public Client addclient(){
        Client cl = new Client();
        String nom , prenom;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir  le nom du client: ");
        nom = clavier.nextLine();
        cl.setNom(nom);
        System.out.println("Veuillez saisir  le prénom du client: ");
        prenom = clavier.nextLine();
        cl.setPrenom(prenom);
        return  cl;
    }


    public void addCompte(){
        String reponse1;
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
            banque.setComptes(cp);
            banque.setClients(cl);
        }
        else if(reponse1.equals("n")){
            System.out.println("Donnez l'id de l'utilisateur");
            reponse2 = clavier3.nextInt();
            for(Client elem : banque.getClients()){
                if(elem != null && elem.getIdclient()==reponse2 ){
                    Compte cp = new Compte(elem , solde);
                    elem.setComptes(cp);

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

    public static void main(String[] args) {
       // Client cl = new Client();
        //Client cl2 = new Client("niz","sef");
        Banque bq = new Banque();
        ServiceCrud sc = new ServiceCrud(bq);
       // sc.banque.setClients(cl);
        sc.addCompte();
        //System.out.println(cl2.toString());
        for(Client elem : sc.banque.getClients()) {
            if (elem != null) {
                System.out.println(elem.toString());
            }
        }
        }



    }



