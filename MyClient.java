import java.io.*;
import java.net.*;
public class MyClient
{
  public static void main(String[] args)
  {
    try
    {
      //Socket s=new Socket("ec2-52-87-97-178.compute-1.amazonaws.com",6666);
      Socket s=new Socket("ec2-52-87-97-178.compute-1.amazonaws.com",6666);
      DataInputStream din=new DataInputStream(s.getInputStream());
      DataOutputStream dout= new DataOutputStream(s.getOutputStream());
      //long START=System.nanoTime();
      long k=0;
      int req_per_sec=10; int count_req_per_sec=0;

      File fpp= new File("Output.txt");
      BufferedWriter bfw= new BufferedWriter(new FileWriter(fpp.getAbsoluteFile()));
      while(count_req_per_sec<=90)
      {
        double time_between_each_request=1.0/(req_per_sec+count_req_per_sec*1111); //10 req per sec. Then, 1/10 sec between each request.
        long START=System.nanoTime();


        File myWriter= new File("rate_"+Integer.toString(req_per_sec+count_req_per_sec*1111)+".txt");
        //System.out.println("File name:"+ Integer.toString(req_per_sec+count_req_per_sec*1111)+", and real-int is: "+Double.toString( (req_per_sec+count_req_per_sec*1111)-(int)(req_per_sec+count_req_per_sec*1111) ) );
        //System.out.println("\n");

        if( ( (req_per_sec+count_req_per_sec*1111)-(int)(req_per_sec+count_req_per_sec*1111) )!=0 )
        {
          myWriter.delete();continue;
        }

        //FileReader fr= new FileReader("req_per_sec_"+Integer.toString(req_per_sec+count_req_per_sec*1111));

        //myWriter.write("Ben 10");

        //int ch;
        // while ((ch=fr.read())!=-1)
        //     System.out.print((char)ch);

        BufferedWriter bw = new BufferedWriter(new FileWriter(myWriter.getAbsoluteFile()));


        //String str = "This file is created through java";

        //bw.write(str);
        //bw.close();

        double count=0;

        //P:-System.out.println("count_req_per_sec: "+count_req_per_sec);
        //P:-System.out.println("reqqq: "+Integer.toString(req_per_sec+count_req_per_sec*1111));

        for( int i=0;i<(req_per_sec+count_req_per_sec*1111);i++)
        {
          //myWriter.write("WITCH  its duration ");
          // if(count_req_per_sec==0)
          //   bw.write("HUUU\n");
          bw.flush();
          long wait_start=System.nanoTime();
          //P:-bw.write("Initial wait_start: "+Long.toString(wait_start)+"\n");

          long startTime = System.nanoTime();
          dout.writeUTF("Put a coin to your witcher");
          String str=din.readUTF();
          long endTime = System.nanoTime();
          long duration = (endTime - startTime);
          //System.out.println(duration);
          //P:- if(count_req_per_sec==0)
          //P:- {
          //P:-   System.out.println("Durr "+Long.toString(duration));
          //P:- }
          bw.write(Long.toString(duration)+"\n");
          bw.flush();
          //myWriter.write("\n");
          //System.out.println(str);
          dout.flush();
          count=count+(duration)*1.0/(req_per_sec+count_req_per_sec*1111);

          //k++;

          long wait_end=System.nanoTime();
          //P:-bw.write("Initial wait_end: "+Long.toString(wait_end)+", and initial diff betn wait_start and stop: "+Long.toString(wait_end-wait_start)+"\n");
          bw.flush();
          while(wait_end-wait_start<=(time_between_each_request)*1000000000)
          {
            wait_end=System.nanoTime();
          }

          //P:-bw.write("Final wait_end: "+Long.toString(wait_end)+", and final diff betn wait_start and stop: "+Long.toString(wait_end-wait_start)+"\n");
          //P:-bw.flush();
          //P:-bw.flush();
          //P:-bw.write("time_between_each_req "+Double.toString(time_between_each_request)+"\n");
          //P:-bw.flush();
          //if(count_req_per_sec==9){System.out.println("For "+Integer.toString(i)+", time_between_each_request is: "+Double.toString(time_between_each_request*1000000000)+", and what we got is: "+Long.toString(wait_end-wait_start)+"\n\n");}
          //P:-bw.flush();
        }

        bfw.write("< "+Integer.toString((req_per_sec+count_req_per_sec*1111))+", "+Double.toString(count)+" >\n");
        bfw.flush();

        long END=System.nanoTime();
        //P:-System.out.println(Integer.toString(req_per_sec+count_req_per_sec*1111)+" requests per sec took this much time(shud be ~ 1 sec): "+Long.toString(END-START));
        //System.out.println("Am done with count_req_per_sec: "+count_req_per_sec);
        count_req_per_sec++;
        bw.close();
      }
      bfw.close();
      dout.writeUTF("done");
      //System.out.println("HEYY "+k);
      dout.close();
      s.close();
    }catch(Exception e){System.out.println(e);}
  }
}

// long startTime = System.nanoTime();
// methodToTime();
// long endTime = System.nanoTime();
//
// long duration = (endTime - startTime);
