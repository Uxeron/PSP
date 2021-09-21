package com.uxeron.psp.Validators;

import org.junit.Assert;
import org.junit.Test;

public class EmailValidatorTest {
    @Test
    public void emailNoAt() {
        final String emailWithoutEt = "userdomain.net";
        final ValidationError expectedError = new ValidationError("MissingAt");

        Assert.assertTrue(PasswordChecker
            .validate(emailWithoutEt)
            .contains(expectedError));
    }

    @Test
    public void emailWithAt() {
        final String emailWithEt = "user@domain.net";
        final ValidationError expectedError = new ValidationError("MissingAt");

        Assert.assertFalse(PasswordChecker
            .validate(emailWithEt)
            .contains(expectedError));
    }

    @Test
    public void emailInvalidSymbolsDoubleAt() {
        final String invalidEmail = "user@@domain.net";
        final ValidationError expectedError = new ValidationError("InvalidSymbols");

        Assert.assertTrue(PasswordChecker
            .validate(invalidEmail)
            .contains(expectedError));
    }

    @Test
    public void emailInvalidSymbolsSpace() {
        final String invalidEmail = "user @domain.net";
        final ValidationError expectedError = new ValidationError("InvalidSymbols");

        Assert.assertTrue(PasswordChecker
            .validate(invalidEmail)
            .contains(expectedError));
    }

    @Test
    public void emailAllValidSymbols() {
        final String validEmail = "user@domain.net";
        final ValidationError expectedError = new ValidationError("InvalidSymbols");

        Assert.assertFalse(PasswordChecker
            .validate(validEmail)
            .contains(expectedError));
    }

    @Test
    public void emailInvalidDomain() {
        final String invalidEmail = "user@domainnet";
        final ValidationError expectedError = new ValidationError("InvalidDomain");

        Assert.assertTrue(PasswordChecker
            .validate(invalidEmail)
            .contains(expectedError));
    }

    @Test
    public void emailValidDomain() {
        final String validEmail = "user@domain.net";
        final ValidationError expectedError = new ValidationError("InvalidDomain");

        Assert.assertFalse(PasswordChecker
            .validate(validEmail)
            .contains(expectedError));
    }
}
