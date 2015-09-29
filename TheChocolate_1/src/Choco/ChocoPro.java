package ChocoGUI;
public class ChocoPro {
    
    public String name;
    public int pop;
    public ChocoPro next;
    
    public ChocoPro()
    {
        name="";
        pop=0;
        next=null;
    }
    public String getName()
    {
        return name;
        
    }
    
    public int getChocoPro()
    {
        return pop;
    }
    public ChocoPro getNext()
    {
       
        return next;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setChocoPro(int pop)
    {
        this.pop=pop;
    }
            
    public void setNext(ChocoPro next)
    {
        this.next=next;
    }
    
    
    
   
}
