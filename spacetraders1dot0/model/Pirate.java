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
public class Pirate extends Player {
    //todo, skimmed over final project description to get these descriptions
    //Pirates positions need to be within 20 clicks of ports. This is where they will commonly be found
    //Pirates attack on sight, unless player notoriety is very high. then pirate will be scared
    //Therefore pirate need a wimp factor
    //Money will attract stronger pirates, more money means the pirate encounters are harder
    public Pirate(){
        name = posNames[(int)(Math.random() * ((posNames.length)))];
        
    }
}
