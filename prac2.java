import java.util.*;
import java.io.*;

class prac2{
    public static void main(String[] arg)
    {
    String[] MDT=new String[40];
    int MDT_index=0;
    MNT[] mntarr=new MNT[40];
    int mnt_index=0;
    ALA[] alaarr=new ALA[40];
    int ala_i=0;
    try{
        File myFile=new File("Input.txt");
        Scanner myReader=new Scanner(myFile);
        FileWriter ir=new FileWriter("Intermediate_p.txt");
        //System.out.println("***********************");
        int flag=0;
        int j=0;
        while(myReader.hasNextLine())
        {
            String data=myReader.nextLine();
            if(data.equals("MACRO")){
                data=myReader.nextLine();
                while(!data.equals("MEND"))
                {
                    MDT[MDT_index]=data;
                    System.out.println(j+" "+MDT[MDT_index]);
                    j++;
                    MDT_index++;
                    data=myReader.nextLine();
                }
                MDT[MDT_index]=data;
                System.out.println(j+" "+MDT[MDT_index]);
                j++;
                MDT_index++;
                flag=1;
            }
            if(flag==0)
            {
                ir.write(data+"\n");
            }
            if(data.equals("MEND"))
                flag=0;
        }
        for(int i=0;i<MDT_index;i++)
        {
            //String[] result=MDT[i].split(" ");
            if(i==0)
            {
                String[] result=MDT[i].split(" ");
                mntarr[mnt_index]=new MNT(0,result[0]);
                alaarr[mnt_index]=new ALA(result[1],result[2],"n","n",0);
                //ala_i++;
                mnt_index++;
            }
            else if(MDT[i].equals("MEND") && i<MDT_index-1)
            {
                String[] result=MDT[i+1].split(" ");
                mntarr[mnt_index]=new MNT(i+1,result[0]);
                alaarr[mnt_index]=new ALA(result[1],result[2],"n","n",i+1);
                //ala_i++;
                mnt_index++;
            }
        }
        MNT.display(mntarr);
        ALA.display_a(alaarr);
        myReader.close();
        ir.close();

        File myFile_o=new File("Intermediate_p.txt");
        Scanner myReader_o=new Scanner(myFile_o);
        FileWriter op=new FileWriter("Output_p.txt");
        int k=-1;
        while(myReader_o.hasNextLine())
        {
            String data=myReader_o.nextLine();
            String[] result=data.split(" ");

            for(int i=0;i<mnt_index;i++)
            {
                if(result[0].equals(mntarr[i].m_name))
                {

                    //if(alaarr[i]!=null && alaarr[i].in_a==mntarr[i].index)
                    alaarr[i].v1="**********";
                    alaarr[i].v2=result[2];
                    k=mntarr[i].index;
                    System.out.println(i+"**********************");
                    break;
                }
                else
                {
                    k=-1;
                }
            }
            if(k==-1)
            {
                //data=myReader_o.nextLine();
                op.write(data+"\n");
            }
            else
            {
                
                k++;
                while(!MDT[k].equals("MEND"))
                {
                    op.write(MDT[k]+"\n");
                    k++;
                }
                //if(MDT[k].equals("MEND"))
                    //k=-1;
                //data=myReader_o.nextLine();
            }

           
        }
        myReader_o.close();
        op.close();
    }

    catch(FileNotFoundException e)
    {
        System.out.println("Error occured!!!");
    }

    catch(IOException e)
    {
        System.out.println("Error occured!!!");
    }

    }
}

class MNT{
    int index;
    String m_name;
    MNT(int index_c,String m_name_c)
    {
        index=index_c;
        m_name=m_name_c;
    }

    public static void display(MNT[] mntarr)
    {
        for(int i=0;i<mntarr.length;i++)
        {
            if(mntarr[i]!=null)
            {
                System.out.println(i+" "+mntarr[i].m_name+" "+mntarr[i].index);
            }
        }
    }
}

class ALA
{
    String a1,a2,v1,v2;
    int in_a;
    ALA(String a1_c,String a2_c,String v1_c,String v2_c,int in_a_c)
    {
        a1=a1_c;
        a2=a2_c;
        v1=v1_c;
        v2=v2_c;
        in_a = in_a_c;
    }

    public static void display_a(ALA[] alaarr)
    {
        for(int i=0;i<alaarr.length;i++)
        {
            if(alaarr[i]!=null)
            {
            System.out.println(alaarr[i].a1+" "+alaarr[i].v1+" "+alaarr[i].a2+" "+alaarr[i].v2);
            }
        }
    }
}