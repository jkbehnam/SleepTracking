package arithtopia.android.com.arithtopia.adapters;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import arithtopia.android.com.arithtopia.R;
import arithtopia.android.com.arithtopia.objects_class.Gamer;
import info.hoang8f.widget.FButton;

/**
 * Created by behnam_b on 7/5/2016.
 */
public class adapter_gamer_recycle extends RecyclerView.Adapter<adapter_gamer_recycle.MyViewHolder> {
    private List<Gamer> data_gamer_list;
    String User_Path = "/data/data/com.behnam_b.bime_2/bime/";
    OnCardClickListner onCardClickListner;
    //adapter_gamer_recycle.OnCardClickListner onCardClickListner;

    AlertDialog.Builder builder;
    View alert_dialog_delete;
    AlertDialog ald_delete;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView gamer_name, gamer_phone, gamer_memebr, gamer_reg_time, sex_patient;
        public FButton btn_delete, btn_show_code;

        public MyViewHolder(View view) {
            super(view);
            gamer_name = (TextView) view.findViewById(R.id.cv_gamer_name);
            gamer_phone = (TextView) view.findViewById(R.id.cv_gamer_phone);
            gamer_memebr = (TextView) view.findViewById(R.id.cv_gamer_member);
            gamer_reg_time = (TextView) view.findViewById(R.id.cv_gamer_reg_time);

            btn_delete = (FButton) view.findViewById(R.id.btn_delete);
            btn_show_code = (FButton) view.findViewById(R.id.btn_edit);


        }
    }


    public adapter_gamer_recycle(ArrayList<Gamer> data_visits_list) {
        this.data_gamer_list = data_visits_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_gamer, parent, false);

     /*   builder = new AlertDialog.Builder(parent.getContext());
        ald_delete = builder.create();
        alert_dialog_delete = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_delete, null);
        ald_delete.setView(alert_dialog_delete);
*/

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Gamer gamer = data_gamer_list.get(position);
        holder.gamer_name.setText(gamer.getName());
        holder.gamer_phone.setText(gamer.getPhone_number());
        holder.gamer_memebr.setText(String.valueOf(gamer.getMembers()));
        holder.gamer_reg_time.setText(gamer.getReg_time());

        holder.btn_delete.setTag(gamer.getPhone_number());
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ald_delete.show();
                FButton btn_alert_delete = (FButton) alert_dialog_delete.findViewById(R.id.submit);
                FButton btn_alert_cancle = (FButton) alert_dialog_delete.findViewById(R.id.cancel);
                btn_alert_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    /*    SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(User_Path + "bime.db",
                                null, null);
                        db.delete("patient", "insurance_id='" + String.valueOf(gamer.getInsurance_id()) + "' ", null);
                        data_patient_list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, getItemCount());

                        //  refresh();
                        db.close();
                        ald_delete.cancel();

                    }
                });
                btn_alert_cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ald_delete.cancel();
                    }
                });

*/
            }

        });
        holder.btn_show_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCardClickListner.OnCardClicked(v, position);
            }
        });

    }

    public interface OnCardClickListner {
        void OnCardClicked(View view, int position);
    }

    public void setOnCardClickListner(adapter_gamer_recycle.OnCardClickListner onCardClickListner) {
        this.onCardClickListner = onCardClickListner;
    }

    @Override
    public int getItemCount() {
        return data_gamer_list.size();
    }
}