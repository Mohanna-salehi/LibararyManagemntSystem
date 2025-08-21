import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Book;
import model.Item;
import model.Magazine;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Item item = new Item();
        item.setAuthor("Jake");
        item.setTitle("item");

        Book book = new Book();
        book.setTitle("A");
        book.setISBN("b");

        Magazine magazine = new Magazine();
        magazine.setTitle("magazine");
        magazine.setGenre("action");

        em.getTransaction().begin();
        em.persist(book);
        em.persist(magazine);
        em.persist(item);
        em.getTransaction().commit();
        List<Item> fromItem = em.createQuery("from Item", Item.class).getResultList();
        System.out.println(fromItem);
        em.close();
        emf.close();

    }
}
