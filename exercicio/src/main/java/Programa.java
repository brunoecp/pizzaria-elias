import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Programa {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizza");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Ingredientes frango = new Ingredientes();
        frango.setNome("frango");
        Ingredientes caputupiry = new Ingredientes();
        caputupiry.setNome("catupiry");
        Ingredientes molhoDeTomate = new Ingredientes();
        molhoDeTomate.setNome("molho de tomate");

        em.persist(frango);
        em.persist(caputupiry);
        em.persist(molhoDeTomate);

        Pizza p = new Pizza("frango", 40.5);
        p.getIngrediente().add(frango);
        p.getIngrediente().add(caputupiry);
        p.getIngrediente().add(molhoDeTomate);

        em.persist(p);
        em.getTransaction().commit();
        em.close(); // fechando...
        emf.close();
    }
}
