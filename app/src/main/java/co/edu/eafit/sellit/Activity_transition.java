package co.edu.eafit.sellit;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class Activity_transition extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transicioncamara);


        Bitmap bitmap  = getIntent().getParcelableExtra("name");
        ImageView view = (ImageView) findViewById(R.id.posted_img);
        view.setImageBitmap(bitmap);

        Button publicar =(Button)findViewById(R.id.btn_publicar);

        /*TextView display_name = (TextView)findViewById(R.id.username);
        String name = getIntent().getStringExtra("user-name");

        display_name.setText(name);*/

        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView image = (ImageView)findViewById(R.id.posted_img);
                EditText name_field = (EditText)findViewById(R.id.nombre_foto);
                EditText price_field = (EditText)findViewById(R.id.precio_prod);
                EditText description_field = (EditText)findViewById(R.id.descripcion_prod);

                Bitmap bitmap  = getIntent().getParcelableExtra("name");
                String name = name_field.getText().toString();
                String price = price_field.getText().toString();
                String description = description_field.getText().toString();

                Intent intent_feed = new Intent(getApplicationContext(),Activity_feed.class);
                intent_feed.putExtra("product-image",bitmap);
                intent_feed.putExtra("product-name", name);
                intent_feed.putExtra("product-price", price);
                intent_feed.putExtra("product-description", description);

                startActivity(intent_feed);
            }
        });

    }



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
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
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
            View rootView = inflater.inflate(R.layout.feed, container, false);
            return rootView;
        }
    }
}

