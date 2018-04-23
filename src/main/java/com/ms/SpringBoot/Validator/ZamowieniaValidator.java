package com.ms.SpringBoot.Validator;

import com.ms.SpringBoot.Model.Zamowienia;
import com.ms.SpringBoot.utils.SpringUtils;
import org.glassfish.hk2.utilities.general.ValidatorUtilities;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ZamowieniaValidator implements Validator {


    @Override
    public boolean supports(Class<?> klasa) {
        return Zamowienia.class.equals(klasa);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Zamowienia zamowienia = (Zamowienia) object;

        ValidationUtils.rejectIfEmpty(errors,"nrZamowienia", "error.zamowienia.polePuste");
        ValidationUtils.rejectIfEmpty(errors, "dataZamowienia", "error.zamowienia.polePuste");
        ValidationUtils.rejectIfEmpty(errors, "kompletne", "error.zamowienia.polePuste");

        if (zamowienia.getIloscZamowiona() <= 0) {
            errors.rejectValue("iloscZamowiona", "error.zamowienia.zeroLubMniej");
        }

        if (!SpringUtils.isEmpty(zamowienia.getNrZamowienia())) {
            if (zamowienia.getNrZamowienia().length() < 5) {
                errors.rejectValue("nrZamowienia", "error.zamowienia.numerMniejszyNiz5");
            }
        }
    }
}
