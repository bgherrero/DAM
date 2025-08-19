package matricula;

/**
 *
 * @author bgher
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.EventListener;
import java.util.EventObject;


public class MatriculaBean {
    private String dni;
    private String nombreModulo;
    private String curso;
    private double nota;
    
    private Connection conn;
    private List<MatriculaBean> listaMatriculas;
    private List<BDModificadaListener> listeners = new ArrayList<>();

    public MatriculaBean() {
        conectarBD();
        listaMatriculas = new ArrayList<>();
    }

   private void conectarBD() {
    String urljdbc = "jdbc:mysql://localhost:3306/matriculasalumnos?useSSL=false";
    String usuario = "root";
    String contraseña = "root";

    try {
        conn = DriverManager.getConnection(urljdbc, usuario, contraseña);
        
    } catch (SQLException e) {
        System.out.println("Error al conectar con la BD: " + e.getMessage());
        e.printStackTrace();
    }
}

    public void seleccionarFila(int i) {
        if (i >= 0 && i < listaMatriculas.size()) {
            MatriculaBean m = listaMatriculas.get(i);
            this.dni = m.getDNI();
            this.nombreModulo = m.getNombreModulo();
            this.curso = m.getCurso();
            this.nota = m.getNota();
        }
    }

    public void cargarMatriculas() {
        listaMatriculas.clear();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Matriculas");

            while (rs.next()) {
                MatriculaBean m = new MatriculaBean();
                m.setDNI(rs.getString("DNI"));
                m.setNombreModulo(rs.getString("NombreModulo"));
                m.setCurso(rs.getString("Curso"));
                m.setNota(rs.getDouble("Nota"));

                listaMatriculas.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMatricula() throws ClassNotFoundException {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO Matriculas (DNI, NombreModulo, Curso, Nota) VALUES (?, ?, ?, ?)");
            stmt.setString(1, this.dni);
            stmt.setString(2, this.nombreModulo);
            stmt.setString(3, this.curso);
            stmt.setDouble(4, this.nota);
            stmt.executeUpdate();

            // Notificar a los listeners que la BD ha sido modificada
            notificarBDModificada();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public String getDNI() { return dni; }
    public void setDNI(String dni) { this.dni = dni; }

    public String getNombreModulo() { return nombreModulo; }
    public void setNombreModulo(String nombreModulo) { this.nombreModulo = nombreModulo; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    // Manejadores de eventos
    public static class BDModificadaEvent extends EventObject {
        public BDModificadaEvent(Object source) {
            super(source);
        }
    }

    public interface BDModificadaListener extends EventListener {
        void capturarBDModificada(BDModificadaEvent ev);
    }

    public void addBDModificadaListener(BDModificadaListener listener) {
        listeners.add(listener);
    }

    private void notificarBDModificada() {
        BDModificadaEvent evento = new BDModificadaEvent(this);
        for (BDModificadaListener listener : listeners) {
            listener.capturarBDModificada(evento);
        }
    }
}

