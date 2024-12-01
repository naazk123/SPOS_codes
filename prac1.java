import java.io.*;
import java.util.*;

class prac1
{
    public static void main(String[] arg)
    {
        HashMap<String,String> optab= new HashMap<>();
        optab.put("STOP","00");
        optab.put("ADD","01");
        optab.put("SUB","02");
        optab.put("MULT","03");
        optab.put("MOVER","04");
        optab.put("MOVEM","05");
        optab.put("COMP","06");
        optab.put("BC","07");
        optab.put("DIV","08");
        optab.put("READ","09");
        optab.put("PRINT","10");
        optab.put("AREG","01");
        optab.put("BREG","02");
        optab.put("CREG","03");
        optab.put("LE","02");
        optab.put("START","00");
        
        HashMap<String,String> type=new HashMap<>();
        type.put("STOP","IS");
        type.put("ADD","IS");
        type.put("SUB","IS");
        type.put("MULT","IS");
        type.put("MOVER","IS");
        type.put("MOVEM","IS");
        type.put("COMP","IS");
        type.put("BC","IS");
        type.put("DIV","IS");
        type.put("READ","IS");
        type.put("PRINT","IS");
        type.put("DS","DS");
        type.put("DC","DS");
        type.put("END","AD");
        int line=0,lc=0;
        String op1=null,op2=null; //op1-> reg , op2->symbol
        symtab[] symarr=new symtab[40];
        int symindex=0;
        ic[] icarr=new ic[40];
        int icindex=0;
        mach[] macharr=new mach[40];
        int machindex=0;
        try{
            System.out.println("********************************");
        File myFile=new File("text.txt");
        Scanner myReader=new Scanner(myFile);
        while(myReader.hasNextLine())
        {
            String data=myReader.nextLine();
            String[] result=data.split(" ");
            line++;
            if(line==1 && !result[0].equals("START"))
            {
                System.out.println("Input should start with START keyword!!!!");
                break;
            }

            for(int i=0;i<result.length;i++)
                System.out.print(result[i]+"------");

            if(line==1)
                lc=Integer.parseInt(result[1]);

            if(result.length==1)
            {
                op1=null;
                op2=null;
            }

            if(result.length==2)
            {
                op1=null;
                op2=result[1];
            }

            if(result.length==3)
            {
                op1=result[1];
                op2=result[2];
            }

            System.out.println(optab.get(result[0]));
            String word=optab.get(op1);
            int pos;
            switch(result[0])
            {
                case "READ":
                    pos=symtab.checksymbol(symarr, op2);
                    System.out.println(pos+"************************************");
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "MOVER":
                    pos=symtab.checksymbol(symarr, op2);
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "MOVEM":
                    pos=symtab.checksymbol(symarr, op2);
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "MULT":
                    pos=symtab.checksymbol(symarr, op2);
                    System.out.println(pos+"************************************");
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "ADD":
                    pos=symtab.checksymbol(symarr, op2);
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "COMP":
                    pos=symtab.checksymbol(symarr, op2);
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;
                case "BC":
                    pos=symtab.checksymbol(symarr, op2);
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "PRINT":
                    pos=symtab.checksymbol(symarr, op2);
                    if(pos==-1)
                    {
                        symarr[symindex]=new symtab(0,op2);
                        pos=symindex;
                        symindex++;
                    }
                    
                    icarr[icindex]=new ic(lc,pos,optab.get(result[0]),type.get(result[0]),word,"S");
                    icindex++;
                    lc++;
                    break;

                case "STOP":
                    break;

                default:

            }


        }

        ic.display_ic(icarr);
        for(int i=0;i<symarr.length;i++)
        {
            if(symarr[i]!=null)
            {
                symarr[i].address=lc;
                lc++;
            }
        }
        symtab.display_sym(symarr);
        for(int i=0;i<icindex;i++)
        {
            int index=icarr[i].sym_add;
            if(macharr[i]==null)
                macharr[i]=new mach(icarr[i].lc,symarr[index].address,icarr[i].op1,icarr[i].op2);
            
        }
        mach.display_mach(macharr);
        myReader.close();
        }

        catch(FileNotFoundException e)
        {
            System.out.println("Error occured!!!");
        }

    }
}

class symtab{

    int address;
    String symbol;
    symtab()
    {
        address=0;
        symbol=" ";
    }

    symtab(int add,String sym)
    {
        address=add;
        symbol=sym;
    }

    public static int checksymbol(symtab[] symarr,String sym)
    {
        int p=-1;
        for(int i=0;i<symarr.length;i++)
        {
            if(symarr[i]!=null && symarr[i].symbol.equals(sym))
            {
                p=i;
                break;
            }
        }
        return p;
    }

    public static void display_sym(symtab[] symarr)
    {
        for(int i=0;i<symarr.length;i++)
        {
            if(symarr[i]!=null)
                System.out.println(i+" "+symarr[i].symbol+" "+symarr[i].address);
        }
    }

}

class ic{
    int lc,sym_add;
    String op1,type1,op2,sym_type;
    ic(int lc_c,int sym_add_c,String op1_c,String type1_c,String op2_c,String sym_type_c)
    {
        lc=lc_c;
        sym_add=sym_add_c;
        op1=op1_c;
        type1=type1_c;
        op2=op2_c;
        sym_type=sym_type_c;
    }

    public static void display_ic(ic[] icarr)
    {
        for(int i=0;i<icarr.length;i++)
        {
            if(icarr[i]!=null)
                System.out.println(icarr[i].lc+" "+icarr[i].type1+" "+icarr[i].op1+" "+icarr[i].op2+" "+icarr[i].sym_add+" "+icarr[i].sym_type);
        }
    }
}

class mach{
    int lc,sym_add;
    String op1,op2;
    mach(int lc_c,int sym_add_c,String op1_c,String op2_c)
    {
        lc=lc_c;
        sym_add=sym_add_c;
        op1=op1_c;
        op2=op2_c;
    }
    public static void display_mach(mach[] macharr)
    {
        for(int i=0;i<macharr.length;i++)
        {
            if(macharr[i]!=null)
                System.out.println(macharr[i].lc+" "+macharr[i].op1+" "+macharr[i].op2+" "+macharr[i].sym_add);
        }
    }
}