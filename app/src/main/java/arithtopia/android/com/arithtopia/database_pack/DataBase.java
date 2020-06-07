package arithtopia.android.com.arithtopia.database_pack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by User on 1/25/2018.
 */

public class DataBase {
    static String User_Path;
    static Context context;
    static SQLiteDatabase db;
    @SuppressLint("WrongConstant")
    public DataBase(Context Context) {
        context = Context;
        User_Path =  "/data/data/arithtopia.android.com.arithtopia/datahhbases/";

        open_db();
        db = context.openOrCreateDatabase(User_Path + "/arith_topia.db",
                SQLiteDatabase.CREATE_IF_NECESSARY, null);
    }

    public static void open_db() {
        File f = new File(User_Path);
        if (!f.exists()) {
            try {
                f.mkdirs();
                f.createNewFile();
                InputStream in = context.getAssets().open("arith_topia.db");

                OutputStream out = new FileOutputStream(User_Path + "arith_topia.db");

                int read;
                byte[] buffer = new byte[1024];

                while ((read = in.read(buffer)) != -1) {

                    out.write(buffer, 0, read);

                }

                in.close();
                out.close();


            } catch (Exception exp) {


            }
        } else {

        }
    }

    public SQLiteDatabase getInstance() {
        return db;
    }
}
