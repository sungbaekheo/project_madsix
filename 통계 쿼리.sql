SELECT surveyee.ID, surveyee.Name, a1.answer as question1, a2.answer as question2, a3.answer as question3, a4.answer as question4
FROM (((((questions
INNER JOIN surveyee ON questions.ID = surveyee.ID)
INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1)
INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2)
INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3)
INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4);

SELECT answer, COUNT(ID)
FROM answers
RIGHT JOIN (
	SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4
	FROM (((((questions
	INNER JOIN surveyee ON questions.ID = surveyee.ID)
	INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1)
	INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2)
	INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3)
	INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4)
    ) AS Q1
ON answers.answer_key = Q1.question4
GROUP BY Q1.question4;
    
SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4
	FROM (((((questions
	INNER JOIN surveyee ON questions.ID = surveyee.ID)
	INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1)
	INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2)
	INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3)
	INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4);
    
SELECT answer, COUNT(ID)
FROM answers
RIGHT JOIN (
	SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4
	FROM (((((questions
	INNER JOIN surveyee ON questions.ID = surveyee.ID)
	INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1)
	INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2)
	INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3)
	INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4)
    ) AS Q1
ON answers.answer_key = Q1.question4
GROUP BY Q1.question4;

SELECT COUNT(ID) FROM questions;
