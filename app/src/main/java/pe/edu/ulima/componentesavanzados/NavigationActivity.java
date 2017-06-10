package pe.edu.ulima.componentesavanzados;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean mDrawerOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                if (item.getItemId() == R.id.menuHelados){
                    FragmentManager fMan = getSupportFragmentManager();
                    FragmentTransaction ft = fMan.beginTransaction();
                    ft.replace(R.id.flaContenido,new HeladoFragment());
                    ft.addToBackStack(null);
                    ft.commit();
                }else if (item.getItemId() == R.id.menuDonas){
                    FragmentManager fMan = getSupportFragmentManager();
                    FragmentTransaction ft = fMan.beginTransaction();
                    ft.replace(R.id.flaContenido,new DonaFragment());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

        ActionBar appBar = getSupportActionBar();
        if (appBar != null){
            appBar.setHomeAsUpIndicator(android.R.drawable.star_on);
            appBar.setDisplayHomeAsUpEnabled(true);
        }

        FragmentManager fMan = getSupportFragmentManager();
        FragmentTransaction ft = fMan.beginTransaction();
        ft.add(R.id.flaContenido,new HeladoFragment());
        ft.addToBackStack(null);
        ft.commit();
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
        }/*else if (item.getItemId() == R.id.menAB1) {
                Toast.makeText(this, "Menu AB1", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.menAB2){
            Toast.makeText(this, "Menu AB2", Toast.LENGTH_SHORT).show();
        }*/
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}
