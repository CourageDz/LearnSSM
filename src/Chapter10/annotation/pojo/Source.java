package Chapter10.annotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "source")
public class Source {
//	@Value("苹果")
	private String fruit;// 类型
//	@Value("5分甜")
	private String sugar;// 糖分描述
//	@Value("中杯")
	private String size;// 大小杯
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
