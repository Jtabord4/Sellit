package co.edu.eafit.sellit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_preferences extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        Button agree =(Button)findViewById(R.id.btn_preferences_agree);

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

                updatePreferences(preferences);

                Intent intent_preferences = new Intent(getApplicationContext(),Activity_feed.class);
                startActivity(intent_preferences);
            }
        });

    }

    public void updatePreferences(SharedPreferences pref) {

    }
}


