import matplotlib.pyplot as plt

x_list=list()
y_list=list()

f=open('Output.txt','r')
#g=open('Output_y.txt','w')
#h=open('Output_x.txt','w')
data=f.readlines()
for line in data:
    word=line.split()
    x=word[2]
    y_list.append(float(x))
    #strr=x
    #if(x!='16754.69837999924'):
    #    strr+=','
    #g.write(strr)
#g.close()

a=10
d=1111
n=0
for n in range(0,91):
    s=str((a+n*d))
    #h.write(s)
    #if(n!=90):
    #    h.write(",")
    x_list.append(int(s))

#h.close()
#print(x_list)
#print("LEN_x: ",len(x_list))
#print(y_list)
#print("LEN_y: ",len(y_list))

#figure, axes = plt.subplots(nrows=3, ncols=1)

plt.subplot(311)
plt.plot(x_list, y_list, color='green', linestyle='dashed', linewidth = 3,
         marker='o', markerfacecolor='blue', markersize=12)
#plt.ylim=(16000,100000)
#plt.xlim=(10,100000)

plt.xlabel("No of requests per second")
plt.ylabel("Respose time of AWS server")
plt.title("Output graph for cloud load")


x_list=x_list[1:]
y_list=y_list[1:]
plt.subplot(312)
plt.plot(x_list, y_list, color='green', linestyle='dashed', linewidth = 3,
         marker='o', markerfacecolor='blue', markersize=12)
plt.xlabel("No of requests per second")
plt.ylabel("Time without 1st entry")
#plt.title("Output graph for cloud load")



x_list=x_list[3:]
y_list=y_list[3:]
plt.subplot(313)
plt.plot(x_list, y_list, color='green', linestyle='dashed', linewidth = 3,
         marker='o', markerfacecolor='blue', markersize=12)
plt.xlabel("No of requests per second")
plt.ylabel("Time without first 4 entries")
#plt.title("Output graph for cloud load")

#figure.tight_layout(pad=4.0)

plt.show()
