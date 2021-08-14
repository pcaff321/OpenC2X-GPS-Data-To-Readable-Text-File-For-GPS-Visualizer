import java.io.*;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class read_GPS_cvs {
  public static void main(String[] args){
//    private final static String csvPath = "GPSData.csv";
    Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Please enter the file you wish to convert:");

    String fileInput = scanObj.nextLine();  // Read user input
    File csvFile = new File(fileInput);
    try{
      if (csvFile.isFile()) {

        System.out.println("File selected: " + fileInput);  // Output user input

        System.out.println("Please enter the name of the file you wish to name the new file:");
        System.out.println("WARNING: Will overwrite existing files");

        String fileName = scanObj.nextLine();  // Read user input

FileWriter fileWriter = new FileWriter(fileName + ".txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);



        bufferedWriter.append("type\tlatitude\tlongitude\n");

        BufferedReader csvReader = new BufferedReader(new FileReader("GPSData.csv"));

        String line = csvReader.readLine();

while (line != null) {        

          String longitude = line.split("\t")[1];
          String latitude = line.split("\t")[2];
          String input = "W\t" + longitude + "\t" + latitude;

          bufferedWriter.append(input);
          bufferedWriter.append("\n");

 line = csvReader.readLine();
        }

        bufferedWriter.close();

      try {
        java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.gpsvisualizer.com/map_input?form=leaflet"));
        } catch (IOException ex) {
        System.out.println("Error opening GPS Visualizer");
        }
      }
      else
      {
        System.out.println(fileInput + " does not exist.");
      }
    }
    catch(IOException e) {
      System.out.println("Error occurred.");
      e.printStackTrace();
    }
  }
}
