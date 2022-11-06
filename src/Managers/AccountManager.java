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
            boolean jp = true;
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
                        while (jp) {
                            System.out.println("Do you want to add a new accoun?(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sc.addCompte();
                            } else if (reponse2.equals("n")) {
                                jp=false;

                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");
                            }

                        }
                        break;
                    case 2:
                        sc.modifycompte();
                        while (jp) {
                            System.out.println("Do you want to modify another account?(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sc.modifycompte();
                                break;
                            } else if (reponse2.equals("n")) {
                                jp=false;
                                break;
                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");
                            }
                        }
                        break;
                    case 3:
                        sc.deletecompte();
                        while(jp) {
                            System.out.println("Do you want to delete another account?(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sc.deletecompte();
                                break;
                            } else if (reponse2.equals("n")) {
                                jp=false;
                                break;
                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");
                            }
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
                        while (jp) {
                            System.out.println("Do you want the information of a other account?(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sc.infocompte();
                                break;
                            } else if (reponse2.equals("n")) {
                                jp=false;
                                break;
                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");;
                            }
                        }
                        break;
                    case 6:
                        sf.retier();
                        while (jp) {
                            System.out.println("Do you want to do another withdrawl?(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sf.retier();
                                ;
                                break;
                            } else if (reponse2.equals("n")) {
                                jp=false;
                                break;
                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");
                            }
                        }
                        break;
                    case 7:
                        sf.verser();
                        while (jp) {
                            System.out.println("Do you want to another payement? ?(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sf.verser();
                                break;
                            } else if (reponse2.equals("n")) {
                                jp=false;
                                break;
                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");
                            }
                        }
                        break;
                    case 8:
                        sf.virement();
                        while (jp) {
                            System.out.println("Do you want to do another bank transfer(y/n)");
                            reponse2 = clavier3.nextLine();
                            if (reponse2.equals("y")) {
                                sf.virement();
                                break;
                            } else if (reponse2.equals("n")) {
                                jp=false;
                                break;
                            } else {
                                System.out.println("Please only answer by yes or no (y/n)");
                            }
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
                System.out.println("Thank you for using our application , see you soon!");
                running = false;
                break;
            }
            else{
                System.out.println("Please only answer by yes or no (y/n)");
                question();
        }

    }
         }
     }