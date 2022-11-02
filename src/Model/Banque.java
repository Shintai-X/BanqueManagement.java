package Model;

import java.util.Scanner;

public class Banque {
    private static int ctr=0;
    private  int ctr2=0;
    private int idbanque;
    private  String nomagence;
    private String emailagence;
    private int maxcomptes;
    private int maxclients;
    private Client[] clients = new Client[10];
    private Compte[] comptes = new Compte[20];


    public int getIdbanque() {
        return idbanque;
    }

    public String getNomagence() {
        return nomagence;
    }

    public String getEmailagence() {
        return emailagence;
    }

    public void setNomagence(String nomagence) {
        this.nomagence = nomagence;
    }

    public void setEmailagence(String emailagence) {
        if(emailagence.matches("^(.+)@(.+)$")) {
            this.emailagence = emailagence;
        }
        else{
            Scanner clavier = new Scanner(System.in);
            System.out.println("Attention!!Veuillez saisir un email Valide sous forme xxx@xxxx.xx:");
            emailagence = clavier.nextLine();
            setEmailagence(emailagence);


        }
    }

    public Banque(){
        idbanque =++ctr;
    }
    public Banque(int maxclients , int maxcomptes , Compte c , Client cl){
        this.maxclients=maxclients;
        this.maxcomptes=maxcomptes;

    }
    Banque(String email){
        setEmailagence(emailagence);
    }

    /*public static void main(String[] args) {
        Banque b = new Banque();
        String email;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir un email ");
        email = clavier.nextLine();
        b.setEmailagence(email);
        System.out.println(b.getEmailagence());

    }*/

}
