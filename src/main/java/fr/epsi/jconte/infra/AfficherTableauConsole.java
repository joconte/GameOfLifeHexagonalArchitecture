package fr.epsi.jconte.infra;

import fr.epsi.jconte.domain.AfficheTableau;

public class AfficherTableauConsole implements AfficheTableau {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    @Override
    public String Affiche(int[][] tableau) {
        int height = tableau.length;
        int width = tableau[0].length;
        String display ="";
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(j==0)
                    display+="|";
                display += tableau[i][j]==1?ANSI_BLUE_BACKGROUND+ANSI_BLUE+" 1 "+ANSI_RESET:ANSI_BLACK_BACKGROUND+ANSI_BLACK+" 0 "+ANSI_RESET;
                display += "|";
            }
            display+="\n";
            for(int j=0;j<width;j++)
                display+=" ---";
            display+="\n";
        }
        return display;
    }
}
