package com.toreforge;

import sun.jvm.hotspot.utilities.Assert;

import java.awt.*;
import java.util.HashMap;

public class Board {

    /**
     * Represents how many times did the
     * ball bounce. Use bounce() method
     * to modify this value
     */
    private int bounceCount = 0;

    /**
     * Map loaded from file
     */
    private HashMap<Point, Chamber> chambers = new HashMap<>();

    /**
     * Current ball position updated at load time
     */
    private Point currentBallPosition;

    /**
     * Size of loaded board
     */
    private Point boardSize;

    /**
     * Initial vector for the ball
     */
    private Vector currentVector;

    public void loadBoard() throws Exception {
        BoardLoader loader = new BoardLoader("input.txt");
        currentVector = new Vector(
                getVectorX(loader.getLine(0)),
                getVectorY(loader.getLine(0))
        );

        int columns = loader.getLine(1).length();
        boardSize = new Point(columns,loader.getLineCount() - 1);

        for (int row = 0; row < loader.getLineCount() - 1; row++) {
            // first row is a vector
            String line = loader.getLine(row + 1);
            for (int position = 0; position < line.length(); position++) {
                Point c = new Point(position, row);
                Chamber chamberType =
                        Chamber.fromString(String.valueOf(line.charAt(position)));
                chambers.put(c, chamberType);
                if (chamberType.equals(Chamber.BALL))
                    currentBallPosition = new Point(position, row);
            }
        }
    }

    private short getVectorX(String literalVector) {
        String v = literalVector.replace("(", "");
        return Short.valueOf(v.split(",")[0]);
    }

    private short getVectorY(String literalVector) {
        String v = literalVector.replace(")", "");
        return Short.valueOf(v.split(",")[1]);
    }

    public boolean isBoardLoaded() {
        return !chambers.isEmpty();
    }

    public Chamber getChamber(Point coords) {
        return chambers.get(coords);
    }

    public void setChamberType(Point coords, Chamber type) {
        chambers.put(coords, type);
    }

    public void setBallAt(Point position) {
        chambers.put(position, Chamber.BALL);
        currentBallPosition = position;
    }

    public void setMarkAt(Point position) {
        chambers.put(position, Chamber.MARK);
    }

    public Point getBallPosition() {
        return new Point(0, 0);
    }

    public void saveBoard() {

    }

    public void bounce() {
        bounceCount++;
    }

    public void bounce(int count) {
        bounceCount += count;
    }

    public int getBounceCount() {
        return bounceCount;
    }
}
