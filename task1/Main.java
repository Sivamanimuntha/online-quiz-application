

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.begin();

    }
}

class Quiz
{
    void begin()
    {
        Question[] questions = new Question[5];

        questions[0] = new Question("when is the object created with new keyword?","run time","compile time","depend on code","none", new Answer("run time"));
        questions[1] = new Question("who invented java programming?","guido van","james gosling","dennis","bjarne", new Answer("james gosling"));
        questions[2] = new Question("what is the platform of java?","dependent","no platform","independent","none", new Answer("independent"));
        questions[3] = new Question("Number of primitive data types in java are?","6","7","9","8", new Answer("8"));
        questions[4] = new Question("Arrays in java are?","objects","object reference","primitive data types","none", new Answer("objects"));

        int countTotal = 0;
        int countRight = 0;
        int countWrong = 0;

        for(Question q: questions)
        {
            System.out.println(q.getQuestion());
            System.out.println("A : " +q.getOption1());
            System.out.println("B : " +q.getOption2());
            System.out.println("C : " +q.getOption3());
            System.out.println("D : " +q.getOption4());

            String answer = "";

            char ans;
            System.out.println("Enter your answer");
            Scanner scan = new Scanner(System.in);
            ans = scan.next().charAt(0);

            switch(ans)
            {
                case 'A':
                    answer = q.getOption1();
                    break;
                case 'B':
                    answer = q.getOption2();
                    break;
                case 'C':
                    answer = q.getOption3();
                    break;
                case 'D':
                    answer = q.getOption4();
                    break;
                case 'a':
                    answer =q.getOption1();
                    break;
                case 'b':
                    answer=q.getOption2();
                    break;
                case 'c':
                    answer=q.getOption3();
                    break;
                case 'd':
                    answer=q.getOption4();
                    break;
                default:
                    System.out.println("invaild charchter");
                    break;
            }
            System.out.println("Your answer " + answer + " " + q.getAnswer());
            if(answer.equals(q.getAnswer().getAnswer()))
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Correct Answer                      ");
                System.out.println("------------------------------------------------------");
                countRight++;
            }
            else
            {
                System.out.println("------------------------------------------------------");
                System.out.println("                  Wrong Answer                      ");
                System.out.println("------------------------------------------------------");
                countWrong++;
            }
            System.out.println("============================================================================================");
            countTotal++;
        }

        Result result = new Result(countTotal,countRight,countWrong);
        result.showResult();
    }
}

class Question
{

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    Answer answer;

    public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public Answer getAnswer() {
        return answer;
    }
}

class Answer
{
    String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}

interface IResult
{
    void showResult();
    double showPercentage(int correctAnswers,int totalQuestions);
    String showPerformance(double percentage);
}

class Result implements IResult
{
    int totalQuestions;
    int correctAnswers;
    int wrongAnswers;

    public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public void showResult() {
        System.out.println("Your results!");
        System.out.println("Total Questions " + totalQuestions);
        System.out.println("Number of correct answers " + correctAnswers);
        System.out.println("Number of wrong answers " + wrongAnswers);
        System.out.println("Percentage " + showPercentage(correctAnswers,totalQuestions));
        System.out.println("Your performance " + showPerformance(showPercentage(correctAnswers,totalQuestions)));

    }

    @Override
    public double showPercentage(int correctAnswers, int totalQuestions) {
        //System.out.println(correctAnswers + " " + totalQuestions);
        return (double) (correctAnswers / (double)totalQuestions) * 100 ;
    }

    @Override
    public String showPerformance(double percentage) {
        String performance = "";

        if(percentage >=60)
        {
            performance = "Good";
        }
        else if(percentage <= 40)
        {
            performance = "Poor";
        }

        return performance;

    }
}
