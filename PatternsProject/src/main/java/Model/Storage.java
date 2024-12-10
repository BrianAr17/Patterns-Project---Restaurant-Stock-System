package Model;

import Products.Equipment.*;
import Products.Non_Perishable.*;
import Products.Perishable.*;
import Products.Product;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    // Equipment fields
    private static int apron;
    private static int bowl;
    private static int cloth;
    private static int dishwasher;
    private static int fork;
    private static int fryingPan;
    private static int grill;
    private static int handMixer;
    private static int heatLamp;
    private static int iceMachine;
    private static int knife;
    private static int microwave;
    private static int mixer;
    private static int oven;
    private static int plate;
    private static int saucepan;
    private static int skillet;
    private static int spoon;
    private static int washingMachine;
    private static int wineOpener;
    // Non-Perishable fields
    private static int brownRice;
    private static int bucatini;
    private static int cocaCola;
    private static int drPepper;
    private static int fanta;
    private static int fettuccini;
    private static int linguini;
    private static int oliveOil;
    private static int pepsi;
    private static int ravioli;
    private static int rigatoni;
    private static int spaghetti;
    private static int sprite;
    private static int tomatoSauce;
    private static int whiteRice;
    // Perishable fields
    private static int beef;
    private static int bread;
    private static int butter;
    private static int chicken;
    private static int egg;
    private static int goat;
    private static int icebergLettuce;
    private static int lemon;
    private static int oregano;
    private static int pork;
    private static int potato;
    private static int romanLettuce;
    private static int salmon;
    private static int tomato;
    private static int tuna;

    // THRESHOLD
    // Equipment
    private static final int apronTHRESHOLD = 20;
    private static final int bowlTHRESHOLD = 500;
    private static final int clothTHRESHOLD = 100;
    private static final int dishwasherTHRESHOLD = 5;
    private static final int forkTHRESHOLD = 1000;
    private static final int fryingPanTHRESHOLD = 20;
    private static final int grillTHRESHOLD = 3;
    private static final int handMixerTHRESHOLD = 10;
    private static final int heatLampTHRESHOLD = 10;
    private static final int iceMachineTHRESHOLD = 2;
    private static final int knifeTHRESHOLD = 1000;
    private static final int microwavesTHRESHOLD = 3;
    private static final int mixerTHRESHOLD = 3;
    private static final int ovenTHRESHOLD = 6;
    private static final int plateTHRESHOLD = 750;
    private static final int saucePanTHRESHOLD = 20;
    private static final int skilletTHRESHOLD = 20;
    private static final int spoonTHRESHOLD = 500;
    private static final int washingMachineTHRESHOLD = 3;
    private static final int wineOpenerTHRESHOLD = 50;
    // Non-Perishable
    private static final int brownRiceTHRESHOLD = 20;
    private static final int bucatiniTHRESHOLD = 50;
    private static final int cocaColaTHRESHOLD = 250;
    private static final int drPepperTHRESHOLD = 250;
    private static final int fantaTHRESHOLD = 250;
    private static final int fettucciniTHRESHOLD = 50;
    private static final int linguiniTHRESHOLD = 50;
    private static final int oliveOilTHRESHOLD = 20;
    private static final int pepsiTHRESHOLD = 250;
    private static final int ravioliTHRESHOLD = 50;
    private static final int rigatoniTHRESHOLD = 50;
    private static final int spaghettiTHRESHOLD = 75;
    private static final int spriteTHRESHOLD = 250;
    private static final int tomatoSauceTHRESHOLD = 100;
    private static final int whiteRiceTHRESHOLD = 20;
    // Perishable
    private static final int beefTHRESHOLD = 100;
    private static final int breadTHRESHOLD = 500;
    private static final int butterTHRESHOLD = 100;
    private static final int chickenTHRESHOLD = 100;
    private static final int eggTHRESHOLD = 500;
    private static final int goatTHRESHOLD = 100;
    private static final int icebergLettuceTHRESHOLD = 75;
    private static final int lemonTHRESHOLD = 100;
    private static final int oreganoTHRESHOLD = 100;
    private static final int porkTHRESHOLD = 100;
    private static final int potatoTHRESHOLD = 500;
    private static final int romanLettuceTHRESHOLD = 75;
    private static final int salmonTHRESHOLD = 50;
    private static final int tomatoTHRESHOLD = 100;
    private static final int tunaTHRESHOLD = 50;


    public static void addProduct(Delivery delivery) {
        HashMap<Product, Integer> map = delivery.getOrder().getOrder();

        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            // Equipment Classes
            if (entry.getKey().getClass().equals(Apron.class)) {
                apron += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Bowl.class)) {
                bowl += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Cloth.class)) {
                cloth += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(DishWasher.class)) {
                dishwasher += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Fork.class)) {
                fork += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(FryingPan.class)) {
                fryingPan += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Grill.class)) {
                grill += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(HandMixer.class)) {
                handMixer += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(HeatLamp.class)) {
                heatLamp += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(IceMachine.class)) {
                iceMachine += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Knife.class)) {
                knife += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Microwave.class)) {
                microwave += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Mixer.class)) {
                mixer += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Oven.class)) {
                oven += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Plate.class)) {
                plate += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(SaucePan.class)) {
                saucepan += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Skillet.class)) {
                skillet += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Spoon.class)) {
                spoon += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(WashingMachine.class)) {
                washingMachine += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(WineOpener.class)) {
                wineOpener += entry.getValue();
            }


            // Non-Perishable Classes
            else if (entry.getKey().getClass().equals(BrownRice.class)) {
                brownRice += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Bucatini.class)) {
                bucatini += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(CocaCola.class)) {
                cocaCola += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(DrPepper.class)) {
                drPepper += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Fanta.class)) {
                fanta += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Fettuccini.class)) {
                fettuccini += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Linguini.class)) {
                linguini += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(OliveOil.class)) {
                oliveOil += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Pepsi.class)) {
                pepsi += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Ravioli.class)) {
                ravioli += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Rigatoni.class)) {
                rigatoni += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Spaghetti.class)) {
                spaghetti += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Sprite.class)) {
                sprite += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(TomatoSauce.class)) {
                tomatoSauce += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(WhiteRice.class)) {
                whiteRice += entry.getValue();
            }


            // Perishable Classes
            else if (entry.getKey().getClass().equals(Beef.class)) {
                beef += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Bread.class)) {
                bread += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Butter.class)) {
                butter += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Chicken.class)) {
                chicken += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Egg.class)) {
                egg += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Goat.class)) {
                goat += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(IcebergLettuce.class)) {
                icebergLettuce += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Lemon.class)) {
                lemon += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Oregano.class)) {
                oregano += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Pork.class)) {
                pork += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Potato.class)) {
                potato += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(RomanLettuce.class)) {
                romanLettuce += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Salmon.class)) {
                salmon += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Tomato.class)) {
                tomato += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(Tuna.class)) {
                tuna += entry.getValue();
            }
        }
        validateStock();
    }

    public static void validateStock() {
        // Equipment Classes
        if (apron > apronTHRESHOLD) {
            apron = apronTHRESHOLD;
        }
        else if (bowl > bowlTHRESHOLD) {
            bowl = bowlTHRESHOLD;
        }
        else if (cloth > clothTHRESHOLD) {
            cloth = clothTHRESHOLD;
        }
        else if (dishwasher > dishwasherTHRESHOLD) {
            dishwasher = dishwasherTHRESHOLD;
        }
        else if (fork > forkTHRESHOLD) {
            fork = forkTHRESHOLD;
        }
        else if (fryingPan > fryingPanTHRESHOLD) {
            fryingPan = fryingPanTHRESHOLD;
        }
        else if (grill > grillTHRESHOLD) {
            grill = grillTHRESHOLD;
        }
        else if (handMixer > handMixerTHRESHOLD) {
            handMixer = handMixerTHRESHOLD;
        }
        else if (heatLamp > heatLampTHRESHOLD) {
            heatLamp = heatLampTHRESHOLD;
        }
        else if (iceMachine > iceMachineTHRESHOLD) {
            iceMachine = iceMachineTHRESHOLD;
        }
        else if (knife > knifeTHRESHOLD) {
            knife = knifeTHRESHOLD;
        }
        else if (microwave > microwavesTHRESHOLD) {
            microwave = microwavesTHRESHOLD;
        }
        else if (mixer > mixerTHRESHOLD) {
            mixer = mixerTHRESHOLD;
        }
        else if (oven > ovenTHRESHOLD) {
            oven = ovenTHRESHOLD;
        }
        else if (plate > plateTHRESHOLD) {
            plate = plateTHRESHOLD;
        }
        else if (saucepan > saucePanTHRESHOLD) {
            saucepan = saucePanTHRESHOLD;
        }
        else if (skillet > skilletTHRESHOLD) {
            skillet = skilletTHRESHOLD;
        }
        else if (spoon > spoonTHRESHOLD) {
            spoon = spoonTHRESHOLD;
        }
        else if (washingMachine > washingMachineTHRESHOLD) {
            washingMachine = washingMachineTHRESHOLD;
        }
        else if (wineOpener > wineOpenerTHRESHOLD) {
            wineOpener = wineOpenerTHRESHOLD;
        }


        // Non-Perishable Classes
        else if (brownRice > brownRiceTHRESHOLD) {
            brownRice = brownRiceTHRESHOLD;
        }
        else if (bucatini > bucatiniTHRESHOLD) {
            bucatini = bucatiniTHRESHOLD;
        }
        else if (cocaCola > cocaColaTHRESHOLD) {
            cocaCola = cocaColaTHRESHOLD;
        }
        else if (drPepper > drPepperTHRESHOLD) {
            drPepper = drPepperTHRESHOLD;
        }
        else if (fanta > fantaTHRESHOLD) {
            fanta = fantaTHRESHOLD;
        }
        else if (fettuccini > fettucciniTHRESHOLD) {
            fettuccini = fettucciniTHRESHOLD;
        }
        else if (linguini > linguiniTHRESHOLD) {
            linguini = linguiniTHRESHOLD;
        }
        else if (oliveOil > oliveOilTHRESHOLD) {
            oliveOil = oliveOilTHRESHOLD;
        }
        else if (pepsi > pepsiTHRESHOLD) {
            pepsi = pepsiTHRESHOLD;
        }
        else if (ravioli > ravioliTHRESHOLD) {
            ravioli = ravioliTHRESHOLD;
        }
        else if (rigatoni > cocaColaTHRESHOLD) {
            rigatoni = rigatoniTHRESHOLD;
        }
        else if (spaghetti > spaghettiTHRESHOLD) {
            spaghetti = spaghettiTHRESHOLD;
        }
        else if (sprite > spriteTHRESHOLD) {
            sprite = spriteTHRESHOLD;
        }
        else if (tomatoSauce > tomatoSauceTHRESHOLD) {
            tomatoSauce = tomatoSauceTHRESHOLD;
        }
        else if (whiteRice > whiteRiceTHRESHOLD) {
            whiteRice = whiteRiceTHRESHOLD;
        }


        // Perishable Classes
        else if (beef > beefTHRESHOLD) {
            beef = beefTHRESHOLD;
        }
        else if (bread > breadTHRESHOLD) {
            bread = breadTHRESHOLD;
        }
        else if (butter > butterTHRESHOLD) {
            butter = butterTHRESHOLD;
        }
        else if (chicken > chickenTHRESHOLD) {
            chicken = chickenTHRESHOLD;
        }
        else if (egg > eggTHRESHOLD) {
            egg = eggTHRESHOLD;
        }
        else if (goat > goatTHRESHOLD) {
            goat = goatTHRESHOLD;
        }
        else if (icebergLettuce > icebergLettuceTHRESHOLD) {
            icebergLettuce = icebergLettuceTHRESHOLD;
        }
        else if (lemon > lemonTHRESHOLD) {
            lemon = lemonTHRESHOLD;
        }
        else if (oregano > oreganoTHRESHOLD) {
            oregano = oreganoTHRESHOLD;
        }
        else if (pork > porkTHRESHOLD) {
            pork = porkTHRESHOLD;
        }
        else if (potato > potatoTHRESHOLD) {
            potato = potatoTHRESHOLD;
        }
        else if (romanLettuce > romanLettuceTHRESHOLD) {
            romanLettuce = romanLettuceTHRESHOLD;
        }
        else if (salmon > salmonTHRESHOLD) {
            salmon = salmonTHRESHOLD;
        }
        else if (tomato > tomatoTHRESHOLD) {
            tomato = tomatoTHRESHOLD;
        }
        else if (tuna > tunaTHRESHOLD) {
            tuna = tunaTHRESHOLD;
        }
    }

    public static void consume(Product product) {
        // Equipment
        if (product.getClass().equals(Apron.class)) {
            apron--;
        }
        else if (product.getClass().equals(Bowl.class)) {
            bowl--;
        }
        else if (product.getClass().equals(Cloth.class)) {
            cloth--;
        }
        else if (product.getClass().equals(DishWasher.class)) {
            dishwasher--;
        }
        else if (product.getClass().equals(Fork.class)) {
            fork--;
        }
        else if (product.getClass().equals(FryingPan.class)) {
            fryingPan--;
        }
        else if (product.getClass().equals(Grill.class)) {
            grill--;
        }
        else if (product.getClass().equals(HandMixer.class)) {
            handMixer--;
        }
        else if (product.getClass().equals(HeatLamp.class)) {
            heatLamp--;
        }
        else if (product.getClass().equals(IceMachine.class)) {
            iceMachine--;
        }
        else if (product.getClass().equals(Knife.class)) {
            knife--;
        }
        else if (product.getClass().equals(Microwave.class)) {
            microwave--;
        }
        else if (product.getClass().equals(Mixer.class)) {
            mixer--;
        }
        else if (product.getClass().equals(Oven.class)) {
            oven--;
        }
        else if (product.getClass().equals(Plate.class)) {
            plate--;
        }
        else if (product.getClass().equals(Skillet.class)) {
            skillet--;
        }
        else if (product.getClass().equals(Spoon.class)) {
            spoon--;
        }
        else if (product.getClass().equals(WashingMachine.class)) {
            washingMachine--;
        }
        else if (product.getClass().equals(WineOpener.class)) {
            wineOpener--;
        }
        // Non-Perishable
        else if (product.getClass().equals(BrownRice.class)) {
            brownRice--;
        }
        else if (product.getClass().equals(Bucatini.class)) {
            bucatini--;
        }
        else if (product.getClass().equals(CocaCola.class)) {
            cocaCola--;
        }
        else if (product.getClass().equals(DrPepper.class)) {
            drPepper--;
        }
        else if (product.getClass().equals(Fanta.class)) {
            fanta--;
        }
        else if (product.getClass().equals(Fettuccini.class)) {
            fettuccini--;
        }
        else if (product.getClass().equals(Linguini.class)) {
            linguini--;
        }
        else if (product.getClass().equals(OliveOil.class)) {
            oliveOil--;
        }
        else if (product.getClass().equals(Pepsi.class)) {
            pepsi--;
        }
        else if (product.getClass().equals(Ravioli.class)) {
            ravioli--;
        }
        else if (product.getClass().equals(Rigatoni.class)) {
            rigatoni--;
        }
        else if (product.getClass().equals(Spaghetti.class)) {
            spaghetti--;
        }
        else if (product.getClass().equals(Sprite.class)) {
            sprite--;
        }
        else if (product.getClass().equals(TomatoSauce.class)) {
            tomatoSauce--;
        }
        else if (product.getClass().equals(WhiteRice.class)) {
            whiteRice--;
        }
        // Perishable
        else if (product.getClass().equals(Beef.class)) {
            beef--;
        }
        else if (product.getClass().equals(Bread.class)) {
            bread--;
        }
        else if (product.getClass().equals(Butter.class)) {
            butter--;
        }
        else if (product.getClass().equals(Chicken.class)) {
            chicken--;
        }
        else if (product.getClass().equals(Egg.class)) {
            egg--;
        }
        else if (product.getClass().equals(Goat.class)) {
            goat--;
        }
        else if (product.getClass().equals(IcebergLettuce.class)) {
            icebergLettuce--;
        }
        else if (product.getClass().equals(Lemon.class)) {
            lemon--;
        }
        else if (product.getClass().equals(Oregano.class)) {
            oregano--;
        }
        else if (product.getClass().equals(Pork.class)) {
            pork--;
        }
        else if (product.getClass().equals(RomanLettuce.class)) {
            romanLettuce--;
        }
        else if (product.getClass().equals(Salmon.class)) {
            salmon--;
        }
        else if (product.getClass().equals(Tomato.class)) {
            tomato--;
        }
        else if (product.getClass().equals(Tuna.class)) {
            tuna--;
        }
    }

    public static int getApron() {
        return apron;
    }

    public static int getBowl() {
        return bowl;
    }

    public static int getCloth() {
        return cloth;
    }

    public static int getDishwasher() {
        return dishwasher;
    }

    public static int getFork() {
        return fork;
    }

    public static int getFryingPan() {
        return fryingPan;
    }

    public static int getGrill() {
        return grill;
    }

    public static int getHandMixer() {
        return handMixer;
    }

    public static int getHeatLamp() {
        return heatLamp;
    }

    public static int getIceMachine() {
        return iceMachine;
    }

    public static int getKnife() {
        return knife;
    }

    public static int getMicrowave() {
        return microwave;
    }

    public static int getMixer() {
        return mixer;
    }

    public static int getOven() {
        return oven;
    }

    public static int getPlate() {
        return plate;
    }

    public static int getSaucepan() {
        return saucepan;
    }

    public static int getSkillet() {
        return skillet;
    }

    public static int getSpoon() {
        return spoon;
    }

    public static int getWashingMachine() {
        return washingMachine;
    }

    public static int getWineOpener() {
        return wineOpener;
    }

    public static int getBrownRice() {
        return brownRice;
    }

    public static int getBucatini() {
        return bucatini;
    }

    public static int getCocaCola() {
        return cocaCola;
    }

    public static int getDrPepper() {
        return drPepper;
    }

    public static int getFanta() {
        return fanta;
    }

    public static int getFettuccini() {
        return fettuccini;
    }

    public static int getLinguini() {
        return linguini;
    }

    public static int getOliveOil() {
        return oliveOil;
    }

    public static int getPepsi() {
        return pepsi;
    }

    public static int getRavioli() {
        return ravioli;
    }

    public static int getRigatoni() {
        return rigatoni;
    }

    public static int getSpaghetti() {
        return spaghetti;
    }

    public static int getSprite() {
        return sprite;
    }

    public static int getTomatoSauce() {
        return tomatoSauce;
    }

    public static int getWhiteRice() {
        return whiteRice;
    }

    public static int getBeef() {
        return beef;
    }

    public static int getBread() {
        return bread;
    }

    public static int getButter() {
        return butter;
    }

    public static int getChicken() {
        return chicken;
    }

    public static int getEgg() {
        return egg;
    }

    public static int getGoat() {
        return goat;
    }

    public static int getIcebergLettuce() {
        return icebergLettuce;
    }

    public static int getLemon() {
        return lemon;
    }

    public static int getOregano() {
        return oregano;
    }

    public static int getPork() {
        return pork;
    }

    public static int getPotato() {
        return potato;
    }

    public static int getRomanLettuce() {
        return romanLettuce;
    }

    public static int getSalmon() {
        return salmon;
    }

    public static int getTomato() {
        return tomato;
    }

    public static int getTuna() {
        return tuna;
    }
}