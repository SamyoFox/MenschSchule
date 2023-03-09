import java.util.concurrent.*;

import MenschExtends.Raeuber;
import MenschExtends.Zivilist;

public class AutomaticStory
{
    public static void main(String[] args) throws Exception{
        //Menschen werden erstellt
        Zivilist testMensch = new Zivilist(111, 111, "Test");
        Raeuber raeuberTyp = new Raeuber(222, 222, "Räuber");
        Zivilist mensch3 = new Zivilist(333, 333, "Mensch3");
        // Alle Menschen werden in einem Array gespeichert
        Zivilist[] zivilisten = new Zivilist[]{testMensch, mensch3};
        Raeuber[] raeuber = new Raeuber[]{raeuberTyp};
        // Insgesamt 1000 Aktionen werden ausgeführt
        for (int i=0;i<1000;i++){
            // Zufälliger Mensch für die Aktion wird ausgewählt
            int mensch = ThreadLocalRandom.current().nextInt(0, zivilisten.length);
            /* Zufällige Aktion wird ausgewählt
               Aktion 0: Erfrischungsgetränk nehmen
               Aktion 1: Mit anderer Person laufen gehen
               Aktion 2: Beklaut werden
               Aktion 3: Arbeiten                     */
            int aktion = ThreadLocalRandom.current().nextInt(0,4);
            switch(aktion){
                case 0:
                    // Die Stärke des Erfrischungsgetränkes wird zufällig entschieden
                    int energieStaerke = ThreadLocalRandom.current().nextInt(0, 100);
                    // Der vorhin per Zufall ausgewählte Mensch nimmt nun ein Erfrischungsgetränk von einer zufälligen Stärke
                    zivilisten[mensch].nehmeEineErfrischung(energieStaerke);
                    // Konsolenausgabe mit Name und neuem Energielevel
                    System.out.println(zivilisten[mensch].getName() + " nimmt ein Erfrischungsgetränk. Neues Energielevel: " + zivilisten[mensch].getEnergieReserve());
                    break;
                case 1:
                    // Zufälliger Mensch zum mitlaufen wird ausgewählt
                    int andererMensch = ThreadLocalRandom.current().nextInt(0, zivilisten.length);
                    // Falls der andere Mensch derselbe Mensch ist wird neu entschieden
                    while(andererMensch == mensch){
                        andererMensch = ThreadLocalRandom.current().nextInt(0, zivilisten.length);
                    }
                    // Die Länge der Strecke wird zufällig ausgewählt
                    int strecke = ThreadLocalRandom.current().nextInt(0, 100);
                    if (zivilisten[mensch].walkStrecke(strecke) && zivilisten[andererMensch].walkStrecke(strecke)){
                        System.out.println(zivilisten[mensch].getName() + " ist " + strecke + "km zusammen mit " + zivilisten[andererMensch].getName() + " gelaufen.");
                        System.out.println(zivilisten[mensch].getName() + " | Strecke insgesamt: " + zivilisten[mensch].getStrecke() + "km | Verbleibende Energie: " + zivilisten[mensch].getEnergieReserve());
                        System.out.println(zivilisten[andererMensch].getName() + " | Strecke insgesamt: " + zivilisten[mensch].getStrecke() + "km | Verbleibende Energie: " + zivilisten[mensch].getEnergieReserve());
                    } else if (zivilisten[mensch].walkStrecke(strecke)) {
                        System.out.println(zivilisten[mensch].getName() + " wollte zusammen mit " + zivilisten[andererMensch].getName() + " " + strecke + "km laufen, jedoch hatte nur " + zivilisten[mensch].getName() + " genug Energie dafür.");
                        System.out.println(zivilisten[mensch].getName() + " | Strecke insgesamt: " + zivilisten[mensch].getStrecke() + "km | Verbleibende Energie: " + zivilisten[mensch].getEnergieReserve());
                    } else if (zivilisten[andererMensch].walkStrecke(strecke)) {
                        System.out.println(zivilisten[mensch].getName() + " wollte zusammen mit " + zivilisten[andererMensch].getName() + " " + strecke + "km laufen, jedoch hatte nur " + zivilisten[andererMensch].getName() + " genug Energie dafür.");
                        System.out.println(zivilisten[andererMensch].getName() + " | Strecke insgesamt: " + zivilisten[andererMensch].getStrecke() + "km | Verbleibende Energie: " + zivilisten[andererMensch].getEnergieReserve());
                    } else {
                        System.out.println(zivilisten[andererMensch].getName() + " hat nicht genug Energie um " + strecke + "km zu laufen.");
                    }
                    
                    break;
                case 2:
                    int geld = ThreadLocalRandom.current().nextInt(0, 100);
                    int stealer = ThreadLocalRandom.current().nextInt(0, raeuber.length);
                    if (zivilisten[mensch].beklautWerden(raeuber[stealer], geld)){
                        System.out.println(zivilisten[mensch].getName() + " wurden " + geld + "€ von " + raeuber[stealer].getName() + "gestohlen");
                        System.out.println(zivilisten[mensch].getName() + " hat nun " + zivilisten[mensch].getMoney() + "€");
                        System.out.println(raeuber[stealer].getName() + " hat nun " + raeuber[stealer].getMoney() + "€"); 
                    } else {
                        System.out.println(raeuber[stealer].getName() + "  hat versucht " + zivilisten[mensch].getName() + " " + geld + "€ zu klauen, aber diese Person hat kein Geld.");
                    }
                    break;
                case 3:
                    int geldVerdient = ThreadLocalRandom.current().nextInt(0, 100);
                    zivilisten[mensch].setMoney(zivilisten[mensch].getMoney()+geldVerdient);
                    System.out.println(zivilisten[mensch].getName() + " hat gearbeitet und " + geldVerdient + "€ verdient.");
                    System.out.println(zivilisten[mensch].getName() + " hat nun " + zivilisten[mensch].getMoney() + "€");
                    break;
                }
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
