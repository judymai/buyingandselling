package com.mycompany.myfirstapp;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.parse.Parse;
import com.facebook.Session;

import java.util.Locale;

public class MainActivity extends ActionBarActivity {

    private TextView displayText;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "DrytnAJeUWXXNixWdFQNB8gUqQDZsi0GSqO7sTB3", "6lgg4j81kBXjWjUMVociUUkc0D5yCxaDTy5W1gMP");

        // Font change
        /*
        TextView myTextView=(TextView)findViewById(R.id.textBox);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");
        myTextView.setTypeface(typeFace);
        */
        /*Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/fontname.ttf");
        textview.setTypeface(tf);*/

    }

    public static void setFont(TextView textView) {
        Typeface tf = Typeface.createFromAsset(textView.getContext()
                .getAssets(), "fonts/Roboto-Regular.ttf");

        textView.setTypeface(tf);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.home:
                goHome();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case R.id.action_profile:
                openProfile();
                return true;
            case R.id.action_login:
                openLogin();
                return true;
            case R.id.action_search:
                onSearchRequested();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSearchRequested() {
        Bundle appData = new Bundle();
        appData.putString("hello", "world");
        startSearch(null, false, appData, false);
        return true;
    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    public void goHome () {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this, activity_setting.class);
        startActivity(intent);
    }

    public void openProfile() {
        Intent intent = new Intent(this, SellerProfile.class);
        startActivity(intent);
    }

    public void openLogin() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
