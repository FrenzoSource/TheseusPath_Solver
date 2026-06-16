package src;
import java.util.ArrayList;








public class Ligne {
    private ArrayList<Case> ligne;

    Ligne() {
        this.ligne = new ArrayList<Case>();
    }

    public ArrayList<Case> getLigne() { return this.ligne; }
    public Case getCase(int i) { return this.ligne.get(i); }

    public void ajoutCase(Case c1) {
        this.ligne.add(c1);
    };

    

    //Pour test
    public void afficherLigne() {
        for (Case c : this.ligne) {
            System.out.println(c.toString());
        };
    }


}
