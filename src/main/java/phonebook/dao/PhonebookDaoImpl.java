package phonebook.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import phonebook.entity.Phonebook;

import java.util.List;

/**
 * Created by Admin on 19.02.2017.
 */
@Repository("phonebookDao")
public class PhonebookDaoImpl extends AbstractDao<Integer, Phonebook> implements PhoneBookDao {

    public Phonebook findById(int id) {
        return getByKey(id);
    }

    public void saveRecord(Phonebook phbkMember) {
        persist(phbkMember);
    }

    public void deleteRecordByTelNumber(String telNumber) {
        Query query = getSession().createSQLQuery("delete from phonebook where telNumber = :telNumber");
        query.setString("telNumber", telNumber);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Phonebook> findAllRecords() {
        Criteria criteria = createEntityCriteria();
        return (List<Phonebook>) criteria.list();
    }

    public Phonebook findRecordByTelNumber(String telNumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("telNumber", telNumber));
        return (Phonebook) criteria.uniqueResult();
    }
}