package pe.edu.ulima.componentesavanzados;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class NavigationActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean mDrawerOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                if (item.getItemId() == R.id.menu1){
                    finish();
                }else{
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        ActionBar appBar = getSupportActionBar();
        if (appBar != null){
            appBar.setHomeAsUpIndicator(android.R.drawable.star_on);
            appBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            if (mDrawerOpened == false){
                drawerLayout.openDrawer(GravityCompat.START);
                mDrawerOpened = true;
            }else{
                drawerLayout.closeDrawers();
                mDrawerOpened = false;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
