package org.example.repo;

import org.example.entities.User;
import org.example.repo.interfaces.IUserRepository;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


//@Slf4j
@Repository
@Transactional
public class UserRepositoryImpl implements IUserRepository {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private SessionFactory sessionFactory;

    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *  Get all users from DB
     *
     * @return Set<User>
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Users u", User.class).list();
    }

    /**
     * @param username
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return sessionFactory.getCurrentSession().createNamedQuery("User.findByUsername", User.class).setParameter("username", username).getSingleResult();
    }

    /**
     * Find a user by its Id
     * @param id - identification of the user
     *
     * @return a found user
     */
    @Override
    @Transactional(readOnly = true)
    public User findById(String id) {
        return sessionFactory.getCurrentSession().createNamedQuery("User.findById", User.class).setParameter("id", id).uniqueResult();
    }


    /**
     * @return
     */
    @Override
    public List<User> findAllWithTasks() {
        return Collections.emptyList();
    }

    /**
     * Save/Update the current user
     * @param user - the current user
     *
     * @return the saved user
     */
    @Override
    @Transactional
    public User save(User user) {
        if (findById(user.getId()) == null) {
            sessionFactory.getCurrentSession().persist(user);
            return findById(user.getId());
        } else {
            return (User) sessionFactory.getCurrentSession().merge(user);
        }
    }

    /**
     * Delete current User
     * @param user - the current user
     */
    @Override
    @Transactional
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
