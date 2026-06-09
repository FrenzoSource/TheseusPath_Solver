package src;








public class Case {
    private int x;
    private int y;
    private boolean Mur;
    private boolean EstPasse;


    Case(int x, int y, boolean mur, boolean estPasse) {
        this.x = x;
        this.y = y;
        this.Mur = mur;
        this.EstPasse = estPasse;
    }


    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public boolean getMur() { return this.Mur; }
    public boolean getEstPasse() { return this.EstPasse; }


    public void setMur(boolean bool) { this.Mur = bool; }
    public void setEstPasse(boolean bool) { this.EstPasse = bool; }


    public String toString() { return "case de coordonnes (" + this.getX() + "," + this.getY() + "), Mur:" + this.getMur(); }

    
}