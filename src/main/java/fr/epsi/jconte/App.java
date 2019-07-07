package fr.epsi.jconte;

import fr.epsi.jconte.domain.Tableau;
import fr.epsi.jconte.infra.AfficherTableauConsole;
import fr.epsi.jconte.infra.InitTableauWithApi;



public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        Tableau tableau = new Tableau();
        InitTableauWithApi initTableauWithApi = new InitTableauWithApi();
        tableau.setTableauDeJeu(initTableauWithApi.Init(10,10));
        System.out.println("Tableau initial récupéré via l'API");
        AfficherTableauConsole afficherTableauConsole = new AfficherTableauConsole();
        System.out.println(afficherTableauConsole.Affiche(tableau.getTableauDeJeu()));
        tableau.calculNextTableau();
        System.out.println("Tableau apres une génération");
        System.out.println(afficherTableauConsole.Affiche(tableau.getTableauDeJeu()));
        tableau.applyNGeneration(5);
        System.out.println("Tableau apres 5 générations");
        System.out.println(afficherTableauConsole.Affiche(tableau.getTableauDeJeu()));
    }
}

