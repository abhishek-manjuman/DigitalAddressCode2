package com.dacode.digitaladdresscode;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AddNewAddressFragment addNewAddressFragment;
    private AccountFragment accountFragment;
    private AddressListFragment addressListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.fragment_container);

        homeFragment =new HomeFragment();
        notificationFragment = new NotificationFragment();
        addNewAddressFragment = new AddNewAddressFragment();
        accountFragment = new AccountFragment();
        addressListFragment = new AddressListFragment();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()){

                    case R.id.nav_home :
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_account :
                        setFragment(accountFragment);
                        return true;
                    case R.id.nav_add_new_address :
                        setFragment(addNewAddressFragment);
                        return true;
                    case R.id.nav_address_list :
                        setFragment(addressListFragment);
                        return true;
                    case R.id.nav_notification :
                        setFragment(notificationFragment);
                        return true;

                    default :
                        return false;

                }


            }

        });
    }
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();

    }
}
