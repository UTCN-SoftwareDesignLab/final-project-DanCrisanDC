package moviesApp.config;

import moviesApp.model.Movie;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class Mapper {

    @Autowired
    public Mapper() {}

    public Movie mapToMovie(String received) {

        Movie movie = new Movie();
        JSONObject jsonObject = new JSONObject(received);

        movie.setName(jsonObject.get("title").toString());

        JSONArray jsonArray = jsonObject.getJSONArray("genres");
        movie.setGenre(jsonArray.getJSONObject(0).getString("name"));

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            movie.setLaunchDate(format.parse(jsonObject.get("release_date").toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        movie.setDescription(jsonObject.get("overview").toString());
        movie.setRating(Double.parseDouble(jsonObject.get("vote_average").toString()));
        movie.setDuration(Integer.parseInt(jsonObject.get("runtime").toString()));
        movie.setBudget(Integer.parseInt(jsonObject.get("budget").toString()));
        movie.setRevenue(Integer.parseInt(jsonObject.get("revenue").toString()));

        return movie;
    }
}
