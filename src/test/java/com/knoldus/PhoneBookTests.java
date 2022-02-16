package com.knoldus;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PhoneBookTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBook phoneBookTest = new PhoneBook();

    @Test
    public void findNumberByName_CorrectIfFound() {
        Optional <String> phoneNumber = phoneBookTest.findNumberByName("Aman");
        assertThat(phoneNumber.get()).isEqualTo("8546738291");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfNotFound () {
        expectedException.expect(NoSuchElementException.class);
        Optional <String> phoneNumber = phoneBookTest.findNumberByName("Mohit");
        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfFound () {
        Optional <String> name = phoneBookTest.findNameByNumber("(6574882288");
        assertThat(name.get()).isEqualTo("Suresh");
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfNotFound () {
        expectedException.expect(NoSuchElementException.class);
        Optional <String> phoneNumber = phoneBookTest.findNameByNumber("6578943201");
        phoneNumber.get();
    }
}
