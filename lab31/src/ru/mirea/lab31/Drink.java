package ru.mirea.lab31;

public final class Drink extends MenuItem implements Alcoholable {
    private double alcoholVol;
    private DrinkTypeEnum type;

    public Drink(int price, String name, String description, DrinkTypeEnum type) throws IllegalArgumentException {
        super(price, name, description);
        if (type == null) throw new IllegalArgumentException("Object of Drink has incorrect characteristics!");
        this.type = type;
    }

    public Drink(String name, String description, DrinkTypeEnum type) throws IllegalArgumentException {
        super(0, name, description);
        if (type == null) throw new IllegalArgumentException("Object of Drink has incorrect characteristics!");
        this.type = type;
    }

    public void setAlcoholVol(double alcoholVol) {
        this.alcoholVol = alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return type != DrinkTypeEnum.JUICE &&
                type != DrinkTypeEnum.COFFEE &&
                type != DrinkTypeEnum.GREEN_TEA &&
                type != DrinkTypeEnum.BLACK_TEA &&
                type != DrinkTypeEnum.MILK &&
                type != DrinkTypeEnum.WATER &&
                type != DrinkTypeEnum.SODA;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }
}
