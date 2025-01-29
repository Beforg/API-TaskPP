package beforgts.taskpp_api.controller;
import beforgts.taskpp_api.domain.ResponseDTO;
import beforgts.taskpp_api.domain.list.CreateTaskListDTO;
import beforgts.taskpp_api.domain.list.TaskListDTO;
import beforgts.taskpp_api.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/lists")
public class TaskListController {

    @Autowired
    private TaskListService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody CreateTaskListDTO dto) {
        this.service.create(dto);
        return ResponseEntity.ok(new ResponseDTO("List created successfully.", HttpStatus.CREATED));
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<TaskListDTO>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }
    @GetMapping("/get")
    public ResponseEntity<Page<TaskListDTO>> get(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.service.get(page, size));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable String id, @RequestBody CreateTaskListDTO dto){
        this.service.update(id, dto);
        return ResponseEntity.ok(new ResponseDTO("List updated successfully.", HttpStatus.OK));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.ok(new ResponseDTO("List deleted successfully.", HttpStatus.OK));
    }

}
