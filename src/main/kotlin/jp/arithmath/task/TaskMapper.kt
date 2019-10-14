package jp.arithmath.task

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
public interface TaskMapper {
    @Select("select * from task")
    fun findAll() : Array<TaskData>

    @Select("select * from task where id = #{id}")
    fun findOne(id: Int): TaskData

    @Select("insert into task(id, task) values (#{id}, #{task})")
    //@Options(useGeneratedKeys = true)
    fun save(id: Int, task: String)

    @Select("update task set task = #{task} where id = #{id}")
    fun update(id: Int, task: String)

    @Select("delete from task where id = #{id}")
    fun delete(id: Int)
}