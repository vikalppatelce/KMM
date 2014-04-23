package demo.vicshady.kingofmirchmasala.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author Vikalp Patel (vikalppatelce@yahoo.com)
 * @category Ui Helper
 * 
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 4;
	
	/**
	 * @param fm
	 */
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
	 */
	@Override
	public Fragment getItem(int item) {
		switch (item) {

			// Open HomeFragment.java
		case 0:
			HomeFragment homeFragment = new HomeFragment();
			return homeFragment;

			// Open PlaceOrderFragment.java
		case 1:
			PlaceOrderFragment placeOrderFragment = new PlaceOrderFragment();
			return placeOrderFragment;

			// Open NewArrivalFragment.java
		case 2:
			NewArrivalFragment newArrivalFragment = new NewArrivalFragment();
			return newArrivalFragment;
		case 3:
			AboutFragment aboutFragment = new AboutFragment();
			return aboutFragment;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

}
