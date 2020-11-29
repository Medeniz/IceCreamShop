package be.intecbrussel.eatables;

public class Cone implements Eatable {

    private Flavor[] balls;

    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        int arrayLenght = balls.length;
        String myMessage = "I am eating a cone with " + arrayLenght + " ball" + ((arrayLenght > 1) ? "s" : "") + ". ";
        myMessage += "My flavor choice" + ((arrayLenght > 1) ? "s" : "") + " " + ((arrayLenght > 1) ? "are: " : "is: ");
        for (int i = 0; i < arrayLenght; i++) {
            if (i < arrayLenght - 1) {
                myMessage += balls[i] + ", ";
            } else {
                myMessage += balls[i] + ".";
            }
        }
        System.out.println(myMessage);
    }

    public enum Flavor {
        STRAWBERRY, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE;
    }
}
