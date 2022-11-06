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
            System.out.println("Please insert the id of the account");
            try {
                id = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
        while (true) {
            System.out.println("Please insert the balance you want to add::");
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
        System.out.println("Please insert the id of the account:");
        id = clavier.nextInt();
        while (true) {
            System.out.println("Please insert the balance you want to withdrawl:");
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
                    System.out.println("Not Enough Money");
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
            System.out.println("Please insert the id of the account1:");
            try {
                id1 = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
        while (true) {
            System.out.println("Please insert the id of the account2:");
            try {
                id2 = Integer.parseInt(clavier.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input please answer a int value!");
            }
        }
        System.out.println("Please insert the balance:");
        montant = clavier.nextDouble();
        for(Compte cp : banque.getComptes()){
            if(cp!=null && cp.getIdcompte() ==id1){
                for(Compte cp2 : banque.getComptes()){
                    if(cp2!=null && cp2.getIdcompte()==id2){
                        cp.setSolde(cp.getSolde() + montant);
                        cp.setJournalisation("Received "+ montant +" from Account number: "+cp2.getIdcompte());
                        cp2.setSolde(cp.getSolde() -montant);
                        cp2.setJournalisation("Sent "+ montant + " to Account number: "+cp.getIdcompte());



                    }
                }

            }
        }



    }
}
