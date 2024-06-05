package plugin;

import com.alibaba.fastjson.JSON;
import kd.bos.openapi.common.custom.annotation.*;
import kd.bos.openapi.common.result.CustomApiResult;
import kd.bos.print.api.PrintTask;
import kd.bos.print.api.PrintWork;
import kd.bos.print.core.service.PrtAttach;
import kd.bos.print.service.BosPrintServiceHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴方涛
 * @date 2021/07/06 16:27
 * @description 调用打印服务
 * @version 1.0.0
 */
@ApiController(value = "/print", desc = "")
public class PrintTest {
    @ApiPostMapping(value="/printDocument")
    public CustomApiResult<String> print(@ApiRequestBody PrintParam work1) {

        PrintWork printWork = new PrintWork();
        printWork.setPrintLang(work1.getPrintLang());
        printWork.setExpType(work1.getExpType());

        List<PrintTask> taskList = new ArrayList<>();
        work1.getTaskList().forEach(task -> {
            PrintTask printTask = new PrintTask();
            printTask.setTplId(task.getTplId());
            printTask.setPkIds(task.getPkIds());
            taskList.add(printTask);
        });

        printWork.setTaskList(taskList);

        printWork.getTaskList().forEach(task -> {
            task.setTplId( BosPrintServiceHelper.getTplIdByNum(task.getTplId()));
                });
        PrtAttach prtAttach = BosPrintServiceHelper.execPrint( printWork);
        return CustomApiResult.success(JSON.toJSONString(prtAttach));

    }

    @ApiModel
     static class PrintParam implements java.io.Serializable

    {
        @ApiParam(value="打印语言")
        private String printLang;
        @ApiParam(value="打印类型")
        private String expType;
        @ApiParam(value="打印任务列表")
        private List<Task> taskList;

        public String getPrintLang() {
            return printLang;
        }

        public void setPrintLang(String printLang) {
            this.printLang = printLang;
        }

        public String getExpType() {
            return expType;
        }

        public void setExpType(String expType) {
            this.expType = expType;
        }

        public List<Task> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<Task> taskList) {
            this.taskList = taskList;
        }
    }
    @ApiModel
    static class Task implements java.io.Serializable{
        @ApiParam(value="模板ID")
        private String tplId;
        @ApiParam(value="主键ID列表")
        private List<Object> pkIds;

         public String getTplId() {
             return tplId;
         }

         public void setTplId(String tplId) {
             this.tplId = tplId;
         }

         public List<Object> getPkIds() {
             return pkIds;
         }

         public void setPkIds(List<Object> pkIds) {
             this.pkIds = pkIds;
         }
     }
}
