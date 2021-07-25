This simple application will just be a web-based interface to update a database on horses. I am not concerned with the look at all, just functionality. This is a basic CRUD application. The application should use Java, Spring Framework MVC and the MySQL database.
These are the basic requirements:
Must be able to list all of the horses in the database. The list should include the horse name, the age of the horse (calculated from foal year*), gender
[x] C - You should have the ability to add a horse to the list.
[x] R - From that list you should be able select a to view all of the details of the horse.
[x] U - You should be able to select a horse to edit from the list.
[x] D - You should be able to delete horses from the list.

Database table:

Table Name: horse
id (auto increment handled by DB)
name
gender (can only be m for male or f for female)**
foalyear
equibaselink
owner
trainer
jockey

*  Every horse is considered a weanling from the moment of birth. A horse becomes a year old, or Yearling, January 1st of the very next year after birth. Effectively every Thoroughbred horse's birthday as far as the industry is concerned January 1st. A horse born in 2019 is considered a 1 year old on Jan 1st 2020. So you use the foal year and the current year to calculate the age in years. A horse born in 2017 (any time of that year) would be 4 years old now.

**  Gender is displayed based on the gender in the database and the age. If a female is 4 years old it's a Filly, 4 and over is a Mare. A male is a Colt under 4 and a Horse 4 years and up.

I am not sure what IDE you use. We used to use Netbeans but now we use IntelliJ. I would prefer you used one of these to make the project, but it is not necessary at all that you use an IDE. We discussed that you have an application server that you can use so I will expect 2 things in the end. 
1 - link to the functional application.
2 - either a zip of the source or a github link to the source.