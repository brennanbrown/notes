/**
 * This class contains information about a planet. Upon creation of an
 * instance of this class the radius and the density must be provided. From an  
 * instance of this class the planet's radius, density, volume and mass can
 * be obtained.
 *
 * @version     10 Oct 2000
 * @author      Sharon Hoiland
 */

public class Planet{
    
	/**
     * the radius of the planet in meters
     */
    private double radius;

    /**
     * the density of the planet in kg/m3
     */
    private double density;
    

    /**
     * Constructor
     *
     * @param   radius  a double for the planet's radius in meters
     * @param   density a double for the planet's density in kg/m3
     */
    public Planet (double radius, double density){
      this.radius = radius;
      this.density = density;
    }

     /**
     * Default constructor
     * Creates an instance of Planet with radius of 1.0 and density of 1.0
     *
     */
    public Planet (){
     	this(1.0,1.0);
    }

    /** Set the radius of the Planet in meters
     *
     * @param a double for the radius of the planet in meters
     */
   public void setRadius(double radius) {
      this.radius = radius;
   }

    /**
     * Set the density of the planet in kg/m3
     * @param density double for the density of the planet in kg/m3
     */

   public void setDensity(double density) {
      this.density = density;
   }

/**
 * description of the method
 * @return density of planet
 */
   public double getDensity(){
      return density; 
   }
  /* Get the radius of the Planet in meters
     *
     * @return a double for the radius of the planet in meters
     */

   public double getRadius(){
      return radius;
   }
    /**
     * Get the volume of the planet in meters cubed
     *
     * @return a double for the value of the planet in meters cubed
     */

   public double getVolume() {
      return  (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
   }

    /*
     * Get the mass of the planet in kilograms
     * @return a double for the mass of the planet in kilograms
     */

   public double getMass (){
      return getVolume () * density;
   }

    /**
     * A quick test method for the class so it can be run standalone.
     * It creates a planet then tests the result of all methods.
     *
     * @param args an array of strings that contains command line arguments.
     * Not used in this case.
     */

   public static void main (String args []) {
      Planet p2 = new Planet (1 ,1);
   
      if (p2.getRadius () != 1.0) {
         System.out.println("incorrect radius: " + p2.getRadius());
      }
      if (p2.getDensity () != 1.0){
        System.out.println("incorrect density: " + p2.getDensity());
      }
      if (p2.getVolume() != (4.0 / 3.0) * Math.PI){
        System.out.println("incorrect voulme: " + p2.getVolume());
      }
      if (p2.getMass () != (4.0 / 3.0 ) * Math.PI){
         System.out.println("incorrect mass: " + p2.getMass());
      }
	System.out.println ("End of Test");
   }
}

