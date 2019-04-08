package Homework;

public enum Homework_Gastable {

    AIR(1.29, 1.01),
    OXYGEN(1.43, 0.92),
    HELIUM(0.18,5.1),
    XENON(5.89,0.16),
    METHANE(0.72,2.21)
    ;

    double density;
    double heatCapacity;

    Homework_Gastable(double d, double hc) {
        density = d;
        heatCapacity = hc * 1E3; // 1E3 = 1*10^3
    }
}
