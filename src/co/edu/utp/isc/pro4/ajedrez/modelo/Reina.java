/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author utp
 */
public class Reina extends Ficha {

    public Reina(Color color) {
        super(color);
    }

     @Override
        public void mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
            boolean ocupada = false;
            boolean validador;
            int x = 0;
            int cI,cF,fI,fF, restaA, restaB;
            cI = casillaI.getColumna() - 'A';//x Inicial
            fI = casillaI.getFila() - 1;//y Inicial
            cF = casillaF.getColumna() - 'A';//x Final 
            fF = casillaF.getFila() - 1 ;//y Final
            restaA = fI - fF;
            restaB = cI - cF;
            Casilla casillaC;
            Casilla casillaComp;
            casillaC = casillaI;
            if((fI==fF) || (cI==cF) || (Math.abs(fI-fF) == Math.abs(cI-cF))){
                if (casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI - 1;
                }
                else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI - 1;
                }
                else if (casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI;
                    fI = fI - 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI;
                }
                else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI;
                }
                casillaC = tablero.getCasilla(fI,cI);
                casillaComp=casillaC;
                ocupada = casillaC.isOcupada();
                
                
                while((((casillaC.getFila() != casillaF.getFila()) && (casillaC.getColumna() != casillaF.getColumna())) || ((casillaC.getFila() != casillaF.getFila()) || (casillaC.getColumna() != casillaF.getColumna()))) && ocupada==false){
                    ocupada=casillaC.isOcupada();
                   casillaC = tablero.getCasilla(fI,cI);
                 
               
                    if (casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                        cI = cI + 1;
                        fI = fI + 1;
                    }
                    else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                        cI = cI - 1;
                        fI = fI + 1;
                    }
                    else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                        cI = cI - 1;
                        fI = fI - 1;
                    }
                    else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                        cI = cI + 1;
                        fI = fI - 1;
                    }
                    else if (casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI;
                    fI = fI - 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI;
                }
                else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI;
                }
                    
                }
                if(!casillaF.isOcupada()){//Que en la casilla final no haya nada    TIPO 1 (MOVIMIENTO NORMAL)
                    if(!ocupada){//Si no hay nada en la trayectoria
                        casillaI.setFichaNull();
                        super.asociarFichaTablero(this, casillaF);
                    }
                    else{
                        System.out.println("Hay una ficha en la trayectoria");
                        x=1;
                    }
                }
                else{//Que en la casilla final haya una ficha                       TIPO 2 (COMER)
                   
                    if(casillaComp==casillaF){
                    if((this.getColor() != casillaF.getFicha().getColor())){//Si la fichaI y la fichaF son de diferente color
                       this.comer(casillaI,casillaF);
                   }
                   
                   else{
                       System.out.println("Ambas fichas son del mismo color");
                   }
                }
                    else {
                        validador=true;
                    if(validador==ocupada){
                    validador=false;
                    }
                    else {
                    validador=true;
                    }
                    
                        if((this.getColor() != casillaF.getFicha().getColor())&& validador==true){
                        
                        this.comer(casillaI,casillaF);
                        
                        }
                         else{
                       System.out.println("Ambas fichas son del mismo color");
                   }
                    
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
            //Cabeza ficha triangulo(2 lineas)
            GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
            polyline.moveTo(x + 15, y + 30);
            polyline.lineTo(x + 25, y + 20);
            polyline.lineTo(x + 35, y + 30);
            polyline.moveTo(x + 15, y + 30);
            g.fill(polyline);
            //Circulo cabeza
            g.fill(new Ellipse2D.Double(x+20, y+10, 10, 10));
            g.setPaint(java.awt.Color.BLACK);
            //Base de ficha
            g.draw(new Rectangle2D.Double(x+10,y+40,30,10));
            //Cuerpo de ficha
            g.draw(new Rectangle2D.Double(x+20,y+30,10,10));
            //Cabeza ficha triangulo(2 lineas)
            g.draw(new Line2D.Double(x+15,y+30,x+25,y+20));
            g.draw(new Line2D.Double(x+25,y+20,x+35,y+30));
            //Circulo cabeza
            g.draw(new Ellipse2D.Double(x+20, y+10, 10, 10));
        }


    

   
    
}
