package plugin;

import kd.bos.bill.AbstractBillPlugIn;
import kd.sdk.plugin.Plugin;

import java.util.EventObject;

/**
 * 单据界面插件
 */
public class Test1 extends AbstractBillPlugIn implements Plugin {

    @Override
    public void afterCreateNewData(EventObject e) {
        this.getView().showMessage("helloword!");
        super.afterCreateNewData(e);
    }
}