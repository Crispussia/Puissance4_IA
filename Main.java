
import java.util.Scanner;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Main {
    public static void main(String[] args) {

        Puissance4 puissance3=new Puissance4();
        Noeud noeud=new Noeud(true,puissance3.getMatriceJeu());
        Coup coupJouIA;
        Scanner clavier = new Scanner(System.in);
        System.out.println("\n***********Bienvenue dans le Jeu Puissance 4*********\n");
        System.out.println("Choisissez votre tour de jeu: \n\n1 : Tour Joueur IA  \n2 : Tour JoueurHumain\n");
        System.out.print("Choix : ");
        int choix=0;
        int position = 1;
        while (position == 1) {
            choix = 0;
            clavier = new Scanner(System.in);
            try {
                position = 2;
                choix = clavier.nextInt();
                if (choix == 1 || choix == 2) {
                    position = 2;
                } else {
                    position = 1;
                    System.out.println("Choisissez votre tour de jeu: \n\n1 : Tour Joueur IA  \n2 : Tour JoueurHumain\n");
                    System.out.print("Choix : ");
                }

            } catch (Exception e) {
                position = 1;
                System.out.println("Choisissez votre tour de jeu: \n\n1 : Tour Joueur IA  \n2 : Tour JoueurHumain\n");
                System.out.print("Choix : ");

            }
        }
        System.out.println(choix);
        if (choix == 2) {
            noeud.setMax(!noeud.isMax());

        }
        /* ***DEBUT DU JEU*** */
        System.out.println("\n*********Debut du Jeu : ************\n");
        System.out.println(puissance3.toString());


        while(!puissance3.estFinJeu(!noeud.isMax(),puissance3.getMatriceJeu())) {
            noeud.setMatrice(puissance3.getMatriceJeu());

            /* Ia joue */
            if(noeud.isMax() == true){
                System.out.println("Tour Joueur IA");
                coupJouIA= puissance3.alpha_beta(noeud, MIN_VALUE, MAX_VALUE,4);
                puissance3.jouer(true,coupJouIA.getColonne(), puissance3.getMatriceJeu());
                System.out.println("\nLe joueur IA a joué à la colonne :  "+coupJouIA.getColonne());

            }
            else{
                System.out.println("Tour Joueur Humain");
                System.out.print("\nChoisir une colonne entre 0 et " + (puissance3.WIDTH-1) + " : ");
                System.out.println(" ");
                int coupJouHumain = 0;
                int position1 = 1;
                while (position1 == 1) {
                    coupJouHumain= 0;
                    Scanner scanner2 = new Scanner(System.in);
                    try {
                        position1 = 2;
                        coupJouHumain = scanner2.nextInt();
                        if (coupJouHumain >= 0 && coupJouHumain<= puissance3.WIDTH-1) {
                            position1 = 2;
                        } else {
                            position1= 1;
                            System.out.print("\nChoisir une colonne entre 0 et " + (puissance3.WIDTH-1) + " : ");
                            System.out.println(" ");
                        }

                    } catch (Exception e) {
                        position1 = 1;
                        System.out.print("\nChoisir une colonne entre 0 et " + (puissance3.WIDTH-1) + " : ");
                        System.out.println(" ");

                    }
                }
                puissance3.jouer(noeud.isMax(),coupJouHumain, puissance3.getMatriceJeu());

            }
            System.out.println(puissance3.toString());

            /* Tour Joueur Suivant */
            noeud.setMax(!noeud.isMax());
            System.out.println(" ");

        }
        /* Joueur qui gagne*/
        if(!noeud.isMax()==true){
            System.out.println("Victoire Joueur IA");
        }else{
            System.out.println("Victoire Joueur Humain");
        }

    }
}
