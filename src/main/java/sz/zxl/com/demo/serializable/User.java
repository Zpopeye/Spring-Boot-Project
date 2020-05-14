package sz.zxl.com.demo.serializable;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String id="你眼中的世界就是你自己";
    private String name;
    private Integer age;
    private String sex;
}
