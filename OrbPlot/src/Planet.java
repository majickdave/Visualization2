import processing.core.*;

public class Planet {
  public PVector loc;
  public PVector rot;
  public float radius;
  public int id;
  public String trackID, textureURL;
  public PApplet p;
  IJGSphere s;


  public Planet() {
  }

  public Planet(PApplet p, PVector loc, float radius, int id, String trackID) {
    this.p = p;
    this.loc = loc;
    rot = new PVector(0,0,0);
    this.radius = radius;
    this.id = id;
    this.trackID = trackID;
    textureURL = "trackID_"+trackID+".jpeg";

    s = new IJGSphere(this.p, new RGBA(120, 120, 120, 255), textureURL, radius, 16, 16);
    
    // enable vertex normals for smoohing
    s.setSmooth(true);
  }

  public void display() {
    p.pushMatrix();
    s.display();
    p.popMatrix();
  }

  public boolean isHit() {
    if (p.dist(p.mouseX-p.width/2, p.mouseY-p.height/2, loc.x, loc.y) < radius) {
      return true;
    } 
    return false;
  }
}