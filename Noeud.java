public class Noeud {
    public int[][] matrice;
    private boolean max;
    private int h;


    public Noeud(boolean max, int[][] matrice) {
        this.max = max;
        this.matrice = matrice;
    }

    public int getH() {
        return h;
    }

    public int[][] getMatrice() {

        return matrice;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isMax() {
        return this.max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }

    public String toString() {
        String str = "+---+---+---+---+---+---+---+\n| ";
        for (int i = 0; i < this.getMatrice().length; i++) {
            for (int j = 0; j < this.getMatrice()[0].length; j++) {
                str = str + this.getMatrice()[i][j] + " | ";
            }
            if (i == this.getMatrice().length - 1) {
                str = str + "\n+---+---+---+---+---+---+---+\n ";
            } else {
                str = str + "\n+---+---+---+---+---+---+---+\n| ";
            }

        }
        return str;
    }

    public int quatrePionsAlignesLigne(boolean typeJoueur) {

        /* Initialisation */

        /* Joueur ou IA */
        int symboleJoueur;
        if (typeJoueur == true) {
            symboleJoueur = 1;
        } else {
            symboleJoueur = 2;
        }
        int compteur = 0;
        for (int i = 0; i < this.matrice.length; i++) {
            compteur = 1;
            for (int j = 0; j < this.matrice[0].length - 1; j++) {
                if (this.getMatrice()[i][j] != 0 && this.getMatrice()[i][j] == this.getMatrice()[i][j + 1] && this.getMatrice()[i][j] == symboleJoueur)
                    compteur++;
                else
                    compteur = 1;
                if (compteur == 4) {
                    return 1000;

                }
            }

        }

        return 0;
    }

    public int quatrePionsAlignesColonne(boolean typeJoueur) {

        /* Initialisation */

        /* Joueur ou IA */
        int symboleJoueur;
        if (typeJoueur == true) {
            symboleJoueur = 1;
        } else {
            symboleJoueur = 2;
        }
        int compteur = 0;
        for (int j = 0; j < this.matrice[0].length; j++) {
            compteur = 1;
            for (int i = 0; i < this.matrice.length - 1; i++) {
                if (this.getMatrice()[i][j] != 0 && this.getMatrice()[i][j] == this.getMatrice()[i + 1][j] && this.getMatrice()[i][j] == symboleJoueur)
                    compteur++;
                else
                    compteur = 1;
                if (compteur == 4) {
                    return 1000;
                }
            }
        }
        return 0;
    }

    /* Fonction : Vérification 4 pions alignés en diagonale droite*/
    public int quatrePionsAlignesdiagonaleNormale(boolean typeJoueur) {

        /* Initialisation */

        int symbolJoueur;
        if (typeJoueur == true){
            symbolJoueur = 1;
        }else{
            symbolJoueur = 2;
        }

        int l, k;
        int compteur = 0;

        for ( int i = this.getMatrice().length - 1; i>= 3; i--)   {
            l= i;

            for (int j = 3; j<= this.getMatrice()[0].length - 1; j++)
            {
                k = j;
                if(this.getMatrice()[i][j] == symbolJoueur) {
                    while ( (l >= 0) && (k >= 0) && this.getMatrice()[l][k] == symbolJoueur && compteur<4) {
                            l= l - 1;
                            k= k - 1;
                            compteur= compteur + 1;
                    }
                    if (compteur == 4) {
                        return 1000;
                    }

                    l= i;
                    compteur = 0;
                }

            }
        }
        return 0;
    }
    public int quatrePionsAlignesdiagonaleInverse(boolean typeJoueur) {

        /* Initialisation */

        /* Joueur ou IA */
        int symbolJoueur;
        if (typeJoueur == true){
            symbolJoueur = 1;
        }else{
            symbolJoueur = 2;
        }

        int l, k;
        int compteur = 0;



        for (int i = this.matrice.length - 1; i >= 3; i--)
        {
            l= i;
            for (int j = 0; j <=this.matrice[0].length - 3; j++)
            {
                k= j;
                if (this.matrice[i][j] == symbolJoueur) {
                    while ((l>= 0) && (k< this.matrice[0].length ) && (this.matrice[l][k] == symbolJoueur && compteur < 4)) {
                        l= l - 1;
                        k= k + 1;
                        compteur= compteur + 1;
                    }
                    if (compteur == 4){
                        return 1000;
                    }

                }
                l=i;
                compteur = 0;

            }
        }
        return 0;
    }

    public int quatrePionsPossiblesLigne(boolean typeJoueur) {


        int symbolJoueur;
        if (typeJoueur == true) {
            symbolJoueur = 1;
        } else {
            symbolJoueur = 2;
        }
        int evaluation = 0;
        for (int i = 0; i < this.getMatrice().length; i++) {

            for (int j = 0; j < this.getMatrice()[0].length; j++) {

                if (this.getMatrice()[i][j] == 0) {

                    if(j+3 < this.matrice[0].length && this.matrice[i][j + 1] == symbolJoueur && this.matrice[i][j + 2] == this.matrice[i][j + 1] && this.matrice[i][j + 3] == this.matrice[i][j + 1]){
                            evaluation = evaluation + 400;

                    }

                    if((j-1 >= 0) && (j+2 < this.matrice[0].length) && this.matrice[i][j - 1] == symbolJoueur && this.matrice[i][j + 1] == this.matrice[i][j - 1] && this.matrice[i][j + 2] == this.matrice[i][j - 1]){
                            evaluation = evaluation + 400;

                    }

                    if((j-2 >= 0) && (j+1 < this.matrice[0].length) && this.matrice[i][j - 2] == symbolJoueur && this.matrice[i][j - 1] == this.matrice[i][j - 2]  && this.matrice[i][j + 1] == this.matrice[i][j - 2] ){

                            evaluation = evaluation + 400;
                    }


                    if(j-3 >= 0 && this.matrice[i][j - 3] == symbolJoueur && this.matrice[i][j - 2] == this.matrice[i][j - 3] && this.matrice[i][j - 1] == this.matrice[i][j - 3]){

                            evaluation = evaluation + 400;
                    }


                    if(j+2 < this.matrice[0].length && this.matrice[i][j + 1] == symbolJoueur && this.matrice[i][j + 2] == this.matrice[i][j + 1]) {
                            evaluation = evaluation + 200;

                    }

                    if((j-1) >= 0 && (j+1 < this.matrice[0].length) && this.matrice[i][j - 1] == symbolJoueur && this.matrice[i][j + 1] == this.matrice[i][j - 1] ) {
                            evaluation = evaluation + 200;

                    }


                    if(j-2 >= 0 && this.matrice[i][j - 2] == symbolJoueur && this.matrice[i][j - 1] == this.matrice[i][j - 2] ) {

                            evaluation = evaluation + 200;
                    }

                    if(j-1 >= 0 && this.matrice[i][j - 1] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }

                    if(j+1 < this.matrice[0].length && this.matrice[i][j + 1] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }
                }

            }
        }
        return evaluation;
    }

    public int quatrePionsPossiblesColonne(boolean typeJoueur) {


        int symbolJoueur;
        if (typeJoueur == true) {
            symbolJoueur = 1;
        } else {
            symbolJoueur = 2;
        }
        int evaluation = 0;
        for (int j = 0; j < this.getMatrice()[0].length; j++) {

            for (int i = 0; i < this.getMatrice().length; i++) {

                if (this.getMatrice()[i][j] == 0) {

                    if(i+3 < this.matrice.length && this.matrice[i + 1][j] == symbolJoueur && this.matrice[i + 2][j] ==this.matrice[i + 1][j]  && this.matrice[i + 3][j] == this.matrice[i + 1][j] ){
                            evaluation = evaluation + 400;

                    }

                    if((i-1 >= 0) && (i+2 < this.matrice.length) && this.matrice[i - 1][j] == symbolJoueur && this.matrice[i + 1][j] == this.matrice[i - 1][j] && this.matrice[i + 2][j] ==this.matrice[i - 1][j]){
                            evaluation = evaluation + 400;

                    }
                    // 1 1 0 1
                    if((i-2 >= 0) && (i+1 <this.matrice.length) && this.matrice[i - 2][j] == symbolJoueur && this.matrice[i - 1][j] == this.matrice[i - 2][j] && this.matrice[i + 1][j] == this.matrice[i - 2][j]){
                            evaluation = evaluation + 400;

                    }

                    if(i-3 >= 0 && this.matrice[i - 3][j] == symbolJoueur && this.matrice[i - 2][j] == symbolJoueur && this.matrice[i - 1][j] == this.matrice[i - 2][j]){
                            evaluation = evaluation + 400;

                    }
                    if(i+2 < this.matrice.length && this.matrice[i + 1][j] == symbolJoueur && this.matrice[i + 2][j] == this.matrice[i + 1][j] ) {
                            evaluation = evaluation + 200;

                    }

                    if((i-1 >= 0) && (i+1 < this.matrice.length) && this.matrice[i - 1][j] == symbolJoueur && this.matrice[i + 1][j] ==this.matrice[i - 1][j]) {
                            evaluation = evaluation + 200;

                    }

                    if(i-2 >= 0 && this.matrice[i - 2][j] == symbolJoueur && this.matrice[i - 1][j] == this.matrice[i - 2][j]) {
                            evaluation = evaluation + 200;

                    }

                    if(i+1 < this.matrice.length && this.matrice[i + 1][j] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }
                }

            }
        }
        return evaluation;
    }

    public int quatrePionsPossiblesDiagonaleInverse(boolean typeJoueur){

        int symbolJoueur;
        if (typeJoueur == true){
            symbolJoueur = 1;
        } else {
            symbolJoueur = 2;
        }

        int evaluation = 0;

        /* Evaluation */

        for (int i = this.matrice.length-1; i >=0; i--) {

            for (int j = 0; j < this.matrice[0].length; j++) {
                if(this.matrice[i][j] == 0) {

                    if((i-3 >= 0) && (j+3 < this.matrice[0].length) && this.matrice[i-1][j+1] == symbolJoueur && this.matrice[i-2][j+2] == this.matrice[i-1][j+1]  && this.matrice[i-3][j+3] == this.matrice[i-1][j+1] ){
                            evaluation = evaluation + 400;

                    }

                    if((i+1 < this.matrice.length) && (i-2 >= 0) && (j-1 >= 0) && (j+2 < this.matrice[0].length) && this.matrice[i+1][j-1] == symbolJoueur && this.matrice[i-1][j+1] ==this.matrice[i+1][j-1] && this.matrice[i-2][j+2] == this.matrice[i+1][j-1]){
                            evaluation = evaluation + 400;

                    }

                    if((i+2 < this.matrice.length) && (i-1 >= 0) && (j-2 >= 0) && (j+1 < this.matrice[0].length) && this.matrice[i+2][j-2] == symbolJoueur && this.matrice[i+1][j-1] ==this.matrice[i+2][j-2]  && this.matrice[i-1][j+1] ==this.matrice[i+2][j-2] ){
                            evaluation = evaluation + 400;

                    }

                    if((i-3 >= 0) && (j-3 >= 0) && this.matrice[i-3][j-3] == symbolJoueur && this.matrice[i-2][j-2] == this.matrice[i-3][j-3] && this.matrice[i-1][j-1] == this.matrice[i-3][j-3]){
                            evaluation = evaluation + 400;

                    }


                    if((i-2 >= 0) && (j+2 < this.matrice[0].length) && this.matrice[i-1][j+1] == symbolJoueur && this.matrice[i-2][j+2] ==this.matrice[i-1][j+1]) {
                            evaluation = evaluation + 200;

                    }

                    if(i-1 >= 0 && (i+1<this.matrice.length) && (j-1 >= 0) && (j+1 < this.matrice[0].length) && this.matrice[i+1][j-1] == symbolJoueur && this.matrice[i-1][j+1] == this.matrice[i+1][j-1]) {
                            evaluation = evaluation + 200;

                    }

                    if((i+2 < this.matrice.length) && (j-2 >= 0) && this.matrice[i+2][j-2] == symbolJoueur && this.matrice[i+1][j-1] == this.matrice[i+2][j-2] ) {
                            evaluation = evaluation + 200;
                    }

                    if((i+1 < this.matrice.length) && (j-1 >= 0) && this.matrice[i+1][j-1] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }

                    if((i-1 >= 0) && (j+1 < this.matrice[0].length) &&  this.matrice[i-1][j+1] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }
                }
            }
        }

        return evaluation;
    }
    public int quatrePionsPossiblesDiagonaleNormale(boolean typeJoueur){

        /* Initialisation */

        /* Joueur vs IA */
        int symbolJoueur;
        if (typeJoueur == true){
            symbolJoueur = 1;
        }else{
            symbolJoueur = 2;
        }

        int evaluation = 0;


        for (int i = this.matrice.length-1; i >=0; i--) {
            for (int j = 0; j < this.matrice[0].length; j++) {
                if(this.matrice[i][j] == 0) {


                    if((i+3<this.matrice.length) && (j+3<this.matrice[0].length) && this.matrice[i+1][j+1] == symbolJoueur && this.matrice[i+2][j+2] == symbolJoueur && this.matrice[i+3][j+3] == symbolJoueur){
                            evaluation = evaluation + 400;

                    }

                    if((i-1>=0) && (i+2<this.matrice.length) && (j-1>=0) && (j+2)<this.matrice[0].length && this.matrice[i-1][j-1] == symbolJoueur && this.matrice[i+1][j+1] == symbolJoueur && this.matrice[i+2][j+2] == symbolJoueur){
                            evaluation = evaluation + 400;

                    }

                    if((i-2>=0) && (i+1<this.matrice.length) && (j-2>=0) && (j+1<this.matrice[0].length) && this.matrice[i-2][j-2] == symbolJoueur && this.matrice[i-1][j-1] == symbolJoueur && this.matrice[i+1][j+1] == symbolJoueur){
                            evaluation = evaluation + 400;

                    }

                    if((i+3<this.matrice.length) && (j-3>=0) && this.matrice[i+3][j-3] == symbolJoueur && this.matrice[i+2][j-2] == symbolJoueur && this.matrice[i+1][j-1] == symbolJoueur){
                            evaluation = evaluation + 400;

                    }

                    if((i+2<this.matrice.length) && (j+2<this.matrice[0].length) && this.matrice[i+1][j+1] == symbolJoueur && this.matrice[i+2][j+2] == symbolJoueur) {
                            evaluation = evaluation + 200;

                    }

                    if(i-1>=0 && i+1<this.matrice.length && j-1>=0 && j+1<this.matrice[0].length && this.matrice[i-1][j-1] == symbolJoueur && this.matrice[i+1][j+1] == symbolJoueur) {
                            evaluation = evaluation + 200;

                    }

                    if((i-2>=0) && (j-2>=0) && this.matrice[i-2][j-2] == symbolJoueur && this.matrice[i-1][j-1] == symbolJoueur) {
                            evaluation = evaluation + 200;

                    }

                    if(i-1>=0&& j-1>=0 && this.matrice[i-1][j-1] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }

                    if(i+1<this.matrice.length && j+1<this.matrice[0].length && this.matrice[i+1][j+1] == symbolJoueur) {
                            evaluation = evaluation + 30;

                    }
                }
            }
        }
        return evaluation;
    }
    public void evaluer(){

        this.h = -2*this.quatrePionsAlignesLigne(false)
                + this.quatrePionsAlignesLigne(true)
                -2*this.quatrePionsAlignesColonne(false)
                + this.quatrePionsAlignesColonne(true)
                -2*this.quatrePionsAlignesdiagonaleNormale(false)
                + this.quatrePionsAlignesdiagonaleNormale(true)
                -2*this.quatrePionsAlignesdiagonaleInverse(false)
                + this.quatrePionsAlignesdiagonaleInverse(true)
                -2*this.quatrePionsPossiblesLigne(false)
                + this.quatrePionsPossiblesLigne(true)
                -2*this.quatrePionsPossiblesColonne(false)
                + this.quatrePionsPossiblesColonne(true)
                -2*this.quatrePionsPossiblesDiagonaleNormale(false)
                + this.quatrePionsPossiblesDiagonaleNormale(true)
                -2*this.quatrePionsPossiblesDiagonaleInverse(false)
                + this.quatrePionsPossiblesDiagonaleInverse(true);
    }

}
