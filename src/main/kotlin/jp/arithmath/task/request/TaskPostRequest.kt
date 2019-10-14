package jp.arithmath.task.request

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Size

data class TaskPostRequest(
        @NotNull
        val id: Int,

        @NotNull
        @Size(min = 1)
        val task: String
)