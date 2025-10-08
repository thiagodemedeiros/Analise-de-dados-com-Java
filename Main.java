import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args){
    String path = "campeonato-brasileiro-cartoes.csv";

    List<String> list =  new ArrayList<String>();
    int i = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();
      line = br.readLine();
      while (line != null && i <= 10) {
        System.out.println(line);
        line = br.readLine();
        i++;
      }
    }
    catch (IOException e) {
      System.out.println("ERROR: " + e);
    }
  }
}