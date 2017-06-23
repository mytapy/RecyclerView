package com.example.mytapy.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String GET_DONORS_URL = "http://redlinkmedia.com/findDonor.php";
    ArrayList<Donors> donorsList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_list_donors);
        populateRecycleView();
    }

    private void populateRecycleView() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(GET_DONORS_URL, new Response.Listener<JSONArray>() {
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
                        donorsList.add(donors);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                DonorsAdapter donorsAdapter = new DonorsAdapter(MainActivity.this, donorsList);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(donorsAdapter);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        NetworkRequestSingleTon.getOurInstance(MainActivity.this).addToRequestQue(jsonArrayRequest);
    }
}
