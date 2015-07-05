package paquete;

public class ComboBox 
{
  private String nombre;
  private int codigo;

    public ComboBox(int codigo, String nombre)
      {
        this.codigo = codigo;
        this.nombre = nombre;
      }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String toString()
    {
     return nombre;
    }
  }