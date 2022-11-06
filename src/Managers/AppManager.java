package Managers;

import Model.Banque;

import java.util.Scanner;

public class AppManager {
     Banque bq = new Banque();

     public AppManager(Banque bq){
         this.bq=bq;
     }
    public  void finalapp() {
        AccountManager am = new AccountManager(bq);
        ClientManager cm = new ClientManager(bq);
        int reponse;
        Scanner clavier = new Scanner(System.in);
        System.out.println("-Welcome to your bank Manager-");
        System.out.println("------------------------------");
        System.out.println("-Enter[1] to manage the accounts-");
        System.out.println("-Enter[2] to manage the clients -");
        System.out.println("-Enter[3] to exit the application-");
        System.out.print("Choose a option:");
        reponse = clavier.nextInt();
        switch (reponse){
            case 1:
                am.accountManager();
                break;
            case 2:
                cm.accountManager();
            case 3:
                System.out.println("Merci d'avoir utilisé notre application! a la prochaine");
                System.exit(0);

        }


    }
}
