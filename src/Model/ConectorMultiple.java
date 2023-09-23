
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
        linea.setEndY(altoLinea());
    }
    
    public double altoLinea(){
        return Bloque.ALTO*(largoConector+2);
    }
    
    
    public void setPreBloqueY(){
        this.SidePart.setY(7+altoLinea());
        this.TopPart.setY(altoLinea());
    }
    
    @Override
    public double[] getRectVertices(){
        double [] d = {getX(), getY()+altoLinea(), getX()+52, getY()+80+altoLinea()};
        return d;
    }
    
}
