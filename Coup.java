public class Coup {

    private int eval;
    private int colonne;

    public Coup(int val, int c){
        this.eval = val;
        this.colonne = c;
    }

    public int getEval(){
        return this.eval;
    }


    public int getColonne(){
        return this.colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setEval(int eval) {
        this.eval = eval;
    }
}
