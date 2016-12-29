package br.gov.sp.fatec.mapskills.domain.scene;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class SceneService implements RepositoryService<Scene> {
	
	@Autowired
	private SceneRepository sceneRepo;

	@Override
	public void deleteAll() {
		sceneRepo.deleteAll();
	}
	
	public void save(final Scene scene) {
		final int index = nextIndex(scene.getGameThemeId());
		scene.putIndex(index);
		sceneRepo.save(scene);
	}
	
	public void save(final List<Scene> scenes) {
		int index;
		for(final Scene scene : scenes) {
			index = nextIndex(scene.getGameThemeId());
			scene.putIndex(index);
		}
		sceneRepo.save(scenes);
	}
	/**
	 * Método que recupera todas as cenas habilitadas de um tema
	 * @return
	 */
	public Collection<Scene> findAllByGameThemeIdAndEnabled(final long gameThemeId) {
		return sceneRepo.findAllByGameThemeIdAndEnabled(gameThemeId, true);
	}
	
	/**
	 * Método que recupera o próximo index da cena válida, de determinado tema 
	 * @param themeId
	 * @return
	 */
	public int nextIndex(final long themeId) {
		return sceneRepo.findNextIndex(themeId);
	}

}
