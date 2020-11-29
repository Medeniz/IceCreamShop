package be.intecbrussel.application;
//import be.intecbrussel.sellers.IceCreamCar;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(1, 5, 10);
        IceCreamSalon salon = new IceCreamSalon(priceList);

        Cone cone1 = salon.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.BANANA});
        Cone cone2 = salon.orderCone(new Cone.Flavor[]{Cone.Flavor.MOKKA});
        Cone cone3 = salon.orderCone(new Cone.Flavor[]{Cone.Flavor.STRACIATELLA, Cone.Flavor.STRAWBERRY, Cone.Flavor.LEMON, Cone.Flavor.VANILLA});
        IceRocket iceRocket = salon.orderIceRocket();
        Magnum magnum1 = salon.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        Magnum magnum2 = salon.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        Magnum magnum3 = salon.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);

        Eatable[] iceCreamOrders = new Eatable[]{cone1, cone2, cone3, iceRocket, magnum1, magnum2, magnum3};
        for (Eatable icecream : iceCreamOrders) {
            icecream.eat();
        }
        System.out.println("Total Profit: " + salon.getProfit());
    }
}
