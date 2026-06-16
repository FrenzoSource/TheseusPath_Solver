package src;
import java.io.*;

/*Convertir données txt sous forme de plateau */

public class ConversionDonnee {
    private String fileName;
    private Plateau plateau;

    ConversionDonnee(String nomFichier) {
        this.fileName = nomFichier;
    }

    public String getFileName() { return this.fileName; }
    public Plateau getPlateau() { return this.plateau; }

    public void setFileName(String nomFichier) { this.fileName = nomFichier; }
    

    public void recuperationDonnees() {
        System.out.println(new File(".").getAbsolutePath());
        BufferedReader tampon = null;
        try {
            tampon = new BufferedReader(new FileReader(this.fileName));
            //creation du plateau
            this.plateau = new Plateau();
            String ligne = null;
            int numeroLigne = 0;
            while ((ligne=tampon.readLine()) != null) {  //ajout de chaque ligne
                Ligne ligneTmp = new Ligne();
                for (int i = 0; i < ligne.length(); i++) {   //i correspondera au numero de colonne
                    //creation et ajout de chaque case. Mur ou case libre
                    Case caseTmp = new Case(numeroLigne, i, ligne.charAt(i) == '1', false);
                    ligneTmp.ajoutCase(caseTmp);
                }
                this.plateau.ajouterLigne(ligneTmp);
                ++numeroLigne;
                System.out.println(ligne);
            };
        }
        catch(IOException e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        }
    }





}