package com.devappsec.security.inputvalidation.service;

import com.devappsec.security.inputvalidation.model.InputValidationModel;
import com.devappsec.security.inputvalidation.constant.Constant;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class InputValidationServiceImpl implements InputValidationService {

    @Override
    public boolean validateInput(InputValidationModel inputValidationModel) {
        return isSafe(inputValidationModel);
    }

    private boolean isSafe(InputValidationModel inputValidationModel) {
        if (inputValidationModel.getType().equals("email")) {
            return isEmailSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("password")) {
            return isPasswordSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("url")) {
            return isURLSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("ip")) {
            return isIPSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("text")) {
            return isTextSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("date")) {
            return isDateSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("creditcard")) {
            return isCreditCardSafe(inputValidationModel.getValue());
        } else if (inputValidationModel.getType().equals("phonenumber")) {
            return isPhoneNumberSafe(inputValidationModel.getValue());
        } else {
            return false;
        }
    }

    private boolean isEmailSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.EMAIL_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isPasswordSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.PASSWORD_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isURLSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.URL_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isIPSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.IP_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isTextSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.TEXT_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isDateSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.DATE_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isCreditCardSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.CREDITCARD_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

    private boolean isPhoneNumberSafe(String value) {
        boolean valid = false;
        if(Pattern.matches(Constant.PHONENUMBER_INPUT_VALIDATION_PATTERN, value)) {
            valid = true;
        }
        return valid;
    }

}