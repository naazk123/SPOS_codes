import java.util.*;
import java.io.*;
public class sposass3
{
    static void fcfs_funct()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of process:");
        int n=input.nextInt();
        int[][] fcfs=new int[n][2];
        System.out.println("Enter the value of AT and BT in sorted order according to the AT:");
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                {
                    fcfs[i][j]=input.nextInt();
                }
        System.out.println("Process table:");
        System.out.println("Process AT\tBT");
        for(int i=0;i<n;i++)
        {
            System.out.print("P"+i+"\t");
                for(int j=0;j<2;j++)
                    System.out.print(fcfs[i][j]+"\t");
                System.out.println();
        }
        int[][] wt_tt_f=new int[n][2];

        System.out.println("Grantt Chart");
        int a=0;
        for(int i=0;i<n;i++)
        {
            System.out.print(a+"|"+"P"+i+"|");
            a+=fcfs[i][1];
            if(fcfs[0][0]==0)
            {
                if(i==0)
                    wt_tt_f[0][0]=0;
                else
                    wt_tt_f[i][0]=a-fcfs[i][0];

            }
            else
                wt_tt_f[i][0]=a-fcfs[i][0];
        }
        System.out.println(a+"|");
        
        for(int i=0;i<n;i++)
        {
            wt_tt_f[i][1]=wt_tt_f[i][0]+fcfs[i][1];
        }
        System.out.println("TT and WT");
        System.out.println("Process WT\tTT");
        for(int i=0;i<n;i++)
        {
            System.out.print("P"+i+"\t");
            for(int j=0;j<2;j++)
                System.out.print(wt_tt_f[i][j]+"\t");
            System.out.println();
        }
        int avg_wt=0,avg_tt=0;
        for(int i=0;i<n;i++)
        {
            avg_wt+=wt_tt_f[i][0];
            avg_tt+=wt_tt_f[i][1];
        }
        System.out.println("Average waiting time is:"+avg_wt/n);
        System.out.println("Average turn around time is:"+avg_tt/n);
        
    }

    static int min_bt(int[][] arr)
    {
        int min=arr[0][1];
        int pos=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i][1]<min)
            {
                min=arr[i][1];
                pos=i;
            }
        }

        return pos;
    }

    static void sjf_funct()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of process:");
        int n=input.nextInt();
        int[][] sjf=new int[n][2];
        int bt_t=0;
        System.out.println("Enter the value of AT and BT in sorted order according to the BT:");
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                {
                    sjf[i][j]=input.nextInt();
                }
        int[] comp=new int[n];
        for(int i=0;i<n;i++)
        {
            comp[i]=0;
        }
        System.out.println("Process table:");
        System.out.println("Process AT\tBT");
        for(int i=0;i<n;i++)
        {
            System.out.print("P"+i+"\t");
                for(int j=0;j<2;j++)
                {
                    System.out.print(sjf[i][j]+"\t");
                    bt_t+=sjf[1][j];
                }
                System.out.println();
        }
        System.out.println("Grantt Chart");
        int com=0;
        int a_pos=-1;
        for(int i=0;i<n;i++)
        {
            if(sjf[i][0]==0)
            {
                a_pos=i;
                break;
            }
        }   
    }

    static void priority()
    {
        
    }
    public static void main(String arg[])
    {
        fcfs_funct();
    }
    
}
