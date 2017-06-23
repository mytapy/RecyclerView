package com.example.mytapy.recyclerview;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


class NetworkRequestSingleTon {
    private static Context context;
    private RequestQueue requestQueue;
    private static NetworkRequestSingleTon networkRequestSingleTonInstance;


    private NetworkRequestSingleTon(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized NetworkRequestSingleTon getOurInstance(Context context){
        if(networkRequestSingleTonInstance == null){
            networkRequestSingleTonInstance = new NetworkRequestSingleTon(context);
        }
        return networkRequestSingleTonInstance;
    }

    public<T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
    }
}
