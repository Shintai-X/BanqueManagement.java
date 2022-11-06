package Model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Banque {
    private static int ctr=0;
    private  int ctr2=0;
    private  int ctr3=0;
    private int idbanque;
    private  String nomagence;
    private String emailagence;
    private int maxcomptes;
    private int maxclients;
    private Client[] clients = new Client[10];
    // look arraylist
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

    public Compte[] getComptes() {
        Compte[] cpts = Arrays.stream(comptes).filter(Objects::nonNull).toArray(Compte[]::new);
        return cpts;
    }

    public Client[] getClients() {
        Client[] clts = Arrays.stream(clients).filter(Objects::nonNull).toArray(Client[]::new);
        return clts;

    }

    public void setComptes(Compte cp) {
        this.comptes[ctr2] = cp;
        ctr2++;

    }
    public void setClients(Client cl) {
        this.clients[ctr3] = cl;
        ++ctr3;
    }
    public void setarraycl(Client[] clients){
        this.clients=clients;
    }
    public void setarraycp(Compte[] comptes){
        this.comptes=comptes;
    }

    public int getCtr3() {
        return ctr3;
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
    public Banque(int maxclients , int maxcomptes , Compte c , Client cl , String emailagence){
        this.maxclients=maxclients;
        this.maxcomptes=maxcomptes;
        this.emailagence=emailagence;
        setClients(cl);
        setComptes(c);

    }
    Banque(String email){
        setEmailagence(emailagence);
    }

    @Override
    public String toString() {
        return "Banque{" +
                "clients=" + Arrays.toString(clients) +
                '}';
    }

    /* public static void main(String[] args) {
        Banque b = new Banque();
        Client cl = new Client();
        cl.addclient();
        b.setClients(cl);
        b.addCompte();
        System.out.println("hahah"+Arrays.toString(b.getClients()));


    }*/

}
