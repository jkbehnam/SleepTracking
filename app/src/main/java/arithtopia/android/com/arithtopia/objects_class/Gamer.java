package arithtopia.android.com.arithtopia.objects_class;

public class Gamer {
    private String name;
    private String phone_number;
    private String reg_time;
    private int members;
    public Gamer(String _name, String _phone_number, int _members,String _reg_time ){
        setName(_name);
        setPhone_number(_phone_number);
        setMembers(_members);
        setReg_time(_reg_time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }
    public String print_gamer_card(){

        String card=this.getName()+"/"+this.getPhone_number()+"/"+String.valueOf(this.members);
           return card;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }
}
