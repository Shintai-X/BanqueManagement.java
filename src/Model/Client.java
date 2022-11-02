package Model;

import java.util.Scanner;

public class Client {
    private static int ctr=0;
    private int idclient;
    private String nom;
    private String prenom;
    private Compte[] comptes = new Compte[2];

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
    public Client(String nom , String prenom){
        idclient = ++ctr;
        setNom(nom);
        setPrenom(prenom);
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
        System.out.println("Le nom du client est : "+ c1.getNom() +" et son prénom est: "+c1.getPrenom()+" et son id est:"+c1.getIdclient());
    } */

}
