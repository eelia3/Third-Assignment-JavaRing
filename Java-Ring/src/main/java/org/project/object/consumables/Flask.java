package org.project.object.consumables;

import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public class Flask extends Consumable {
    private int flaskCount;
    private int fhp;
    private int fmp;

    public Flask(int fmp, int fhp, int flaskCount) {
        super("flask");
        this.fmp = fmp;
        this.fhp = fhp;
        this.flaskCount = flaskCount;
    }



    public int hflask() {
        if (flaskCount  >= 2) {
            flaskCount -= 2;
            return fhp;

        }
        else return 0;
    }

    public int mflask() {
        if (flaskCount >= 1) {
            flaskCount--;
            return fmp;
        } else {
            return 0;
        }
    }
}
