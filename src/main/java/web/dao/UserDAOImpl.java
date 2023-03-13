package web.dao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {
    public UserDAOImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() { //
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return resultList;
    }





    @Override
    public void delete(User user) {//ok
        User managed = entityManager.merge(user);
        entityManager.remove(managed);




    }

    @Override
    public User getById(Long id) {//ok
        return entityManager.find(User.class, id);
    }
    @Override
    public void save(User user) {//adduser
//        User managed = entityManager.merge(user);
//        entityManager.persist(managed);
        entityManager.persist(user);
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}