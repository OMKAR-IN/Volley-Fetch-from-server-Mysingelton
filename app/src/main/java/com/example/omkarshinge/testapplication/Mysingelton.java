package com.example.omkarshinge.testapplication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Mysingelton {
    private static Mysingelton minstance;
    private RequestQueue requestQueue;
    private static Context mctx;

    private Mysingelton(Context context)
    {
        mctx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());

        }
        return requestQueue;
    }

    public static synchronized Mysingelton getMinstance(Context context)
    {
        if (minstance == null)
        {
            minstance = new Mysingelton(context);
        }
        return minstance;
    }

    public<T> void addToRequestqueue(Request<T> request)
    {
        requestQueue.add(request);
    }
}
