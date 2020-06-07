package arithtopia.android.com.arithtopia.database_pack;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import arithtopia.android.com.arithtopia.objects_class.Gamer;

public class save_to_table  {
    public static void save_gamer(Gamer gamer,Context context){
        ContentValues cv;
        cv = new ContentValues();
        cv.put("gamer_name",gamer.getName());
        cv.put("gamer_phone_number", gamer.getPhone_number());
        cv.put("gamer_member_number",gamer.getMembers());
        cv.put("gamer_reg_time",gamer.getReg_time());
        new DataBase(context).getInstance().insert("gamer_table", null, cv);
        Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show();
    }
}
