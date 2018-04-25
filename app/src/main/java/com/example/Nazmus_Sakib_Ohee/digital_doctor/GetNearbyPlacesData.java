package com.example.Nazmus_Sakib_Ohee.digital_doctor;

/**
 * Created by Nazmus_Sakib_Ohee on 11/16/2017.
 */


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

public class GetNearbyPlacesData extends AsyncTask<Object, String, String> {

    private Context context;
    private OnNearbyPlaceFound onNearbyPlaceFound;
    private String googlePlacesData;
    private GoogleMap mMap;
    private String url;
    private PlaceDetails placeDetails;
    private ArrayList<PlaceDetails> placeDetailsArrayList;

    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap) objects[0];
        url = (String) objects[1];
        context = (Context) objects[2];
        onNearbyPlaceFound = (OnNearbyPlaceFound) objects[3];

        DownloadNearbyPlaceUrl downloadURL = new DownloadNearbyPlaceUrl();
        try {
            googlePlacesData = downloadURL.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String s) {
        NearByPlaceDataParser parser = new NearByPlaceDataParser();
        placeDetailsArrayList = parser.parse(s);
        Log.d("nearbyplacesdata","called parse method");
        //onNearbyPlaceFound.placeFound(placeDetailsArrayList);

        showNearbyPlaces(placeDetailsArrayList);
    }




    private void showNearbyPlaces(ArrayList<PlaceDetails> placeDetailsArrayList)
    {



        if(placeDetailsArrayList.size()==0){
            Toast.makeText(context,"Sorry we find nothing for you",Toast.LENGTH_SHORT).show();
            return;

        }

        // onNearbyPlaceFound.placeFound(placeDetailsArrayList);

        for(int i = 0; i < placeDetailsArrayList.size(); i++)
        {
            MarkerOptions markerOptions = new MarkerOptions();
            placeDetails = placeDetailsArrayList.get(i);

            String placeName = placeDetails.getPlaceName();
            String vicinity = placeDetails.getVicinity();
            String ref = placeDetails.getReference();
            double lat = placeDetails.getLat();
            double lng = placeDetails.getLan();

            LatLng latLng = new LatLng( lat, lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : "+ ref);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        }
    }




}