public interface Map <Key extends Comparable<Key>, Value>{

    /**
     * Mete un valor al diccionario
     * @param keyValue es la llave que se quiere introducir al diccionario
     * @param value es el valor que se quiere introducir al diccionario
     */
    public void put(Key keyValue, Value value);

    /**
     * Regresa el valor que guarda una llava
     * @param key llave de quien se quiere el valor
     * @return el valor de la llave
     */
    public Value get(Key key);

    /**
     * Muestra si la llave esta en la coleccion
     * @param key la llave que se quiere averiguar
     * @return true si existe la llave y false si no existe
     */
    public boolean contains(Key key);

}