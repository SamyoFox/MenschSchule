package MenschExtends;

public class Raeuber extends Zivilist{

    public Raeuber(int groesse, int gewicht, String name) {
        super(groesse, gewicht, name);
    }

    public boolean klauen(Zivilist mensch, int geld){
        return mensch.beklautWerden(this, geld);
    }
    
}
