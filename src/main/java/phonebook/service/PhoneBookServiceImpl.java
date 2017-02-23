package phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phonebook.dao.PhoneBookDao;
import phonebook.entity.Phonebook;

import java.util.List;

/**
 * Created by Admin on 19.02.2017.
 */

@Service("phonebookService")
@Transactional
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookDao dao;

    public Phonebook findById(int id) {
        return dao.findById(id);
    }

    public void saveRecord(Phonebook record) {
        dao.saveRecord(record);
    }

    public void updateRecord(Phonebook record) {
        Phonebook entity =  dao.findById(record.getId());
        if (entity!=null){
            entity.setName(record.getName());
            entity.setTelNumber(record.getTelNumber());
            entity.setEmail(record.getEmail());
        }
    }

    public void deleteRecordByTelNumber(String telNumber) {
        dao.deleteRecordByTelNumber(telNumber);

    }

    public List<Phonebook> findAllRecords() {
        return dao.findAllRecords();
    }

    public Phonebook findRecordByTelNUmber(String telNumber) {
        return dao.findRecordByTelNumber(telNumber);
    }
}
