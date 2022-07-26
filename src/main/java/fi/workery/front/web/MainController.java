package fi.workery.front.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.azure.cosmos.models.PartitionKey;

import fi.workery.front.domain.Signup;
import fi.workery.front.domain.SignupRepository;
import fi.workery.front.domain.Task;
import fi.workery.front.domain.TaskRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MainController {
	@Autowired
	private SignupRepository sigRepo;
	@Autowired
	private TaskRepository taskRepo; 
	
	@GetMapping("/")
	public String firstPage() {
		return "index";
	}
	
	@GetMapping("/tasks")
	public String getAllTasks(Model model) {
		Iterable<Task> all = taskRepo.findAll(); 
		List<Task> add = StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
		model.addAttribute("tasks", add);
		return "first";
	}
	
	@GetMapping("/signs")
	public String getAllSignups(Model model) {
		Iterable<Signup> allSigs = sigRepo.findAll(); 
		List <Signup> addedSigs = StreamSupport.stream(allSigs.spliterator(), false).collect(Collectors.toList());
		model.addAttribute("signups", addedSigs); 
		return "signals"; 
	}
	
	@GetMapping("/taskdel/{id}")
	public String deleteTask(@PathVariable("id") String id) {
		PartitionKey part = new PartitionKey(id); 
		Optional<Task> task = taskRepo.findById(id, part);
		taskRepo.delete(task.get()); 
		return "redirect:/tasks"; 
	}
	
	@GetMapping("/sigdel/{id}")
	public String deleteSig(@PathVariable("id") String id) {
		Optional<Signup> signup = sigRepo.findById(id);
		PartitionKey sigPart = new PartitionKey(signup.get().getTaskId()); 
		sigRepo.deleteById(id, sigPart); 
		return "redirect:/signs"; 
	}
	
	@GetMapping("/create")
	public String makeNew(Model model) {
		Task taski = new Task();
		model.addAttribute("task", taski);
		return "newtask";
	};

	@PostMapping("/tallenna")
	public String saveTask(Model model, @ModelAttribute("task") Task task ) {
		taskRepo.save(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/taskedit/{id}")
	public String editTask(@PathVariable("id") String id, Model model) {
		Optional<Task> tak = taskRepo.findById(id);
		model.addAttribute("task", tak.get());
		return "oldtask";
	}
	

}
