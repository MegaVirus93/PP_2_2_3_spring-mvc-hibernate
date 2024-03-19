//package hiber.dao;
//
//import hiber.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//@Repository
//public class UserDaoEmImp implements UserDao {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Override
//    public void add(User user) {
//        entityManager.persist(user);
//    }
//
//    @Override
//    public List<User> listUsers() {
//        return entityManager.createQuery(
//                "select u from User u", User.class
//        ).getResultList();
//    }
//
//    @Override
//    public User getUserById(long id) {
//        TypedQuery<User> query = entityManager.createQuery(
//                "select u from User u where id = :id", User.class
//        );
//        query.setParameter("id", id);
//        return query.getResultList().stream().findAny().orElse(null);
//    }
//
//    @Override
//    public void update(User user, long id) {
//        User userToBeUpdated = getUserById(id);
//        userToBeUpdated.setFirstName(user.getFirstName());
//        userToBeUpdated.setLastName(user.getLastName());
//        userToBeUpdated.setEmail(user.getEmail());
//    }
//
//    @Override
//    public void delete(long id) {
//        entityManager.remove(getUserById(id));
//    }
//}
