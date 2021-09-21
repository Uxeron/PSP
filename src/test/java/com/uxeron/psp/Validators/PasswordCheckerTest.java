package com.uxeron.psp.Validators;

import org.junit.Assert;
import org.junit.Test;

public class PasswordCheckerTest {
    @Test
    public void passwordLengthTooShortZeroLength() {
        final String tooShortPassword = "";
        final ValidationError expectedError = new ValidationError("TooShort");

        Assert.assertTrue(PasswordChecker
            .validate(tooShortPassword)
            .contains(expectedError));
    }

    @Test
    public void passwordLengthTooShort() {
        final String tooShortPassword = "asdf";
        final ValidationError expectedError = new ValidationError("TooShort");

        Assert.assertTrue(PasswordChecker
            .validate(tooShortPassword)
            .contains(expectedError));
    }

    @Test
    public void passwordLengthGood() {
        final String goodLengthPassword = "asdfzxcv"; // At least 8 symbols
        final ValidationError expectedError = new ValidationError("TooShort");

        Assert.assertFalse(PasswordChecker
            .validate(goodLengthPassword)
            .contains(expectedError));
    }

    @Test
    public void passwordMissingUppercase() {
        final String passwordNoUppercase = "asdf";
        final ValidationError expectedError = new ValidationError("MissingUppercase");

        Assert.assertTrue(PasswordChecker
            .validate(passwordNoUppercase)
            .contains(expectedError));
    }

    @Test
    public void passwordHasUppercase() {
        final String passwordWithUppercase = "Asdf";
        final ValidationError expectedError = new ValidationError("MissingUppercase");

        Assert.assertFalse(PasswordChecker
            .validate(passwordWithUppercase)
            .contains(expectedError));
    }

    @Test
    public void passwordMissingSpecialSymbols() {
        final String passwordNoSpecialSymbols = "asdf";
        final ValidationError expectedError = new ValidationError("MissingSpecial");

        Assert.assertTrue(PasswordChecker
            .validate(passwordNoSpecialSymbols)
            .contains(expectedError));
    }

    @Test
    public void passwordHasSpecialSymbols() {
        final String passwordWithSpecialSymbols = "asdf_";
        final ValidationError expectedError = new ValidationError("MissingSpecial");

        Assert.assertFalse(PasswordChecker
            .validate(passwordWithSpecialSymbols)
            .contains(expectedError));
    }
}
