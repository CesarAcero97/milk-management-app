package persistence;

public enum JsonKeysList {
	YEAR("a_o"),
	TOWN("municipio"),
	FARMING_TYPE("tipo_de_explotacion"),
	PRODUCTION_PER_DAY("produccion_por_vaca_litros_dia"),
	COWS("vacas_para_orde_o"),
	TOTAL("total_litros_d_a");
	
	String key;
	
	JsonKeysList(String key) {
		this.key = key;
	}
	
//	@Override
//	public String getKey() {
//		return key;
//	}
//
//	@Override
//	public Object getValue() {
//		return null;
//	}

}
