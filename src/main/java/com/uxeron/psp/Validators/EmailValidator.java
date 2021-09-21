package com.uxeron.psp.Validators;
import java.util.*;

public class EmailValidator implements Validator {

    // Possible ValidationError errors:
    //  MissingAt - the given email is missing the @ symbol
    //  InvalidSymbols - the given email containts invalid symbols
    //  InvalidDomain - the given email's domain is invalid
    public static Collection<ValidationError> validate(String data) {
        // Not implemented
        return new ArrayList<ValidationError>();
    }
}
