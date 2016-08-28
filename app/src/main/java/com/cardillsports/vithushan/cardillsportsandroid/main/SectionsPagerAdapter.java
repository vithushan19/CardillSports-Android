package com.cardillsports.vithushan.cardillsportsandroid.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if (position == 0) return new ArticleListFragment();
        if (position == 1) return new PodcastListFragment();
        if (position == 2) return new CreatorListFragment();
        return PlaceholderFragment.newInstance(position + 1);
    }


    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Articles";
            case 1:
                return "Podcasts";
            case 2:
                return "Authors";
        }
        return null;
    }
}