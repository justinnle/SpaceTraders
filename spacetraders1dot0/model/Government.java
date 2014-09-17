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
class PoliticalSystem{
     private String politicalSystemName;
     private int minTechLevel;
     private int maxTechLevel;
     private int policeForce;
     private int crimeRate;
     private String demandResource;
     private int illegalDemand;
     private int drugDemand;
     private int traderFavor;
     private int bribeRate;
     
     public PoliticalSystem()
     {
          politicalSystemName = "";
          minTechLevel = 0;
          maxTechLevel = 0;
          policeForce = 0;
          crimeRate = 0;
          demandResource = "";
          illegalDemand = 0;
          drugDemand = 0;
          traderFavor = 0;
          bribeRate = 0;
     }
     public void setPoliticalSystemName(String s)
     {
          politicalSystemName = s;
     }
     public void setMinTechLevel(int n)
     {
          minTechLevel = n;
     }
     public void setMaxTechLevel(int n)
     {
          maxTechLevel = n;
     }
     public void setPoliceForce(int n)
     {
          policeForce = n;
     }
     public void setCrimeRate(int n)
     {
          crimeRate = n;
     }
     public void setDemandResource(String s)
     {
          demandResource = s;
     }
     public void setIllegalDemand(int n)
     {
          illegalDemand = n;
     }
     public void setDrugDemand(int n)
     {
          drugDemand = n;
     }
     public void setTraderFavor(int n)
     {
          traderFavor = n;
     }
     public void setBribeRate(int n)
     {
          bribeRate = n;
     }
     public String getPoliticalSystemName()
     {
          return     politicalSystemName;
     }
     public int getMinTechLevel()
     {
          return     minTechLevel;
     }
     public int getMaxTechLevel()
     {
          return maxTechLevel;
     }
     public int getPoliceForce()
     {
          return policeForce;
     }
     public int getCrimeRate()
     {
          return crimeRate;
     }
     public String getDemandResource()
     {
          return demandResource;
     }
     public int getIllegalDemand()
     {
         return illegalDemand;
     }
     public int getDrugDemand()
     {
          return drugDemand;
     }
     public int getTraderFavor()
     {
         return traderFavor;
     }
     public int getBribeRate()
     {
          return bribeRate;
     }
}
public class Government {
     private final int POLITICALSYSTEMNUMBER;
     PoliticalSystem [] thePS;
     PoliticalSystem currentPS;
     
      private String [] politicalSystem = 
     {
          //system min max police crime rare illegal drug trader bribe
          "Anarchy", "0", "6", "0", "5", "Food", "3", "3" , "0", "0",
          "Capitalist State", "5", "7", "2", "2", "Ore", "4", "4", "5", "0",
          "Communist State", "6", "7", "5", "5", "Illegal", "5", "4", "3", "5",
          "Confederacy", "7", "7", "3", "3", "Game", "3", "3", "4", "1",
          "Corporate State", "5", "7", "5", "1", "Robot", "4", "4", "4", "1",
          "Cybernetic State", "7", "7", "5", "5", "Ore", "0", "0", "4", "0",
          "Democracy", "0", "7", "3", "4", "Game", "4", "4", "5", "2",
          "Dictatorship", "0", "7", "5", "4", "Game", "3", "3", "3", "1",
          "Fascist State", "0", "7", "5", "1", "Machine", "2", "0", "1", "1",
          "Feudal State", "0", "1", "1", "5", "Firearm", "5", "4", "1", "2",
          "Military State", "4", "7", "5", "0", "Robot", "0", "0", "5", "0",
          "Monarchy", "0", "4", "4", "3", "Medicine", "2", "3", "4", "2",
          "Pacifist State", "0", "7", "1", "1", "Natural", "0", "2", "5", "0",
          "Socialist State", "0", "5", "1", "5", "Illegal", "5", "3", "3", "5",
          "State of Satori", "0", "1", "1", "0", "None", "0", "0", "0", "0",
          "Technocracy", "5", "7", "5", "1", "Water", "4", "4", "4", "3",
          "Theocracy", "0", "4", "5", "1", "Drug", "0", "5", "3", "3"
     };
      public Government()
      {
           POLITICALSYSTEMNUMBER = 17;
           thePS = new PoliticalSystem[POLITICALSYSTEMNUMBER];
           currentPS = null;
      }
      public void createGovernment(int techLevel)
      {
           initialize();
           int index = (int)(Math.random() * POLITICALSYSTEMNUMBER);
           while(true)
           {
                if (techLevel >= thePS[index].getMinTechLevel()  && techLevel <= thePS[index].getMaxTechLevel())
                     break;
                else
                     index = (int)(Math.random() * POLITICALSYSTEMNUMBER);
           }
           currentPS = thePS[index];
      }
      public int getPoliceForce()
      {
           return currentPS.getPoliceForce();
      }
     @Override
      public String toString()
      {      
           return "Political System Name: " + currentPS.getPoliticalSystemName() + "\n" +
                     "Police Force Level: " + currentPS.getPoliceForce() + "\n" +
                     "Crime Rate Level: " + currentPS.getCrimeRate() + "\n" + 
                     "Demand Resouce Name: " + currentPS.getDemandResource() + "\n" + 
                     "Illegal Demand Level: " + currentPS.getIllegalDemand() + "\n" +
                     "Drug Demand Level: " + currentPS.getDrugDemand() + "\n" +
                     "Trader Favor Level: " + currentPS.getTraderFavor() + "\n" +
                     "Bribe Rate Level: " + currentPS.getBribeRate();
      }
      
      private void initialize()
      {
           for (int i = 0; i < POLITICALSYSTEMNUMBER; ++i)
           {
                int j = i * 10;
                thePS[i] = new PoliticalSystem();
                thePS[i].setPoliticalSystemName(politicalSystem[j]);
                thePS[i].setMinTechLevel(Integer.parseInt(politicalSystem[j+1]));
                thePS[i].setMaxTechLevel(Integer.parseInt(politicalSystem[j+2]));
                thePS[i].setPoliceForce(Integer.parseInt(politicalSystem[j+3]));
                thePS[i].setCrimeRate(Integer.parseInt(politicalSystem[j+4]));
                thePS[i].setDemandResource(politicalSystem[j+5]);
                thePS[i].setIllegalDemand(Integer.parseInt(politicalSystem[j+6]));
                thePS[i].setDrugDemand(Integer.parseInt(politicalSystem[j+7]));
                thePS[i].setTraderFavor(Integer.parseInt(politicalSystem[j+8]));
                thePS[i].setBribeRate(Integer.parseInt(politicalSystem[j+9]));
           }
      }
}
