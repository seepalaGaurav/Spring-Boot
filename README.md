Quiz Application is a Monolithic Application developed using SpringBoot.

This application is used to create quiz with random questions based on requirement as follows:

1)Number of questions

2)Category 

The following is the result of PostMapping for adding question to the database through REST Controller names QuestionController:

![addQuestion](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/25887960-6378-40b2-b822-145d47dbafd5)

Question added in the table:

![addQuestionDB](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/3418f6bc-6577-4192-b8ab-83b6f6fa602b)

The following is the result of GetMapping to get all the questions from the question table:

![allQuestions](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/d28aaa48-4067-4487-8473-9cc429bf849e)

The following is the result of GetMapping to get the questions by category:

![categoryQuestions](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/2739d66f-9c3c-473a-bf8c-42f96e1168ad)

The following are the result of PostMapping for creating new Quiz:

![createQuizz](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/57b44696-a610-4f1a-9dbf-d3baea5f70c8)

![quizTable](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/ae3c0b8b-d19a-4b04-bf75-f673144f31fd)

![quizQuestion](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/7f0e05bf-51ec-4224-a540-0619b5bb23cc)

The following is the result of GetMapping to get Quiz questions:

![getQuizQuestions](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/714299dd-4b92-44f2-b821-a668ca31f808)

The following is the result of PostMapping to submit the Quiz:
Score with all correct answers(5/5):

![quizSubmitAllCorrectAnswers](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/5e5fe9e7-7351-47d7-b180-7c621d526a0a)

Score with three correct answers(3/5):

![quizSubmitSomeCorrectAnswers](https://github.com/seepalaGaurav/Spring-Boot/assets/155337846/d5519d6c-d32e-4fe3-8512-643b62b661dd)


Added The delete Functionality in the Question Controller and Service.





