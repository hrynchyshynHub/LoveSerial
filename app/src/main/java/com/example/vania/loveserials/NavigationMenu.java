package com.example.vania.loveserials;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.vania.loveserials.fragments.MainFragment;
import com.example.vania.loveserials.fragments.NewsFragment;
import com.example.vania.loveserials.fragments.SearchFriendsFragment;
import com.example.vania.loveserials.fragments.SearchSerialsFragment;

public class NavigationMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchSerialsFragment searchSerialsFragment;
    private NewsFragment newsFragment;
    private SearchFriendsFragment searchFriendsFragment;
    MainFragment mainFragment;
    private FragmentTransaction ftrans;

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
        searchSerialsFragment = new SearchSerialsFragment();
        newsFragment= new NewsFragment();
        searchFriendsFragment = new SearchFriendsFragment();
        mainFragment = new MainFragment();
        ftrans = getFragmentManager().beginTransaction();
        ftrans.replace(R.id.container, mainFragment);
        ftrans.commit();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        ftrans = getFragmentManager().beginTransaction();
        if (id == R.id.my_profile) {
            ftrans.replace(R.id.container, mainFragment).addToBackStack(null);
        } else if (id == R.id.search_serial) {
            ftrans.replace(R.id.container, searchSerialsFragment).addToBackStack(null);
        } else if (id == R.id.news) {
            ftrans.replace(R.id.container, newsFragment).addToBackStack(null);
        } else if (id == R.id.friends) {
            ftrans.replace(R.id.container, searchFriendsFragment).addToBackStack(null);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.exit) {
        Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
