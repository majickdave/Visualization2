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

int PlanetCount = 8;
float planetMassMin = 20;
float planetMassMax = 60;
float[] popularity = {74, 52, 58, 77, 37, 55, 49, 50};
String[] composition = {"travis", "flume", "flume_album", "crooked_colours_album", "crooked_colours", "london_grammar", "zero7", "kanye"};
//String[] composition = {"stone"};

JSONArray values;

public void setup() {

  values = new JSONArray();
  
  for (int i = 0; i < PlanetCount; i++) {
   
    JSONObject planet = new JSONObject();
    planet.setFloat("mass", popularity[i]);
    planet.setString("composition", composition[i]);
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
