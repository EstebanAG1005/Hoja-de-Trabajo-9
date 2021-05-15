public class Factory {
    
    public Map<String, String> crearArbol(int op){
        if (op==1){
            return new RedBlackBST<>();
        } else{
            return new SplayBST<>();
        }
    }
    
}
