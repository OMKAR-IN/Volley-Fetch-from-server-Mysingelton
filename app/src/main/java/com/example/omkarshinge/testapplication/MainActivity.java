package com.example.omkarshinge.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView text;
    String serverUrl = "http://192.168.208.1/androidtestproject/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.retrieveButton);
        text = findViewById(R.id.textData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                StringRequest string = new StringRequest(Request.Method.POST, serverUrl,

                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                text.setText(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                text.setText("SWW");
                                error.printStackTrace();
                            }
                        }
                );
                Mysingelton.getMinstance(getApplicationContext()).addToRequestqueue(string);
            }
        });

    }
}
