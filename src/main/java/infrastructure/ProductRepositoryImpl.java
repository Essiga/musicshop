package infrastructure;

import domain.Album;
import domain.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.rmi.RemoteException;
import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private SessionFactory sessionFactory;

    @Override
    public Set<Album> findAlbumsByTitle(String title) throws RemoteException {

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<Album> albums = new HashSet<>();
        Session session = sessionFactory.openSession();

        List<Song> songResults = session.createQuery("from Song where title = :title", Song.class).setParameter("title", title).list();

        for (Song songResult : songResults) {
            for (Album album : songResult.getInAlbum()) {
                albums.add(album);
            }
        }

        return albums;
    }

    @Override
    public List<Song> findSongsByTitle(String title) throws RemoteException {

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Session session = sessionFactory.openSession();
        List<Song> songResults = session.createQuery("from Song where title = :title", Song.class).setParameter("title", title).list();

        return songResults;
    }

    // TODO: implement methods
    @Override
    public List<String> findArtistsByName(String name) throws RemoteException {
        return null;
    }
}