import java.io.* ;
import java.net.*;
public class MyServer
{
  public static void main(String[] args)
  {
    try
    {
      ServerSocket ss=new ServerSocket(6666);
      Socket s= ss.accept();
      DataInputStream dis= new DataInputStream(s.getInputStream());
      DataOutputStream dos= new DataOutputStream(s.getOutputStream());

      String str=(String)dis.readUTF();
      while(!str.equals("done"))
      {
        String ret="";
        for(int i=str.length()-1;i>=0;i--)
        {
          ret+=str.charAt(i);
        }

        dos.writeUTF(ret);

        dos.flush();
        str=(String)dis.readUTF();
      }
      dos.close();
      s.close();

    }catch(Exception e){ System.out.println(e);}
  }

}

