package logic;

public class Maps {
	private BComponent[][] SingleMap;
	
	public Maps(BComponent[][] singleMap) {
		super();
		SingleMap = singleMap;
	}
	
	public BComponent[][] getSingleMap() {
		return SingleMap;
	}

	public void setSingleMap(BComponent[][] singleMap) {
		SingleMap = singleMap;
	}
}