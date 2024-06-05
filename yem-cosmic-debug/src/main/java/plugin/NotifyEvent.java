package plugin;

import kd.bos.bec.api.IEventServicePlugin;
import kd.bos.bec.model.EntityEvent;
import kd.bos.bec.model.KDBizEvent;
import kd.bos.dataentity.entity.DynamicObject;
import kd.bos.servicehelper.BusinessDataServiceHelper;

/**
 * @author Administrator
 */
public class NotifyEvent implements IEventServicePlugin {

    @Override
    public Object handleEvent(KDBizEvent evt) {
        EntityEvent entityEvent = (EntityEvent) evt;//类型转换
        String businesskey = entityEvent.getBusinesskeys().get(0);
        String entityNumber = entityEvent.getEntityNumber();
        DynamicObject obj = BusinessDataServiceHelper.loadSingle(businesskey, entityNumber);
        Long evtID = evt.getEventId();
        String source = evt.getSource();//传递的事件参数


        return IEventServicePlugin.super.handleEvent(evt);
    }
}
