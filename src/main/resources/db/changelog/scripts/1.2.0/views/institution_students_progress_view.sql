-- institution_students_progress_view.sql 1.2.0 29/04/2017
-- Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
-- Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.

DROP VIEW IF EXISTS INSTITUTION_STUDENTS_PROGRESS_VIEW;

CREATE VIEW INSTITUTION_STUDENTS_PROGRESS_VIEW AS
	SELECT
		SUBSTR(s.STU_RA, 7, 3) AS YEAR_SEMESTER,
		INSTITUTION.INS_CODE AS INSTITUTION_CODE,
	    INSTITUTION.INS_LEVEL AS LEVEL,
	    COURSE.CRS_CODE AS COURSE_CODE,
		COURSE.CRS_NAME AS COURSE_NAME,
	    (SELECT COUNT(*) FROM STUDENT STU
			WHERE STU.STU_IS_COMPLETED = 0 AND STU.CRS_CODE = COURSE.CRS_CODE
	        AND SUBSTR(STU.STU_RA, 7, 3) = SUBSTR(s.STU_RA, 7, 3)
	        GROUP BY STU.CRS_CODE) AS NOT_FINALIZED,
	    (SELECT COUNT(*) FROM STUDENT STUD
			WHERE STUD.STU_IS_COMPLETED = 1 AND STUD.CRS_CODE = COURSE.CRS_CODE
	        AND SUBSTR(STUD.STU_RA, 7, 3) = SUBSTR(s.STU_RA, 7, 3)
	        GROUP BY STUD.CRS_CODE) AS FINALIZED
	FROM STUDENT s INNER JOIN COURSE ON COURSE.CRS_CODE = s.CRS_CODE
				 INNER JOIN INSTITUTION ON COURSE.INS_CODE = INSTITUTION.INS_CODE
	GROUP BY YEAR_SEMESTER, INSTITUTION_CODE, LEVEL, COURSE_CODE, COURSE_NAME;