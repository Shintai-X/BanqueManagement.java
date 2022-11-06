package Main;


import Managers.AppManager;
import Model.Banque;

public class Main {

    public static void main(String[] args) {
        Banque bq = new Banque();
        AppManager am = new AppManager(bq);
        am.finalapp();
    }

    }


