import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Consulta {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizza");
        EntityManager em = emf.createEntityManager();


        Pizza p = em.find(Pizza.class, 1l);

        System.out.println("pizza: " + p.getNome() + " " + p.getSabor() + " " + p.getValor() );
        for (Ingredientes ingredientes : p.getIngrediente()) {
            System.out.println("ingredientes: " + ingredientes.getNome());
        }

        em.close(); // fechando...
        emf.close();
    }
}