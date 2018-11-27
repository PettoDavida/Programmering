package Homework;

public enum Homework_Planettable {

    MERCURY(3.301 * 10E23),
    VENUS(4.867 * 10E24),
    EARTH(5.972 * 10E24),
    MARS(6.417 * 10E23),
    JUPITER(1.898 * 10E27),
    SATURN(5.683 * 10E26),
    URANUS(8.681 * 10E25),
    NEPTUNE(1.024 * 10E26);

    double mass;

    Homework_Planettable(double mass) {
        this.mass = mass;
    }
}
