package Utilites;

import Model.Banque;
import Model.Compte;

import java.util.Scanner;

public class ServiceFunction {
    Banque banque;

    ServiceFunction(){}
    ServiceFunction(Banque banque){
        this.banque=banque;
    }
    public void verser(){
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



    }



    public static void main(String[] args) {
        Banque bq = new Banque();
        ServiceFunction sf = new ServiceFunction(bq);
        sf.verser();
    }

}
