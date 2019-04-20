public class NBody {

	public static double readRadius(String s) {
		if (s == null) {
			System.out.println("Please supply a file name as a command line argument.");
		}	


	/** Start reading in the input file*/
		In in = new In(s);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	public static Planet[] readPlanets(String s) {
		if (s == null) {
			System.out.println("Please supply a file name as a command line argument.");
		}	

		/** Start reading in the input file*/
		In in = new In(s);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		Planet[] planet = new Planet[firstItemInFile];
		int index = 0;

		for(int row = 1; row<=firstItemInFile; row++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planet[index] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			index += 1;
		}
		return planet;
	}

    public static String imageToDraw = "images/starfield.jpg";

    /** draw the universe background. */
	public static void drawBackground(double radius) {

		/** /** Sets up the universe so it goes from 
		  * -radius, -radius up to radius, radius */
		StdDraw.setScale(-radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
		StdDraw.show();


	}
	    public static void main(String[] args) {

			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String filename = args[2];
			Planet[] planet = readPlanets(filename);
			double radius = readRadius(filename);
			NBody.drawBackground(radius);

			/** Draw all planets. */
			In in = new In(filename);
		    int numberOfPlanet = in.readInt();
		    for(int i=0; i<numberOfPlanet; i++) {
		    	planet[i].draw();
		    }

		}
}