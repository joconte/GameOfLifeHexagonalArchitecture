package fr.epsi.jconte.domain;


public class Tableau implements InitTableau {

    private int[][] tableauDeJeu;

    public int[][] getTableauDeJeu() {
        return tableauDeJeu;
    }

    public int[][] setTableauDeJeu(int[][] tableauDeJeu) {
        this.tableauDeJeu = tableauDeJeu;
        return this.tableauDeJeu;
    }

    @Override
    public int[][] Init(int width, int height) {
        this.tableauDeJeu = new int[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                tableauDeJeu[i][j]=0;
            }
        }
        return tableauDeJeu;
    }

    public int[][] applyNGeneration(int pNbGeneration){
        for(int i=0; i<pNbGeneration;i++){
            calculNextTableau();
        }
        return tableauDeJeu;
    }

    public int[][] calculNextTableau()
    {
        // Init tab temp
        int height = tableauDeJeu.length;
        int width = tableauDeJeu[0].length;
        int[][] tabTemp = new int[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                tabTemp[i][j]=0;
            }
        }

        // Loop through every cell
        for (int l = 1; l < height - 1; l++)
        {
            for (int m = 1; m < width - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += tableauDeJeu[l + i][m + j];

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= tableauDeJeu[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((tableauDeJeu[l][m] == 1) && (aliveNeighbours < 2))
                    tabTemp[l][m] = 0;

                    // Cell dies due to over population
                else if ((tableauDeJeu[l][m] == 1) && (aliveNeighbours > 3))
                    tabTemp[l][m] = 0;

                    // A new cell is born
                else if ((tableauDeJeu[l][m] == 0) && (aliveNeighbours == 3))
                    tabTemp[l][m] = 1;

                    // Remains the same
                else
                    tabTemp[l][m] = tableauDeJeu[l][m];
            }
        }

        return setTableauDeJeu(tabTemp);
    }
}
