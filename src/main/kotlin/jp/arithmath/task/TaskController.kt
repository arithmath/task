package jp.arithmath.task

import jp.arithmath.task.request.TaskPostRequest
import jp.arithmath.task.request.TaskPutRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Constraint
import javax.validation.Valid
import javax.validation.constraints.Pattern

@RestController
class TaskController(
        val service: TaskService
) {
    @RequestMapping(
            value="/tasks",
            method= [RequestMethod.GET]
    )
    fun getTaskList(): Array<TaskData> {
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