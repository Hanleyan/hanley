package com.api.hanley.dao;

import com.api.hanley.entity.dto.Action;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hanley
 * @date 2019/4/23 15:53
 * 风萧萧兮易水寒
 */
public interface ActionDao {

    Action getActionById(@Param("id") int actionId);

    List<Action> getActionList();

    int addAction(Action action);

    /*List<Action> getActionListByUserId(int userId);

    int addAction(Action action);*/


}
