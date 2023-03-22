package Function;

public class IsSoDienThoai {
    public boolean isSoDienThoai(String phone){
        if(phone.matches(".*[a-zA-Z].*")){
            return false;
        }else {
            if (phone.length()!=10){
                return false;
            }
            return true;
        }
    }
}
