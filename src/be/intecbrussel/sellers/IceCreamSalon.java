package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone orderedCone = new Cone(flavors);
        this.totalProfit += (priceList.getBallPrice() * flavors.length);
        return orderedCone;
    }

    public IceRocket orderIceRocket() {
        IceRocket orderedIceRocket = new IceRocket();
        this.totalProfit += priceList.getRocketPrice();
        return orderedIceRocket;
    }

    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        Magnum orderedMagnum = new Magnum(magnumType);
        this.totalProfit += priceList.getMagnumPrice(magnumType);
        return orderedMagnum;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}

