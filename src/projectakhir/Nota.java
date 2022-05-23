/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectakhir;

/**
 *
 * @author HP
 */
public class Nota 
{
    public Nota(String no_nota, String id_order, String total_harga)
    {
        ViewNota viewNota = new ViewNota();
        ModelToko modelToko = new ModelToko();
        ControllerNota controllerNota = new ControllerNota(viewNota, modelToko, no_nota, id_order, total_harga);
    }
}
