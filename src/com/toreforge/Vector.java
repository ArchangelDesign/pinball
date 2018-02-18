package com.toreforge;

import java.awt.*;

/**
 * Vector wrapper
 * represents direction of the ball
 */
public class Vector {
    private short x;
    private short y;

    /**
     * Initializes vector with initial horizontal
     * and vertical movement speed.
     * @param horizontal speed x
     * @param vertical speed y
     */
    public Vector(short horizontal, short vertical) {
        x = horizontal;
        y = vertical;
    }

    /**
     * Returns new coordinates affected by the vector
     *
     * @param coords current coordinates
     * @param vec vector to apply
     * @return new position
     */
    public static Point applyVector(Point coords, Vector vec) {
        return new Point(coords.x + vec.x, coords.y + vec.y);
    }

    /**
     * @return left vector
     */
    public static Vector left() {
        return new Vector(Short.valueOf("-1"), Short.valueOf("0"));
    }

    /**
     * @return right vector
     */
    public static Vector right() {
        return new Vector(Short.valueOf("1"), Short.valueOf("0"));
    }

    /**
     * @return up vector
     */
    public static Vector up() {
        return new Vector(Short.valueOf("0"), Short.valueOf("-1"));
    }

    /**
     * @return down vector
     */
    public static Vector down() {
        return new Vector(Short.valueOf("0"), Short.valueOf("1"));
    }

    /**
     * @return up and right vector
     */
    public static Vector upRight() {
        return new Vector(Short.valueOf("1"), Short.valueOf("-1"));
    }

    /**
     * @return up and left vector
     */
    public static Vector upLeft() {
        return new Vector(Short.valueOf("-1"), Short.valueOf("1"));
    }

    /**
     * @return down and right vector
     */
    public static Vector downRight() {
        return new Vector(Short.valueOf("1"), Short.valueOf("1"));
    }

    /**
     * @return down and left vector
     */
    public static Vector downLeft() {
        return new Vector(Short.valueOf("-1"), Short.valueOf("1"));
    }

    /**
     * This method takes into account the collision
     * and calculates new vector to be applied to the ball
     *
     * @param input current ball vector
     * @return vector adjusted based on the collision
     */
    public static Vector transformVector(Vector input, Chamber collision) {
        // here is where the magic happens
        return null;
    }
}
