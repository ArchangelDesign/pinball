package com.toreforge;

import com.toreforge.exception.BoardLoaderException;
import com.toreforge.exception.BoardNotLoadedException;

import java.awt.*;
import java.io.IOException;

/**
 * To_Reforge Challenge
 * Date: 2018-02-20
 * Author: Rafal Martinez-Marjanski
 * Brief: Calculate the final position of the ball
 * license: GPL
 */

public class Main {

    public static void main(String[] args)
            throws IOException, BoardLoaderException, BoardNotLoadedException {

        Board b = new Board();

	    // create the board based on the input file
	    b.loadBoard();

	    // to get current position of the ball
	    Point bollPosition = b.getBallPosition();

	    // to set new ball position
	    b.setBallAt(new Point(1,1));

	    // to get the chamber type
	    switch (b.getChamber(new Point(5, 1))) {
            case BOTTOM_RIGHT_BOUNCE:
            case RIGHT_ANGLE_BOUNCE:
            case HORIZONTAL_BARRIER:
            case BOTTOM_LEFT_BOUNCE:
            case LEFT_ANGLE_BOUNCE:
            case VERTICAL_BARRIER:
            case TOP_RIGHT_BOUNCE:
            case TOP_LEFT_BOUNCE:
            case END:
            case MARK:
            case BALL:
            case EMPTY:
        }

        // to set the ball in the position
        b.setBallAt(new Point(2, 4));

	    // to set the mark (where the ball was)
	    b.setMarkAt(new Point(2, 3));

	    // apply vector to position
        Point newPosition = Vector.applyVector(new Point(5, 2), Vector.downRight());

	    // to save the board to the output
	    b.saveBoard();
    }
}
