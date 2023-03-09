package MenschExtends;

public class Mensch
{
    
    private int groesse;
    private int gewicht;
    private int strecke;
    private int energieReserve;
    private int geld;
    private String name;
    
    public Mensch(int groesse, int gewicht, String name)
    {
        this.groesse = groesse;
        this.gewicht = gewicht;
        this.strecke = 0;
        this.energieReserve = 100;
        this.geld = 1000;
        this.name = name;
    }
    
    public int getGroesse(){
        return this.groesse;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getGewicht(){
        return this.gewicht;
    }
    
    public int getStrecke(){
        return this.strecke;
    }
    
    public int getEnergieReserve(){
        return this.energieReserve;
    }
    
    public int getMoney(){
        return this.geld;
    }
    
    public void setMoney(int newValue){
        this.geld = newValue;
    }
    
    public boolean walkStrecke(int walkDistance){
        if (energieReserve >= walkDistance){
            strecke+=walkDistance;
            energieReserve-=walkDistance;
            return true;
        } else {
            return false;
        }
    }
    
    public void nehmeEineErfrischung(int erfrischung){
        energieReserve+=erfrischung;
    }
    
}
