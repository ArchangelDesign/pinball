package com.toreforge;

public enum Chamber {
    EMPTY,
    MARK,
    BALL,
    HORIZONTAL_BARRIER,
    VERTICAL_BARRIER,
    END,
    RIGHT_ANGLE_BOUNCE,
    LEFT_ANGLE_BOUNCE,
    TOP_LEFT_BOUNCE,
    TOP_RIGHT_BOUNCE,
    BOTTOM_LEFT_BOUNCE,
    BOTTOM_RIGHT_BOUNCE;

    public static Chamber fromString(String s) {
        switch (s.toUpperCase()) {
            case "O": return BALL;
            case "-": return HORIZONTAL_BARRIER;
            case "|": return VERTICAL_BARRIER;
            case "V": return BOTTOM_RIGHT_BOUNCE;
            case "^": return TOP_RIGHT_BOUNCE;
            case "U": return BOTTOM_LEFT_BOUNCE;
            case "A": return TOP_LEFT_BOUNCE;
            case "E": return END;
            case "/": return LEFT_ANGLE_BOUNCE;
            case "\\": return RIGHT_ANGLE_BOUNCE;
            case ".": return MARK;
            default: return EMPTY;
        }
    }
}
