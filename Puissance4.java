public class Puissance4 {


    private int matriceJeu[][];
    public int HEIGHT = 6;
    public int WIDTH =  7;
    public Puissance4() {
        this.matriceJeu = new int[this.HEIGHT][this.WIDTH];
        for (int i = 0; i < this.HEIGHT; i++) {
            for (int j = 0; j < this.WIDTH; j++) {
                this.matriceJeu[i][j] = 0;
            }
        }

    }

    public int[][] getMatriceJeu() {
        return matriceJeu;
    }
    public boolean jouer(boolean typeJoueur, int colonne, int[][] matrice) {

        int symboleJoueur;
        if (typeJoueur == true) {
            symboleJoueur = 1;
        } else {
            symboleJoueur= 2;
        }
        if (colonne ==-1) {
            return false;
        }
        if (colonne < 0 || colonne >= matrice[0].length ) {
            return false;
        }
        if(matrice[0][colonne] != 0){
            return false;
        }
        for(int i=matrice.length - 1;i>=0;i--){
            if(i==0 && matrice[i][colonne] != 0){
                return false;
            }
            else if (matrice[i][colonne] == 0){
                matrice[i][colonne] = symboleJoueur;
                return true;
            }
        }
        return false;

    }
    public String toString() {
        String str = "+---+---+---+---+---+---+---+\n| ";
        for (int i = 0; i < this.getMatriceJeu().length; i++) {
            for (int j = 0; j < this.getMatriceJeu()[0].length; j++) {
                str = str + this.getMatriceJeu()[i][j] + " | ";
            }
            if (i == this.getMatriceJeu().length - 1) {
                str = str + "\n+---+---+---+---+---+---+---+\n ";
            } else {
                str = str + "\n+---+---+---+---+---+---+---+\n| ";
            }


        }

        return str;
    }
    public boolean estFinJeu(boolean typeJoueur, int[][] matrice) {

        int compteur=0;
        Noeud n = new Noeud(typeJoueur, matrice);

        if (n.quatrePionsAlignesLigne(typeJoueur) == 1000 ||   n.quatrePionsAlignesColonne(typeJoueur) == 1000||
        n.quatrePionsAlignesdiagonaleInverse(typeJoueur) == 1000 ||   n.quatrePionsAlignesdiagonaleNormale(typeJoueur) == 1000) {
            return true;
        }
        else {
            for(int j=0; j < matrice[0].length; j++){
                if(matrice[0][j] != 0){
                    compteur = compteur + 1;
                }
            }
            if(compteur==matrice.length){
                System.out.println("\n MATCH NUL. ");
                return true;
            }
        }

        return false;
    }

    public void copieMatrice(int[][] mSource, int[][] mDest) {
        for (int i = 0; i < mSource.length; i++) {
            for (int j = 0; j < mSource[0].length; j++) {
                mDest[i][j] = mSource[i][j];
            }
        }
    }
    public Coup alpha_beta(Noeud n, int alpha, int beta, int profondeur) {

        if ((profondeur == 1) || estFinJeu(!n.isMax(), n.getMatrice())) {
            n.evaluer();
            return new Coup(n.getH(),-1);
        }
        int bestj=0;

        if (n.isMax() == true) {
            for (int j = 0; j < this.WIDTH; j++) {
                int[][] matriceCopie = new int[HEIGHT][WIDTH];
                copieMatrice(n.getMatrice(), matriceCopie);

                if (jouer(n.isMax(), j, matriceCopie)) {
                    Noeud successeur = new Noeud(!n.isMax(), matriceCopie);
                    Coup coup = alpha_beta(successeur, alpha, beta, profondeur - 1);

                    successeur.setH(coup.getEval());

                    if (coup.getEval() > alpha) {
                        alpha = coup.getEval();
                        bestj = j;
                    }
                    if (alpha >= beta) {
                        Coup coup1=new Coup(alpha,bestj);
                        return coup1;
                    }
                }
            }return new Coup(alpha,bestj);
        }
        else {
            for (int i = 0; i < this.WIDTH; i++) {

                int[][] matriceCopie2 = new int[HEIGHT][WIDTH];
                copieMatrice(n.getMatrice(), matriceCopie2);

                if (jouer(n.isMax(), i, matriceCopie2)) {
                    Noeud successeur = new Noeud(!n.isMax(), matriceCopie2);
                    Coup coup2 = alpha_beta(successeur, alpha, beta, profondeur - 1);

                    successeur.setH(coup2.getEval());

                    if (coup2.getEval() <beta) {
                        beta = coup2.getEval();
                        bestj = i;
                    }
                    if (alpha >= beta) {

                        Coup Coup3 = new Coup(beta, bestj);
                        return Coup3;
                    }
                }
            }
            return new Coup(beta, bestj);
        }

    }
}
