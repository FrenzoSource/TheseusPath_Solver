package src;
import java.util.*;
import javax.swing.*;
import java.awt.*;







public class Plateau {
    private ArrayList<Ligne> grille;

    Plateau() {
        this.grille = new ArrayList<Ligne>();
    }

    Plateau(ArrayList<Ligne> grille) {
        this.grille = grille;
    }

    public ArrayList<Ligne> getGrille() { return this.grille; }




    public void ajouterLigne(Ligne ligne) {
        this.grille.add(ligne);
    }

    public void ajouterLigne() {
        this.grille.add(new Ligne());
    }

    public void afficherGrille() {
        System.out.println("Affichage de la grille de labyrinthe.");
        for (Ligne ligne: this.grille) {
            ligne.afficherLigne();
        };
    }

    //Affichage par interface graphique du plateau 
    public void afficherPlateau() {
        JFrame panneau = new JFrame("Résolution labyrinthe");
        panneau.setLayout(new GridLayout(this.grille.size(), this.grille.get(0).getLigne().size()));
        //affichage selon la grille du plateau

        


        for (int i = 0; i < this.grille.size(); i++) {
            Ligne ligne = this.grille.get(i);
            for (int j = 0; j < ligne.getLigne().size(); j++) {
                Case c = ligne.getCase(j);
                JButton btnTmp = new JButton("");
                if (c.getMur() == true) {btnTmp.setBackground(Color.black); };
                panneau.add(btnTmp);

            };
        };


        panneau.setSize(400, 400);
        panneau.setVisible(true);
    }


}