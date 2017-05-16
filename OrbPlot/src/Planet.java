import processing.core.*;

public class Planet {
  public PVector loc;
  public PVector rot;
  public float radius;
  public int id, track_popularity, artist_popularity;
  public String trackID, textureURL, artist_name, track_name, album_name;
  public PApplet p;
  IJGSphere s;


  public Planet() {
  }

  public Planet(PApplet p, PVector loc, float radius, int id, String trackID, int track_popularity, int artist_popularity, String artist_name, String track_name, String album_name) {
    this.p = p;
    this.loc = loc;
    rot = new PVector(0,0,0);
    this.radius = radius;
    this.id = id;
    this.trackID = trackID;
    this.artist_name = artist_name;
    this.track_name = track_name;
    this.album_name = album_name;
    this.track_popularity = track_popularity;
    this.artist_popularity = artist_popularity;
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