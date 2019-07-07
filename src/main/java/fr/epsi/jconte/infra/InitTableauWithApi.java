package fr.epsi.jconte.infra;

import fr.epsi.jconte.domain.InitTableau;

import java.util.List;

public class InitTableauWithApi implements InitTableau {

    private RESTClient restClient;

    @Override
    public int[][] Init(int width, int height) {
        int[][] tableau = new int[height][width];
        RootObject array = new RootObject();
        array = restClient.GetResponseFromListListBoolean("https://epsi-i3-gol-seed.cleverapps.io/generate?x="+width+"&y="+height+"");
        int i=0;
        for(List<Boolean> ligne : array.getArray()){
            int j=0;
            for(Boolean cellule : ligne){
                tableau[i][j]=cellule?1:0;
                j++;
            }
            i++;
        }
        return tableau;
    }

    public InitTableauWithApi()
    {
        this.restClient = new RESTClient();
    }
}
