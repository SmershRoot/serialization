package ru.sbt.serialization;

/**
 * Created by Home on 17.07.2018.
 */
public class SomePoint {
    private String name;
    private double x;
    private double y;

    protected SomePoint( double x, double y, String name ) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
