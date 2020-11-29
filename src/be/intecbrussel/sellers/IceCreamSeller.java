package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public interface IceCreamSeller extends Profitable {

    public Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException;

    public IceRocket orderIceRocket() throws NoMoreIceCreamException;

    public Magnum orderMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException;
}
