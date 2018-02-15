package com.toreforge;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class BoardWriter {

    public static void saveBoard(Point size, HashMap<Point, Chamber> board)
            throws IOException {
        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("output.txt")
                );
        writer.close();
    }
}
