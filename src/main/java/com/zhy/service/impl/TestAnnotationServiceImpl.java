package com.zhy.service.impl;

import com.zhy.dao.ITestAnnotationDao;
import com.zhy.service.ITestAnnotationService;
import com.zhy.vo.TestAnnotation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestAnnotationServiceImpl implements ITestAnnotationService {

    // dao对象注入完成
    @Resource
    private ITestAnnotationDao testAnnotationDaoImpl;

    public boolean add(TestAnnotation vo) {
        return this.testAnnotationDaoImpl.doCreate(vo);
    }
}
