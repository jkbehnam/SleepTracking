package arithtopia.android.com.arithtopia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    public ArrayList<navMenuListItem> navigationItems;
    public ListView navigationListView;
    public DrawerLayout drawer_Layout;
    public NavigationView navigationView;
    public TextView tvHeader ;
    public ImageView imgNavigationMenu ;
    public android.support.v7.widget.Toolbar toolbar ;
    public Typeface typeface ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(arithtopia.android.com.arithtopia.R.layout.activity_main_new);

        //---------------------------------------------------------
        typeface = Typeface.createFromAsset(getAssets(),"font/iran_sans.ttf");
        //---------------------------------------------------------

        //---------------------------------------------------------
        toolbar = findViewById(arithtopia.android.com.arithtopia.R.id.toolbar);
        setSupportActionBar(toolbar);
        //---------------------------------------------------------

        //---------------------------------------------------------
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/iran_sans.ttf")
                .setFontAttrId(arithtopia.android.com.arithtopia.R.attr.fontPath)
                .build()
        );
        //---------------------------------------------------------


        //---------------------------------------------------------
        findViewById(arithtopia.android.com.arithtopia.R.id.Add_Gamer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Add_New_Gamer.class));
                overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);

            }
        });

        findViewById(arithtopia.android.com.arithtopia.R.id.imgReport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, ReportActivity.class));
                overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);

            }
        });


        findViewById(arithtopia.android.com.arithtopia.R.id.imgCappAdvice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AdviseActivity.class));
                overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);

            }
        });


        findViewById(arithtopia.android.com.arithtopia.R.id.imgMyMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, MessageActivity.class));
                overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);

            }
        });
        //---------------------------------------------------------


        //---------------------------------------------------------
        navigationItems = new ArrayList<>();
        navigationItems.add(new navMenuListItem(arithtopia.android.com.arithtopia.R.drawable.ic_user_profile, "حساب کاربری"));
        navigationItems.add(new navMenuListItem(arithtopia.android.com.arithtopia.R.drawable.ic_settings,"تنظیمات" ));
        navigationItems.add(new navMenuListItem(arithtopia.android.com.arithtopia.R.drawable.ic_about_us,"توضیحات"));
        //-----------------------------------------------------------

        //-----------------------------------------------------------
        navigationListView = findViewById(arithtopia.android.com.arithtopia.R.id.navigatelistview);
        navigationListView.setAdapter(new navMenuAdapter(MainActivity.this, arithtopia.android.com.arithtopia.R.layout.custom_navigation_row_item, navigationItems));

        navigationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0 :

                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);
                        break;

                    case 1 :
                        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                        overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);
                        break;
                        case 2 :

                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);
                        break;


                }

            }
        });
        //-----------------------------------------------------------

        //-----------------------------------------------------------
        drawer_Layout =  findViewById(arithtopia.android.com.arithtopia.R.id.drawer_layout);
        navigationView = findViewById(arithtopia.android.com.arithtopia.R.id.NavigationView);
        View header = navigationView.getHeaderView(0);
        tvHeader = header.findViewById(arithtopia.android.com.arithtopia.R.id.btnNavigationHeaderLayout);
        tvHeader.setTypeface(typeface);

        tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           //     startActivity(new Intent(MainActivity.this , Login.class));

            }
        });
       //-------------------------------------------------------------


        //------------------------------------------------------------
        imgNavigationMenu = findViewById(arithtopia.android.com.arithtopia.R.id.navigationMenuButton);
        imgNavigationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer_Layout.openDrawer(Gravity.RIGHT);

            }
        });
        //------------------------------------------------------------

    }



    //----------------------------------------------------------------
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    //----------------------------------------------------------------

    //----------------------------------------------------------------

    @Override
    public void onBackPressed() {

        if (drawer_Layout.isDrawerOpen(Gravity.RIGHT))
        {
            drawer_Layout.closeDrawer(Gravity.RIGHT);
        }

        else
        {
            super.onBackPressed();
        }
    }
}
