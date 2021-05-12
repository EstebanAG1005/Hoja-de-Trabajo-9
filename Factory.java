public class Factory {
    
    public Map<String, String> crearArbol(int n){
        if (n==1){
            return new RedBlackBST<>();
        } else{
            return new SplayBST<>();
        }
    }
    
}
