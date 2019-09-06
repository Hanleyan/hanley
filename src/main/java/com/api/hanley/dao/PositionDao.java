package com.api.hanley.dao;

import com.api.hanley.entity.dto.Action;
import com.api.hanley.entity.dto.Position;

/**
 * @author hanley
 * @date 2019/4/23 15:53
 * 风萧萧兮易水寒
 */

public interface PositionDao {

    Position getPositionById(int positionId);

    /*List<Action> getActionList();

    List<Action> getActionListByUserId(int userId);

    int addAction(Action action);*/


}
