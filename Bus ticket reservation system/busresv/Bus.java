public class Bus{
    private int busno;
    private boolean ac;
    private int capacity;
    String route;

   Bus(int busno,boolean ac,int capacity)
   {
    this.busno=busno;
    this.ac=ac;
    this.capacity=capacity;
   } 

   public int getbusno(){
    return busno;
   }
   public boolean isAC(){
       return ac;
   }
   public void setac(boolean ac){
       this.ac=ac;
    }
   public int getcapacity(){
    return capacity;
   }
   public void setcapacity(int cap)
   {
    capacity=cap;
   }

}