package bitcamp.myapp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Mybatis 가 사용할 기본 생성자를 만들어야 한다.
@AllArgsConstructor // 모든 필드값도 만드는 생성자도 만들어라.
@Builder
@Data
public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;

}
