import java.io.*;

import java.net.*;



public class server111

{

    public static void main(String[] args) throws Exception

    {

	ServerSocket sersock = new ServerSocket(7778);

	System.out.println("Waiting for client...");

	Socket sock = sersock.accept();

	String IPadd = sock.getInetAddress().getHostAddress();

      	String HN = sock.getInetAddress().getCanonicalHostName();



       System.out.println("Connected to:" + HN + " " + IPadd);

       BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));

       OutputStream ostream = sock.getOutputStream(); 



       PrintWriter pwrite = new PrintWriter(ostream, true);

       InputStream istream = sock.getInputStream();

       BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));



      String receiveMessage, sendMessage;               

        

        receiveMessage = receiveRead.readLine();

	float hours = Float.parseFloat(receiveMessage);

	System.out.println("Client:"+receiveMessage+" Hours"); 

	

	if (hours >= 0.00 && hours < 12.00)

	{

	 pwrite.println("Server: Good Morning!!");

	 pwrite.flush();

	}

	else if (hours >= 12.00 && hours < 14.00)  

	{

	 pwrite.println("Server: Good Afternoon!!");

	 pwrite.flush();

	}

	else if (hours >= 14.00 && hours < 20.00)

	{

	 pwrite.println("Server: Good Evening!!");

	 pwrite.flush();

	}

	else

	{

	 pwrite.println("Server: Good Night!!");

	 pwrite.flush();

	}

}}
