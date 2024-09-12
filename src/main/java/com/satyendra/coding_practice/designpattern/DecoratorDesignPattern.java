package designpattern;

interface Pizza {
    String description();
    double cost();
}

class PlainPizza implements Pizza {

    @Override
    public String description() {
        return "Plain pizza";
    }

    @Override
    public double cost() {
        return 100.0;
    }
}

// Abstract Decorator
abstract class DecoratedPizza implements Pizza {
    protected Pizza decoratedPizza;

    public DecoratedPizza(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public String description() {
        return decoratedPizza.description();
    }

    @Override
    public double cost() {
        return decoratedPizza.cost();
    }
}

// Concrete decorator
class CheeseDecorator extends DecoratedPizza {
    public CheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String description() {
        return super.description() + ", Cheese Pizza";
    }

    @Override
    public double cost() {
        return super.cost() + 50.0;
    }
}

class PepperoniDecorator extends DecoratedPizza {
    public PepperoniDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String description() {
        return super.description() + ", Pepperoni Pizza";
    }

    @Override
    public double cost() {
        return super.cost() + 60.0;
    }
}

class MushroomDecorator extends DecoratedPizza {
    public MushroomDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String description() {
        return super.description() + ", Mushroom Pizza";
    }

    @Override
    public double cost() {
        return super.cost() + 70.0;
    }
}

class OliveDecorator extends DecoratedPizza {
    public OliveDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String description() {
        return super.description() + ", OliveDecorator Pizza";
    }

    @Override
    public double cost() {
        return super.cost() + 80.0;
    }
}
public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        System.out.println(pizza.description() + " $" + pizza.cost());

        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.description() + " $" + pizza.cost());

        pizza = new PepperoniDecorator(pizza);
        System.out.println(pizza.description() + " $" + pizza.cost());

        pizza = new MushroomDecorator(pizza);
        System.out.println(pizza.description() + " $" + pizza.cost());

        pizza = new OliveDecorator(pizza);
        System.out.println(pizza.description() + " $" + pizza.cost());
    }
}
