package src;
import java.util.*;


public class ZhangSuen implements Optimiseur {
    private ArrayList<Ligne> grille;

    ZhangSuen(ArrayList<Ligne> grille) {
        this.grille = grille;
    }



    public ArrayList<Ligne> getGrille() { return this.grille; }

    //fonction retournant true si la case contient 8 voisins
    public boolean Etape2(int i, int j, ArrayList<Ligne> grille) {
        /*Si la case est compris entre 1 et la taille -2 alors elle possède auto deux voisins 
        Le labirinthe doit avoir une taille supp a 3*/
        if (grille.get(0).getLigne().size() > 3) {
            if ((j > 0) && (j < grille.get(0).getLigne().size() - 1)) { 
                int nbreVoisinsBlanc = 0;
                boolean [] transitionsVoisins = new boolean[8];  //tableau qui va stocker les voisins de la case actuelle


                transitionsVoisins[0] = grille.get(i - 1).getCase(j).getMur();     // P2
                transitionsVoisins[1] = grille.get(i - 1).getCase(j + 1).getMur(); // P3
                transitionsVoisins[2] = grille.get(i).getCase(j + 1).getMur();     // P4
                transitionsVoisins[3] = grille.get(i + 1).getCase(j + 1).getMur(); // P5
                transitionsVoisins[4] = grille.get(i + 1).getCase(j).getMur();     // P6
                transitionsVoisins[5] = grille.get(i + 1).getCase(j - 1).getMur(); // P7
                transitionsVoisins[6] = grille.get(i).getCase(j - 1).getMur();     // P8
                transitionsVoisins[7] = grille.get(i - 1).getCase(j - 1).getMur(); // P9

                for (int i2 = 0; i2 < transitionsVoisins.length; i2++) {
                    if (transitionsVoisins[i2] == false) { nbreVoisinsBlanc++; };   //false == Mur == blanc
                };



                //Verification que le nombre de voisins passant de noir a blanc soit égal à 1
                int black2white = 0;
                for (int k = 0; k < 8; k++) {
                    int next = (k + 1) % 8;

                    if ((transitionsVoisins[k] == true) && (transitionsVoisins[next] == false)) {
                        black2white++;
                    }
                }


                //Verification finale des conditions
                if (
                    ((nbreVoisinsBlanc >= 2) && (nbreVoisinsBlanc <= 6)) &&
                    ((grille.get(i - 1).getCase(j).getMur() == true) || (grille.get(i).getCase(j + 1).getMur() == true) || (grille.get(i).getCase(j - 1).getMur() == true)) &&
                    ((grille.get(i - 1).getCase(j).getMur() == true) || (grille.get(i + 1).getCase(j).getMur() == true) || (grille.get(i).getCase(j - 1).getMur() == true)) &&
                    (black2white == 1)
                ) { return true; }
                
                return false;
            }
            return false;

        }
        return false;
        
    }


    public boolean Etape1(int i, int j, ArrayList<Ligne> grille) {
        /*Si la case est compris entre 1 et la taille -2 alors elle possède auto deux voisins 
        Le labirinthe doit avoir une taille supp a 3*/
        if (grille.get(0).getLigne().size() > 3) {
            if ((j > 0) && (j < grille.get(0).getLigne().size() - 1)) { 
                int nbreVoisinsBlanc = 0;
                boolean [] transitionsVoisins = new boolean[8];  //tableau qui va stocker les voisins de la case actuelle


                transitionsVoisins[0] = grille.get(i - 1).getCase(j).getMur();     // P2
                transitionsVoisins[1] = grille.get(i - 1).getCase(j + 1).getMur(); // P3
                transitionsVoisins[2] = grille.get(i).getCase(j + 1).getMur();     // P4
                transitionsVoisins[3] = grille.get(i + 1).getCase(j + 1).getMur(); // P5
                transitionsVoisins[4] = grille.get(i + 1).getCase(j).getMur();     // P6
                transitionsVoisins[5] = grille.get(i + 1).getCase(j - 1).getMur(); // P7
                transitionsVoisins[6] = grille.get(i).getCase(j - 1).getMur();     // P8
                transitionsVoisins[7] = grille.get(i - 1).getCase(j - 1).getMur(); // P9

                for (int i2 = 0; i2 < transitionsVoisins.length; i2++) {
                    if (transitionsVoisins[i2] == false) { nbreVoisinsBlanc++; };   //false == Mur == blanc
                };



                //Verification que le nombre de voisins passant de noir a blanc soit égal à 1
                int black2white = 0;
                for (int k = 0; k < 8; k++) {
                    int next = (k + 1) % 8;

                    if ((transitionsVoisins[k] == true) && (transitionsVoisins[next] == false)) {
                        black2white++;
                    }
                }


                //Verification finale des conditions
                if (
                    ((nbreVoisinsBlanc >= 2) && (nbreVoisinsBlanc <= 6)) &&
                    ((grille.get(i - 1).getCase(j).getMur() == true) || (grille.get(i).getCase(j + 1).getMur() == true) || (grille.get(i + 1).getCase(j).getMur() == true)) &&
                    ((grille.get(i).getCase(j + 1).getMur() == true) || (grille.get(i + 1).getCase(j).getMur() == true) || (grille.get(i).getCase(j - 1).getMur() == true)) &&
                    (black2white == 1)
                ) { return true; }
                
                return false;
            }
            return false;

        }
        return false;
        
    }


    public ArrayList<Ligne> Optimisation(ArrayList<Ligne> grille) {
        //Etape 1
        for (int i = 1; i < grille.size() - 1; i++) { //commence a la deuxieme ligne, la premiere étant forcémment un bord
            //parcours des cases
            for (int j = 1; j < grille.get(0).getLigne().size() - 1; j++) {
                //Verification des conditions étape 1
                Case caseActuelle = grille.get(i).getCase(j);
                if ((caseActuelle.getMur() == false) && (Etape1(i, j, grille))) {
                    caseActuelle.setMur(true);
                }
            }
        }

        //Etape 2
        for (int i = 1; i < grille.size() - 1; i++) { //commence a la deuxieme ligne, la premiere étant forcémment un bord
            //parcours des cases
            for (int j = 1; j < grille.get(0).getLigne().size() - 1; j++) {
                //Verification des conditions étape 1
                Case caseActuelle = grille.get(i).getCase(j);
                if ((caseActuelle.getMur() == false) && (Etape2(i, j, grille))) {
                    caseActuelle.setMur(true);
                }
            }
        }
        
        return this.grille;
    }
    
}