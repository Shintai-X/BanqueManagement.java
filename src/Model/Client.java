package Model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private static int ctr=0;
    private  int ctr2=0;
    private  int ctr3=0;
    private int idclient;
    private String nom;
    private String prenom;
    private String email;
    private Compte[] comptes = new Compte[2];

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setNom(String nom) {
        if(nom.matches("[A-Za-z ]*")) {
            this.nom = nom;
        }
        else{
            Scanner clavier = new Scanner(System.in);
            System.out.println("Attention!!Veuillez saisir un nom Valide:");
            nom = clavier.nextLine();
            setNom(nom);


        }

    }

    public void setComptes(Compte comptes) {
        this.comptes[ctr2] = comptes;
        ctr2++;
    }

    public void setEmail(String email) {
        if(email.matches("^(.+)@(.+)$")) {
            this.email = email;
        }
        else{
            Scanner clavier = new Scanner(System.in);
            System.out.println("Attention!!Veuillez saisir un email Valide sous forme xxx@xxxx.xx:");
            email = clavier.nextLine();
            setEmail(email);


        }
    }

    public Compte[] getComptes() {
        Compte[] cpts = Arrays.stream(comptes).filter(Objects::nonNull).toArray(Compte[]::new);
        return cpts;
    }


    public void setPrenom(String prenom) {
        if(prenom.matches("[A-Za-z ]*")) {
            this.prenom = prenom;
        }
        else{
            Scanner clavier = new Scanner(System.in);
            System.out.println("Attention!!Veuillez saisir un prenom Valide:");
            prenom = clavier.nextLine();
            setPrenom(prenom);
        }

    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdclient() {
        return idclient;
    }
    public Client(){
        idclient = ++ctr;
    }
    public Client(String nom , String prenom , String email){
        idclient = ++ctr;
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idclient == client.idclient;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ctr2, idclient, nom, prenom);
        result = 31 * result + Arrays.hashCode(comptes);
        return result;
    }





    @Override
    public String toString() {
        return  "-> Client number: " + idclient + "\n" +
                        "-> Client first name: " + nom + "\n" +
                        "-> Client last name: " + prenom + "\n" +
                        "-> Client email: " + email + "\n" +
                        "-> Accounts: " + Arrays.toString(getComptes()) + "\n" +
                        "------------------------------------------------" +"\n"
                ;
            }
     }



    /* public static void main(String[] args) {
        Client c1 = new Client();
        String nom , prenom;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du client");
        nom = clavier.nextLine();
        c1.setNom(nom);
        System.out.println("Veuillez saisir le prenom du client");
        prenom= clavier.nextLine();
        c1.setPrenom(prenom);
        System.out.println(c1.toString());
    }*/


