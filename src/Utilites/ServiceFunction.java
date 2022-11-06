package Utilites;

import Model.Banque;
import Model.Compte;

import java.util.Scanner;

public class ServiceFunction {
    Banque banque;

    public ServiceFunction(){}
    public ServiceFunction(Banque banque){
        this.banque=banque;
    }
    public void verser(){
        double montant;
        int id;
        Scanner clavier = new Scanner(System.in);
        while (true) {
            System.out.println("Donnez l'id du compte:");
            try {
                id = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
        while (true) {
            System.out.println("Donnez le montant verser :");
            try {
                montant = Double.parseDouble(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a double value!");
            }
        }
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
        while (true) {
            System.out.println("Donnez le montant a retuer :");
            try {
                montant = Double.parseDouble(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a double value!");
            }
        }
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
        while (true) {
            System.out.println("Donnez l'id du compte a crediter:");
            try {
                id1 = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
        while (true) {
            System.out.println("Donnez l'id du compte a debiter:");
            try {
                id2 = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
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



    }



   /* public static void main(String[] args) {
        Banque bq = new Banque();
        ServiceFunction sf = new ServiceFunction(bq);
        sf.verser();
    }*/

}
