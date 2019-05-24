package spring.service.qaevent;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import spring.service.common.BaseObjectService;
import us.mn.state.health.lims.qaevent.valueholder.QaEvent;

public interface QaEventService extends BaseObjectService<QaEvent> {
	void getData(QaEvent qaEvent);

	void deleteData(List qaEvents);

	void updateData(QaEvent qaEvent);

	boolean insertData(QaEvent qaEvent);

	QaEvent getQaEventByName(QaEvent qaEvent);

	List getQaEvents(String filter);

	List getAllQaEvents();

	Integer getTotalQaEventCount();

	List getPageOfQaEvents(int startingRecNo);

	List getNextQaEventRecord(String id);

	List getPreviousQaEventRecord(String id);
}
