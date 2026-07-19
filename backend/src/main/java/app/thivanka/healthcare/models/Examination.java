package app.thivanka.healthcare.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Examination\"")
public class Examination{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exam_id;

	@ManyToOne
	@JoinTable(name = "no")
	private Patient patient;

	private LocalDate exam_date;
	private int bp; //blood pressure
	private int hp; //heart pressure
	private float wi; //weight
	private float temp;
	
	//setters
	
	public void setExam_id(Long exam_id) {
		this.exam_id = exam_id;
	}
	
	public void setPatient(Patient no) {
		this.patient = patient;
	}
	
	public void setExam_date(LocalDate exam_date) {
		this.exam_date = exam_date;
	}
	
	public void setBp(int bp) {
		this.bp = bp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setWi(float wi) {
		this.wi = wi;
	}
	
	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	//getters
	
	public Long getExam_id() {
		return exam_id;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public LocalDate getExam_date() {
		return exam_date;
	}
	
	public int getBp() {
		return bp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public float getWi() {
		return wi;
	}
	
	public float getTemp() {
		return temp;
	}
}