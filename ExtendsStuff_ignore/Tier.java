package ExtendsStuff;
public class Tier {
    
    private int alter;
    private int groesse;
    private int gewicht;
    private String geschlecht;
    private String name;

    public Tier(int alter, int groesse, int gewicht, String geschlecht, String name) {
        this.alter = alter;
        this.groesse = groesse;
        this.gewicht = gewicht;
        this.geschlecht = geschlecht;
        this.name = name;
    }

    public int getAlter(){
        return this.alter;
    }

    public int getGroesse(){
        return this.groesse;
    }

    public int getGewicht(){
        return this.gewicht;
    }

    public String getGeschlecht(){
        return this.geschlecht;
    }
    
    public String getName(){
        return this.name;
    }

    public void schlafen(){
        // Schlafen
    }

    public void essen(){

    }

    public void trinken(){

    }

    public void laufen(String startPosition, String endPosition) {
        
    }

}