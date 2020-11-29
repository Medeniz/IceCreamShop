package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    private MagnumType type;

    public Magnum() {
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return this.type;
    }

    @Override
    public void eat() {
        String myMessage = "I am eating a " + getType() + " Magnum";
        System.out.println(myMessage);
    }

    public enum MagnumType {
        MILKCHOCOLATE(1), WHITECHOCOLATE(2), BLACKCHOCOLATE(2), ALPINENUTS(3), ROMANTICSTRAWBERRIES(4);

        private double rate;

        MagnumType(double rate) {
            this.rate = rate;
        }

        public double getRate() {
            return this.rate;
        }

    }
}


