package com.knoldus;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNUmberByNameAndPunishIfNothingFound () {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No Number found");

        phoneBookCrawler.findPhoneNUmberByNameAndPunishIfNothingFound("ShivamSaini");
    }

    @Test
    public void findNumberByName_CorrectIfFound(){
        String actualNumber = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Aman");
        assertThat(actualNumber).isEqualTo("8546738291");
    }

    @Test
    public void findNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String actualBook = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Cloe");
        assertThat(actualBook).isEqualTo("PhoneBook{ PhoneBook = {Aman=8546738291, Suresh = 6574882288}}");
    }

    @Test
    public void findNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
        String actualNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Aman", "6578943201");
        assertThat(actualNumber).isEqualTo("8546738291");
    }

    @Test
    public void findNumberByNameOrNameByNumber_CorrectIfFoundByNumber () {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Mohit", "6574882288");
        assertThat(name).isEqualTo("Suresh ");
    }


}
