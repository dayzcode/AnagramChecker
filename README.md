# AnagramChecker
AnagramChecker Project 
Anagram Checker
Program to accept a username and 2 text values and return an indicator whether the values are an anagram.
A word is an anagram of another word if both use the same letters in the same quantity, but arranged differently.  For example 'friend' and 'finder'.
The delivered program should compile and run.  Include appropriate usage documentation.  Please state any assumptions you have made.
Expected effort is 2-3 hours.
Requirements

Validation	For the first release, input values with the following must be rejected
•	spaces 
•	numbers
Persistence & Performance	Each time values & results are processed, they should be written to the following:
•	An external file
•	A cache – (i.e., an Array or a Collection)
The file should be appended to, rather than overwritten. 
Improve performance by checking new requests against the cache, prior to processing.
Maintainability & Supportability	Other developers must be able to change code safely; protect your code with tests.
Support teams must be able to deal with issue; this can be achieved with good logging.


Nice-to-have (if you have time):
•	The input values in the file and cache should be unique.
•	Validate that the inputs do not have special characters
•	The solution must have the ability to easily add further validations over time – could you use a Factory pattern?
•	Upon start-up, populate the cache with the previous results stored in the file.
![image](https://github.com/dayzcode/AnagramChecker/assets/61425096/8089f63a-c040-4913-ac3b-beecbc903191)
