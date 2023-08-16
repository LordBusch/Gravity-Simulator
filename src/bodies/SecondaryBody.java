package bodies;

import java.awt.Color;

public class SecondaryBody {
    private double velocity;
    private double mass;
    private double radius;
    private double angle;
    private double x;
    private double y;
    private Color color;

    public SecondaryBody(double velocity, double mass, double radius, double angle, double x, double y, Color color) {
        this.velocity = velocity;
        this.mass = mass;
        this.radius = radius;
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getVelocity() {
        return this.velocity;
    }
    public double getMass() {
        return this.mass;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getAngle() {
        return this.angle;
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

    public void setVelocity(double x) {
        this.velocity = x;
    }
    public void setMass(double x) {
        this.mass = x;
    }
    public void setRadius(double x) {
        this.radius = x;
    }
    public void setAngle(double x) {
        this.angle = x;
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
