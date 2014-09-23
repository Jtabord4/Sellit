package co.edu.eafit.sellit;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;

import java.io.File;
import java.net.URI;
import java.util.Random;

public class Activity_feed extends Activity {

    private static String logtag = "cameraApp";
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.horizontal_view);



        View view = getLayoutInflater().inflate(R.layout.feed_images, null);

        ImageView image = (ImageView)view.findViewById(R.id.feed_image);
        Bitmap bitmap  = getIntent().getParcelableExtra("product-image");
        image.setImageBitmap(bitmap);

        TextView display_name = (TextView)view.findViewById(R.id.name_feed);
        String name = getIntent().getStringExtra("product-name");
        display_name.setText(name);

        TextView display_price = (TextView)view.findViewById(R.id.price_feed);
        String price = getIntent().getStringExtra("product-price");
        display_price.setText(price);

        TextView display_description = (TextView)view.findViewById(R.id.description_feed);
        String description = getIntent().getStringExtra("product-description");
        display_description.setText(description);

        mainLayout.addView(view);

        View view2 = getLayoutInflater().inflate(R.layout.feed_images, null);
        mainLayout.addView(view2);


        Button btn_profile =(Button)findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent_profile = new Intent(getApplicationContext(),Activity_profile.class);
                startActivity(intent_profile);
            }
        });

        Button btn_camera = (Button) findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(cameraListener);

    }

    private OnClickListener cameraListener = new OnClickListener(){
        public void onClick(View v){
        takePhoto(v);
        }

    };

    private void takePhoto(View v){
        Intent intentcamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intentcamera, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        Bitmap thumbnail = null;
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                thumbnail = (Bitmap) data.getExtras().get("data");

                Intent i = new Intent(this, Activity_transition.class);
                i.putExtra("name", thumbnail);
                startActivity(i);



            }

        }

                /*Uri selectedImage = imageUri;
                getContentResolver().notifyChange(selectedImage, null);

                ImageView imageView = (ImageView) findViewById(R.id.posted_img);
                ContentResolver cr = getContentResolver();
                Bitmap bitmap;

                try{
                    bitmap = MediaStore.Images.Media.getBitmap(cr, selectedImage);
                    imageView.setImageBitmap(bitmap);
                    Toast.makeText(Activity_feed.this, selectedImage.toString(), Toast.LENGTH_LONG).show();


                } catch (Exception e){
                    Log.e(logtag, e.toString());
                }*/


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
