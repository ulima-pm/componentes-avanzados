package pe.edu.ulima.componentesavanzados;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class ScreenPagerAdapter extends FragmentStatePagerAdapter {
    public ScreenPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        ScreenFragment fragment = new ScreenFragment();

        Bundle data = new Bundle();
        data.putInt("NUM_FRAGMENT", position);

        fragment.setArguments(data);

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
