package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        URL url=null;
        HttpURLConnection connection=null;
        int responsecode=0;
        String urlStr="https://api.chucknorris.io/jokes/random";

        try
        {
            url=new URL(urlStr);


        } catch (MalformedURLException e)
        {
            System.out.println("Incorrect URL");
        }
        try
        {
            connection=(HttpURLConnection) url.openConnection();
            responsecode=connection.getResponseCode();


        }
        catch (Exception e)
        {
            System.out.println("Connection Failed");
        }

        if (responsecode==200)
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder Data=new StringBuilder();
            String readline=null;
            while ((readline=in.readLine())!=null)
            {
                Data.append((readline));
            }
            try
            {
                in.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println(Data.toString());
            JSONObject jsonApiResponse=new JSONObject(Data.toString());
            System.out.println(jsonApiResponse.get("categories"));
            System.out.println(jsonApiResponse.get("created_at"));
            System.out.println(jsonApiResponse.get("icon_url"));
            System.out.println(jsonApiResponse.get("id"));
            System.out.println(jsonApiResponse.get("updated_at"));
            System.out.println(jsonApiResponse.get("url"));
            System.out.println(jsonApiResponse.get("value"));
           // JSONObject jsonApiResponse1=new JSONObject(jsonApiResponse.get());

        }
        else
        {
            System.out.println("API call not made ");
        }



    }
}