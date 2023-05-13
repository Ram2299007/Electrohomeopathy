package com.mgUnicorn.eh.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mgUnicorn.eh.Fragments.callsFragment;
import com.mgUnicorn.eh.Fragments.chatsFragment;
import com.mgUnicorn.eh.Fragments.statusFragment;

public class fragmentsAdapter extends FragmentPagerAdapter {
    public fragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new statusFragment();
            case 1:return new chatsFragment();
            case 2:return new callsFragment();
            default:return new chatsFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title=null;
        if(position==0)
        {
            title="Patients";

        }

        if(position==1)
        {
            title="Support";


        }
        if(position==2)
        {
            title="Spec. of Eh";
        }
        return title;
    }
}
