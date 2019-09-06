package com.api.hanley.service.impl;

import com.api.hanley.dao.ActionDao;
import com.api.hanley.dao.PositionDao;
import com.api.hanley.entity.dto.Action;
import com.api.hanley.entity.dto.Position;
import com.api.hanley.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hanley
 * @date 2019/4/23 16:24
 * 风萧萧兮易水寒
 */
@Service("powerService")
public class PowerServiceImpl implements PowerService {

    @Resource
    private ActionDao actionDao;

    @Resource
    private PositionDao positionDao;

    @Override
    public Action getActionById(int actionId) {
        return actionDao.getActionById(actionId);
    }

    @Override
    public List<Action> getActionList() {
        return actionDao.getActionList();
    }

    @Override
    public Position getPositionById(int positionId) {
        return positionDao.getPositionById(positionId);
    }

    @Override
    public int addAction(Action action) {
        return actionDao.addAction(action);
    }

    @Override
    public List<List<Object>> getActionObjectList(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<List<Object>>  lists = new ArrayList<List<Object>>();

        List<Action>  list = actionDao.getActionList();
        for (Action action:list) {
            List<Object> objectList = new ArrayList<Object>();
            objectList.add(action.getId());
            objectList.add(action.getAction());
            objectList.add(action.getActionPath());
            objectList.add(format.format(action.getCreateTime()) );
            objectList.add(format.format(action.getUpdateTime()) );
            objectList.add(action.getDelFlag());
            lists.add(objectList);
        }
        return lists;
    }


}
