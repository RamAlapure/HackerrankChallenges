/*
Write a qury to print respective department name and number of students majoring in each department for all departments 
in the department table even one with no current students. Sort your result by descending number of students, 
if two or more departments have same number of students then sort those departments alphabetically by department name.

Enter your query here.
*/

select dept_name, count(student_id) from departments

left join students on departments.dept_id = students.dept_id 

group by dept_name order by count(student_id) desc, dept_name asc;
