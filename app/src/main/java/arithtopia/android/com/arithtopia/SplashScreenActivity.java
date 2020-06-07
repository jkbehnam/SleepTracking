package arithtopia.android.com.arithtopia;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SplashScreenActivity extends AppCompatActivity {

    Animation fade_in;
    public static int Time_Out = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //---------------------------------------------------------
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/iran_sans.ttf")
                .setFontAttrId(arithtopia.android.com.arithtopia.R.attr.fontPath)
                .build()
        );
        //---------------------------------------------------------



        //------------------------------------------------------------------------------------------
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //------------------------------------------------------------------------------------------
        setContentView(arithtopia.android.com.arithtopia.R.layout.activity_splash_screen);


        //------------------------------------------------------------------------------------------
        fade_in = AnimationUtils.loadAnimation(SplashScreenActivity.this, arithtopia.android.com.arithtopia.R.anim.fade_in);
        //------------------------------------------------------------------------------------------


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(SplashScreenActivity.this , LoginActivity.class));
                overridePendingTransition(arithtopia.android.com.arithtopia.R.anim.fade_in, arithtopia.android.com.arithtopia.R.anim.fade_out);
                finish();

            }
        }, Time_Out);

    }

}
