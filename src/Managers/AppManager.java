package Managers;

import Model.Banque;

import java.util.Scanner;

public class AppManager {
     Banque bq = new Banque();

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

     public AppManager(Banque bq){
         this.bq=bq;
     }
    public  void finalapp() {
        AccountManager am = new AccountManager(bq);
        ClientManager cm = new ClientManager(bq);
        int reponse;
        boolean jx=true;
        Scanner clavier = new Scanner(System.in);
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";
        System.out.println(Character.toString( 127974 )+ANSI_CYAN+"-Welcome to Inchallah bank -"+ ANSI_RESET+Character.toString( 127974 ));
        System.out.println("------------------------------");
        System.out.println( ANSI_GREEN+"-Enter[1] to manage the accounts-"+ANSI_RESET);
        System.out.println( ANSI_GREEN+"-Enter[2] to manage the clients -"+ANSI_RESET);
        System.out.println( ANSI_GREEN+"-Enter[3] to exit the application-"+ANSI_RESET);
        System.out.print(ANSI_BLUE + "Choose a option:" + ANSI_RESET);
        reponse = clavier.nextInt();
            while (reponse > 3) {
                errormessage2();
                System.out.print(ANSI_BLUE + "Choose a option:" + ANSI_RESET);
                reponse = clavier.nextInt();
            }
            switch (reponse) {
                case 1:
                    am.accountManager();
                    break;
                case 2:
                    cm.accountManager();
                    break;
                case 3:
                    System.out.println(Character.toString(128176) + ANSI_CYAN + "Thank you for using our application , see you soon!" + ANSI_RESET + Character.toString(128176));
                    System.exit(0);
                    break;

            }



    }
}
