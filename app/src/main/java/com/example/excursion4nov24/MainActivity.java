package com.example.excursion4nov24;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    int UMIDpassword = 12345678;
    int numberEntered;
    EditText UMIDentered;
    TextView incorrectUMIDdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);

        incorrectUMIDdisplay = (TextView)findViewById(R.id.incorrectUMIDdisplay);
        UMIDentered = (EditText)findViewById(R.id.UMIDfield);

        //button to next page
        Button nextButton = (Button)findViewById(R.id.next_button);
        //event handler for next page
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(checkUMID()) {
                    startActivity(new Intent(MainActivity.this, SurveyActivity.class));
                }
                else
                {
                    incorrectUMIDdisplay.setText("Incorrect UMID entered");
                }
            }
        });

    }

    public boolean checkUMID()
    {
        if(UMIDentered.getText().toString().isEmpty())
        {
            Log.i("MainActivity", "Empty string");
            return false;
        }
        numberEntered = Integer.valueOf(UMIDentered.getText().toString());

        if(numberEntered == UMIDpassword)
        {
            return true;
        }
        return false;
    }


}