package jp.arithmath.task.request

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Size

data class TaskPutRequest(
        @NotNull
        @Size(min = 1)
        val task: String
)