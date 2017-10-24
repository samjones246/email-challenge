import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class EmailChallenge {
    public static void main(String[] args) throws Exception{
        System.out.print("Enter email ID to look up: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String id = br.readLine();
        URL address = new URL("http://www.ecs.soton.ac.uk/people/" + id);
        BufferedReader urlReader = new BufferedReader(new InputStreamReader(address.openStream()));
        String line, name ="";
        while ((line=urlReader.readLine())!=null && name.equals("")){
            if (line.contains("<title>")){
                name = line;
            }
        }
        name = name.substring(name.indexOf(">")+1, name.indexOf("|"));
        if (name.equals("People ")){
            System.out.println("Invalid ID");
        }else{
            System.out.println(name);
        }
    }
    
}
