package arithtopia.android.com.arithtopia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import arithtopia.android.com.arithtopia.adapters.adapter_gamer_recycle;
import arithtopia.android.com.arithtopia.database_pack.DataBase;
import arithtopia.android.com.arithtopia.database_pack.save_to_table;

import net.glxn.qrgen.android.QRCode;

import java.util.ArrayList;
import java.util.Calendar;

import arithtopia.android.com.arithtopia.objects_class.Gamer;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Add_New_Gamer extends AppCompatActivity {
    AlertDialog.Builder builder;
    View alert_dialog_newitem;
    AlertDialog ald_insert, ald_QRcode;
    RecyclerView RV;
    EditText gamer_name, gamer_phone_number, gamer_member_numer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(arithtopia.android.com.arithtopia.R.layout.activity_add__new__gamer);
        Toolbar toolbar = findViewById(arithtopia.android.com.arithtopia.R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView tvToolbarTitle = findViewById(arithtopia.android.com.arithtopia.R.id.tvToolbarAllPage);
        tvToolbarTitle.setText(R.string.add_gamer);
        context = this;
        builder = new AlertDialog.Builder(this);
        ald_insert = builder.create();
        alert_dialog_newitem = LayoutInflater.from(this).inflate(arithtopia.android.com.arithtopia.R.layout.alert_dialoge_add_gamer, null);
        ald_insert.setView(alert_dialog_newitem);
        ald_insert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        gamer_name = (EditText) alert_dialog_newitem.findViewById(arithtopia.android.com.arithtopia.R.id.gamer_name);
        gamer_member_numer = (EditText) alert_dialog_newitem.findViewById(arithtopia.android.com.arithtopia.R.id.gamer_member_number);
        gamer_phone_number = (EditText) alert_dialog_newitem.findViewById(arithtopia.android.com.arithtopia.R.id.gamer_phone_numer);

        final EditText[] et = {gamer_name, gamer_member_numer, gamer_phone_number};
        final Button submit = (Button) alert_dialog_newitem.findViewById(arithtopia.android.com.arithtopia.R.id.submit);
        Button cancle = (Button) alert_dialog_newitem.findViewById(arithtopia.android.com.arithtopia.R.id.cancel);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ald_insert.cancel();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(arithtopia.android.com.arithtopia.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamer_name.setText("");
                gamer_member_numer.setText("");
                gamer_phone_number.setText("");
                ald_insert.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty(et)) {
                    Calendar cal = Calendar.getInstance();

                    Gamer gamer = new Gamer(gamer_name.getText().toString(), gamer_phone_number.getText().toString(), Integer.parseInt(gamer_member_numer.getText().toString()), cal.getTime().toString());
                    save_to_table.save_gamer(gamer, context);
                    ald_insert.cancel();
                    alert_dialog_newitem = LayoutInflater.from(context).inflate(arithtopia.android.com.arithtopia.R.layout.alert_new_gamer_qrcode, null);
                    Bitmap myBitmap = QRCode.from(gamer.print_gamer_card()).withSize(Screen_width(), Screen_width()).bitmap();
                    ImageView myImage = (ImageView) alert_dialog_newitem.findViewById(arithtopia.android.com.arithtopia.R.id.qrcod_imageView);
                    myImage.setImageBitmap(myBitmap);
                    ald_QRcode = builder.create();
                    ald_QRcode.setView(alert_dialog_newitem);
                    ald_QRcode.show();
                    ShowData_3();
                } else
                    Toast.makeText(context, "همه ی موارد باید پر شوند", Toast.LENGTH_SHORT).show();

            }
        });

        RV = (RecyclerView) findViewById(R.id.recycle_gamer);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RV.setLayoutManager(mLayoutManager);
        RV.setItemAnimator(new SlideInLeftAnimator());
        ShowData_3();
    }

    //----------------------------------------------------------------
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public int Screen_width() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        return width;
    }

    //----------------------------------------------------------------
    public boolean isEmpty(EditText[] etText) {
        for (EditText et : etText
                ) {
            if (et.getText().toString().trim().length() == 0) {
                et.setError("لطفا این فیلد را پر کنید");
                et.requestFocus();

                return true;

            }
        }

        return false;

    }

    public void ShowData_3() {
        SQLiteDatabase db = new DataBase(getBaseContext()).getInstance();
        Cursor cr = db.rawQuery("select * from gamer_table", null);
        cr.moveToLast();
        final ArrayList<Gamer> gamer_list = new ArrayList<>();
        adapter_gamer_recycle madapter;
        if (cr.getCount() != 0) {
            do {
                Gamer dv = new Gamer(cr.getString(cr.getColumnIndex("gamer_name")), cr.getString(cr.getColumnIndex("gamer_phone_number")), cr.getInt(cr.getColumnIndex("gamer_member_number")), cr.getString(cr.getColumnIndex("gamer_reg_time")));
                gamer_list.add(dv);

            } while (cr.moveToPrevious());
        }
        madapter = new adapter_gamer_recycle(gamer_list);


        ScaleInAnimationAdapter alphaAdapter = new ScaleInAnimationAdapter(madapter);
        alphaAdapter.setFirstOnly(true);
        RV.setAdapter(alphaAdapter);
       /* madapter.setOnCardClickListner(new adapter_gamer_recycle().OnCardClickListner() {
            @Override
            public void OnCardClicked(View view, int position) {

                data_patient dv = new data_patient();
                dv = dv_list.get(position);
                ald_insert.show();
                edit(dv.getInsurance_id(), container);
            }
        });*/
    }
}
