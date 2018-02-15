package com.toreforge;

import com.toreforge.exception.BoardLoaderException;

import java.io.IOException;

public class Main {

    public static void main(String[] args)
            throws IOException, BoardLoaderException {
	    Board b = new Board();
	    b.loadBoard();
	    b.saveBoard();
    }
}
