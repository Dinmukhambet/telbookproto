package phonebook.dao;

import phonebook.entity.Phonebook;

import java.util.List;

/**
 * Created by Admin on 19.02.2017.
 */
public interface PhoneBookDao {

    Phonebook findById(int id);

    void saveRecord(Phonebook phbkmember);

    void deleteRecordByTelNumber(String telNumber);

    List<Phonebook> findAllRecords();

    Phonebook findRecordByTelNumber(String telNumber);

}
