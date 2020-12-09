package com.javalearning.demo.design_pattern.response_chain.next_type;

import com.javalearning.demo.design_pattern.response_chain.next_type.model.DepartmentManager;
import com.javalearning.demo.design_pattern.response_chain.next_type.model.GeneralManager;
import com.javalearning.demo.design_pattern.response_chain.next_type.model.Handler;
import com.javalearning.demo.design_pattern.response_chain.next_type.model.ProjectManager;

/**
 * @description 责任链初始化器
 * @date 2020/5/8
 */
public class ResponseChainInitializer {

    private static Handler INSTANCE;

    static {
        init();
    }

    private static void init() {
        ProjectManager projectManager = new ProjectManager();
        DepartmentManager departmentManager = new DepartmentManager();
        GeneralManager generalManager = new GeneralManager();
        projectManager.setSuccessor(departmentManager);
        departmentManager.setSuccessor(generalManager);
        INSTANCE = projectManager;
    }

    public static Handler getInstance(){
        return INSTANCE;
    }
}
