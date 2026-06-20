package src;
import java.util.*;


public class ZhangSuen implements Optimiseur {
    private ArrayList<Ligne> grille;

    ZhangSuen(ArrayList<Ligne> grille) {
        this.grille = grille;
    }



    public ArrayList<Ligne> getGrille() { return this.grille; }

    //fonction retournant true si la case contient 8 voisins
    public boolean VoisinsValides(int i, int j, ArrayList<Ligne> grille) {
        /*Si la case est compris entre 1 et la taille -2 alors elle possède auto deux voisins 
        Le labirinthe doit avoir une taille supp a 3*/
        if (grille.get(0).getLigne().size() > 3) {
            if ((j > 0) && (j < grille.get(0).getLigne().size() - 1)) { 
                ArrayList<Ligne> tabTmp = new ArrayList<Ligne>();  //tableau temporaire qui va permettre de verifier les conditions des voisins
                int nbreVoisinsBlanc = 0;
                boolean [] transitionsVoisins = new boolean[8];
                int indiceTabTrans = 0;

                for (int ligneActuelle = -1; ligneActuelle <= 1; ligneActuelle++) {
                    Ligne ligneTmp = new Ligne();
                    for (int colonneActuelle = -1; colonneActuelle <= -1; colonneActuelle++) {
                        ligneTmp.ajoutCase(grille.get(ligneActuelle).getCase(colonneActuelle));

                        if ((ligneActuelle != 1) && (colonneActuelle != 1)) { transitionsVoisins[indiceTabTrans] = grille.get(ligneActuelle).getCase(colonneActuelle).getMur(); indiceTabTrans++; }
                        
                        if (grille.get(ligneActuelle).getCase(colonneActuelle).getMur() == false) { nbreVoisinsBlanc++; };
                    };
                    tabTmp.add(ligneTmp);
                };

                //Verification que le nombre de voisins passant de noir a blanc soit égal à 1
                int black2white = 0;
                for (int k = 0; k < (transitionsVoisins.length-1); k++) {
                    if ((transitionsVoisins[k] == false) && (transitionsVoisins[k + 1] == true)) { black2white++; }
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
            else { return false;}

        }
        return false;
        
    }


    public ArrayList<Ligne> Optimisation(ArrayList<Ligne> grille) {
        //Parcours de la grille
        for (int i = 1; i < grille.size() - 1; i++) { //commence a la deuxieme ligne, la premiere étant forcémment un bord
            //parcours des cases
            for (int j = 0; j < grille.get(0).getLigne().size(); j++) {
                //Verification des conditions étape 1
                Case caseActuelle = grille.get(i).getCase(j);
                if ((caseActuelle.getMur() == false) && (VoisinsValides(i, j, grille))) {
                    caseActuelle.setMur(true);
                }
            }
        }
        return this.grille;
    }
    
}