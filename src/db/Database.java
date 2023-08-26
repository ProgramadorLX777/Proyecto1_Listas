package db;

import java.util.ArrayList;
import model.Empleado;

public class Database {

    private ArrayList<Empleado> lista;

    public Database() {
        lista = new ArrayList<>();
    }

    public void addItem(Empleado empleado) {
        lista.add(empleado);
    }

    public Empleado getItem(int id) {
        return lista.get(id);
    }

    public Empleado getItemByName(String nombre) {
        Empleado empleado = new Empleado();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                empleado = lista.get(i);
            }
        }
        return empleado;
    }

    public void updateItem(int id, Empleado empleado) {
        lista.set(id, empleado);
    }

    public void deleteItem(int id) {
        lista.remove(id);
    }

    public int getSize() {
        return lista.size();
    }

}
