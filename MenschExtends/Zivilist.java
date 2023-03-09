package MenschExtends;

public class Zivilist extends Mensch{

    public Zivilist(int groesse, int gewicht, String name) {
        super(groesse, gewicht, name);
    }

        
    public boolean beklautWerden(Raeuber raeuber, int geld){
        if (geld<=getMoney()){
            setMoney(getMoney()-geld);
            raeuber.setMoney(raeuber.getMoney()+geld);
            return true;
        } else {
            return false;
        }
    }
    
}
