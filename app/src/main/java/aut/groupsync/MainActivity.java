package aut.groupsync;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import aut.groupsync.services.IUserService;
import aut.groupsync.services.UserService;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private IUserService userService = new UserService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (menuItem.getItemId()) {

            case R.id.nav_timetable:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Timetable()).commit();
                break;

                //Who did this? - John
            case R.id.nav_groups:
                String groupName = "GroupView Name"; // #todo set properly
                AccountView user = new AccountView(userService);
                //fragment = new GroupView(groupName, user);
                title = "GroupView";
                break;
            case R.id.nav_account:
                fragment = new AccountView(userService);
                title = "AccountView";
                break;
        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    fragment).commit();
        }
        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
