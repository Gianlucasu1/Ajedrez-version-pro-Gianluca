/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author utp
 */
public class Caballo extends Ficha {

    public Caballo(Color color) {
        super(color);
    }

     @Override
        public void mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
            boolean ocupada = false;
            int cI,cF,fI,fF;
            cI = casillaI.getColumna() - 'A';//x Inicial
            fI = casillaI.getFila() - 1;//y Inicial
            cF = casillaF.getColumna() - 'A';//x Final 
            fF = casillaF.getFila() - 1 ;//y Final
 
            if((fI-fF)*(f1-f2) +(c1-c2)*(c1-c2) == 5){
                
                
                ocupada = casillaC.isOcupada();
              
                if(!casillaF.isOcupada()){//Que en la casilla final no haya nada    TIPO 1 (MOVIMIENTO NORMAL)
                    if(!ocupada){//Si no hay nada en la trayectoria
                        casillaI.setFichaNull();
                        super.asociarFichaTablero(this, casillaF);
                    }
                    else{
                        System.out.println("Hay una ficha en la trayectoria");
                    }
                }
                else{//Que en la casilla final haya una ficha                       TIPO 2 (COMER)
                   if(this.getColor() != casillaF.getFicha().getColor()){//Si la fichaI y la fichaF son de diferente color
                       this.comer(casillaI,casillaF);
                   }
                   else{
                       System.out.println("Ambas fichas son del mismo color");
                   }
                }
                
            }
            else{
                System.out.println("De esa forma no se mueve el alfil");
            }
        }
    

    @Override
    public void draw(Graphics2D g, float x, float y) { 
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 50, y + 50,
                java.awt.Color.WHITE));
    //Base de ficha
      g.fill(new Rectangle2D.Double(x+10,y+40,30,10));
      //Cuerpo de ficha
      g.fill(new Rectangle2D.Double(x+20,y+30,10,10));
      //Cabeza ficha
      GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 20, y + 30);
        polyline.lineTo(x + 15, y + 25);
        polyline.lineTo(x + 20, y + 15);
        polyline.lineTo(x + 15, y + 10);
        polyline.lineTo(x + 20, y + 5);
        polyline.lineTo(x + 25, y + 10);
        polyline.lineTo(x + 30, y + 5);
        polyline.lineTo(x + 35, y + 10);
        polyline.lineTo(x + 30, y + 15);
        polyline.lineTo(x + 30, y + 30);
        polyline.moveTo(x + 20, y + 30);
        g.fill(polyline);
    //Cambiar color para margen
    g.setPaint(java.awt.Color.BLACK);
    //Base de ficha
    g.draw(new Rectangle2D.Double(x+10,y+40,30,10));
    //Cuerpo de ficha
    g.draw(new Rectangle2D.Double(x+20,y+30,10,10));
    //Cabeza ficha
    polyline.moveTo(x + 20, y + 30);
        polyline.lineTo(x + 15, y + 25);
        polyline.lineTo(x + 20, y + 15);
        polyline.lineTo(x + 15, y + 10);
        polyline.lineTo(x + 20, y + 5);
        polyline.lineTo(x + 25, y + 10);
        polyline.lineTo(x + 30, y + 5);
        polyline.lineTo(x + 35, y + 10);
        polyline.lineTo(x + 30, y + 15);
        polyline.lineTo(x + 30, y + 30);
        polyline.moveTo(x + 20, y + 30);
        g.draw(polyline);
    }
    
}
