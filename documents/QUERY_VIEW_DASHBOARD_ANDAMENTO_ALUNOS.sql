-- resultados dashboard mentor, traz a quantidade de alunos
-- que finalizaram e não finalizaram sumarizados por curso
-- deixando o filtro para ser realizado na cláusula WHERE.
SELECT
	SUBSTR(stu.STU_RA, 7, 3) AS ANO_SEMESTRE,
	institution.INS_CODE,
    institution.INS_LEVEL AS LEVEL,
    course.CRS_CODE,
	course.CRS_NAME AS CURSO,
    (SELECT count(*) FROM student 
		WHERE STU_IS_COMPLETED = 0 AND CRS_CODE = course.CRS_CODE GROUP BY CRS_CODE) AS NAO_FINALIZADOS,
    (SELECT count(*) FROM student
		WHERE STU_IS_COMPLETED = 1 AND CRS_CODE = course.CRS_CODE GROUP BY CRS_CODE) AS FINALIZADOS
FROM student stu INNER JOIN course ON course.CRS_CODE = stu.CRS_CODE
				 INNER JOIN institution ON course.INS_CODE = institution.INS_CODE
GROUP BY ANO_SEMESTRE, institution.INS_CODE, LEVEL, course.CRS_CODE, CURSO;

-- resultados dashboard do admin, traz a quantidade de alunos
-- que finalizaram e não finalizaram sumarizado pelo nível de
-- instituição. SUPERIOR - Fatec e TECHNICAL - ETEC
SELECT
	SUBSTR(stu.STU_RA, 7, 3) AS YEAR_SEMESTER,
    institution.INS_LEVEL AS LEVEL,
    (SELECT count(*) FROM student 
		WHERE STU_IS_COMPLETED = 0 AND INS_CODE = institution.INS_CODE GROUP BY INS_CODE) AS NAO_FINALIZADOS,
    (SELECT count(*) FROM student
		WHERE STU_IS_COMPLETED = 1 AND CRS_CODE = institution.INS_CODE GROUP BY INS_CODE) AS FINALIZADOS
FROM student stu INNER JOIN institution ON stu.INS_CODE = institution.INS_CODE
GROUP BY YEAR_SEMESTER, LEVEL;

-- resultados dashboard do admin, traz a quantidade de alunos
-- que finalizaram e não finalizaram sumarizados por cada
-- instituição.
SELECT
	SUBSTR(stu.STU_RA, 7, 3) AS ANO_SEMESTRE,
	institution.INS_CODE,
    institution.INS_LEVEL AS LEVEL,
	institution.INS_COMPANY AS INSTITUTION,
    (SELECT count(*) FROM student 
		WHERE STU_IS_COMPLETED = 0 AND INS_CODE = institution.INS_CODE GROUP BY INS_CODE) AS NAO_FINALIZADOS,
    (SELECT count(*) FROM student
		WHERE STU_IS_COMPLETED = 1 AND INS_CODE = institution.INS_CODE GROUP BY INS_CODE) AS FINALIZADOS
FROM student stu INNER JOIN institution ON stu.INS_CODE = institution.INS_CODE
GROUP BY ANO_SEMESTRE, institution.INS_CODE, LEVEL, INSTITUTION;