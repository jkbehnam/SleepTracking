package arithtopia.android.com.arithtopia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(arithtopia.android.com.arithtopia.R.layout.activity_profile);

        //------------------------------------------------------
        Toolbar toolbar = findViewById(arithtopia.android.com.arithtopia.R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView tvToolbarTitle = findViewById(arithtopia.android.com.arithtopia.R.id.tvToolbarAllPage);
        tvToolbarTitle.setText(arithtopia.android.com.arithtopia.R.string.profile);
        //------------------------------------------------------


        //------------------------------------------------------

        //------------------------------------------------------


    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);
    }


    //----------------------------------------------------------------
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    //----------------------------------------------------------------


    //----------------------------------------------------------------

    //----------------------------------------------------------------
}
