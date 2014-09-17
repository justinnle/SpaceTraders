/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0.model;
import java.util.HashSet;

/**
 *
 * @author song
 */
public class SolarSystem {
     private int x_axis;
     private int y_axis;
     private String ssName;
     private final int PLANETNUMBER;
     private final Planet[] thePlanet;
     
     
     public SolarSystem(String SSN, int planetNumber, int x, int y)
     {
          x_axis = x;
          y_axis = y;
          ssName = SSN;
          PLANETNUMBER = planetNumber;
          thePlanet = new Planet[PLANETNUMBER];          
     }
     public void createPlanet(String [] name)
     {
          int x, y, techLevel, specialResource;
          HashSet theSet = new HashSet();
          for (int i = 0; i < PLANETNUMBER; ++i)
          {
               x = (int) (Math.random() * 300 +50);         //planet x_axis in the solar system
               y = (int) (Math.random() * 300 + 50);        //planet y_axis in the solar system
                while(theSet.contains(x))
               {
                    x = (int) (Math.random() * 300 +50);         
                    y = (int) (Math.random() * 300 + 50);
               }
               theSet.add(x);
               techLevel = (int)(Math.random() * 8);                  //planet tech level
               specialResource = (int)(Math.random() * 13);      //planet special resource
               thePlanet[i] = new Planet(x, y, techLevel, specialResource, name[i]);
               
          }
     }
     public void displaySolarSystem()
     {
          System.out.println("solar system: " + ssName + "(" + x_axis + ", " + y_axis + ")" + " :   ");
          for (int i = 0; i < PLANETNUMBER; ++i)
          {
               System.out.println(thePlanet[i].toString());
          }
          System.out.println("");
     }
     public int getX_axis()
     {
          return x_axis;
     }
     public int getY_axix()
     {
          return y_axis;
     }
     public String getSolarSystemName()
     {
          return ssName;
     }
     public int getPlanetNumber()
     {
          return PLANETNUMBER;
     }
     public Planet[] getPlanet()
     {
          return thePlanet;
     }
}
