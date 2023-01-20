/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author KARLA
 */
public interface EmpleadoDao {
        public List listar();
        public Empleado buscar(String dni);
}
