/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;


/**
 *
 * @author song
 */
public class Planet {

    private final int xCoordinate;
    private final int yCoordinate;
    private final int techLevel;
    private final int specialResource;
    private final String planetName;
    private Police[] planetPolice;
    private Government theGovernment;

    public Planet(int x, int y, int t, int s, String n) {
        xCoordinate = x;
        yCoordinate = y;
        techLevel = t;
        specialResource = s;
        planetName = n;
//        planetPolice = new Police[t]; //i guess depending on tech level determines police
        this.createGovernment();
        this.createPlanetPolice();
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public int getSpecialResource() {
        return specialResource;
    }

    public String getName() {
        return planetName;
    }
    public void createGovernment()
    {
         theGovernment = new Government();
         theGovernment.createGovernment(this.techLevel);
    }
    public void createPlanetPolice() {
//        int amountOfPolice = techLevel;
         int amountOfPolice = theGovernment.getPoliceForce();
        planetPolice = new Police[amountOfPolice];
        for (int i = 0; i < planetPolice.length; i++) {
            int xp = (int) (Math.random() * ((xCoordinate + 20) - (xCoordinate - 20)) + (xCoordinate - 20));
            int yp = (int) (Math.random() * ((yCoordinate + 20) - (yCoordinate - 20)) + (yCoordinate - 20));
            planetPolice[i] = new Police(techLevel, specialResource, xp, yp);
        }
    }
    public Police[] getPolice() {
        return planetPolice;
    }

    public String planetPoliceInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < planetPolice.length; i++) {
            sb.append(planetPolice[i].toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Planet name: " + planetName + " Coordinate: (" + xCoordinate + ", " + yCoordinate + ")" + "   TechLevel: " 
                + techLevel(techLevel) + "  specialResource: " + specialResource(specialResource) + "\n " + 
                theGovernment.toString() + "\n" + planetPoliceInfo();
    }

    private String specialResource(int s) {
        switch (s) {
            case 0:
                return "NO-SPECIAL-RESOURCES";
            case 1:
                return "MINERAL-RICH";
            case 2:
                return "MINERAL-POOR";
            case 3:
                return "DESERT";
            case 4:
                return "LOTS-OF-WATER";
            case 5:
                return "RICH-SOIL";
            case 6:
                return "RICH-FAUNA";
            case 7:
                return "LEFE-LESS";
            case 8:
                return "WEIRD-MUSHROOMS";
            case 9:
                return "LOTS-OF-HERBS";
            case 10:
                return "ARTISTIC";
            default:
                return "WARLIKE";
        }
    }

    private String techLevel(int t) {
        switch (t) {
            case 0:
                return "Pre-Agriculture";
            case 1:
                return "Agriculture";
            case 2:
                return "Medieval";
            case 3:
                return "Renaissance";
            case 5:
                return "Early-Industrial";
            case 6:
                return "Industrial";
            case 7:
                return "Post-Industrial";
            default:
                return "Hi-Tech";
        }
    }
}
