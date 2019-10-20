package jp.arithmath.task

import jp.arithmath.task.`interface`.Loggable
import jp.arithmath.task.request.TaskPostRequest
import jp.arithmath.task.request.TaskPutRequest
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Slf4j
@RestController
@CrossOrigin(origins = ["http://localhost:8080"])
class TaskController(
        val service: TaskService
): Loggable {

    @RequestMapping(
            value="/tasks",
            method= [RequestMethod.GET]
    )
    fun getTaskList(): Array<TaskData> {
        log.info("get task list info. key = {}", "hoge")
        log.warn("get task list warn. key = {}", "fuga")
        log.warn("get task list TARGET warn. key = {}", "piyo")
        log.error("get task list error. key = {}", "fnfn")
        log.error("get task list TARGET error. key = {}", "hnhn")
        return service.getTaskList()
    }

    @RequestMapping(
            value="/tasks/{taskId}",
            method= [RequestMethod.GET]
    )
    fun getTask(
            @PathVariable taskId: String): TaskData {
        return service.getTask(taskId.toInt())
    }

    @RequestMapping(
            value="/tasks",
            method= [RequestMethod.POST]
    )
    fun createTask(
            @RequestBody @Valid request: TaskPostRequest
    ): TaskData {
        return service.createTask(TaskData(
                request.id,
                request.task
        ))
    }

    @RequestMapping(



            value="/tasks/{taskId}",
            method= [RequestMethod.PUT]
    )
    fun updateTask(
            @PathVariable taskId: String,
            @RequestBody @Valid request: TaskPutRequest
    ): TaskData {
        return service.updateTask(TaskData(
                taskId.toInt(),
                request.task
        ))
    }

    @RequestMapping(
            value="/tasks/{taskId}",
            method= [RequestMethod.DELETE]
    )
    fun deleteTask(
            @PathVariable taskId: String
    ): TaskData {
        return service.deleteTask(
                taskId.toInt()
        )
    }

}