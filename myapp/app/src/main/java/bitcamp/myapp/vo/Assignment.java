package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자
//@RequiredArgsConstructor // 필수값을 받는 생성자
//@AllArgsConstructor // 모든 아규먼트를 다 받는 생성자
@Data
public class Assignment implements Serializable {

  private static final long serialVersionUID = 100L;
  private String title;
  private String content;
  private int no;
  private Date deadline;


}
