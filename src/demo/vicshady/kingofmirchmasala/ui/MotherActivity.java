package demo.vicshady.kingofmirchmasala.ui;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import demo.vicshady.kingofmirchmasala.R;
import demo.vicshady.kingofmirchmasala.app.AppConstants;


/**
 * @author Vikalp Patel(vikalppatelce@yahoo.com)
 *
 */
public class MotherActivity extends SherlockFragmentActivity {

	// Declare Variables
	ActionBar mActionBar;
	ViewPager mPager;
	Tab tab;
	Typeface stylefontActionBar;

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.activity_mother);
		
		stylefontActionBar = Typeface.createFromAsset(getAssets(), AppConstants.fontStyle);
		
		// Activate Navigation Mode Tabs
		mActionBar = getSupportActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// Locate ViewPager in activity_main.xml
		mPager = (ViewPager) findViewById(R.id.pager);
		
		// Activate Fragment Manager
		FragmentManager fm = getSupportFragmentManager();

		// Capture ViewPager page swipes
		ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				// Find the ViewPager Position
				mActionBar.setSelectedNavigationItem(position);
				switch(position)
				{
				case 0:
					setMotherActionBarTitle(getString(R.string.str_home_fragment));
					break;
				case 1:
					setMotherActionBarTitle(getString(R.string.str_place_order_fragment));
					break;
				case 2:
					setMotherActionBarTitle(getString(R.string.str_new_arrival_fragment));
					break;
				case 3:
					setMotherActionBarTitle(getString(R.string.str_about_fragment));
					break;
				}
			}
		};

		mPager.setOnPageChangeListener(ViewPagerListener);
		// Locate the adapter class called ViewPagerAdapter.java
		ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(fm);
		// Set the View Pager Adapter into ViewPager
		mPager.setAdapter(viewpageradapter);
		
		// Capture tab button clicks
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// Pass the position on tab click to ViewPager
				mPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
			}
		};

		// Create first Tab
//		tab = mActionBar.newTab().setText("Tab1").setTabListener(tabListener);
		tab = mActionBar.newTab().setIcon(R.drawable.tab_icon_kmm_home).setTabListener(tabListener);
		mActionBar.addTab(tab);
		setMotherActionBarTitle(getString(R.string.str_home_fragment));
		
		// Create second Tab
//		tab = mActionBar.newTab().setText("Tab2").setTabListener(tabListener);
		tab = mActionBar.newTab().setIcon(R.drawable.tab_icon_place_order).setTabListener(tabListener);
		mActionBar.addTab(tab);
		setMotherActionBarTitle(getString(R.string.str_place_order_fragment));
		
		// Create third Tab
//		tab = mActionBar.newTab().setText("Tab3").setTabListener(tabListener);
		tab = mActionBar.newTab().setIcon(R.drawable.tab_icon_new_arrival).setTabListener(tabListener);
		mActionBar.addTab(tab);
		setMotherActionBarTitle(getString(R.string.str_new_arrival_fragment));
		
//		tab = mActionBar.newTab().setText("Tab4").setTabListener(tabListener);
		tab = mActionBar.newTab().setIcon(R.drawable.tab_icon_kmm_about).setTabListener(tabListener);
		mActionBar.addTab(tab);
		setMotherActionBarTitle(getString(R.string.str_about_fragment));

	}
	
	public void setMotherActionBarTitle(String s)
	{
//		mActionBar.setTitle(s);
		fontActionBar(s);
	}
	
	public void fontActionBar(String str)
	{
		try {
			int titleId;
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				titleId = getResources().getIdentifier("action_bar_title","id", "android");
			} else {
				titleId = R.id.abs__action_bar_title;
			}
			TextView yourTextView = (TextView) findViewById(titleId);
			yourTextView.setText(str);
			yourTextView.setTypeface(stylefontActionBar);
		} catch (Exception e) {
			Log.e("ActionBar Style", e.toString());
		}
	}
}
