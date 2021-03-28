package info_sec.project.contoller;

import info_sec.project.model.Curator;
import info_sec.project.repo.CuratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuratorController {

    @Autowired
    CuratorRepo curatorRepo;

    @GetMapping(value = "/curators", produces = "application/json")
    List<Curator> getCurators() {
        return curatorRepo.findAll();
    }

    @GetMapping(value = "/curators/{id}", produces = "application/json")
    Curator getCurator(@PathVariable Long id) {
        return curatorRepo.findById(id);
    }

    @PostMapping(value = "/curators", produces = "application/json")
    Curator createCurator(@RequestBody Curator newCurator) {
        return curatorRepo.save(newCurator);
    }

    @PutMapping(value = "/curators/{id}", produces = "application/json")
    Curator updateCurator(@RequestBody Curator updatedCurator, @PathVariable Long id) {
        Curator curator = curatorRepo.findById(id);
        curator.setName(updatedCurator.getName() != null ? updatedCurator.getName() : curator.getName());
        curator.setGroups(updatedCurator.getGroups() != null ? updatedCurator.getGroups() : curator.getGroups());
        curator.setDepartment(updatedCurator.getDepartment() != null ? updatedCurator.getDepartment() : curator.getDepartment());
        return curatorRepo.save(curator);
    }
}
