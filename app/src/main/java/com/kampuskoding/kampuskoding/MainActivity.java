package com.kampuskoding.kampuskoding;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.kampuskoding.kampuskoding.Tab.MyAdapter;
import com.kampuskoding.kampuskoding.Tab.SlidingTabLayout;
import com.kampuskoding.kampuskoding.fragment.ChatFragment;
import com.kampuskoding.kampuskoding.fragment.ExploreFragment;
import com.kampuskoding.kampuskoding.fragment.FriendFragment;
import com.kampuskoding.kampuskoding.fragment.HomeFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import static android.R.attr.fraction;
import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager=(ViewPager)findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

        //===================================================================================

        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(
                        new ProfileDrawerItem().withName("Kampus Koding").withEmail("kampuskoding@gmail.com").withIcon(getResources().getDrawable(R.drawable.icon))
                )
                .build();
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();

        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Home").withIcon(getResources().getDrawable(R.drawable.ic_home_white_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Explore").withIcon(getResources().getDrawable(R.drawable.ic_explore_white_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Chate").withIcon(getResources().getDrawable(R.drawable.ic_chat_white_24dp)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Friends").withIcon(getResources().getDrawable(R.drawable.ic_person_white_24dp)));
    //=======================================================================================================
//        bottomBar =(BottomBar)findViewById(R.id.bottombar);
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            Fragment fragment = null;
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if (tabId == R.id.tab_home){
//                    fragment = new HomeFragment();
//                }else if (tabId == R.id.tab_explore){
//                    fragment = new ExploreFragment();
//                }else if (tabId ==R.id.tab_chat){
//                    fragment = new ChatFragment();
//                }else if (tabId==R.id.tab_friends){
//                    fragment = new FriendFragment();
//                }
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.content, fragment)
//                        .commit();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
