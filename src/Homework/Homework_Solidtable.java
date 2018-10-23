package Homework;

public enum Homework_Solidtable {

    ICE(0.92, 2.2, 0, 334),
    IRON(7.87, 0.45, 1538, 276),
    TUNGSTEN(19.3,0.13,3422,192),
    MAGNESIUM(1.74,1.02,650,368),

            ;

    double density;
    double heatCapacity;
    double meltPoint;
    double meltEntalpy;

    Homework_Solidtable (double d, double hc, double sp, double se) {
        density = d * 1E3;
        heatCapacity = hc * 1E3;
        meltPoint = sp;
        meltEntalpy = se * 1E3;
    }
}
