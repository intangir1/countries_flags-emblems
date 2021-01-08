package com.likhtman.countriesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> countries;

    private ImageView flag;
    private ImageView emblem;

    private LinearLayout linearLayout;


    private void initCountries(){
        countries = new ArrayList<>();
        countries.add("israel");
        countries.add("america");
        countries.add("russia");
        countries.add("germany");
        countries.add("britain");
        countries.add("poland");
    }


    private void initVisuals(){
        flag = (ImageView)findViewById(R.id.flag);
        emblem = (ImageView)findViewById(R.id.emblem);

        linearLayout = (LinearLayout)findViewById(R.id.buttons);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < countries.size(); i++){
            Button btn = new Button(this);
            int text_id = getResources().getIdentifier(countries.get(i), "string", getPackageName());
            btn.setText(text_id);
            btn.setLayoutParams(params);
            btn.setOnClickListener(this);
            layout.addView(btn);
        }
        linearLayout.addView(layout, params);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCountries();
        initVisuals();
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button)view;
        String button_text = btn.getText().toString();
        String flag_name = "f" + button_text;
        String emblem_name = "e" + button_text;
        int flag_id = getResources().getIdentifier(flag_name, "drawable", getPackageName());
        int emblem_id = getResources().getIdentifier(emblem_name, "drawable", getPackageName());
        flag.setImageResource(flag_id);
        emblem.setImageResource(emblem_id);
    }
}
