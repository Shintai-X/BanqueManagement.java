package Managers;

import Main.Main;
import Model.Banque;
import Model.Compte;
import Utilites.ServiceCrud;
import Utilites.ServiceFunction;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AccountManager {
    Banque bq;

    public String question(){
        String answer="";
        Scanner clavier = new Scanner(System.in);
        System.out.println("Voulez vous continuez ?");
        return answer = clavier.nextLine();
    }

    AccountManager(Banque bq){
        this.bq=bq;
    }
    public void accountManager() {
        ServiceCrud sc = new ServiceCrud(bq);
        ServiceFunction sf = new ServiceFunction(bq);
        boolean running=true;
        String answer;
        String reponse2;
        Scanner clavier = new Scanner(System.in);
        Scanner clavier3 = new Scanner(System.in);
        while(running) {
            int choice;
            Scanner clavier2 = new Scanner(System.in);
            System.out.println("------------------------------");
            System.out.println("-Welcome to your bank Account Manager manager-");
            System.out.println("------------------------------");
            System.out.println("-Enter[1] to create and add a new account-");
            System.out.println("-Enter[2] to modify a account-");
            System.out.println("-Enter[3] to delete a account-");
            System.out.println("-Enter[4] to display all accounts-");
            System.out.println("-Enter[5] to search a account-");
            System.out.println("-Enter[6] to withdrawala account-");
            System.out.println("-Enter[7] to fill a account-");
            System.out.println("-Enter[8] to do a bank trasnfere-");
            System.out.println("-Enter[9] to exit this menu -");
            System.out.println("------------------------------");
            System.out.print("Choose a option:");
                choice = clavier2.nextInt();
                switch (choice) {
                    case 1:
                        reponse2 = "";
                        sc.addCompte();
                        System.out.println("Vous voulez ajouter un nouveau compte?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.addCompte();
                        } else if (reponse2.equals("n")) {

                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 2:
                        sc.modifycompte();
                        System.out.println("Vous voulez modifier un autre compte?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.modifycompte();
                            break;
                        } else if (reponse2.equals("n")) {
                            break;
                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 3:
                        sc.deletecompte();
                        System.out.println("Vous voulez supprimer un autre compte?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.deletecompte();
                            break;
                        } else if (reponse2.equals("n")) {
                            break;
                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 4:
                        for (Compte cp : bq.getComptes()) {

                            if (cp != null) {
                                System.out.println(cp.toString());
                            }
                        }
                        break;
                    case 5:
                        sc.infocompte();
                        System.out.println("Vous voulez les information d'un autre compte?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.infocompte();
                            break;
                        } else if (reponse2.equals("n")) {
                            break;
                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 6:
                        sf.retier();
                        System.out.println("Vous encore faire un retrait ?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sf.retier();
                            ;
                            break;
                        } else if (reponse2.equals("n")) {
                            break;
                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 7:
                        sf.verser();
                        System.out.println("Vous encore faire un versement? ?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sf.verser();
                            break;
                        } else if (reponse2.equals("n")) {
                            break;
                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 8:
                        sf.virement();
                        System.out.println("Vous encore faire un virement ?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sf.virement();
                            break;
                        } else if (reponse2.equals("n")) {
                            break;
                        } else {
                            System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                        }
                        break;
                    case 9:
                        AppManager ap = new AppManager(bq);
                        ap.finalapp();
                        break;

                }

            String rep = question();
            if(rep.equals("y")){
            }
            else if(rep.equals("n")){
                System.out.println("Merci d'avoir utilisé notre application! a la prochaine");
                running = false;
                break;
            }
            else{
                System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                question();
        }

    }
         }
     }