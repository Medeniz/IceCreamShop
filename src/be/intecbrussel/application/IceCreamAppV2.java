package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {
    public static void main(String[] args) {

        PriceList priceList = new PriceList(1, 5, 10);
        Stock carStock = new Stock(3, 2, 5, 2);
        IceCreamCar car = new IceCreamCar(priceList, carStock);

        Eatable[] allOrders = new Eatable[7];
        try {
            Eatable cone1 = car.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.BANANA});
            allOrders[0] = cone1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Eatable cone2 = car.orderCone(new Cone.Flavor[]{Cone.Flavor.MOKKA});
            allOrders[1] = cone2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Eatable cone3 = car.orderCone(new Cone.Flavor[]{Cone.Flavor.STRACIATELLA, Cone.Flavor.STRAWBERRY,
                    Cone.Flavor.LEMON, Cone.Flavor.VANILLA});
            allOrders[2] = cone3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Eatable iceRocket = car.orderIceRocket();
            allOrders[3] = iceRocket;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Eatable magnum1 = car.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
            allOrders[4] = magnum1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Eatable magnum2 = car.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
            allOrders[5] = magnum2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Eatable magnum3 = car.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
            allOrders[6] = magnum3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Eatable iceCream : allOrders) {
            if (iceCream instanceof Exception) {
                continue;
            }
            if (iceCream != null) {
                iceCream.eat();
            }
        }
        System.out.println("Total Profit: " + car.getProfit());
    }
}