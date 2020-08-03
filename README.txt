I have used AWS, and am using ec2-user image. Also, I have run both my client and server programs on cloud, and
thus, I have been able to reach 1,00,000 lakh requests per second, unlike some people.
I have not being able to autoscale, and have only done for non-Autoscaled.
Start an instance on cloud, and start 2 terminals for this. Put MyServer.java and MyClient.java on the instance.
Install java using the command: sudo amazon-linux-extras install java-openjdk11

Then, run MyServer.java first and then, MyClient.java.
The programs create Output.txt and all the rate_x files, where x is no of requests per second.
These are on the cloud. You need to bring these files to your machine.

Use:
scp -i Aloha.pem -r ec2-user@ec2-52-87-97-178.compute-1.amazonaws.com:java Non-Autoscaled  :- By this, (ec2user@ec2-52-87-97-178.compute-1.amazonaws.com:java), i.e, folder named 'java' in aws instance, is copied, and put in the folder "Non-Autoscaled",
which shud present inside the folder in which we have this terminal open(on our local machine). Note that entore java folder is copied due to
"-r", which copies files recursively.  If u wanna copy from local machine to aws instance, just reverse the order of "Non-Autoscaled" and the DNS extension.
