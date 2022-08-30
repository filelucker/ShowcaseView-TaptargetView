package com.example.showcaseviewexample;

import android.graphics.Typeface;
import android.os.Bundle;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.showcaseviewexample.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        TapTargetView.showFor(this,
//                TapTarget.forView(binding.fab,"This is A Fab Button","Replace with your own action")
//                        .outerCircleColor(R.color.teal_200)
//                        .outerCircleAlpha(0.96f)
//                        .targetCircleColor(R.color.white)
//                        .titleTextSize(20)
//                        .titleTextColor(R.color.white)
//                        .descriptionTextSize(10)
//                        .descriptionTextColor(R.color.black)
//                        .textColor(R.color.black)
//                        .textTypeface(Typeface.SANS_SERIF)
//                        .dimColor(R.color.black)
//                        .drawShadow(true)
//                        .cancelable(false)
//                        .tintTarget(true)
//                        .transparentTarget(true)
//                        .targetRadius(60),
//                new TapTargetView.Listener(){
//
//                    @Override
//                    public void onTargetClick(TapTargetView view) {
//                        super.onTargetClick(view);
//                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    }
//                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}