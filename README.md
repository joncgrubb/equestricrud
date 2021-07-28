# Equestricrud
A simple Spring Web MVC application with Thymeleaf template processing written in Java, deployed to Heroku using a MySQL database.

## Requirements

- [x] Ability to add a horse to the list.
- [x] Ability to select a horse from the list and view detailed information.
- [x] Ability to select a horse from the list and edit the details.
- [x] Ability to delete a horse from the list.

## Other Considerations

- [x] Project should be built using Java, Spring Web MVC Framework and a MySQL database.
- [x] Project should be deployed to an application server.
- [x] The horse list should show the following details:
        * Horse name
        * Horse age (calculated from foal year, see below)
        * Horse gender (calculated based on foal year, current year and actual gender, see below)
- [x] Age : Effectively every Thoroughbred horse's birthday as far as the industry is concerned is January 1st. A horse born in 2019 is will be considered a 1 year old on Jan 1st 2020.
- [x] Gender :
        * Female:
            * < 4 years old = "Filly"
            * 4+ years old = "Mare"
        * Male:
            * < 4 years old = "Colt"
            * 4+ years old = "Horse"

## Java / Spring Web MVC Framework / MySQL Database
For this application, I utilized the Java Development Kit 11 coupled with the [most recent version of Spring Boot](https://github.com/joncgrubb/equestricrud/blob/402adb9b509cab0a9d16966013b5b8ebcd27c0c6/pom.xml#L8). I have utilized Spring Boot for the sake of being able to quickly deploy a Spring-powered application out of the box, without having to write a lot of boilerplate code. It is important to note here that we *are* using Spring MVC within Spring Boot by [including the spring-web dependency](https://github.com/joncgrubb/equestricrud/blob/402adb9b509cab0a9d16966013b5b8ebcd27c0c6/pom.xml#L33). Viewing the [pom file](https://github.com/joncgrubb/equestricrud/blob/main/pom.xml) you can see all the dependencies used for this application, including the Java Persistence API (JPA) and MySQL Connector required to store data in a MySQL database.

There are many articles online detailing how to set up a simple Spring MVC web application. Many of these articles make use of in-memory databases for ease of getting a working sample app running locally. A handful of these articles do mention connecting to a local MySQL database, but most of these articles are many years old and much of the information is very outdated. One of the issues I found was outdated application properties to successfully connect the app to the database. Checking out the [application.properties file](https://github.com/joncgrubb/equestricrud/blob/main/src/main/resources/application.properties) you can see the configuration variables that worked for me (Note: the `spring.jpa.show-sql=true` line is only useful for debugging as it shows the queries being executed in the terminal and is not required to make the application work). The other variables listed in that file are required, but their values will be your local MySQL database information, for example:
`spring.datasource.url=jdbc:mysql://127.0.0.1:3306/database_name`
`spring.datasource.username=database_username`
`spring.datasource.password=database_password`

* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [MySQL Community Edition (Free)](https://www.mysql.com/products/community/#:~:text=MySQL%20Community%20Edition%20is%20the,community%20of%20open%20source%20developers.)

## Front end templating with Thymeleaf
According to their website, "Thymeleaf is a modern server-side Java template engine for both web and standalone environments".

These [templates](https://github.com/joncgrubb/equestricrud/tree/main/src/main/resources/templates) allow the developer to directly reference objects passed from the controller into the template, and makes it easy to utilize conditionals in displaying the data. Viewing these templates you can see that I've also used [Bootstrap](https://github.com/joncgrubb/equestricrud/tree/main/src/main/resources/static) just to have a quick and easy way to make the web app look presentable.

* [Thymeleaf](https://www.thymeleaf.org/)
* [Bootstrap](https://getbootstrap.com/docs/5.0/getting-started/introduction/)

## Deploying to Heroku
What is Heroku? Heroku is a platform as a service (PaaS) that enables developers to build, run, and operate applications entirely in the cloud. They do offer many paid services, but for building and deploying small to medium sized projects their free tier is great. That said, there are some quirks that you should be aware of when attempting to deploy an application such as this to their service.

### Setup
* You need to register a new Heroku account [here](https://signup.heroku.com/login).
* You need to download Git or Git Bash [here](https://git-scm.com/downloads). I used Windows 10 with Git Bash for developing this application, so pick your downloads accordingly.
* You need to download the Heroku CLI [here](https://devcenter.heroku.com/articles/heroku-cli). It is important to note here that if you already have Git Bash installed with an open terminal window, you will need to close that window and open a new one after installing Heroku CLI for Git to recognize the installation. If you do not, Heroku CLI will not be recognized. You can easily test if the CLI was installed properly by issuing the following command in Git Bash: `heroku --version`

### Creating the App
You can now login to Heroku create your app within the web interface.
![alt text](https://github.com/joncgrubb/equestricrud/blob/main/images/heroku_create_new_app.PNG?raw=true)

Give your app a name. One drawback here is that app names are shared between all users, so you must select a name that is not in use.
![alt text](https://github.com/joncgrubb/equestricrud/blob/main/images/heroku_name_new_app.PNG?raw=true)

Now click the Resources tab in the navbar.
![alt text](https://github.com/joncgrubb/equestricrud/blob/main/images/heroku_resources_tab.PNG?raw=true)

Heroku natively supports PostgreSQL for all applications. Unfortunately that means we need to use a third party addon to make use of a MySQL database. Thankfully this is incredibly easy in the Heroku environment thanks to ClearDB. Simply search for "cleardb" in the Add-ons search box and click the link.
![alt text](https://github.com/joncgrubb/equestricrud/blob/main/images/heroku_cleardb_addon.PNG?raw=true)

Submit the "order form" for the Ignite plan, which is free.
![alt text](https://github.com/joncgrubb/equestricrud/blob/main/images/heroku_cleardb_submit.PNG?raw=true)

You can now see the addon has been added to your application. Now you should click the Settings tab in the navbar and click the Reveal Config Vars button, this is where your database URL, username, and password are stored. The URL will be the only item in the list, add the other two shown below and copy the username and password values from inside the URL, the username will be directly after the `mysql://` and will be separated from the password with a `:`
![alt text](https://github.com/joncgrubb/equestricrud/blob/main/images/heroku_config_vars.PNG?raw=true)

You will need to update your application.properties file mentioned earlier if you have not yet done so or if you decided to use alternate variable names.

### Deployment
The first thing you will need to do is add a [system.properties](https://github.com/joncgrubb/equestricrud/blob/402adb9b509cab0a9d16966013b5b8ebcd27c0c6/system.properties#L1) file to the root directory of the project with a single line shown in the link. If you fail to do this step, your Heroku build *WILL* fail. For some reason, Heroku attempts to build the project using JDK 1.8, which in this case will not work. This file and single line will tell Heroku the correct Java runtime to use while building.

Next you will want to commit your main repository branch and push it to your remote Github repo.

In Git Bash, run the following command to add a Heroku remote to your local repository: 
`heroku git:remote -a name-of-your-heroku-app`

Now you can run the final command to deploy the application to Heroku. Note that Heroku *only* deploys code that you push to master or main, pushing to another branch will have no effect.
`git push heroku main`

You can watch as the build process runs and completes and if you have followed these steps exactly and your build completed successfully on your local environment, you should be met with a "Build Success" message! You can check the activity of your app within the Heroku web interface at any time by clicking the Activity tab in the navbar. You can also see terminal logs by clicking the More button in the top right corner of the page.