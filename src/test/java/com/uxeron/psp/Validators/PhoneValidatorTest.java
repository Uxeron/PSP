package com.uxeron.psp.Validators;

import org.junit.Assert;
import org.junit.Test;

public class PhoneValidatorTest {
    @Test
    public void numberContainsInvalidSymbols() {
        final String invalidNumber = "_862645123";
        final ValidationError expectedError = new ValidationError("HasNonNumeric");

        Assert.assertTrue(PasswordChecker
            .validate(invalidNumber)
            .contains(expectedError));
    }

    @Test
    public void numberNoInvalidSymbols() {
        final String validNumber = "862645123";
        final ValidationError expectedError = new ValidationError("HasNonNumeric");

        Assert.assertFalse(PasswordChecker
            .validate(validNumber)
            .contains(expectedError));
    }

    @Test
    public void numberInvalidLengthTooShort() {
        final String invalidNumber = "8626451";
        final ValidationError expectedError = new ValidationError("InvalidLength");

        Assert.assertTrue(PasswordChecker
            .validate(invalidNumber)
            .contains(expectedError));
    }

    @Test
    public void numberInvalidLengthTooLong() {
        final String invalidNumber = "86264512345";
        final ValidationError expectedError = new ValidationError("InvalidLength");

        Assert.assertTrue(PasswordChecker
            .validate(invalidNumber)
            .contains(expectedError));
    }

    @Test
    public void numberValidLength() {
        final String validNumber = "862645123";
        final ValidationError expectedError = new ValidationError("InvalidLength");

        Assert.assertFalse(PasswordChecker
            .validate(validNumber)
            .contains(expectedError));
    }

    @Test
    public void numberReplaceCountryCode() {
        final String number = "862645123";

        String replacedString = PhoneValidator.replacePrefix(number);

        Assert.assertTrue(replacedString.substring(0, 4) == "+370");
    }

    @Test
    public void numberDoNotReplaceCountryCode() {
        final String number = "662645123";

        String replacedString = PhoneValidator.replacePrefix(number);

        Assert.assertTrue(replacedString.equals(number));
    }
}
