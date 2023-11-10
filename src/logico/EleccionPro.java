package logico;
/**
 *Enumeracion asigna número identificador y un precio a cada *producto*.
 **/
public enum EleccionPro {

    //----------------------------------------------------------------------
    COCA_COLA(1, 1000),
    SPRITE(2, 1200),
    FANTA(3, 900),
    SNICKER(4, 900),
    SUPER8(5, 800);
    private final int tipo;
    private final int precio;

    //----------------------------------------------------------------------
    /**
     * El constructor recibe el tipo y precio del producto.
     * @param tipo identificador del producto.
     * @param precio precio del producto.
     **/
    EleccionPro(int tipo, int precio){
        this.tipo = tipo;
        this.precio = precio;
    }
    /**
     * Método getPrecio:
     * @return retorna precio producto.
     **/
    public int getPrecio(){
        return precio;
    }

    /**
     * Método getTipo:
     * @return retorna tipo producto.
     **/
    public int getTipo(){
        return tipo;
    }

}
