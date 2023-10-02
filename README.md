# wowcher-code
speaking-clock

#Prerequisites :-
You should have git, java & maven installed in your system with environment & path variable set.

#GIT REPOSITORY LINK FOR CLONING SPEAKING-CLOCK PROJECT (By Varun Tiwari) :-
https://github.com/varun-tiwari-108/wowcher-code.git


# ---------- Clone the project ----------

#STEP 1 :-
Make a new folder anywhere in your local machine. Go to that folder/directory and open it in 'cmd' or 'command-prompt'. After that write "git clone <git repo link mention above> ."

#FOR e.g., :-
C:\Users\Varun Tiwari\Documents\Clone Repo>git clone https://github.com/varun-tiwari-108/wowcher-code.git .

#NOTE :-
Mention '.' also after the git link in the command to clone everything.


# ---------- Build the project ----------

#STEP 2 :-
Once cloning is done with step 1, there should be a folder named 'speaking-clock' created in your directory. Go inside that folder and open it in 'cmd' or 'command-prompt'. After that write "mvn clean install"

#FOR e.g., :-
C:\Users\Varun Tiwari\Documents\Clone Repo\speaking-clock>mvn clean install


# ---------- Run the application / Deploy the applcation on the embedded tomcat server ----------

#STEP 3 :-
Once the project is build successfully with step 2, there should be a 'target' folder created inside the folder 'speaking-clock'. Go inside 'target' folder and open it in 'cmd' or 'command-prompt'. There shoud be an executable jar in the 'target' folder. To deploy that jar & run application server write command "java -jar <jar file name>"

#FOR e.g., :-
C:\Users\Varun Tiwari\Documents\Clone Repo\speaking-clock\target>java -jar speaking-clock-0.0.1-SNAPSHOT.jar


# ---------- Links/Endpoints ----------

#Swagger Link :-
http://localhost:8080/swagger-ui/index.html#/


#Endpoint to convert time into words :-
http://localhost:8080/speaking-clock/{time}

#FOR e.g., :-
http://localhost:8080/speaking-clock/08:34


#Endpoint to tell if currently is Mid-day, Mid-night or none :-
http://localhost:8080/speaking-clock/mid/{time}

#For e..g., :-
http://localhost:8080/speaking-clock/mid/12:11