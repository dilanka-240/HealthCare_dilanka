package app.thivanka.healthcare.dto;

public class DoctorDTO {
  private Long id;
  private String d_name;
  private Long no;
  private String accessToken;
  private String refreshToken;

  public DoctorDTO(Long id, String d_name, Long no) {
    this.id = id;
    this.d_name = d_name;
    this.no = no;
  }

  // setters

  public void setId(Long id) {
    this.id = id;
  }

  public void setDoctorName(String d_name) {
    this.d_name = d_name;
  }

  public void setPatientNo(Long no) {
    this.no = no;
  }

  // getters

  public Long getId() {
    return id;
  }

  public String getDoctorName() {
    return d_name;
  }

  public Long getPatientNo() {
    return no;
  }
}
