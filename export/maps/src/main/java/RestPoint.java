import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class RestPoint {
    private JSONArray nodes;

    RestPoint(String server, String location,String around) throws IOException {
        try {
            StringBuilder stringBuilder = new StringBuilder();


            URL oracle = new URL(server+"interpreter?data=[out:json];(node(around:"+around+","+location+")[public_transport=platform];node(around:"+around+","+location+")[amenity~\"cafe|pub|bar\"];);out;");
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                stringBuilder.append(inputLine);
            }
            in.close();
            JSONObject json = new JSONObject(stringBuilder.toString());
            nodes = json.getJSONArray("elements");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public JSONArray getPoints() {
        return nodes;
    }
}
