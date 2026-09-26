class ProductOfNumbers {

    List<Integer> prefix;
    public ProductOfNumbers() {
        prefix=new ArrayList<>();
        prefix.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefix.clear();
            prefix.add(1);
        }
        else{
            int lastProduct=prefix.get(prefix.size()-1);
            prefix.add(num*lastProduct);
        }
    }
    
    public int getProduct(int k) {
        if(prefix.size()-k-1<0){
            return 0;
        }
        else{
            int total=prefix.get(prefix.size()-1);
            int restElement=prefix.get(prefix.size()-k-1);
            return total/restElement;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */