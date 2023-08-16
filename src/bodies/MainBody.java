package bodies;

import java.awt.Color;

public class MainBody {
    private double mass;
    private double radius;
    private double x;
    private double y;
    private Color color;

    public MainBody(double mass, double radius, double x, double y, Color color) {
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getMass() {
        return this.mass;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public Color getColor() {
        return this.color;
    }

    public void setMass(double x) {
        this.mass = x;
    }
    public void setRadius(double x) {
        this.radius = x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double x) {
        this.y = x;
    }
    public void setColor(Color x) {
        this.color = x;
    }
}
