package commerce.vo;

public class AttachedFile {

  private int no;
  private String filePath;
  private int commerceNo;

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

  public int getCommerceNo() {
    return commerceNo;
  }

  public void setCommerceNo(int commerceNo) {
    this.commerceNo = commerceNo;
  }

  public AttachedFile filePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  public AttachedFile commerceNo(int commerceNo) {
    this.commerceNo = commerceNo;
    return this;
  }
}
