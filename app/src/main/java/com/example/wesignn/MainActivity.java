package com.example.wesignn;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnStore, btnGetall;
    private EditText etname;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String> arrayList;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        databaseHelper = new DatabaseHelper(this);


        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetall = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = etname.getText().toString();
                String[] arr = result.split("");
                Log.d("Console test",arr.toString());

                LinearLayout linearLayout1 = findViewById(R.id.rootContainer);
                linearLayout1.removeAllViews();

                ScrollView scrollView = new ScrollView(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                scrollView.setLayoutParams(layoutParams);

                LinearLayout linearLayout = new LinearLayout(context);
                LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setLayoutParams(linearParams);

                scrollView.addView(linearLayout);

                for (String s : arr) {
                    String alphabet = s.toLowerCase();
                    if(alphabet.matches("[a-zA-Z]")){
                        Log.d("Console test i", alphabet);
                        ImageView imageView1 = new ImageView(context);
                        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params1.setMargins(0, 30, 0, 30);
                        params1.gravity = Gravity.CENTER;
                        imageView1.setLayoutParams(params1);
                        switch (alphabet) {
                            case "a":
                                imageView1.setImageResource(R.drawable.finger_a);
                                linearLayout.addView(imageView1);
                                break;
                            case "b":
                                imageView1.setImageResource(R.drawable.finger_b);
                                linearLayout.addView(imageView1);
                                break;
                            case "c":
                                imageView1.setImageResource(R.drawable.finger_c);
                                linearLayout.addView(imageView1);
                                break;
                            default:
                                imageView1.setImageResource(R.drawable.wesign);
                                linearLayout.addView(imageView1);
                        }
                    }
                }

                if (linearLayout1 != null) {
                    linearLayout1.addView(scrollView);
                }
//                databaseHelper.addStudentDetail(etname.getText().toString());
//                etname.setText("");
//                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                arrayList = databaseHelper.getAllStudentsList();
//                tvnames.setText("");
//                for (int i = 0; i < arrayList.size(); i++){
//                    tvnames.setText(tvnames.getText().toString()+", "+arrayList.get(i));
//                }
                Intent myIntent = new Intent(context, VideoActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
