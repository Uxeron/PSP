package com.uxeron.psp.Validators;
import java.util.*;

public class PasswordChecker implements Validator {

    // Possible ValidationError errors:
    //  TooShort - the given password is too short
    //  MissingUppercase - the given password does not have any uppercase characters
    //  MissingSpecial - the given password does not have any special symbols
    public static Collection<ValidationError> validate(String data) {
        // Not implemented
        return new ArrayList<ValidationError>();
    }
}
