package 第四次作业;

 interface Function<T>{
    T get(int index);
    void add(T t);
    void remove(int index);
    void addAt(int index , T t);
    boolean exit(Object o);
    int size();
    boolean isEmpty();
    void clear();
}

class ArrayList<T> implements Function<T>{
     private static int length = 5;
     private Object[] element = null;
     private int standard;
     private int locate;

     public ArrayList(){
         this(length);
     }

    public ArrayList(int size){
        if(size < 0){
            throw new RuntimeException("数组大小不能小于0");
        }
        else{
            this.element = new Object[size];
            this.locate = 0;
            standard = size;
        }
    }

    @Override
    public T get(int index) {
        large(index);
        return (T) this.element[index];
    }

    @Override
    public void add(T t) {
        large();
        this.element[locate] = t;
        this.locate++;
    }

    @Override
    public void remove(int index) {
        large(index);
        for (int i = 0; i < element.length; i++) {
            if( i+1 < element.length){
                element[i] = element[i + 1];
            }
        }
        locate--;
    }

    @Override
    public void addAt(int index, T t) {
        large(index);
        for (int i = 0; i < element.length; i++) {
            if( i >= index && i+2 < element.length){
                element[i] = t;
                element[i+1] = element[i+2];
            }
        }
        locate++;
    }

    @Override
    public boolean exit(Object o) {
        for (Object element: this.element) {
            if(o.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.locate;
    }

    @Override
    public boolean isEmpty() {
        if(this.locate > 0){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        element = new Object[length];
    }

    public void large(){
        if(this.locate == this.standard){
            this.standard = this.standard + this.length;
            Object[] newElement = new Object[this.standard];
            for (int i = 0; i < this.element.length; i++) {
                newElement[i] = this.element[i];
            }
            this.element = newElement;
        }
    }

    private void large(int index){
        if(index > standard || index < 0){
            throw new RuntimeException("数组越界异常");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList= new ArrayList<String>();
        arrayList.add("hljj");
        arrayList.add("zxjj");
        arrayList.add("qiaoqiao");
        System.out.println("想要女装的是" + arrayList.get(0));
        System.out.println("有几个人想要跳舞？" + arrayList.size());
        arrayList.remove(1);
        System.out.println("有几个想要唱歌" + arrayList.size());
        arrayList.addAt(2,"yangshen");
        System.out.println("喜欢复读的有：");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i) + "\t");
        }
    }
}
