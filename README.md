# Earthquake_Prediction
<h3> 1. Introduction </h3> <br>
Earthquakes are a reality in this world. Even tough humanity has reached a technology level 
that has never been reached before we are still struggling to make accurate predictions about when 
an earthquake will happen. 
Earthquakes are an intense shake of the lithosphere (Earth’s outermost surface). New 
technological developments give us lots of data about its magnitude to exact location and depth. But 
these data are recorded after an earthquake has happened. 
All professions have been working together to make this uncertainty less threatening. By 
developing stronger buildings to making AI powered prediction or analysis systems about it. We are 
being tomorrow’s software engineers working on this project and helping others is very important.
Today there are lots of databases that we can use for our project. The most popular and 
trustable sources are Kandilli and AFAD for Turkey. After discussing we decided on using AFAD’s data 
would be more suitable for this project.
In this article you can see the technologies, methodologies, and algorithms. Thank you and 
enjoy reading!
<h3> 2. Literature </h3> <br>
Computers have come a long way in such a short time. This gives us the advantage of having 
more complex computations and work with larger data. Everyday lots of earthquakes happen just in 
Turkey varying from low to very high magnitudes of earthquakes. This gives us a very big database to 
work with. 
These databases usually consist of several important columns. Location, it tells us where in 
Turkey this Earthquake originated from. For example, “Bodrum/Muğla” etc. Event dates are exact or 
near exact moments of when the earthquake has happened. For example, “11-06-2020 19:41”. 
Longitude and Latitude are more specific and scientific location data about the earthquake. For 
example, “44.4443 – 38.4033”. Depth is also an important metric about earthquake. It makes a huge 
difference in how we feel the earthquake. For example, “7.6km”. Magnitude tells us how strong the 
earthquake was. For example, “3.5 mW”. Last one is type and tells us how big or small is the 
earthquake. It has a value between 0 – 1.
After acquiring the data, we need to perform some operations using the data to gain a 
meaningful and usable model. First of all we examined the dataset by analyzing its pair plot. By 
analyzing this pair plot, we saw in magnitude and depth columns have positive skewness. But we didn’t 
change the data to not the hurt our real factual data set. We analyzed the correlation matrix and 
compared the columns correlation. 
We had noisy and unnecessary data in our data set, so we eliminated columns like, EventID, 
EpicenterAgency and Location. By doing that we now have clearer and less noise in our data to work 
with. 

We made a normalization to our magnitude column we had data names like “Small, Moderate, 
Major etc.” after this normalization we have a data type between 0-1 to make it easier to read and 
work with. 0 is for small earthquakes and 1 is for moderate earthquakes.
Mappings of data can be very helpful to visualize our world and to understand easier the data. 
It gives the data a meaning to exist and something to be compared. By this in mind we also made a 
map of turkey to see if the matches to real fault lines. We already have the altitude and longitude, so 
we project it to a real Turkey fault line map with K-Means clustering. 
Machine learning has different ways to learn something. You can make it learn by nothing or 
giving it some training data and test later to see how accurate your model is. We chose the improvised 
learning would be better to make it work. We have a data set of around 8500 and we use neural 
networks to make it work. 
We showed how data works, how to normalize it and how to train the data. I hope its good 
information for you.

<h3 > 3. Structure of the solution proposed – Components, Architectural design </h3> <br>

Structure is the most important part of the project. Structure fails all the project fails so we 
made our project very strong there are three parts that makes this project possible. Let’s go through 
them together.
First with the data we have we made basic reading processes. We realized we had too much 
noisy and unnecessary data. Spyder helped us to make the data separated more pure. This made the 
data ready. Libraries like pandas and NumPy has been imported. Next thing was to eliminate 
unnecessary data like eventide and such. We separated the Time and the date. Changing the 
magnitude and normalizing it helped through the process. We made an operation called time stamp 
on date. It’s ((1970/1/1) – Current Date) *86400). We separated the data by x and y. X is longitude 
latitude, type, depth, and time stamp. Y is magnitude. We recorded the data to a new file. This was the 
process of data.
Mapping was not the hardest to code but really hard to make it precision and accurate. We
added the needed libraries for it. We need the data of latitude and longitude. So, we took it from the 
prepared data. After taking all the data we made a k-means clustering of 3 classes. By that definition 
we separated the data by 3 both on latitude and the longitude. After this we put the pairs on the for 
loops by normalizing the data and made them seeable on the map picture with RGB colors.
Modelling required high level libraries. After importing the libraries, exception handling has to 
be done to make it structurally strong, so we did that. We have 3 different main variables. Our X data 
(longitude etc.). Y is the classes. Batch Size is 8500 because we have around that number of examples. 
We made an iterator to fit our model. We split the data by %70 training and %30 percent testing. 
Shuffling the data was important to not let the model being just overfitting or memorizing the model. 
We created the variables for neural network. Hidden layer count was 9 because it was the optimum 
for this project. We used multilayer configuration layer to our model. We used TANH an RELU for best 
results in activation. Weighing is XAVIER. We used 6 dense layer and 1 output layer. After these layers 
we taught the model. We fit our model for 10.000 times to get the best result. Evaluation decides on 
which one of the five class to put it on. At the end of the program, we can see information about; 

