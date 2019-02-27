package com.yaoyong.demo.base.sqlInjector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

/**
 * <p>
 * 抽象的注入方法类
 * </p>
 *
 * @author hubin
 * @since 2018-04-06
 */
public abstract class AbstractLogicMethod extends AbstractMethod {

    public AbstractLogicMethod() {
        // TO DO NOTHING
    }

    /**
     * <p>
     * SQL 更新 set 语句
     * </p>
     *
     * @param table 表信息
     * @return sql set 片段
     */
    protected String sqlLogicSet(TableInfo table) {
        return "SET " + table.getLogicDeleteSql(false, true);
    }

    // ------------ 处理逻辑删除条件过滤 ------------

//    @Override
//    protected String sqlWhereEntityWrapper(boolean newLine, TableInfo table) {
//        if (table.isLogicDelete()) {
//            String sqlScript = table.getAllSqlWhere(true, true, WRAPPER_ENTITY_DOT);
//            sqlScript = SqlScriptUtils.convertIf(sqlScript, String.format("%s != null", WRAPPER_ENTITY),
//                true);
//            sqlScript += (NEWLINE + table.getLogicDeleteSql(true, false) + NEWLINE);
//            String normalSqlScript = SqlScriptUtils.convertIf(String.format("AND ${%s}", WRAPPER_SQLSEGMENT),
//                String.format("%s != null and %s != '' and %s", WRAPPER_SQLSEGMENT, WRAPPER_SQLSEGMENT,
//                    WRAPPER_NONEMPTYOFNORMAL), true);
//            normalSqlScript += NEWLINE;
//            normalSqlScript += SqlScriptUtils.convertIf(String.format(" ${%s}", WRAPPER_SQLSEGMENT),
//                String.format("%s != null and %s != '' and %s", WRAPPER_SQLSEGMENT, WRAPPER_SQLSEGMENT,
//                    WRAPPER_EMPTYOFNORMAL), true);
//            sqlScript += normalSqlScript;
//            sqlScript = SqlScriptUtils.convertChoose(String.format("%s != null", WRAPPER), sqlScript,
//                table.getLogicDeleteSql(false, false));
//            sqlScript = SqlScriptUtils.convertWhere(sqlScript);
//            return newLine ? NEWLINE + sqlScript : sqlScript;
//        }
//        // 正常逻辑
//        return super.sqlWhereEntityWrapper(newLine, table);
//    }

//    @Override
//    protected String sqlWhereByMap(TableInfo table) {
//        if (table.isLogicDelete()) {
//            // 逻辑删除
//            String sqlScript = SqlScriptUtils.convertChoose("v == null", " ${k} IS NULL ",
//                " ${k} = #{v} ");
//            sqlScript = SqlScriptUtils.convertForeach(sqlScript, "cm", "k", "v", "AND");
//            sqlScript = SqlScriptUtils.convertIf(sqlScript, "cm != null and !cm.isEmpty", true);
//            sqlScript += (NEWLINE + table.getLogicDeleteSql(true, false));
//            sqlScript = SqlScriptUtils.convertWhere(sqlScript);
//            return sqlScript;
//        }
//        return super.sqlWhereByMap(table);
//    }
}