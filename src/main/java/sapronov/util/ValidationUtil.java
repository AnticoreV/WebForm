package sapronov.util;

public class ValidationUtil {
    private static ValidationUtil validationUtil;

    private ValidationUtil(){}

    public static ValidationUtil getInstance(){
        if(validationUtil == null){
            validationUtil = new ValidationUtil();
        }
        return validationUtil;
    }

    //policy_number requires minimum 8 characters
    public boolean isMinValidLength(String pass, int length){
        if(pass.length() < length){
            return false;
        }else return true;
    }
    //area request can have maximum 5000 characters
    public boolean isMaxValidLength(String pass, int length){
        if(pass.length() > length){
            return false;
        }else return true;
    }
    //policy_number requires minimum 1 small/big letter, 1 number
    public boolean isValidSymbols(String pass){
        int letter = 0, number = 0, big_letter = 0;
        for(int i = 0; i < pass.length(); i++){
            if(pass.charAt(i) > 47 && pass.charAt(i) < 58){number++;}
            else if (pass.charAt(i) > 96 && pass.charAt(i) < 123) {letter++;}
            else if (pass.charAt(i) > 64 && pass.charAt(i) < 91) {big_letter++;}
            else return false;
        }
        if(letter == 0 || number == 0 || big_letter == 0){
            return false;
        }
        return true;
    }
    //name and surname contains only letters
    public boolean isValidSymbols(String name, String surname){
        if(name == null || surname == null)return false;
        for(int i = 0; i < name.length(); i++){
            if (name.charAt(i) > 96 && name.charAt(i) < 123) {}
            else if (name.charAt(i) > 64 && name.charAt(i) < 91) {}
            else return false;
        }
        for(int i = 0; i < surname.length(); i++){
            if (surname.charAt(i) > 96 && surname.charAt(i) < 123) {}
            else if (surname.charAt(i) > 64 && surname.charAt(i) < 91) {}
            else return false;
        }
        return true;
    }
}
