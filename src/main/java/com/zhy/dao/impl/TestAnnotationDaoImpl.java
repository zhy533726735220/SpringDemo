package com.zhy.dao.impl;

import com.zhy.dao.ITestAnnotationDao;
import com.zhy.vo.TestAnnotation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

// 写上此注解之后就相当于bean对象已经在applicationContext.xml文件里面配置上了
// 而他的引用名字就是首字母小写，即：deptDAOImpl
@Repository
public class TestAnnotationDaoImpl implements ITestAnnotationDao {
    public boolean doCreate(TestAnnotation vo) {
        Logger.getLogger(TestAnnotationDaoImpl.class).info(vo.toString());
        return true;
    }
}
