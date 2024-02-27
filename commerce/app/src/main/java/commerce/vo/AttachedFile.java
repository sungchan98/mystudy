package commerce.vo;

public class AttachedFile {

  private int no;
  private String filePath;
  private int productNo;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public int getProductNo() {
    return productNo;
  }

  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }

  public AttachedFile filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  public AttachedFile productNo(int productNo) {
    this.productNo = productNo;
    return this;
  }
}
