package Managers;

import Main.Main;
import Model.Banque;
import Model.Compte;
import  Model.Client;
import Utilites.ServiceCrud;
import Utilites.ServiceFunction;

import java.util.Scanner;

public class ClientManager {
    Banque bq;

    ClientManager(Banque bq){
        this.bq=bq;
    }
    public String question(){
        String answer="";
        Scanner clavier = new Scanner(System.in);
        System.out.println("Voulez vous continuez ?");
        return answer = clavier.nextLine();
    }
    public static void errormessage() {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        String y = Character.toString( 10060 );
        String z = "Please only answer by yes or no (y/n)";
        String x = y+z+y;
        System.out.println(ANSI_RED +x + ANSI_RESET);

    }
    public  static void errormessage2(){
        {
            final String ANSI_RED = "\u001B[31m";
            final String ANSI_RESET = "\u001B[0m";
            String y = Character.toString( 10060 );
            String z = "Please only answer by numbers you see on the list";
            String x = y+z+y;
            System.out.println(ANSI_RED +x + ANSI_RESET);

        }
    }
    public void accountManager(){
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";
        ServiceCrud sc = new ServiceCrud(bq);
        ServiceFunction sf = new ServiceFunction(bq);
        boolean running=true;
        boolean jp = true;
        boolean jx = true;
        String answer;
        String reponse2;
        Scanner clavier = new Scanner(System.in);
        Scanner clavier3 = new Scanner(System.in);
        while(running) {
            int choice;
            Scanner clavier2 = new Scanner(System.in);
            System.out.println("------------------------------");
            System.out.println(Character.toString( 128694 )+ANSI_CYAN+"-Welcome to the client manager of inchallah bank-"+ ANSI_RESET+Character.toString( 128694 ));
            System.out.println("------------------------------");
            System.out.println(ANSI_GREEN+"-Enter[1] to create and add a new client-"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"-Enter[2] to modify a client-"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"-Enter[3] delete a client-"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"-Enter[4] to display all clients-"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"-Enter[5] to have information of a client-"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"-Enter[6] to exit this menu-"+ANSI_RESET);
            System.out.println("------------------------------");

            System.out.print(ANSI_BLUE+"Choose a option:"+ANSI_RESET);
            choice = clavier2.nextInt();
            while (choice > 6) {
                errormessage2();
                System.out.print(ANSI_BLUE + "Choose a option:" + ANSI_RESET);
                choice = clavier.nextInt();
            }

            switch (choice) {
                case 1:
                    sc.addclient();
                    while (jp) {
                        System.out.println("Do you want to add a new client?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.addclient();
                            break;
                        } else if (reponse2.equals("n")) {
                            jp = false;
                            break;
                        } else {
                            errormessage();
                        }
                    }
                    break;
                case 2:
                    sc.modifyclient();
                    while (jp) {
                        System.out.println("Do you want to modify another client?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.modifycompte();
                            break;
                        } else if (reponse2.equals("n")) {
                            jp = false;
                            break;
                        } else {
                            errormessage();
                        }
                    }
                    break;
                case 3:
                    sc.deleteclient();
                    while (jp) {
                        System.out.println("Do you want to delete another client?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.deleteclient();
                            break;
                        } else if (reponse2.equals("n")) {
                            jp = false;
                            break;
                        } else {
                            errormessage();
                        }
                    }
                    break;
                case 4:
                    for (Client elem : bq.getClients()) {
                        if (elem != null) {
                            System.out.println(elem.toString());
                        }
                    }
                    break;
                case 5:
                    sc.infoclient();
                    while (jp) {
                        System.out.println("Do you want the information of another account?(y/n)");
                        reponse2 = clavier3.nextLine();
                        if (reponse2.equals("y")) {
                            sc.infoclient();
                            break;
                        } else if (reponse2.equals("n")) {
                            jp = false;
                            break;
                        } else {
                            errormessage();

                        }
                    }
                    break;
                case 6:
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
                errormessage();
                question();


            }
        }

                }
        }






