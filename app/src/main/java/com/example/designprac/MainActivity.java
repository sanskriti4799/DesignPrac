package com.example.designprac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
Development development_frag;
Design design_frag;
Marketing marketing_frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        development_frag=new Development();
        design_frag=new Design();
        marketing_frag=new Marketing();

        BottomNavigationView nav=findViewById(R.id.nav);
        final FrameLayout content=findViewById(R.id.contentlayout);
change_Fragment(development_frag);
nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId())
        {
            case R.id.development:
                change_Fragment(development_frag);
                Animation a= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(a);
                return true;
            case R.id.design:
                change_Fragment(design_frag);
                Animation b= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                content.startAnimation(b);
                return true;
            case R.id.marketing:
                change_Fragment(marketing_frag);
                Animation c= AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                content.startAnimation(c);
                return true;
                default: return false;
        }

    }
});
    }

    private void change_Fragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.contentlayout,fragment);
        fragmentTransaction3.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.designprac, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.development:
                Toast.makeText(MainActivity.this, "HI1", Toast.LENGTH_SHORT).show();
            case R.id.design:
                Toast.makeText(MainActivity.this, "HI2", Toast.LENGTH_SHORT).show();
            case R.id.marketing:
                Toast.makeText(MainActivity.this, "HI3", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }





}
