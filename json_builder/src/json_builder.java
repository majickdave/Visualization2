import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class json_builder extends PApplet {


float planetMassMin = 50;
float planetMassMax = 100;
float[] popularity = {74, 52, 58, 77, 37, 55, 49, 50};
String[] composition = {"travis", "flume", "flume_album", "crooked_colours_album", "crooked_colours", "london_grammar", "zero7", "kanye","drake", 
                        "drake1", "drake2", "drake3", "drake4", "drake5", "kendrick", "nuv", "lost_boy_crow", "ott", "nora", "slusshi", "washed_out"};
//String[] composition = {"stone"};
int PlanetCount = composition.length;

JSONArray values;

public void setup() {

  values = new JSONArray();
  
  for (int i = 0; i < PlanetCount; i++) {
   
    JSONObject planet = new JSONObject();
    planet.setFloat("mass", random(planetMassMin, planetMassMax));
    planet.setString("composition", composition[i]); //PApplet.parseInt(random(composition.length))
    planet.setInt("id", i);
    
    values.setJSONObject(i, planet);
    
  }
  
  saveJSONArray(values, "/Users/majic/NetBeansProjects/OrbPlot/build/classes/data/planets.json");   // Set your path
  
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "json_builder" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
