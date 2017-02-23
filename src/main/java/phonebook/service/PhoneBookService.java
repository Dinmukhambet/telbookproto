package phonebook.service;

import phonebook.entity.Phonebook;

import java.util.List;

/**
 * Created by Admin on 19.02.2017.
 */
public interface PhoneBookService  {

    Phonebook findById(int id);

    void saveRecord(Phonebook record);

    void updateRecord(Phonebook record);

    void deleteRecordByTelNumber(String telNumber);

    List<Phonebook> findAllRecords();

    Phonebook findRecordByTelNUmber(String telNumber);
}
