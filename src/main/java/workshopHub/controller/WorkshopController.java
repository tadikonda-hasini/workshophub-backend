package workshopHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import workshopHub.entity.Workshop;
import workshopHub.repository.WorkshopRepository;

import java.util.List;

@RestController
@RequestMapping("/api/workshops")
@CrossOrigin(origins = "http://localhost:5173")
public class WorkshopController {

    @Autowired
    private WorkshopRepository repo;

    // GET all workshops
    @GetMapping
    public List<Workshop> getAll() {
        return repo.findAll();
    }

    // POST create workshop
    @PostMapping
    public Workshop create(@RequestBody Workshop workshop) {
        return repo.save(workshop);
    }

    // DELETE workshop
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}