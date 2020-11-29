package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    private PriceList priceList;
    private Stock stock;
    private double profit;


    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        return prepareCone(flavors);
    }

    private Cone prepareCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        Cone orderedCone = new Cone(flavors);
        int coneInStock = stock.getCones();
        int ballInStock = stock.getBalls();

        if (coneInStock == 0) {
            throw new NoMoreIceCreamException("Unfortunately we don't have any more cone left...");
        } else {
            if (ballInStock == 0) {
                throw new NoMoreIceCreamException("Unfortunately we don't have any more balls left...");
            } else {
                this.profit += priceList.getBallPrice() * flavors.length;
                ballInStock -= flavors.length;
                coneInStock -= 1;
            }
        }
        stock.setBalls(ballInStock);
        stock.setCones(coneInStock);

        return orderedCone;
    }


    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        return prepareRocket();
    }

    private IceRocket prepareRocket() throws NoMoreIceCreamException {
        IceRocket orderedIceRocket = new IceRocket();
        int rocketInStock = stock.getIceRockets();

        if (rocketInStock == 0) {
            throw new NoMoreIceCreamException("Sorry, we ran out of ice rockets");
        } else {
            rocketInStock -= 1;
            this.profit = priceList.getRocketPrice();
        }
        stock.setIceRockets(rocketInStock);

        return orderedIceRocket;
    }

    public Magnum orderMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        return prepareMagnum(magnumType);
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        Magnum orderedMagnum = new Magnum(magnumType);
        int magnumInStock = stock.getMagni();

        if (magnumInStock == 0) {
            throw new NoMoreIceCreamException("Sorry, we ran out of magnum");
        } else {
            magnumInStock -= 1;
            this.profit = priceList.getMagnumPrice(magnumType);
        }
        this.profit += priceList.getMagnumPrice(magnumType);
        stock.setMagni(magnumInStock);
        return orderedMagnum;
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
