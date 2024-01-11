package pl.lison.ideas.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lison.ideas.question.domain.model.Answer;
import pl.lison.ideas.question.domain.model.Question;
import pl.lison.ideas.question.service.AnswerService;
import pl.lison.ideas.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/answers")
public class AnswerAdminViewController {

    private final AnswerService answerService;

    public AnswerAdminViewController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public String indexView(Model model, @PathVariable("question-id")UUID questionId){

     model.addAttribute("answers", answerService.getAnswers(questionId));
     return  "admin/answer/index";
    }
//    @GetMapping("{id}")
//    public String editView(Model model, @PathVariable UUID id){
//
//        model.addAttribute("question", questionService.getQuestion(id));
//        return "admin/question/edit";
//    }
//
//    @PostMapping("{id}")
//    public String edit(@ModelAttribute("question")Question question, @PathVariable UUID id){
//        questionService.updateQuestion(id, question);
//        return  "redirect:/admin/questions";
//    }


}
