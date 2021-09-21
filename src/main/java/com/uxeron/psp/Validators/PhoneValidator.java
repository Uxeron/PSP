package com.uxeron.psp.Validators;
import java.util.*;

public class PhoneValidator implements Validator {

    private static final Map<String, String> prefixMap = new HashMap<>();
    static {
        prefixMap.put("8", "+370");
    }

    // Length includes the prefix
    private static final Map<String, Integer> lengthMap = new HashMap<>();
    static {
        lengthMap.put("+370", 12);
    }

    // Possible ValidationError errors:
    //  HasNonNumeric - the given phone number has symbols other than numbers
    //  InvalidLength - the given phone number has the wrong length
    public static Collection<ValidationError> validate(String data) {
        // Not implemented
        return new ArrayList<ValidationError>();
    }

    // Finds and adds the appropriate prefix from prefixMap
    public static String replacePrefix(String number) {
        // Not implemented
        return number;
    }
}
