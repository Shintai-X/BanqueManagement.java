package Model;
import java.util.Date;
import java.time.LocalDateTime;
import  java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;


public class Compte {
    private  static  int ctr=0;
    private    int ctr2=0;
    private  int idcompte;
    private  double solde;
    private  String[] journalisation = new String[10];
    private  String date_creation;
    private  Client proprio;



    public void setSolde(double solde) {
        if(solde>=0){
        this.solde = solde;
        }
        else {
            Scanner clavier = new Scanner(System.in);
            System.out.println("Attention!!Veuillez saisir un solde positife:");
            solde = clavier.nextDouble();
            setSolde(solde);
        }
        }


    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setProprio(Client proprio) {
        this.proprio = proprio;
    }

    public void setJournalisation() {
        this.journalisation[ctr] = this.getDate_creation();
    }

    public Client getProprio() {
        return proprio;
    }

    public double getSolde() {

        return solde;
    }

    public String[] getJournalisation() {
        return journalisation;


    }

    public int getIdcompte() {
        return idcompte;
    }

    public String getDate_creation() {
        return date_creation;
    }


     public Compte(){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
         String current_date=dtf.format(LocalDateTime.now());
         idcompte = ++ctr;
        setDate_creation(current_date);
         journalisation[ctr2] = current_date;
         ++ctr2;
         setSolde(0.0);

     }
     public Compte(Client c ,double solde){
         DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
         String current_date=dtf.format(LocalDateTime.now());
         idcompte = ++ctr;
         setDate_creation(current_date);
         journalisation[ctr2] = current_date;
         ++ctr2;
         setSolde(solde);
         setProprio(c);
     }

    @Override
    public String toString() {
        return "Compte{" +
                "solde=" + this.getSolde() +
                '}';
    }

    public static void main(String[] args) {
        Client c = new Client("Nom","Prenom");
        Compte c1 = new Compte();
        double solde;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez Saisir un solde:");
        solde = clavier.nextDouble();
        c1.setProprio(c);
        c1.setSolde(solde);
        System.out.println("Solde: "+c1.getSolde() +" et: "+Arrays.toString(c1.journalisation));









    }
}
