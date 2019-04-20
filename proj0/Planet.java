public class Planet {

	public double xxPos, yyPos;
	public double xxVel, yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;


	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
 
    public Planet(Planet P) {
    	xxPos = P.xxPos;
    	yyPos = P.yyPos;
    	xxVel = P.xxVel;
    	yyVel = P.yyVel;
    	mass = P.mass;
    	imgFileName = P.imgFileName;
    }

    /** Calculate the distance between two planets.*/
    public double calcDistance(Planet P) {
    	double r = Math.sqrt((P.xxPos - xxPos) * (P.xxPos - xxPos) + (P.yyPos - yyPos) * (P.yyPos - yyPos));
    	return r;
    }

    /** Calculate the force exerted on this planet by the given planet.*/
    public double calcForceExertedBy(Planet P) {
    	double distanceSquare = this.calcDistance(P) * this.calcDistance(P);
    	double force = G*P.mass*mass/(distanceSquare);
    	return force;
    }

    /** Calculate the the force exerted in the X direction with sign*/
    public double calcForceExertedByX(Planet P) {
    	double dx = P.xxPos - xxPos;
    	double dy = P.yyPos - yyPos;
    	double force = this.calcForceExertedBy(P);
    	double forceX = force*dx/this.calcDistance(P);
    	return forceX;
    } 

/** Calculate the the force exerted in the Y direction with sign. */
	public double calcForceExertedByY(Planet P) {
		double dx = P.xxPos - xxPos;
    	double dy = P.yyPos - yyPos;
    	double force = this.calcForceExertedBy(P);
    	double forceY = force*dy/this.calcDistance(P);
    	return forceY;
    } 
/**  take in an array of Planets and calculate the net X force exerted by all planets in that array. */
	public double calcNetForceExertedByX(Planet[] list) {
		double sumOfForceInX = 0;
		for(Planet temp:list) {
    		if(this.equals(temp)) {
    			continue;
    		}
    		sumOfForceInX += this.calcForceExertedByX(temp);
		}
        return sumOfForceInX;
	}

/**  take in an array of Planets and calculate the net Y force exerted by all planets in that array. */
	public double calcNetForceExertedByY(Planet[] list) {
		double sumOfForceInY = 0;
		for(int x = 0; x < list.length; x++) {
    		if(this.equals(list[x])) {
    			continue;
    		}
    		sumOfForceInY += this.calcForceExertedByY(list[x]);
		}
        return sumOfForceInY;
	}

/** update the planet’s position and velocity instance variables. */
	public void update(double dt, double fX, double fY) {
		double accelX = fX/mass;
		double accelY = fY/mass;
		xxVel = xxVel + accelX*dt;
		yyVel = yyVel + accelY*dt;
		xxPos = xxPos + xxVel*dt;
		yyPos = yyPos + yyVel*dt;
	}

/** Draw one planet according to their location. */
    public void draw() {
    	StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
    

}
