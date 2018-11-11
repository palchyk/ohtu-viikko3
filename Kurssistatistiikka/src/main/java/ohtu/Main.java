package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        System.out.println("");
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }
        System.out.println("opiskelijanumero " + studentNr+"\n\n");
        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        
        String ohtus = "https://studies.cs.helsinki.fi/courses/ohtu2018/stats";
        String bodyText3 = Request.Get(ohtus).execute().returnContent().asString();
        String rubys = "https://studies.cs.helsinki.fi/courses/rails2018/stats";
        String bodyText4 = Request.Get(rubys).execute().returnContent().asString();
        
        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(bodyText3).getAsJsonObject();
        JsonObject parsittuData2 = parser.parse(bodyText4).getAsJsonObject();
        double ohtuaika =0;
        double ohtuteht =0;
        double ohtumaar = 0;
        for (int i = 1; i <= parsittuData.size(); i++) {
            ohtuaika+=parsittuData.getAsJsonObject(String.valueOf(i)).get("hour_total").getAsDouble();
            ohtuteht+=parsittuData.getAsJsonObject(String.valueOf(i)).get("exercise_total").getAsDouble();
            ohtumaar+=parsittuData.getAsJsonObject(String.valueOf(i)).get("exercises").getAsJsonArray().size();
        }
        double rubyaika =0;
        double rubyteht =0;
        double rubymaar = 0;
        for (int i = 1; i <= parsittuData2.size(); i++) {
            rubyaika+=parsittuData2.getAsJsonObject(String.valueOf(i)).get("hour_total").getAsDouble();
            rubyteht+=parsittuData2.getAsJsonObject(String.valueOf(i)).get("exercise_total").getAsDouble();
            rubymaar+=parsittuData2.getAsJsonObject(String.valueOf(i)).get("exercises").getAsJsonArray().size();
        }
       
        
        
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Submission[] subs2 = mapper.fromJson(bodyText2, Submission[].class);
  
        int teht = 0;
        int tunt = 0;
        int teht2 = 0;
        int tunt2 = 0;
        String ruby = "Web-palvelinohjelmointi Ruby on Rails syksy 2018\n\n";
        String ohtu = "Ohjelmistotuotanto syksy 2018\n\n";
        for (Submission submission : subs) {
            if(submission.getCourse().equals("rails2018")){
                ruby+= "viikko "+submission.getWeek()+"\n tehtyjä tehtäviä "+
                        submission.getExercises().size()+"/"+subs2[0].getExercises().get(submission.getWeek())
                        +submission.toString();
            tunt += submission.getHours();
            teht += submission.getExercises().size();
            }
            if(submission.getCourse().equals("ohtu2018")){
                ohtu+= "viikko "+submission.getWeek()+"\n tehtyjä tehtäviä "+
                        submission.getExercises().size()+"/"+subs2[1].getExercises().get(submission.getWeek())
                        +submission.toString();
            tunt2 += submission.getHours();
            teht2 += submission.getExercises().size();
            }
        }
        System.out.println(ruby+"\n"+"yhteensä: "+teht+"/"+subs2[0].getExercisesSum()+" tehtävää "+tunt+" tuntia\n");
        System.out.println("kurssilla yhteensä "+rubymaar+" palautusta, palautettuja tehtäviä "+rubyteht+" kpl, aikaa käytetty yhteensä "+rubyaika+" tuntia");
        System.out.println("");
        System.out.println(ohtu+"\n"+"yhteensä "+teht2+"/"+subs2[1].getExercisesSum()+" tehtävää "+tunt2+" tuntia\n");
        System.out.println("kurssilla yhteensä "+ohtumaar+" palautusta, palautettuja tehtäviä "+ohtuteht+" kpl, aikaa käytetty yhteensä "+ohtuaika+" tuntia");
        
    }
}
