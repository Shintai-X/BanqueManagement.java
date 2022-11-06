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
    public void accountManager(){
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
            System.out.println("-Welcome to your bank client Manager manager-");
            System.out.println("------------------------------");
            System.out.println("-Enter[1] to create and add a new client-");
            System.out.println("-Enter[2] to modify a client-");
            System.out.println("-Enter[3] delete a client-");
            System.out.println("-Enter[4] to display all clients-");
            System.out.println("-Enter[5] to have information of a client-");
            System.out.println("-Enter[6] to exit this menu-");
            System.out.println("------------------------------");
            System.out.print("Choose a option:");
            choice = clavier2.nextInt();
            switch (choice){
                case 1:
                    sc.addclient();
                    System.out.println("Vous voulez ajouter un nouveau client?(y/n)");
                    reponse2 = clavier3.nextLine();
                    if(reponse2.equals("y")){
                        sc.addclient();
                        break;
                    }
                    else if(reponse2.equals("n")){
                        break;
                    }
                    else{
                        System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                    }
                    break;
                case 2:
                    sc.modifyclient();
                    System.out.println("Vous voulez modifier un autre client?(y/n)");
                    reponse2 = clavier3.nextLine();
                    if(reponse2.equals("y")){
                        sc.modifycompte();
                        break;
                    }
                    else if(reponse2.equals("n")){
                        break;
                    }
                    else{
                        System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                    }
                    break;
                case 3:
                    sc.deleteclient();
                    System.out.println("Vous voulez supprimer un autre client?(y/n)");
                    reponse2 = clavier3.nextLine();
                    if(reponse2.equals("y")){
                        sc.deleteclient();
                        break;
                    }
                    else if(reponse2.equals("n")){
                        break;
                    }
                    else{
                        System.out.println("Réponder par y(yes) ou n(non) seulement s'il vous plait!");
                    }
                    break;
                case 4:
                    for(Client elem : bq.getClients()) {
                        if (elem != null) {
                            System.out.println(elem.toString());
                        }
                    }
                    break;
                case 5:
                    sc.infoclient();
                    System.out.println("Vous voulez les information d'un autre client?(y/n)");
                    reponse2 = clavier3.nextLine();
                    if(reponse2.equals("y")){
                        sc.infoclient();
                        break;
                    }
                    else if(reponse2.equals("n")){
                        break;
                    }
                    else{

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

