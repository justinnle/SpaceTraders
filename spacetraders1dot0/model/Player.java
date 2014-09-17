//playerSkillAllocation works as following
//playerSkillAllocation[0] == Pilot
//playerSkillAllocation[1] == Fighter
//playerSkillAllocation[2] == Trader
//playerSkillAllocation[3] == Engineer
//playerSkillAllocation[4] == Investor
//We can use these values as modifiers for later. 
//For instance a high point allocation under Fighter
//can be used as a damage modifier/multiplier in combat
//or High point in investor
//can be modifier for how lucky you are in getting money.
package spacetraders1dot0.model;

/**
 *
 * @author Kentaro
 */
public class Player {
    protected final String [] posNames = {"Ken", "Bro", "Song", "Ju-Hwan", "Ryan", "Justin", "Nub",
        "Bro1", "Bro2", "TeleTubby", "Ham", "Donut", "Chicken", "Bob", "Bobbro", "ChestBro"};
    protected String name;
    private int totalSkillPoints;
    private double currency;
    private int[] skills;
    private int notoriety; //for police
    protected int x;//position
    protected int y;

    public Player() {
        name = "";
        totalSkillPoints = 15;
        currency = 1000;
        skills = new int[5];//Pilot, Fighter, Trader, Engineer, Investor
        notoriety = 0;
        x = 0;
        y = 0;
    }

    public Player(String name, int totalSkill, double currency, int[] skills, int notoriety, int x,int y) {
        this.name = name;
        totalSkillPoints = totalSkill;
        this.currency = currency;
        this.skills = skills;
        this.notoriety = notoriety;
        this.x=x;
        this.y=y;
    }
    public Player(int x, int y){ //for subclass
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNotoriety(int notoriety) {
        this.notoriety = notoriety;
    }

    public int getNotoriety() {
        return notoriety;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return name;
    }

    public void setPlayerSkillPoints(int skillPoints) {
        totalSkillPoints = skillPoints;
    }

    public int getPlayerSkillPoints() {
        return totalSkillPoints;
    }

    public void setPlayerCurrency(double money) {
        currency = money;
    }

    public void updatePlayerCurrent(double money) {
        currency += money;
    }

    public double getPlayerCurrency() {
        return currency;
    }

    public int[] getPlayerSkillAllocation() {
        return skills;
    }

    //skill corresponds to which skill to update (Pilot, Fighter, Trader, Engineer, Investor)
    public void allocatePlayerSkill(int amount, int skill) {
        skills[skill] = amount;
    }

    //based on which skill point is the most determines what JOB your character will have
    public String getPlayerJob() {
        int max = 0;
        int maxPosition = 0;
        for (int i = 0; i < skills.length; i++) {
            if (skills[i] > max) {
                max = skills[i];
                maxPosition = i;
            }
        }
        if (maxPosition == 0) {
            return "Pilot";
        } else if (maxPosition == 1) {
            return "Fighter";
        } else if (maxPosition == 2) {
            return "Trader";
        } else if (maxPosition == 3) {
            return "Engineer";
        } else {
            return "Investor";
        }

    }

    public void playerReset() {
        name = "";
        totalSkillPoints = 15;
        currency = 1000;
        notoriety = 0;
        for (int i = 0; i < skills.length; i++) {
            skills[i] = 0;
        }
    }

    @Override
    public String toString() {
        return name + "\nSkills: Pilot(" + skills[0] + ")|Fighter(" + skills[1] + ")|Trader("
                + skills[2] + ")|Engineer(" + skills[3] + ")|Investor(" + skills[4] + ")\n"
                + "Currency: " + currency;
    }
}
