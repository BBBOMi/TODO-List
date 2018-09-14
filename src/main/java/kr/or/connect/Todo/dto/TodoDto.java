package kr.or.connect.Todo.dto;

public class TodoDto {
  long id;
  String name;
  String regdate;
  int sequence;
  String title;
  String type;
  
  public TodoDto() {
    
  }
  
  public TodoDto(String title, String name, int sequence) {
    super();
    this.title = title;
    this.name = name;
    this.sequence = sequence;
  }
  
  public TodoDto(long id, String title, String name, int sequence, String type, String regdate) {
    super();
    this.id = id;
    this.name = name;
    this.sequence = sequence;
    this.title = title;
    this.type = type;
    this.regdate = regdate;
  }
 
  public long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
 
  public String getRegdate() {
    return regdate;
  }
  
  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
  
  public int getSequence() {
    return sequence;
  }
  
  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Todo [id=" + id + ", name=" + name + ", regdate=" + regdate + ", sequence=" + sequence
        + ", title=" + title + ", type=" + type + "]";
  }

}
