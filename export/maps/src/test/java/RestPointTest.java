import org.json.JSONArray;
import org.json.JSONObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 03.06.2018.
 */
class RestPointTest {
    RestPoint restPoint;
    String location = "59.93823555,30.2668659740719";
    String around = "400";
    String server = "http://overpass-api.de/api/";

    @BeforeEach
    void init() throws IOException {
        restPoint = new RestPoint(server, location, around);
    }

    @Test
    void getPointsTest() throws Exception {
        try {
            int countBus = 0;
            int countBar = 0;
            int countCafe = 0;
            for (int i = 0; i < restPoint.getPoints().length(); i++) {
                JSONObject point = restPoint.getPoints().getJSONObject(i);
                JSONObject pointTags = point.getJSONObject("tags");
                if (pointTags.has("public_transport")) countBus++;
                if (pointTags.has("amenity")) {
                    if (pointTags.get("amenity").equals("bar") || pointTags.get("amenity").equals("pub")) countBar++;
                    if (pointTags.get("amenity").equals("cafe")) countCafe++;
                }
            }
            System.out.println("Public transport " + countBus);
            System.out.println("Bar " + countBar);
            System.out.println("Cafe " + countCafe);
            assertTrue(countCafe >= 2 && countBus >= 1 && countBar >= 1, "this point on the map does not satisfy the conditions");
            System.out.println("Success: this point on the map satisfies the conditions");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPoints_RestPointTest() throws Exception {
        try {
            assertTrue(restPoint.getPoints() instanceof JSONArray, "return not JSON");
            assertTrue(restPoint.getPoints().length() > 0, "Nope points");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPoints_TestBars() throws Exception {
        try {
            int countBar = 0;
            System.out.println("Bar|Pub:");
            for (int i = 0; i < restPoint.getPoints().length(); i++) {
                JSONObject point = restPoint.getPoints().getJSONObject(i);
                JSONObject pointTags = point.getJSONObject("tags");

                if (pointTags.has("amenity")) {
                    if (pointTags.get("amenity").equals("bar") || pointTags.get("amenity").equals("pub")) {
                        countBar++;
                        System.out.println(pointTags.get("name"));
                    }
                }
                if (pointTags.has("name")) {
                    if (pointTags.get("name").toString().matches("(.*)(([Бб]ар)|([Bb]ar))(.*)")) {
                        System.out.println(pointTags.get("name"));
                    }
                }

            }
            assertTrue(countBar > 0, "Nope Bars");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPoints_TestOtherInformation() throws Exception {
        try {
            int countTags = 0;
            System.out.println("Information about point:");
            for (int i = 0; i < restPoint.getPoints().length(); i++) {

                JSONObject point = restPoint.getPoints().getJSONObject(i);

                JSONObject pointTags = point.getJSONObject("tags");
                for (int j = 0; j < pointTags.names().length(); j++) {
                    System.out.println(pointTags.names().getString(j) + ":  " + pointTags.get(pointTags.names().getString(j)));
                }
                System.out.println();
                countTags++;
            }
            assertEquals(countTags, restPoint.getPoints().length(), "Tags not egueals all objects");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


