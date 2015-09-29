package ChocoGUI;
import ChocoGUI.ChocoPro;
import ChocoGUI.ChocoPro;
import java.io.*;



public class Choconame {

    
    public ChocoPro first=null,p=null;
    public long len = 0;
    
    public Choconame(String datFile)   // Used to create the file
    {
        String nameTemp;
        int popTemp;
        try
        {
            RandomAccessFile f = new RandomAccessFile(datFile, "r"); // the file is created 
            len=f.length()/34;
                    if(len>0)
                    {
                        first=new ChocoPro();
                        byte nameBytes[]=new byte[30];
                        f.readFully(nameBytes);
                        nameTemp=new String(nameBytes,0).trim();
                        popTemp=Integer.parseInt(f.readLine());
                        first.setName(nameTemp);
                        first.setChocoPro(popTemp);
                        p=first;
                        for(int i=1;i<len;i++) 
                        {
                            f.readFully(nameBytes);
                            nameTemp=new String(nameBytes,0).trim();
                            popTemp=Integer.parseInt(f.readLine());
                            p.setNext(new ChocoPro());
                            p=p.getNext();
                            p.setName(nameTemp);
                            p.setChocoPro(popTemp);
                        }
                                
                        p.setNext(null);
                    }
                    
                    f.close();
           }
        catch(IOException e)
        {
            
        }
    }
    
    public ChocoPro chofind(String Chocolate)
    {
        p=first;
        ChocoPro found=null;
        while(p!=null)     
        {
            int charnum=Chocolate.length();
            if(p.getName().substring(0,charnum).equalsIgnoreCase(Chocolate))
            found=p;
            p=p.getNext();
            
        }
        
        return found;
    }
    
    
    public void choadd(String name,int pop)
            
        
    {
        
        
        
        
        ChocoPro temp=null;
        String upName=name.toUpperCase();
        ChocoPro current=new ChocoPro();
        current.setName(name);
        current.setChocoPro(pop);
        if(first==null||first.getName().toUpperCase().compareTo(upName)>0)
        {
            current.setNext(first);
            first=current;
          
        }
        
        else
        {
            p=first;
            while(p!=null&&p.getName().compareTo(name)<0)
            {
                temp=p;
                p=p.getNext();
                
            }
            
            temp.setNext(current);
            current.setNext(p);
        }
        
        
    }
    
    
    
    public void chodelete(String name)
    {
        ChocoPro temp=null;
        String upName=name.toUpperCase();
        if(first!=null)
        {
            if(first.getName().equalsIgnoreCase(name))
                first=first.getNext();
            else
            {
                p=first;
                while(p!=null&&p.getName().toUpperCase().compareTo(upName)<0)
                {
                  temp=p;
                  p=p.getNext();
                  
                }
                if(p!=null&&p.getName().equalsIgnoreCase(name))
                    temp.setNext(p.getNext());
                
            }
        }
    }
    
    
    public void choprint()
    {
        System.out.println("Chocolate             Weight(KG)");
        System.out.println("---------------------------------");
        p=first;
        while(p!=null)
            
        {
            System.out.println(p.getName()+"\t\t\t"+p.getChocoPro());
            System.out.println("\n");
            p=p.getNext();
        }
        
    }
    
    
    
    
    public void save(String datFile)
    {
        String nameTemp;
        int popTemp;
        try
        {
            RandomAccessFile f=new RandomAccessFile(datFile,"rw");
            p=first;
            while(p!=null)
            {
                nameTemp=p.getName()+"               ";
                f.writeBytes(nameTemp.substring(0,30));
                f.writeInt(p.getChocoPro());
                p=p.getNext();
            
            }
            f.close();
            
            
        }
        catch(IOException e)
        {
            
        }
    }
    
}
