package com.api.hanley.service;

import com.api.hanley.entity.dto.Action;
import com.api.hanley.entity.dto.Position;

import java.util.List;

/**
 * @author hanley
 * @date 2019/4/23 16:22
 * 风萧萧兮易水寒
 */
public interface PowerService {

    Action getActionById(int actionId);

    List<Action> getActionList();

    Position getPositionById(int positionId);

    int addAction(Action action);
    List<List<Object>> getActionObjectList();
}
