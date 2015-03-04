package model;

public class Target
{
  private String join_type;
  private String cell_id;
  private String camp_name;

  public String getJoin_type()
  {
    return this.join_type;
  }
  public void setJoin_type(String join_type) {
    this.join_type = join_type;
  }
  public String getCell_id() {
    return this.cell_id;
  }
  public void setCell_id(String cell_id) {
    this.cell_id = cell_id;
  }
  public String getCamp_name() {
    return this.camp_name;
  }
  public void setCamp_name(String camp_name) {
    this.camp_name = camp_name;
  }
}