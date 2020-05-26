package com.github.luoyemyy.resource.mapper

import com.github.luoyemyy.resource.entity.ResourceRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectKey
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface ResourceMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    @SelectKey(statement=["SELECT LAST_INSERT_ID()"], keyProperty="record.id", before=false, resultType=Long::class)
    fun insert(insertStatement: InsertStatementProvider<ResourceRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("ResourceRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): ResourceRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ResourceRecordResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        Result(column="path_id", property="pathId", jdbcType=JdbcType.INTEGER),
        Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        Result(column="parent_level", property="parentLevel", jdbcType=JdbcType.INTEGER),
        Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<ResourceRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}