/**
 * Created by synerzip on 20/2/17.
 */
public class Player {
    private String lname, fname;
    private int points;

    public Player(String lname, String fname) {
        this.lname = lname;
        this.fname = fname;
        this.points = 0;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }
}
