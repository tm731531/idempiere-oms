package tw.tom.oms.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import tw.tom.oms.process.*;

public class OMSProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		if(className.equals(OMSGetOrderProcess.class.getName())) {
			return new OMSGetOrderProcess();
		}
		if(className.equals(OMSRefreshTokenProcess.class.getName())) {
			return new OMSRefreshTokenProcess();
		}
		return null;
	}

}
