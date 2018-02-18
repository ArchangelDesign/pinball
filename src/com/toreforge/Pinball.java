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

public class Pinball {

    public static void main(String[] args)
            throws IOException, BoardLoaderException, BoardNotLoadedException {

        Board b = new Board();

	    // create the board based on the input file
	    b.loadBoard();

	    // to get current position of the ball
	    Point ballPosition = b.getBallPosition();

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
                b.setCurrentVector(
                        Vector.transformVector(
                                b.getCurrentVector(),
                                b.getChamber(new Point(5, 1)
                                )
                        )
                );
            case END:
                // end the program
            case MARK:
                // the ball has already been here
            case BALL:
                // there is only one ball
            case EMPTY:
                // leave the mark and continue the movement
        }

        // to set the ball in the position
        b.setBallAt(new Point(2, 4));

	    // to set the mark (where the ball was)
	    b.setMarkAt(new Point(2, 3));

	    // apply vector to position
        Point newPosition = Vector.applyVector(new Point(5, 2), Vector.downRight());

        // put it to work
        b.setMarkAt(b.getBallPosition());
        b.setBallAt(Vector.applyVector(b.getBallPosition(), b.getCurrentVector()));

        // to save the board to the output
	    b.saveBoard();
    }
}
