package moviesApp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import moviesApp.model.Movie;
import moviesApp.service.MovieService;
import moviesApp.service.MovieServiceImpl;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class Connection {

    @Autowired
    public Connection(){}

    public String apiConnection(int i) throws Exception {
        URL url = new URL("https://api.themoviedb.org/3/movie/" + i + "?api_key=7c75c45991dab553ce30695534bf1683");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        String output;
        output = br.readLine();
        return output;
    }
}
