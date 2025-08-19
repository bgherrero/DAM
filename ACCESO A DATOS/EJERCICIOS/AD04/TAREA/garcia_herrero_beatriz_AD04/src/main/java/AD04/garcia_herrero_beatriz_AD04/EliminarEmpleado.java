package AD04.garcia_herrero_beatriz_AD04;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

public class EliminarEmpleado {

	public static void main(String[] args) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Obtener el empleado a eliminar
            Emp empToDelete = session.get(Emp.class, 8000); // ID del empleado a eliminar

            if (empToDelete != null) {
                session.delete(empToDelete);
                System.out.println("Empleado eliminado con éxito.");
            } else {
                System.out.println("Empleado no encontrado.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
