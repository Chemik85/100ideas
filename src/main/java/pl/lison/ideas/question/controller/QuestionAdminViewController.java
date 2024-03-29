package pl.lison.ideas.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lison.ideas.question.domain.model.Question;
import pl.lison.ideas.question.service.QuestionService;

import java.util.UUID;

@Controller
@RequestMapping("/admin/questions")
public class QuestionAdminViewController {

    private final QuestionService questionService;

    public QuestionAdminViewController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping
    public String indexView(Model model){

        model.addAttribute("questions", questionService.getQuestions());
        return "admin/question/index";
    }
    @GetMapping("{id}")
    public String editView(Model model, @PathVariable UUID id){

        model.addAttribute("question", questionService.getQuestion(id));
        return "admin/question/edit";
    }

    @PostMapping("{id}")
    public String edit(@ModelAttribute("question")Question question, @PathVariable UUID id){
        questionService.updateQuestion(id, question);
        return  "redirect:/admin/questions";
    }


}
