package bodies;

import java.awt.Color;

public class ObjectBody {
    private String name;
    private double velocityX;
    private double velocityY;
    private double mass;
    private double radius;
    private double x;
    private double y;
    private Color color;

    public ObjectBody(String name, double velocityX, double velocityY, double mass, double radius, double x, double y, Color color) {
        this.name = name;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }
    public double getVelocityX() {
        return this.velocityX;
    }
    public double getVelocityY() {
        return this.velocityY;
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

    public void setName(String x) {
        this.name = x;
    }
    public void setVelocityX(double x) {
        this.velocityX = x;
    }
    public void setVelocityY(double x) {
        this.velocityY = x;
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

    @Override
    public String toString() {
        return name;
    }
}
