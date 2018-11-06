package Homework;

public class Homework_physicslibrary {

    static final double g=9.82;          // Gravitaionskonstanten (m/s)
    static final double r=8.314;         // Allmänna gaskonstanten (J mol^-1 K^-1)
    static final double p_0=101325;      // lufttrycket vid havsytan (PA)
    static final double c=299792458;     // Ljusetshastighet (m/s)
    static final double g_swe=9.82;      //Tyngdacceleration i Sverige (m/s)

    public static void main(String args[]){



    }

    /**
     * Tar in fahrenheit och konverterar till celsius
     * @param fahrenheit är en input av grader i fahrenheit
     * @return fahrenheit i celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit){

        return (fahrenheit - 32)/1.8;
    }
    /**
     *Tar in kelvin och omvandlar till celsius
     * @param kelvin är en input av grader i kelvin
     * @return kelvin i celius
     */
    public static double kelvinToCelsius(double kelvin){

        return (kelvin - 273.15);
    }

    /**
     * Räknar ut en vätskas tryck beroende på djup
     * @param density´Densiteten av vätskan
     * @param deep Djupet du vill räkna ut på
     * @return trycket av vätskan på djupet
     */
    public static double fluidPressure(Homework_liquidtable density, double deep){

        return (density.density * g * deep);
    }

    /**
     * Tryck under vattnet vi ett visst djup
     * @param deep djupet du vill räkna ut på
     * @return trycket vatten har på ett visst djup
     */
    public static double pressureUnderWater(double deep) {

        return (Homework_liquidtable.WATER.density * g * deep);
    }

    /**
     * hur mycket kinetiskkraft har ett rörande objekt av en viss massa i en viss fart
     * @param mass massan av objekt
     * @param velocity farten av objektet
     * @return kinetiska energin av ett objekt av en massa
     */
    public static double kineticEnergy(double mass, double velocity){

        return (mass * Math.pow(velocity, 2)/2);
    }

    /**
     * Uträkning av den potentiella energin av ett objekt vid en viss höjg
     * @param mass objektets vikt
     * @param height höjden ett objekt startar vid
     * @return Potentiella energin av objektet
     */
    public static double potentialEnergy(double mass, double height){

        return (mass * g * height);
    }

    /**
     * Beräkning av ett objekts fart vid en utsatt höjd
     * @param height höjden objektet ska falla från
     * @return farten av objektet
     */
    public static double fallSpeed(double height){

        return Math.sqrt(2 * height * g);
    }

    /**
     * Skillnaden mellan två olika tal
     * @param first Ett tal
     * @param last Ett annat tal
     * @return skillnaden av de två talen
     */
    public static double delta(double first, double last){

        return (last - first);
    }

    /**
     * omvandla en vätska till massa
     * @param fluid vätskan du vill omvandla
     * @param volume volymen du vill omvandla
     * @return en vätska i en viss volym omvandlad till massa
     */
    public static double volumeToMass(Homework_liquidtable fluid, double volume){

        return (fluid.density * volume);
    }




}
