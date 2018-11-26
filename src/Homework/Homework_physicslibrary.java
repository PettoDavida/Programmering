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

    /**
     * Omvandling av en gas vid en viss volym till massa
     * @param gas vald gas
     * @param volume vald volym
     * @return massan av gasen vid den valda volymen
     */
    public static double volumeToMass(Homework_Gastable gas, double volume){

        return (gas.density * volume);
    }

    /**
     * omvandlar ett objekt av en volym till en massa
     * @param solid objekt
     * @param volume Volym av objekt
     * @return massan av ett objekt vid en viss volym
     */
    public static double volumeToMass(Homework_Solidtable solid, double volume) {

        return (solid.density * volume);
    }

    /**
     * omvandlar en viss längd och tid till fart
     * @param distance längd
     * @param time tid
     * @return farten av ett objekt
     */
    public static double svtVelocity(double distance, double time) {

        return (distance / time);
    }

    /**
     * omvandlar fart och tid till längd
     * @param velocity fart
     * @param time tid
     * @return längden
     */
    public static double svtDistance(double velocity, double time) {

        return (velocity * time);
    }

    /**
     * Omvandlar längd och fart till tid
     * @param distance längd
     * @param velocity fart
     * @return tiden
     */
    public static double svtTime(double distance, double velocity) {

        return (distance / velocity);
    }

    /**
     * omvandlar kraft och längd till arbete
     * @param force kraft
     * @param distance längd
     * @return arbete
     */
    public static double work(double force, double distance) {

        return (force * distance);
    }

    /**
     * Beräknar hur mycket kraft som behövs
     * @param work arbete
     * @param time tid
     * @return kraft
     */
    public static double power(double work, double time) {

        return (work / time);
    }

    /**
     * Beräknar hur mycket energi man  behöver för att värma ett material till en viss temp.
     * @param solid material
     * @param mass massa av material
     * @param deltaT temperaturen du vill ha
     * @return Energin som krävs för att värma upp
     */
    public static double heat(Homework_Solidtable solid, double mass, double deltaT) {

        return (mass * solid.heatCapacity * deltaT);
    }

    /**
     * Beräknar hur mycket energi man  behöver för att värma en vätska till en viss temp.
     * @param fluid vätskan
     * @param volume volym av vätskan
     * @param deltaT temperaturn du vill komma till
     * @return Energin för att värma upp vätskan
     */
    public static double heat(Homework_liquidtable fluid, double volume, double deltaT) {

        return (volume * fluid.heatCapacity * deltaT);
    }

    /**
     * Beräknar hur mycket energi man  behöver för att värma en gas till en viss temp.
     * @param gas gasen
     * @param volume volym av gasen
     * @param deltaT temperaturn man vill komma till
     * @return Energin för att värma upp gasen
     */
    public static double heat(Homework_Gastable gas, double volume, double deltaT) {

        return (volume * gas.heatCapacity * deltaT);
    }

    /**
     * Hur långt ett objekt har fallit med en konstant acceleration
     * @param velocity hastighet
     * @return längden objektet har fallit
     */
    public static double velocityToHeight(double velocity) {

        return (Math.pow(velocity, 2.0) / (g_swe * 2.0));
    }

    //Notering: Egna metoder

    /**
     * Omvandlar km per timma till meter per sekund
     * @param kmh fart i km/h
     * @return meter/sekund
     */
    public static double convertKMHToMS(double kmh) {

        return (kmh / 3.6);
    }

    /**
     * Omvandlar meter per sekund till km per timme
     * @param ms fart i meter per sekund
     * @return km per timme
     */
    public static double convertMSToKMH(double ms) {
        return ms * 3.6;
    }

    /**
     * Newtons andra lag: beräknar kraften av ett objekt
     * @param mass massa av objektet
     * @param acceleration acceleration
     * @return kraft av objekt
     */
    public static double force(double mass, double acceleration) {
        return mass * acceleration;
    }
}
