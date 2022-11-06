package Model;
import java.util.Date;
import java.time.LocalDateTime;
import  java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Compte {
    private static int ctr = 0;
    private int ctr2 = 0;
    private int idcompte;
    private double solde;
    private String[] journalisation = new String[10];
    private String date_creation;
    private Client proprio;


    public void setSolde(double solde) {
        if (solde >= 0) {
            this.solde = solde;
        } else {
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

    public void setJournalisation(String description) {
        this.journalisation[ctr2] = this.getDate_creation() + ":"+description;
        ctr2++;
    }


    public Client getProprio() {
        return proprio;
    }

    public double getSolde() {

        return solde;
    }

    public String[] getJournalisation() {
        String[] journa = Arrays.stream(journalisation).filter(Objects::nonNull).toArray(String[]::new);
        return journa;


    }

    public int getIdcompte() {
        return idcompte;
    }

    public String getDate_creation() {
        return date_creation;
    }


    public Compte() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
        String current_date = dtf.format(LocalDateTime.now());
        idcompte = ++ctr;
        setDate_creation(current_date);
        setSolde(0.0);

    }

    public Compte(Client c, double solde) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
        String current_date = dtf.format(LocalDateTime.now());
        idcompte = ++ctr;
        setDate_creation(current_date);
        setSolde(solde);
        setProprio(c);
    }

    public Compte(double solde) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm:ss");
        String current_date = dtf.format(LocalDateTime.now());
        idcompte = ++ctr;
        setDate_creation(current_date);
        journalisation[ctr2] = current_date;
        ++ctr2;
        setSolde(solde);
    }

    @Override
    public String toString() {

        return  "\n" + "* Account number: " + this.getIdcompte() + "\n" +
                "* balance: " + this.getSolde() + "\n" +
                "* property of " + this.proprio.getPrenom() + " " + this.proprio.getNom() + "\n" +
                "*Account History: " + Arrays.toString(getJournalisation());
    }


    public static void main(String[] args) {
        Client cl = new Client();
         Compte cp = new Compte(cl ,200);
        System.out.println(cp.toString());
    }

    }













