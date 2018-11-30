package Sistema;
/**
 * 
 * @author villalvan
 *
 */
public class Triangulo {
	Posicion a;
	Posicion b;
	Posicion c;
	Double perimetro;
	public Triangulo(Posicion a, Posicion b, Posicion c){
		this.a = a;
		this.b = b;
		this.c = c;
		perimetro = a.distancia(b) + a.distancia(c) + b.distancia(c);
	}
	
	/**
	 * 
	 * @return Determina si el triangulo contiene al origen. 
	 */
	public Boolean contieneOrigen(){
		/*
		 * Solo se esta teniendo en cuenta un triangulo que tiene un vertice 1 en el origen.
		 * 
		 * Si el planeta 1 esta en el semiplano Y > 0 El planeta 2 deberia estar en el semiplano inferior
		 * y ademas menor al angulo -phi del planeta 1.
		 * Paralemente debe sudecer lo mismo si el planeta 2 esta en el semiplano inferior, el planeta 1
		 * debe estar en el semiplano superior y menor a - phi del planeta 2
		 * Si es el angulo es 180 el sol siempre esta dentro.
		 */
		if((b.estaSemiplanoSuperior() && c.estaSemiplanoInferior() && (b.getAngulo().getPendiente() >= c.getAngulo().getPendiente()  )) ||
		   (c.estaSemiplanoSuperior() && b.estaSemiplanoInferior() && (c.getAngulo().getPendiente() >= b.getAngulo().getPendiente() )) ||
		   (b.estaEnEjeX() || b.estaEnEjeX() ))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @return Devuelve el perimetro. 
	 */
	public Double getPerimetro(){
		return perimetro;
	}
	

}
