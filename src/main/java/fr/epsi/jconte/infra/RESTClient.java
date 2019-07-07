package fr.epsi.jconte.infra;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTClient {

    private ObjectMapper mapper;

    public RESTClient() {
        this.mapper = new ObjectMapper();
    }

    public RootObject GetResponseFromListListBoolean (String pUrl){

        try {

            URL url = new URL(pUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String jsonStr = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                jsonStr+=output;
            }

            RootObject myGenericObject = mapper.readValue(jsonStr,RootObject.class);

            conn.disconnect();

            return myGenericObject;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

}
