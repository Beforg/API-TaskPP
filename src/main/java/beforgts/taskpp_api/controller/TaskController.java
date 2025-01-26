package beforgts.taskpp_api.controller;

import beforgts.taskpp_api.domain.task.CreateTaskDTO;
import beforgts.taskpp_api.domain.ResponseDTO;
import beforgts.taskpp_api.domain.task.TaskCountDTO;
import beforgts.taskpp_api.domain.task.TaskDTO;
import beforgts.taskpp_api.domain.task.UpdateTaskDTO;
import beforgts.taskpp_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody CreateTaskDTO dto){
        this.service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("Task created successfully.", HttpStatus.CREATED));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable String id, @RequestBody UpdateTaskDTO dto){
        this.service.update(id, dto);
        return ResponseEntity.ok(new ResponseDTO("Task updated successfully.", HttpStatus.OK));
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ResponseDTO> deactivate(@PathVariable String id){
        this.service.deactivate(id);
        return ResponseEntity.ok(new ResponseDTO("Task trashed successfully.", HttpStatus.OK));
    }

    @PutMapping("/update/{id}/status")
    public ResponseEntity<ResponseDTO> updateStatus(@PathVariable String id){
        this.service.updateStatus(id);
        return ResponseEntity.ok(new ResponseDTO("Task status updated successfully.", HttpStatus.OK));
    }

    @DeleteMapping("/delete/{id}/permanent")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.ok(new ResponseDTO("Task deleted successfully.", HttpStatus.OK));
    }

    @GetMapping("/get/{date}")
    public ResponseEntity<Page<TaskDTO>> listByDate(
                                                    @PathVariable String date,
                                                    @RequestParam(defaultValue = "1") int page,
                                                    @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(this.service.list(date, page, size));
    }

    @GetMapping("/get/{listId}")
    public ResponseEntity<Page<TaskDTO>> listByList(
                                                                     @PathVariable String listId,
                                                                     @RequestParam(defaultValue = "1") int page,
                                                                     @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(this.service.list(listId, page, size));
    }
    @GetMapping("/get/count")
    public ResponseEntity<TaskCountDTO> count(){
        return ResponseEntity.ok(this.service.countTask());
    }
}
