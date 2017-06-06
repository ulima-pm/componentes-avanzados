package pe.edu.ulima.componentesavanzados;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    ScreenPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mPagerAdapter);
    }
}
