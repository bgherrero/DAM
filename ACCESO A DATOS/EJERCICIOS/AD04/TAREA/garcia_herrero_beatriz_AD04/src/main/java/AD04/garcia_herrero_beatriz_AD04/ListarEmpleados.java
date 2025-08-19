package AD04.garcia_herrero_beatriz_AD04;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class ListarEmpleados {
    public static void main(String[] args) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Inicia una transacción
            session.beginTransaction();

            // Consulta HQL con JOIN
            String hql = "SELECT e.empno, e.ename, e.sal, d.dname, d.loc " +
                         "FROM Emp e JOIN e.dept d";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> results = query.getResultList();

            // Muestra los resultados
            for (Object[] row : results) {
                System.out.println("EMPNO: " + row[0] + ", ENAME: " + row[1] + 
                                   ", SAL: " + row[2] + ", DNAME: " + row[3] + 
                                   ", LOC: " + row[4]);
            }

            // Confirma la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
