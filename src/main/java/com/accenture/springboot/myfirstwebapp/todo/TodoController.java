package com.accenture.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername();
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        model.put("title","List todos");
        return "listTodos";
    }



    //Get
    @RequestMapping(value= "add-todo" , method = RequestMethod.GET)
    public String showTodo(ModelMap model){
        String username = getLoggedInUsername();
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        model.put("title","Add todos");
        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){

            return "todo";
        }
        String username =  getLoggedInUsername();
        todoService.addTodo(username, todo.getDescription(),
                            todo.getTargetDate(), false );

        model.put("title","Add todos");
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id){

        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        String username =  getLoggedInUsername();
        Todo todo = todoService.findById(id);
        model.put("todo",todo);
        model.put("title","Update todos");
        return "todo";
    }

    @RequestMapping(value="update-todo", method= RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }

        String username = getLoggedInUsername();
        todo.setUsername(username);
        todoService.updateTodo(todo);
        model.put("title","Update todos");
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }



}
