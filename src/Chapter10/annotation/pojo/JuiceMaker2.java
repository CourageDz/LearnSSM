package Chapter10.annotation.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("juiceMaker2")
public class JuiceMaker2  {
//    @Value("贡茶")
	private String beverageShop = null;

    @Autowired
	private Source source = null;


	public String getBeverageShop() {
		return beverageShop;
	}

	public void setBeverageShop(String beverageShop) {
		this.beverageShop = beverageShop;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String makeJuice() {
		String juice = "这是一杯由" + beverageShop + "饮品店，提供的" + source.getSize() + source.getSugar() + source.getFruit();
		return juice;
	}

	public void init() {
		System.out.println("【" + this.getClass().getSimpleName() + "】自定义初始化方法");
	}
	
	public void myDestroy() {
		System.out.println("【" + this.getClass().getSimpleName() + "】自定义销毁方法");
	}
}
