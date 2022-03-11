/*
Write the query to print the names of all the hackers who have gained more than 2000 hackos in less than 10 months. 
Print the output in asscending order of H_id.
Enter your query here.
*/

select name from Hacker_details where hackos > 2000 and time < 10 order by H_id asc;
