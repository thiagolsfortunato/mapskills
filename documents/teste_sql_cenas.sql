-- TRAZ TODAS AS CENAS DE UM TEMA AINDA NÃO RESPONDIDAS POR UM ALUNO
SELECT scene.scn_id FROM scene
    INNER JOIN institution inst ON scene.gth_id = inst.gth_id
    INNER JOIN student st ON st.ins_code = inst.ins_code
	WHERE scene.scn_id > 
		(SELECT COALESCE(MAX(event.scn_index), 0) FROM student_question_event event
			INNER JOIN student stu ON event.use_id = stu.use_id
			WHERE event.use_id = 3)
	AND st.stu_is_completed = false
    AND st.use_id = 3
	ORDER BY scene.scn_index ASC;

-- ATIVAÇÕES PARA TESTES --
UPDATE game_theme SET gth_is_active = true WHERE gth_id = 1;
UPDATE institution SET gth_id = 1 WHERE ins_code = '146';


-- TRAZ O MAIOR INDEX ENTRE AS CENAS DE UM TEMA JÁ RESPONDIDAS PELO ALUNO
-- SE NÃO HOUVER NENHUM HISTORICO RETORNA 0 --             
SELECT COALESCE(MAX(event.scn_index), 0) FROM student_question_event event
	INNER JOIN student stu ON event.use_id = stu.use_id
    WHERE event.use_id = 3;
