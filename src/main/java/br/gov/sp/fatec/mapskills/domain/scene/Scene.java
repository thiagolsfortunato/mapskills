package br.gov.sp.fatec.mapskills.domain.scene;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scene")
public class Scene implements Serializable, Comparable<Scene> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scn_id")
	private long id;
	
	@Column(name = "scn_index", nullable = false)
	private int index;
	
	@Column(name = "scn_text", nullable = false)
	private String text;
	
	@Column(name = "scn_url_background", nullable = false)
	private String urlBackground;
	
	@Column(name = "scn_enabled", nullable = false)
	private boolean enabled;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="que_id")
	private Question question;
	
	@Column(name = "gth_id", nullable = false)
	private long gameThemeId;
	
	public Scene() {}
	
	public Scene(final String text, final String urlBackground, final Question question, final long gameThemeId) {
		this.text = text;
		this.urlBackground = urlBackground;
		this.question = question;
		this.gameThemeId = gameThemeId;
		this.enabled = true;
	}

	public long getId() {
		return id;
	}

	public int getIndex() {
		return index;
	}

	public String getText() {
		return text;
	}

	public String getUrlBackground() {
		return urlBackground;
	}

	public Question getQuestion() {
		return question;
	}
	
	public long getGameThemeId() {
		return gameThemeId;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void disable() {
		enabled = false;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public void putIndex(final int index) {
		this.index = index;
	}
	
	/**
	 * O método compareTo é utilizado para realizar a ordenacao das cenas através do index da cena
	 */
	@Override
	public int compareTo(final Scene scene) {
		return this.index < scene.getIndex() ? -1 : (this.index == scene.index ? 0 : 1);
	}

}
