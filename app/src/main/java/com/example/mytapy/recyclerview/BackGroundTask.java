package com.example.mytapy.recyclerview;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class BackGroundTask {
    Context context;
    private static final String GET_DONORS_URL = "http://redlinkmedia.com/findDonor.php";
    private ArrayList<Donors> donorses;


    public BackGroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Donors> getDonors(){
        donorses = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, GET_DONORS_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while (count < response.length()){
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Donors donors = new Donors(
                                jsonObject.getString("fName"), jsonObject.getString("sName"), jsonObject.getString("emailid"),
                                jsonObject.getString("pass"), jsonObject.getString("mobile"), jsonObject.getString("blood"),
                                jsonObject.getString("age"), jsonObject.getString("gender"), jsonObject.getString("country"),
                                jsonObject.getString("location"), jsonObject.getString("latitude"), jsonObject.getString("longitude"),
                                jsonObject.getString("picname"), jsonObject.getString("pic"));
                        donorses.add(donors);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();}
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        NetworkRequestSingleTon.getOurInstance(context.getApplicationContext()).addToRequestQue(jsonArrayRequest);
        return donorses;
    }
}
