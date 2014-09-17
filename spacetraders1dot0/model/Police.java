/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

/**
 *
 * @author Kentaro
 */
//todo, 
//accept surrender, take to court,otherwise fight
//when search ship, if firearms are found then immediate confiscate 
//same for narcotics

public class Police extends Player {
    private int threatRating; //looks at player notoriety
    private int bribeRating; //determined by government type
    private int wantedBribe;
    private Boolean life; //true if alive, false if dead
    
    public Police(){
        super((int)(Math.random() * 300),(int)(Math.random() * 300));
        name = posNames[(int)(Math.random() * ((posNames.length)))];
        threatRating = 0;
        bribeRating = 0;
        life = true;
    }
    public Police(int threatRating, int bribeRating, int x, int y){
        super(x, y);
        name = posNames[(int)(Math.random() * ((posNames.length)))];
        this.threatRating = threatRating;
        this.bribeRating = bribeRating;
        life = true;
    }
    public void setThreatRating(int threat){
        threatRating = threat;
    }
    public int getThreatRating(){
        return threatRating;
    }
    public void setBribeRating(int bribeRating){
        this.bribeRating = bribeRating;
    }
    public int getBribeRating(){
        return bribeRating;
    }
    public String getLife(){
        if(life){
            return "alive";
        }
        else{
            return "dead";
        }
    }
    public void setLife(Boolean t){
        life = t;
    }
    public Boolean searchSpaceShip(int notoriety){
        //bs figures but gives the basic idea
        if(notoriety > 50){  //pulls you over for bad police record
            return true;
        }else if((notoriety + threatRating) >=50){
            return true; //pulls you over for this accumulation
        }
        else if(threatRating > 75){
            return true;    //angry cop, will pull over anything
        }else{
            return false; //wont get pulled over
        }
    }
    public int getWantedBribe(){
        wantedBribe = (100 - bribeRating) * 100; //lower briberating will take more money
        return wantedBribe;
    }
    public Boolean acceptBribe(int bribeAmount){
        if(bribeAmount >= wantedBribe){
            return true;
        }else if(bribeRating == 0){
            return false; //incorruptable
        }else{
            return false; //didn't give him enough bribe money
        }
    }
    @Override
    public String toString(){
        return "\tPolice name: " + name + " Coordinate: (" + x + "," + y + ")" + " threat:" + threatRating + " bribe: " + bribeRating + " Life status " + getLife();
    }

}
