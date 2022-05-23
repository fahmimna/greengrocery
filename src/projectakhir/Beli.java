/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectakhir;

/**
 *
 * @author HP
 */
public class Beli 
{
    ViewBeli viewBeli = new ViewBeli();
    ModelToko modelToko = new ModelToko();
    ControllerBeli controllerBeli = new ControllerBeli(viewBeli, modelToko);
}
