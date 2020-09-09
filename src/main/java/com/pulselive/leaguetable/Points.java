package com.pulselive.leaguetable;

/**
 * Holds values for match result points for won, drawn and lost
 *
 * @author sahak_babayan
 *
 */
public enum Points {
    WON(3),
    DRAWN(1),
    LOST(0);

    private int point;

    Points(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
