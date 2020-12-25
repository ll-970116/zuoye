package com.example.imitation;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imitation.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl, new HomeFragment())
                .commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {

            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, new HomeFragment())
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, new HomeFragment())
                        .commit();
                break;
            case 3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, new HomeFragment())
                        .commit();
                break;
            case 4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, new HomeFragment())
                        .commit();
                break;
            case 5:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl, new HomeFragment())
                        .commit();
                break;
        }
    }
}