package Utilities;

import Model.Client;

import java.util.Scanner;

public class ClientUtilities {
    Client cl;

    public void addclient(Scanner clavier){
        String nom , prenom;
        Client cl = new Client();
        clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir  le nom du client: ");
        nom = clavier.nextLine();
        cl.setNom(nom);
        System.out.println("Veuillez saisir  le prénom du client: ");
        prenom = clavier.nextLine();
        cl.setPrenom(prenom);
    }

    public void modifierClient(int id){
        if(id==cl.getIdclient()){


        }
        else{
            System.out.println("Client introuvable!");
        }
    }


    }


