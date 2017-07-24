package com.example.vania.loveserials;

import android.app.ActivityOptions;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vania.loveserials.fragments.MyProfileFragment;
import com.example.vania.loveserials.fragments.SerialsListFragment;

public class NavigationMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText editStatus;
    private MyProfileFragment myProfileFragment ;
    private SerialsListFragment serialsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        myProfileFragment = new MyProfileFragment();
        serialsListFragment = new SerialsListFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        if (id == R.id.nav_camera) {
            ftrans.replace(R.id.container, myProfileFragment);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_serials) {
            ftrans.replace(R.id.container, serialsListFragment);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ClickToChangeStatus(View view)
    {
        Button changeButton = (Button)findViewById(R.id.ChangeStatus);
        if(changeButton.getText().toString().equals("Edit")) {
            changeButton.setText("Save");
            editStatus = (EditText) findViewById(R.id.MyStatus);
            editStatus.setFocusableInTouchMode(true);
        }
        else if(changeButton.getText().toString().equals("Save"))
        {
            changeButton.setText("Edit");
            editStatus.setFocusable(false);
        }

    }
    public void clickToAddPost(View view)
    {
        EditText editText = (EditText) findViewById(R.id.TextToPost);
        if(!editText.getText().toString().equals("")) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.MainLinearLayout);


            LinearLayout linearLayoutIn = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 20, 0, 0);
            linearLayoutIn.setLayoutParams(layoutParams);
            linearLayoutIn.setOrientation(LinearLayout.VERTICAL);

            LinearLayout linearLayoutIn2 = new LinearLayout(this);
            linearLayoutIn2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayoutIn2.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout linearLayoutIn3 = new LinearLayout(this);
            linearLayoutIn3.setOrientation(LinearLayout.VERTICAL);
            linearLayoutIn3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));


            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.ic_launcher_post);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(75, 75));

            LinearLayout linearLayoutIn4 = new LinearLayout(this);
            linearLayoutIn4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayoutIn4.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams5.setMargins(3, 0, 0, 0);
            TextView textView = new TextView(this);
            textView.setText("Vania Hrynchyshyn");
            textView.setLayoutParams(layoutParams5);
            textView.setTextSize(15);

            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams6.setMargins(3, 15, 0, 0);
            TextView textView2 = new TextView(this);
            textView2.setText("5 mins ago");
            textView2.setLayoutParams(layoutParams6);
            textView2.setTextSize(10);

            LinearLayout linearLayoutIn5 = new LinearLayout(this);
            linearLayoutIn5.setOrientation(LinearLayout.VERTICAL);
            linearLayoutIn5.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView textView3 = new TextView(this);
            textView3.setText(editText.getText());
            textView3.setTextSize(30);


            linearLayout.addView(linearLayoutIn);
            linearLayoutIn.addView(linearLayoutIn2);
            linearLayoutIn2.addView(linearLayoutIn3);
            linearLayoutIn3.addView(imageView);
            linearLayoutIn2.addView(linearLayoutIn4);
            linearLayoutIn4.addView(textView);
            linearLayoutIn4.addView(textView2);
            linearLayoutIn.addView(linearLayoutIn5);
            linearLayoutIn5.addView(textView3);

            editText.setText("");
        }
    }
}
