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

    private static final int apronTHRESHOLD = 20;
    private static final int bowlTHRESHOLD = 500;


    public void addProduct(Delivery delivery) {
        HashMap<Product, Integer> map = delivery.getOrder().getOrder();
//
//        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
//            // Equipment Classes
//            if (entry.getKey().getClass().equals(Apron.class)) {
//                apron += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Bowl.class)) {
//                product2 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Cloth.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(DishWasher.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Fork.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(FryingPan.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Grill.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(HandMixer.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(HeatLamp.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(IceMachine.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Knife.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Microwave.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Mixer.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Oven.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(SaucePan.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Skillet.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Spoon.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(WashingMachine.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(WineOpener.class)) {
//                product3 += entry.getValue();
//            }
//
//
//            // Non-Perishable Classes
//        else if (entry.getKey().getClass().equals(BrownRice.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Bucatini.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(CocaCola.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(DrPepper.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Fanta.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Fettuccini.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Linguini.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(OliveOil.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Pepsi.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Ravioli.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Rigatoni.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Spaghetti.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Sprite.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(TomatoSauce.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(WhiteRice.class)) {
//                product3 += entry.getValue();
//            }
//
//
//            // Perishable Classes
//            else if (entry.getKey().getClass().equals(Beef.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Bread.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Butter.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Chicken.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Egg.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Goat.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(IcebergLettuce.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Lemon.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Oregano.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Pork.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Potato.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(RomanLettuce.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Salmon.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Tomato.class)) {
//                product3 += entry.getValue();
//            }
//            else if (entry.getKey().getClass().equals(Tuna.class)) {
//                product3 += entry.getValue();
//            }
//        }
//        validateStock();
//    }
//
//    public void validateStock() {
//        if (product1 > product1THRESHOLD) {
//            product1 = product1THRESHOLD;
//        }
//        else if (product2 > product2THRESHOLD) {
//            product2 = product2THRESHOLD;
//        }
//        else if (product3 > product3THRESHOLD) {
//            product3 = product3THRESHOLD;
//        }
//    }
//
//    public void consume(Product product) {
//        if (product.getClass().equals(PlaceholderProduct1.class)) {
//            product1--;
//        }
//        else if (product.getClass().equals(PlaceholderProduct1.class)) {
//            product2--;
//        }
//        else if (product.getClass().equals(PlaceholderProduct1.class)) {
//            product3--;
//        }
    }

}
