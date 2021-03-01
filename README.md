# Interns Supervision Solution (Version 1)

This project have been designed and developped by : `Alexandre GOMEZ`, `Tristan CLEMENCEAU`, `Sylvie Alfred`, `Zénon Taleux`, `Daniel Guirol`, `Maxence Chambrin`.

# Summary
1. [Global description](#Global)
2. [Prerequisite](#Prerequisite)
3. [DB Setup](#DB Setup)
4. [How to launch the app](#How to launch the app)
5. [How to generate Javadoc](#How to generate Javadoc)
6. [LICENSE](#LICENSE)

# Global description

Interns Supervision Solution (I2S) is an JEE Web Application that will help any teacher at EFREI Paris supervise easily the interns assigned to him/her.
Each tutor have to login in their username and their password. Then, they will have access to the interns list where they can update their situation, add a new intern or delete a current one.

This version of I2S is built with JSP, Java Beans, Servlets and JDBC.

To design and develop this application we used :
* [Apache Netbeans](https://netbeans.org/kb//) - IDE
* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL](https://dev.mysql.com/doc/) - Open source relational database server

# Prerequisite
Make sure you have installed all of the following prerequisites on your development machine:

* [MySQL Workbench](https://dev.mysql.com/downloads/installer/) or  [WAMP Server](https://www.wampserver.com/) installed to setup the database.
* An IDE (for example [Apache Netbeans](https://netbeans.org))
* Optionnal : [Git](https://git-scm.com/downloads) (you can also download the project directly instead of cloning it)

# DB Setup

As said in Prerequisite, we will use an MySQL database server. For the database setup you will have to use the `sqlScriptCreate.sql` file to create the database and the tables. You can either copy & paste what is inside the file into the sql query window or import the file. 
The `sqlScriptInsertDB.sql` file will let you have all the data needed to test the application. 
The `sqlScriptDropDB.sql` file have everything you need if you want to drop all the tables and the database created.

# How to launch the app

To launch the app, add the project to your IDE (by cloning it with git or download). 
Make sure to have the good database username, password and URL (see `Web Pages -> WEB-INF` then the file `dbproperties.properties`), change the settings if needed.

![Database Settings](https://i.ibb.co/Yp29WnN/aa.png)

Then on your IDE, clean and build the project first, then run it. If the database is well setup, it should work.

# How to generate Javadoc

To generate the javadoc, right click on the projet and select `Generate Javadoc`. It will create the javadoc and it will normally
open the browser with the javadoc. If it does not open the browser, it should at least display the url in the console.

![Generate Javadoc](https://i.ibb.co/mF22J45/aaaa.png)

# LICENSE
This project is licensed under the MIT License - see the LICENSE.md file for details
