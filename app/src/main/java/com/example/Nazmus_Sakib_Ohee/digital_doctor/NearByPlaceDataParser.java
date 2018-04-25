package com.example.Nazmus_Sakib_Ohee.digital_doctor;

/**
 * Created by Nazmus_Sakib_Ohee on 11/16/2017.
 */

import java.util.HashMap;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NearByPlaceDataParser {

    private ArrayList<PlaceDetails> placeDetailsArrayList = null;
    private PlaceDetails placeDetails;

    public NearByPlaceDataParser(){
        placeDetailsArrayList =  new ArrayList<>();

    }



    private PlaceDetails getPlace(JSONObject googlePlaceJson)
    {
        HashMap<String, String> googlePlaceMap = new HashMap<>();
        String placeName = "--NA--";
        String vicinity= "--NA--";
        String latitude= "";
        String longitude="";
        String reference="";

        placeDetails = new PlaceDetails();

        // Log.d("DataParser","jsonobject ="+googlePlaceJson.toString());


        try {

            if (!googlePlaceJson.isNull("name")) {
                placeName = googlePlaceJson.getString("name");
            }
            if (!googlePlaceJson.isNull("vicinity")) {
                vicinity = googlePlaceJson.getString("vicinity");
            }


            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlaceJson.getString("reference");

            placeDetails.setPlaceName(placeName);
            placeDetails.setReference(reference);
            placeDetails.setVicinity(vicinity);
            placeDetails.setLan(longitude);
            placeDetails.setLat(latitude);



            googlePlaceMap.put("place_name", placeName);
            googlePlaceMap.put("vicinity", vicinity);
            googlePlaceMap.put("lat", latitude);
            googlePlaceMap.put("lng", longitude);
            googlePlaceMap.put("reference", reference);


        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return placeDetails;

    }
    private ArrayList<PlaceDetails>  getPlaces(JSONArray jsonArray)
    {

        List<HashMap<String, String>> placelist = new ArrayList<>();
        HashMap<String, String> placeMap = null;

        for(int i = 0; i<jsonArray.length();i++)
        {
            try {

                this.placeDetailsArrayList.add(getPlace((JSONObject) jsonArray.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return placeDetailsArrayList;
    }

    public ArrayList<PlaceDetails> parse(String jsonData)
    {
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        Log.d("json data", jsonData);

        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }
}
