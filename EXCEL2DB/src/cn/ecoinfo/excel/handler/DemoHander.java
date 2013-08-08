package cn.ecoinfo.excel.handler;
/**
 * 测试handler
 * @author zhiqiang
 *
 */
public class DemoHander implements ValueHandler {
	
	private String temp = null;
	
	public DemoHander(){}
	
	public DemoHander(String temp1){
		temp = temp1;
	}
	
	public String todo(String value) {
		if(temp==null){
			return value+"_result";
		}else{
			return temp+value+"_result";
		}
	}

}