evaluation matrix of five classes, accuracy, precision f1 score etc. You can see all the information we 
get from the software in Figure 9. Modelling and Confusion Matrix Results.

<h3> 4. Software Usage </h3> <br>

<h5> 4.1 How to use the software </h5> <br>
We have used two different programming language for different purposes. We used Python to 
make our data more usable and suitable to our needs. Java is for making the machine learning model 
and mapping of fault line with real earthquakes. Let’s start with Python and then Java projects. 
Python as we said earlier being used to make our data more usable and better. You need 
Python to make it work IDE is not very important, but Spyder IDE is recommended. When you open it 
the data set will be ready with your files. After opening you need to just run the code blocks. In the 
Richter Scale code block you can change the division by changing loop values. After everything a new 
file will be added to your project files, and you can use it anywhere you want or in Java.
Java also comes with it’s files and you can bring your data set you made from Python after that 
you just run the program and see the result of your model in command line. Also, you can change the 
percentage of training and test data to have different or make it more accurate.
The other Java file is for mapping of the fault lines is the same process you only need to run 
this code and a page will come up to see your results.
<h5> 4.2 What are the requirements? </h5> <br>
Python and Java SDKs are both need to be downloaded a loaded in your computer. For Python 
there is no specific IDE, but Spyder is recommended because it has all the basic libraries for this kind 
of project. If you don’t want to download Spyder I will list the needed libraries to be downloaded for 
this project under here.
- Pandas
- Seaborn
- NumPy
- matplotlib
- SciPy
- Sklearn
Already downloaded libraries with Python are “datetime” and “time”
Java has two different projects in it. First let’s start with mapping project for this one you can 
use any IDE that can run Java code but there are special libraries you need for this code to run. I will 
list them under here.
- Ajt-2.11

- Commons-math3-3.6
- Javaml-0.1.7
- Weka
With that you can use included dataset and image or add your own to this project.
Second project in Java is Machine learning modelling. You also need and IDE that can run the 
java code and some special libraries. Let’s list them.
- DeepLearning4j
- Nd4j
- Datavec
There are also included Java libraries in these project that doesn’t need any downloading.
If you can make these requirements, you can run all these code without any problems.
<h3> 5. Algorithmic Frame Explanation </h3> <br>
We used two different main algorithms to work with. Mapping used K-means algorithm and 
Modelling used Neural networks.
K-Means algorithm is a method of vector quantization. Data clustering problem consists of 
finding partition of given data in terms of similarity. A new hierarchy of clustering algorithms is 
proposed, and some well-known algorithms are described using this hierarchy.
Neural networks are made from layers of nodes which consist of input (dense) layers and 
output layers. Every neuron in the hidden layer has its bias and trigger value and is triggered when 
sending information to the next layer of the network.

<h3> 6. Demonstration </h3> <br>
This part will include graphical and text-based demonstration about this project let’s start with 
data demonstrations.
Figure 1. Unchanged data
![Unchanged data](/img/1.png)






Figure 5. Cleaned and Usable Data
![Unchanged data](/img/Ekran görüntüsü 2022-01-06 183244.png)

Java side has two different Projects so let’s focus on mapping project first. 
Mapping Project:
Figure 6. Map before Clustering
![Unchanged data](/img/AfterClustering.png)


Figure 7. Map after Clustering

![Unchanged data](/img/Clustering.png)



Figure 9. Modelling and Confusion Matrix Results
![Unchanged data](/img/Ekran görüntüsü 2022-01-06 183308.png)

<h3> 7. Results and Comments </h3> <br>
Results we have can be separated into three different parts. First is making the data usable 
and better. Second is mapping of faulting line and comparing. Third and the last one is neural network 
modelling.
Making the data usable was not the biggest challenge for us. We deleted some unnecessary 
parts form the data and made normalization on the magnitude to meet the standards of the project. 
There were no problems with noisy or missing data so we can say we are lucky. 
Mapping is also quite accurate we have some problems like not being exact but generally you 
can see the lines with the earthquakes quite easily. If we had a perfect altitude and magnitude map It 
would be much easier but to solve that we scaled the map and the coordinates to have the best results.
Modelling would be the hardest part for us. We tried several different algorithms and some 
trial and error for project to work. 70% training to 30% percent test data gave us the best results with 
only 16.7% error rate. Layers, how many examples, how many classes has been worked on for days to 
get the optimum results.

<h3> 8. Future Improvements </h3> <br>
Time means everything. If we had more time, we would get more data to work with more 
algorithms to use and such. At this point we can say we need data about smaller earthquakes for 
Turkey. This challenged us to have more accurate results. 
For mapping if we had an API or something that we can call to have better altitude-longitude 
accuracy we might had better results in that department.
Modelling is the challenge we didn’t had in super or major categories. In the future we can 
improve on that by having much more data to work with. Also %16.7 error rate is right now might be 
okay but, in the future, we can make it les then %10 percent it would be a nice upgrade

Ahmet Yasin Bağçıvan
Mehmet Şener
Adrian Kubczak
