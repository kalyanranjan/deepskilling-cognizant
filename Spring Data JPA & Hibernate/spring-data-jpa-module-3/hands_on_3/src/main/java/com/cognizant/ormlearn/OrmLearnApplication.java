package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.service.AttemptService;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        AttemptService attemptService = context.getBean(AttemptService.class);
        
        testAttemptServiceGetAttemptDetail(attemptService);
    }

    private static void testAttemptServiceGetAttemptDetail(AttemptService attemptService) {
        System.out.println("Start testAttemptServiceGetAttemptDetail");
        Attempt attempt = attemptService.getAttempt(1, 1);
        
        if (attempt != null) {
            for (AttemptQuestion aq : attempt.getAttemptQuestionList()) {
                System.out.println(aq.getQuestion().getText());
                int optionNumber = 1;
                for (AttemptOption ao : aq.getAttemptOptionList()) {
                    System.out.println(optionNumber + ") " + ao.getOptions().getText());
                    System.out.println(ao.getOptions().getScore());
                    System.out.println(ao.isSelected());
                    optionNumber++;
                }
            }
        } else {
            System.out.println("Attempt not found");
        }
    }
}
