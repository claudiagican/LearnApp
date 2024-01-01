A Spring Boot app with Gradle and Thymeleaf that generates a random quiz starting from a dictionary repository (question - answer).  

Landing page with all the tests found in the repository:

<img src="learnapp-index.jpg" alt="landing page" width="500" height="auto">

Quiz page /quiz/{quizName} displays random questions generated on the server side. 
Pressing Check, the validation is made on the server and the correct option with be highlighted with green.

<img src="learnapp-quiz-valid.jpg" alt="valid option" width="500" height="auto">

<img src="learnapp-quiz-invalid.jpg" alt="invalid option" width="500" height="auto">

Without pressing Check, the Next button is disabled:

<img src="learnapp-quiz-option.jpg" alt="before check" width="500" height="auto">

Final page with the score:

<img src="learnapp-end.jpg" alt="end" width="500" height="auto">

The header and the footer of the pages are defined as Thymeleaf fragments and included in the pages index.html or quiz.html.

