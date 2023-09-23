
package Model;


public class ConectorMultiple extends Conector{
    
    
    public Conector inner;
    
    public double largoConector=0;
    
    public ConectorMultiple(Bloque conectador) {
        super(conectador, "v");
        setLargoLinea();
    }
    
    @Override
    public void iniciarComponentes(){
        super.iniciarComponentes();
        inner = new Conector(this,"h",true);
    }
    
    
    
    public void setLargoLinea(){
        linea.setEndY(Bloque.ALTO*(largoConector+2));
    }
    
    
    @Override
    public double[] getRectVertices(){
        double [] d = {getX(), getY()+Bloque.ALTO*(largoConector+2), getX()+52, getY()+80+Bloque.ALTO*(largoConector+2)};
        return d;
    }
    
}
