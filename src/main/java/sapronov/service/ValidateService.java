package sapronov.service;

import sapronov.util.ValidationUtil;

public class ValidateService {
    public boolean isValidData(String pol_num, String name, String surname, String area){

        ValidationUtil valid = ValidationUtil.getInstance();

        if((valid.isMinValidLength(pol_num,8)
                && (valid.isValidSymbols(pol_num))
                && (valid.isValidSymbols(name, surname))
                && valid.isMaxValidLength(area, 5000))){
            return true;
        }
        return false;
    }
}
