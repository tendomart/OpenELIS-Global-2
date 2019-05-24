package spring.service.testcodes;

import java.lang.String;
import spring.service.common.BaseObjectService;
import us.mn.state.health.lims.testcodes.valueholder.TestCodeType;

public interface TestCodeTypeService extends BaseObjectService<TestCodeType> {
	TestCodeType getTestCodeTypeById(String id);

	TestCodeType getTestCodeTypeByName(String name);
}
