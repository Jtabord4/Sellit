package co.edu.eafit.sellit;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity_reg extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button btn_register = (Button)findViewById(R.id.btn_reg);


        btn_register.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                EditText name_field = (EditText)findViewById(R.id.name_edit);
                EditText pass_field = (EditText)findViewById(R.id.pass_edit);
                EditText email_field = (EditText)findViewById(R.id.email_edit);
                TextView error = (TextView)findViewById(R.id.display);

                String name = name_field.getText().toString();
                String pass = pass_field.getText().toString();
                String email = email_field.getText().toString();

                Intent intent = new Intent(getApplicationContext(),Activity_profile.class);
                intent.putExtra("user-name", name);
                startActivity(intent);


                if((!name.equals(null)) && (!pass.equals(null)) && (!email.equals(null))){
                    error.setText("ERROR");
                }else{

                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_my, container, false);
            return rootView;
        }
    }
}
