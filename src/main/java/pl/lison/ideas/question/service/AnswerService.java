package pl.lison.ideas.question.service;

import org.springframework.stereotype.Service;
import pl.lison.ideas.question.domain.model.Answer;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class AnswerService {
    public List<Answer> getAnswers(UUID questionId ) {
        return Arrays.asList(
                new Answer("Answer 1"),
                new Answer("Answer 2"),
                new Answer("Answer 3")
        );
    }

    public Answer getAnswer(UUID id) {
        return new Answer("Answer " + id);
    }

    public Answer createAnswer(UUID questionId, Answer answer) {

        return answer;
    }

    public Answer updateAnswer(UUID id, Answer answer) {

        return answer;
    }

    public void deleteAnswer(UUID id) {

    }
}
