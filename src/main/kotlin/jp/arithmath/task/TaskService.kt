package jp.arithmath.task

import org.springframework.stereotype.Service

@Service
class TaskService(
        val mapper: TaskMapper
) {
    fun getTaskList(): Array<TaskData> {
        return mapper.findAll()
    }

    fun getTask(id: Int): TaskData {
        return mapper.findOne(id)
    }

    fun createTask(task: TaskData): TaskData {
        mapper.save(task.id, task.task);
        return task;
    }

    fun updateTask(task: TaskData): TaskData {
        mapper.update(task.id, task.task)
        return mapper.findOne(task.id)
    }

    fun deleteTask(id: Int): TaskData {
        val before = mapper.findOne(id)
        mapper.delete(id)
        return before
    }
}