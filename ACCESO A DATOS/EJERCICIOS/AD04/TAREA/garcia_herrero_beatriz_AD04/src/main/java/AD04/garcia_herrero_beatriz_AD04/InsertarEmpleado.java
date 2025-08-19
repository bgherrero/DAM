package AD04.garcia_herrero_beatriz_AD04;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

public class InsertarEmpleado {
    public static void main(String[] args) {
        // Obtén la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Crear nuevo empleado
            Emp newEmp = new Emp();
            newEmp.setEmpno(8000); // ID único
            newEmp.setEname("ROBINSON");
            newEmp.setJob("CLERK");
            newEmp.setMgr(7698);
            newEmp.setHiredate(new Date());
            newEmp.setSal(1200.00);
            newEmp.setComm(null);
            newEmp.setDept(10);

            // Guardar empleado
            session.save(newEmp);

            transaction.commit();
            System.out.println("Empleado insertado con éxito.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}