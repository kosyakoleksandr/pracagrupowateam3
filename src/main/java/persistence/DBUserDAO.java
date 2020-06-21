package persistence;

import domain.User;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class DBUserDAO implements UserDAO {

    private final EntityManagerFactory emf;

    @Override
    public User findById(String userId) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            UserEntity userEntity = em.find(UserEntity.class, userId);
            em.getTransaction().commit();
            return from(userEntity);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void save(User u) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(from(u));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(User user) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(from(user));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(String userId) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            UserEntity userEntity = em.find(UserEntity.class, userId);
            if (userEntity != null) {
                em.remove(userEntity);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Set<User> findPlaylistAutor(String playlistId) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            TypedQuery<UserEntity> query = em.createQuery("From UserEntity u WHERE u.playlist.id", UserEntity.class);
            query.setParameter("id", playlistId);
            Set<User> result = query.getResultStream().map(this::from).collect(Collectors.toSet());
            em.getTransaction().commit();
            return result;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    private User from(UserEntity ue) {
        return ue == null ? null :
                new User(ue.getId(), ue.getName(), ue.getSurName(), from(ue.getPlaylist()));
    }

    private UserEntity from(User u) {
        return u == null ? null :
                new UserEntity(u.getId(), u.getName(), u.getSurName(), from(u.getPlaylist()));
    }
}

